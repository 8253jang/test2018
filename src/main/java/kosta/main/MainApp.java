package kosta.main;

import kosta.dao.EmpDAO;
import kosta.dto.EmpDTO;

public class MainApp {

	public static void main(String[] args) {
		EmpDAO dao =new EmpDAO();
		//dao.empByName();
		
		System.out.println("---2. 레코드 삽입 -----");
		//dao.empInsert(new EmpDTO(9011, "수능", "학생", 5000));
		//dao.empInsert(new EmpDTO(9012, "이미선", null, 5000));
		
		System.out.println("---3.  검색 -----");
        // dao.selectAll();
         
         System.out.println("---4.  삭제 -----");
        // dao.delete(9009);
         
         System.out.println("---5.  수정 -----");
        // dao.update(new EmpDTO(8002, "이가현", "교수", 6400));
         
         System.out.println("----6.전체 검색--------------------");
         dao.selectAll2();
         
         System.out.println("----7.사원번호 검색--------------------");
        // dao.selectByEmpno(8000);
         
         System.out.println("----8.급여 검색--------------------");
        // dao.selectBySal(2000, 3000);
         
         System.out.println("----9.정렬하기 --------------------");
         //dao.selectByOrder("empno");//컬럼명
         
         System.out.println("----10.조건 검색 검색--------------------");
         //dao.selectBySearch("ename", "a");
         
         System.out.println("----11.조건 검색 검색--------------------");
         //dao.updateByEname("삼식이", new EmpDTO(0, "삼삼삼","놀고", 4000));
	}

}









