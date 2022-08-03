package com.moody;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MoodyServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {

		RequestDispatcher rd=req.getRequestDispatcher(url);
		rd.forward(req, resp);

	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String cp = req.getContextPath();
		String uri= req.getRequestURI();

		Connection conn=MDBCoon.getConnection();
		CartDAO dao=new CartDAO(conn);
		UserDAO udao=new UserDAO(conn);
		MemberDAO mdao = new MemberDAO(conn);

		String url;

		if(uri.indexOf("cart_insert.do")!=-1) {

			//로그인검증 : session 로그인해야 장바구니로 넘어가게 해줌.
			HttpSession session = req.getSession();
			//
			MemberInfo info = (MemberInfo)session.getAttribute("memberInfo");
			//
			//			if(info==null) {
			//				url="/moody/login.jsp";
			//				forward(req,resp,url);
			//				return;
			//			}

			String id=info.getId();
			String pnum=req.getParameter("pnum");
			String psize=req.getParameter("psize");
			int cnt=Integer.parseInt(req.getParameter("cnt"));

			System.out.println(id);


			CartDTO stddto = null;
			stddto=dao.checkData(id, pnum, psize);

			if(stddto!=null && !stddto.equals("")) {
				//입력받은 cnt값을 update 시켜야함. insert아님
				int newcnt = stddto.getCnt()+cnt;

				System.out.println(newcnt);

				dao.updateCartData(id, pnum, psize, newcnt);

			}else {

				CartDTO dto = new CartDTO(); // 1.dto객체생성
				int maxNum = dao.getMaxNum(); //2.maxnum 불러오기


				dto.setNum(maxNum+1); 
				dto.setId(id); 
				dto.setPnum(req.getParameter("pnum"));
				dto.setPname(req.getParameter("pname"));
				dto.setCnt(Integer.parseInt(req.getParameter("cnt")));
				dto.setPsize(req.getParameter("psize"));
				dto.setPrice(Integer.parseInt(req.getParameter("price")));

				System.out.println(dto.getId()+dto.getPnum()+dto.getPname()+dto.getPrice()+dto.getPsize());
				dao.insertData(dto); //dao에 미리만들어둔 sql문 메소드 불러와서 넣기
			}

			url=cp+"/shopmoody/cart_list.do";
			resp.sendRedirect(url);	//6.리다이랙트 해주기



		}else if(uri.indexOf("cart_list.do")!=-1) {

			HttpSession session = req.getSession();
			MemberInfo info = (MemberInfo)session.getAttribute("memberInfo");
			int discount = 1;
			
			//장바구니 개수 뜨는거 코드
			int countCart = dao.countCart(info.getId());
			req.setAttribute("countCart", countCart);
			System.out.println(countCart);
			
			
			List<CartDTO> lists=
					dao.getLists(info.getId());
			//구해낸 start와 end 가지고 한번에 나타낼 만큼 리스트로 꺼내오기

			String listUrl = cp+"/shopmoody/cart_list.do";
			//System.out.println(listUrl);
			//System.out.println(std+"114번째줄");

//			if(std!=1) {
//				req.setAttribute("discount", 1);
//			}

			req.setAttribute("lists", lists);
			req.setAttribute("discount", discount);

			//System.out.println("여기");

			url = "/moody/pre.jsp";
			forward(req, resp, url);



		}else if(uri.indexOf("cart_delete.do")!=-1) {

			int num = Integer.parseInt(req.getParameter("num"));
			//String pageNum="1";
			//pageNum = request.getParameter("pageNum");

			CartDTO dto = dao.getReadData(num);

			dao.deleteData(num);

			url = cp+ "/shopmoody/cart_list.do";
			resp.sendRedirect(url);


		}else if(uri.indexOf("cart_plus.do")!=-1) {

			int std = Integer.parseInt(req.getParameter("cnt"));
			int num = Integer.parseInt(req.getParameter("num"));
			std++;

			dao.updateCntData(num, std);

			url = cp+ "/shopmoody/cart_list.do";
			resp.sendRedirect(url);




		}else if(uri.indexOf("cart_minus.do")!=-1) {

			int std = Integer.parseInt(req.getParameter("cnt"));
			int num = Integer.parseInt(req.getParameter("num"));
			std--;

			if(std==0) {

				dao.deleteData(num);
			}else {

				dao.updateCntData(num, std);
			}

			url = cp+ "/shopmoody/cart_list.do";
			resp.sendRedirect(url);


		}else if(uri.indexOf("login.do")!=-1) {

			url = "/moody/login.jsp";
			forward(req, resp, url);


		}else if(uri.indexOf("login_ok.do")!=-1) {

			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");



			UserDTO dto = udao.getReadData(id);

			//로그인 실패
			if(dto==null||!dto.getPwd().equals(pwd)) {

				req.setAttribute("message",
						"아이디 또는 패스워드를 정확히 입력해주세요");

				url = "/moody/login.jsp";
				forward(req, resp, url);

				return;

			}

			//로그인 성공

			//세션에 올릴 데이터 객체
			MemberInfo info = new MemberInfo();

			info.setId(dto.getId());
			info.setName(dto.getName());

			//세션 생성
			HttpSession session = req.getSession();

			session.setAttribute("memberInfo", info);

			url = "/moody/productPage.jsp";
			forward(req, resp, url);


		}else if(uri.indexOf("logout.do")!=-1) {


			HttpSession session=req.getSession();
			session.removeAttribute("memberInfo"); 
			session.invalidate(); //세션 안 커스텀 인포를 삭제해라. 이걸로 한번더 확인겸 삭제해줘라

			url = cp +"/shopmoody/cart.do";
			resp.sendRedirect(url);



		}else if(uri.indexOf("cart_coupon.do")!=-1) {

			String cpCode=req.getParameter("coupon");
			System.out.println(cpCode);

			if(cpCode=="discount10" || cpCode.equals("discount10")) {
				System.out.println("여기");
				req.setAttribute("discount", 0.9);
				req.setAttribute("message", "10%할인이 적용됩니다.");
				

			}else {
				System.out.println("저기");
				req.setAttribute("discount", 1);
				req.setAttribute("message", "잘못된 쿠폰코드입니다.");
			}
			
			

			HttpSession session = req.getSession();
			MemberInfo info = (MemberInfo)session.getAttribute("memberInfo");
			
			int countCart = dao.countCart(info.getId());
			req.setAttribute("countCart", countCart);
			
			List<CartDTO> lists=
					dao.getLists(info.getId());
			//구해낸 start와 end 가지고 한번에 나타낼 만큼 리스트로 꺼내오기

			String listUrl = cp+"/shopmoody/cart_list.do";
			//System.out.println(listUrl);
			//System.out.println(std+"114번째줄");

//			if(std!=1) {
//				req.setAttribute("discount", 1);
//			}

			req.setAttribute("lists", lists);


			url = "/moody/pre.jsp";
			forward(req, resp, url);

		}else if(uri.indexOf("cart.do")!=-1) {
			
			url = "/moody/pre.jsp";
			forward(req, resp, url);
		}
		
		
		
		//----------------------------------여기까지 나 하던거
		else if (uri.indexOf("create_ok.do")!=-1) {
			MemberDTO dto = new MemberDTO();

			System.out.println(req.getParameter("id"));

			dto.setId(req.getParameter("id"));
			dto.setPwd(req.getParameter("pwd"));
			dto.setPhoneNum(req.getParameter("phoneNum"));
			dto.setBirth(req.getParameter("birth"));
			dto.setGender(req.getParameter("gender"));
			dto.setEmail(req.getParameter("email"));
			dto.setAddress(req.getParameter("address"));
			dto.setName(req.getParameter("name"));


			mdao.insertData(dto);

			url = "moody_main.do";
			resp.sendRedirect(url);

		}
		
		
	}
}
