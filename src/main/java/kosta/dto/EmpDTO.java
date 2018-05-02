package kosta.dto;

public class EmpDTO {
   private int empno;
   private String empName; //DB의 필드명 ename이다.
   private String job;
   private int sal;
   private String hiredate;
   
    public EmpDTO() {}
	public EmpDTO(int empno, String empName, String job, int sal ) {
		super();
		this.empno = empno;
		this.empName = empName;
		this.job = job;
		this.sal = sal;
	}

	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
    @Override
	public String toString() {
		return empno+" | " + empName +" | "+ job +" | "+sal +" | "+hiredate  ;
	}
   
}
