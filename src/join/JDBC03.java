package join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC03 {

	public static void main(String[] args) {
		
		try {
			
			//지정된 스트리명을 가지는 클래스 또는 인터페이스에 경로를 알림
			Class.forName("oracle.jdbc.OracleDriver"); //오라클 드라이버
			
			//2.DB연동
			
			//현재시점에서 자신의 컴퓨터(localhost 또는 127.0.0.1)가 서버
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="member"; //오라클의 접속할 데이터베이스 명
			String pass="12345";
			
			Connection con=DriverManager.getConnection(url, user, pass);
			

			//3.SQL 실행결과를 PreParedStatement 타입의 변수방에 저장
			PreparedStatement pstmt=con.prepareStatement
					("insert into memberjoin values(?,?)");
			//뷰에서 넘어온 데이터
			String id="sol2022";
			int pwd=12345;
			
			pstmt.setString(1, id);
			pstmt.setInt(2, pwd);
			
			//4.컴파일
			int cnt=pstmt.executeUpdate();
			
			
			//5.결과 처리
			if(cnt > 0)
				System.out.println("저장 완료");
			
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
