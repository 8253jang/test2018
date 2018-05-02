package kosta.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.sun.swing.internal.plaf.metal.resources.metal;

import kosta.dto.EmpDTO;

public class EmpDAO {
  /**
   * 이름 검색하기
   * */
	public void empByName() {
		SqlSession session=null;
		try {
			 session = DbUtil.getSession();
			List<String> list = session.selectList("empMapper.empByName");
			
			
			System.out.println(list);
		}finally {	
	       DbUtil.sessionClose(session);
	   }
	}
	
	/**
	 * 레코드 삽입
	 * */
	public void empInsert(EmpDTO empDTO) {
		SqlSession session=null;
		boolean state=false;
		try {
			session = DbUtil.getSession();
			state = session.insert("empMapper.empInsert", empDTO) >0 ? true: false;
			
			System.out.println("state : " + state);
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 모든 레코드 검색하기
	 * */
	public void selectAll() {
		SqlSession session=null;
		try {
			 session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("empMapper.selectAll");
			for(EmpDTO e:list) {
				System.out.println(e);
			}
			
		}finally {	
	       DbUtil.sessionClose(session);
	   }
	}
	
	/**
	 * 레코드 삭제
	 * */
	public void delete(int empno) {
		SqlSession session=null;
		boolean state=false;
		try {
			session = DbUtil.getSession();
			state = session.delete("empMapper.empDelete", empno) >0 ? true: false;
			
			System.out.println("state : " + state);
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 레코드 수정
	 * */
	public void update(EmpDTO empDTO) {
		SqlSession session=null;
		boolean state=false;
		try {
			session = DbUtil.getSession();
			state = session.update("empMapper.empUpdate", empDTO) >0 ? true: false;
			
			System.out.println("state : " + state);
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	//////////////////////////////////////////////////////
	/**
	 *  include와 resultMap을 이용한 전체 검색
	 * */
	public void selectAll2() {
		 SqlSession session=null;
		 try {
			 session =DbUtil.getSession();
			// List<EmpDTO> list = session.selectList("empSelectMapper.selectAll");
			 
			 //RowBounds이용하기
			 List<EmpDTO> list = 
			    session.selectList("empSelectMapper.selectAll", null, new RowBounds(2, 4));
			
			 for(EmpDTO dto:list) {
				 System.out.println(dto);
			 }
		 }finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 사원번호 검색
	 * */
	public void selectByEmpno(int empno) {
		SqlSession session=null;
		try {
			 session = DbUtil.getSession();
			EmpDTO dto = session.selectOne("empSelectMapper.selectByEmpNo" , empno);
			 System.out.println(dto);
		}finally {	
	       DbUtil.sessionClose(session);
	   }
	}
	
	/**
	 * 급여 범위내 검색
	 * */
	public void selectBySal(int salMin , int salMax) {
		SqlSession session=null;
		 try {
			//mpper쪽으로 전달할 parameterTpe은 Map 
			Map<String, Integer> map = new HashMap<>();
			map.put("min", salMin);
			map.put("max", salMax);
				
			 session =DbUtil.getSession();
			 List<EmpDTO> list = session.selectList("empSelectMapper.selectBySal" , map);
			 
			 for(EmpDTO dto:list) {
				 System.out.println(dto);
			 }
		 }finally {
			DbUtil.sessionClose(session);
		}
	}
	
	 /**
	  * 정렬하기
	  * */
	 public void selectByOrder(String columnName) {
		 SqlSession session=null;
		 try {
			
			 session =DbUtil.getSession();
			 List<EmpDTO> list = session.selectList("empSelectMapper.selectByOrder" , columnName);
			 
			 for(EmpDTO dto:list) {
				 System.out.println(dto);
			 }
		 }finally {
			DbUtil.sessionClose(session);
		}
	 }
		 
	 /**
	  * 검색필드에 해당하는 검색단어를 포함하는 레코드 검색
	  * */
	 public void selectBySearch(String keyField, String keyWord) {
		 SqlSession session=null;
		 try {
			//mpper쪽으로 전달할 parameterTpe은 Map 
			Map<String, String> map = new HashMap<>();
			map.put("keyField", keyField);
			map.put("keyWord", keyWord);
				
			 session =DbUtil.getSession();
			 List<EmpDTO> list = session.selectList("empSelectMapper.selectBySearch" , map);
			 
			 for(EmpDTO dto:list) {
				 System.out.println(dto);
			 }
		 }finally {
			DbUtil.sessionClose(session);
		}
	 }
	 
	 /**
	  * ename에 해당하는 사원의 ename, job, sal을 변경한다.
	  * */
	 public void updateByEname(String whereEname , EmpDTO empDTO) {
		 SqlSession session=null;
		 boolean state=false;
		 try {
			 Map<String, Object> map =new HashMap<>();
			 map.put("whereEname", whereEname);//xml문서에서 #{whereEname}
			 map.put("empDTO", empDTO);//xml문서에서 ${empDTO.속성}
			 
			 session=DbUtil.getSession();
			 state= session.update("empSelectMapper.updateByEname", map)>0 ? true:false;
			
		 }finally{
			 DbUtil.sessionClose(session, state);
		 }
		 
	 }
		
	
}


















