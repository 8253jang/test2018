package kosta.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbUtil {
	private static SqlSessionFactory factory;
	
  static {
	  String resource = "config/SqlMapConfig.xml";
	  try {
		  Reader reader = Resources.getResourceAsReader(resource);
		  factory = new SqlSessionFactoryBuilder().build(reader);
	  }catch (Exception e) {
		e.printStackTrace();
	}
  }
  
  public static SqlSession getSession() {
	  return factory.openSession();
  }
  
  /**
   * 닫기기능 : select경우
   * */
   public static void sessionClose(SqlSession session) {
	   if(session!=null)session.close();
   }
   
   /**
    * 닫기기능 : insert update delete경우
    *   state가 true이면 commit, false이면 rollback
    * */
   public static void sessionClose(SqlSession session , boolean state) {
	   if(session!=null) {
		   if(state)session.commit();
		   else session.rollback();
		   
		   session.close();
	   }
   }
  
  
  public static void main(String[] args) {
	 System.out.println(1);
  }
}








