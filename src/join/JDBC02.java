package join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC02 {

	public static void main(String[] args) {
		
		try {
			
			//지정된 스트리명을 가지는 클래스 또는 인터페이스에 경로를 알림
			Class.forName("oracle.jdbc.OracleDriver"); //오라클 드라이버
			
			//2.DB연동
			
			//현재시점에서 자신의 컴퓨터(localhost 또는 127.0.0.1)가 서버
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="member"; //오라클의 접속할 데이터베이스 명
			String pwd="12345";
			
			Connection con=DriverManager.getConnection(url, user, pwd);
			
			//3. Statement : 인터페이스를 이용하여 SQL문장을 등록
			Statement st=con.createStatement(); //SQL서버에서 Statement 작동
			//4.SQL 실행결과를 ResultSet 타입의 변수방에 저장
			ResultSet rs=st.executeQuery("select * from memberjoin");
			
			//5.결과 처리
			while(rs.next()) {
				System.out.println(rs.getString("id")+" / "+rs.getInt("pwd"));
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
