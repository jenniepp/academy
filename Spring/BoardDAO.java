package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.jdbc.dto.BoardDTO;

public class BoardDAO {

	private SqlSessionTemplate sessionTemplate;

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate=sessionTemplate;
	}
	
	//num의 최대값
	public int getMaxNum() {

		int maxNum=0;
		maxNum = sessionTemplate.selectOne("com.boardMapper.maxNum");

		return maxNum;

	}

	//입력
	public void insertData(BoardDTO dto) {

		sessionTemplate.insert("com.boardMapper.insertData",dto);

	}

	//전체 데이터 가져오기
	public List<BoardDTO> getList(int start, int end, 
			String searchKey, String searchValue){

		Map<String,Object> params = new HashMap<String, Object>();
		
		params.put("start", start);
		params.put("end", end);
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		List<BoardDTO> lists = sessionTemplate.selectList("com.boardMapper.getLists",params);
		return lists;

	}

	//전체 데이터의 개수

	public int getDataCount(String searchKey,String searchValue) {

		int dataCount = 0;

		Map<String,Object> params = new HashMap<String, Object>();
		
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		dataCount = sessionTemplate.selectOne("com.boardMapper.getDataCount",params);
		return dataCount;
	}

	public BoardDTO getReadData(int num) {

		BoardDTO dto = sessionTemplate.selectOne("com.boardMapper.getReadData",num);
		return dto;
	}


	//조회수 증가
	public void updateHitCount(int num) {
		
		sessionTemplate.update("com.boardMapper.updateHitCount",num);
		
	}

	//수정
	public void updateData(BoardDTO dto) {

		sessionTemplate.update("com.boardMapper.updateData",dto);

	}

	//삭제
	public void deleteData(int num) {

		sessionTemplate.delete("com.boardMapper.deleteData",num);
	}



}
