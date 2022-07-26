/**
 * 네이버 자바스크립트 만들어봅시당
 */

//아이디 체크조건 걸어주기
	function idCheck(){
		
		var f=document.myForm;		
		var userId=request.getParameter("userId");
		
		alert(userId);
		
	}
	
	function monthOption(){
		
		for(i=0;i<=12;i++){
			if(i==0){
				alert("<option>월</option>")
			}else
			alert("<option value='"+i+"'>"+i+"</option>")
			
		}
	}
	
	function options() {
		
		for(var i=0;i<=12;i++){
			if(i!=0){
				document.myForm.month[i]=new Option(i,i);
			}else document.myForm.month[i]=new Option("월","");
		}
		
		var ch=['성별','여자','남자','선택안함'];
		for(var i=0;i<4;i++){
		document.myForm.gender[i] =new Option(ch[i],ch[i]);
		}
		
		var ch1=['+82','+47','+30','+856']
		var ch2=['대한민국 +82','노르웨이 +47','그리스 +30','라오스 +856'];
		for(var i=0;i<4;i++){
			document.myForm.tel1[i] =new Option(ch2[i],ch1[i]);
		}
		

	}
	