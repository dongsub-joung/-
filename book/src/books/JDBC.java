package books;

import java.sql.*;

public class JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url= "jdbc:mysql://localhost:3306/first?serverTimezone=UTC";
		String user= "root";
		String pass= "111111";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//JDBC 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//MySQL과의 연결 작업을 위한 Connection 객체 생성	
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("성공"+ conn);
			
			//DB쪽으로 SQL query문을 전송하고, DB가 처리된 결과를 다시 자바프로그램쪽으로 전달할 수 있도록 돕는 객체이다.
			//conn 객체로부터 Statement 객체 획득
			stmt = conn.createStatement();
			
			//query 만들기
			
			StringBuilder sb= new StringBuilder();
			String sql= sb.append("SELECT*FROM books").toString();
			
			//query문 날리기
			stmt.execute(sql);	
		}
		
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패!");
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	
		finally{
	            try{
	                //자원 해제
	                if(conn != null && !conn.isClosed())
	                    conn.close();
	            } 
	            catch(SQLException e){
	                e.printStackTrace();
	            }
	       }
	}
}
