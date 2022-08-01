package join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC03 {

	public static void main(String[] args) {
		
		try {
			
			//������ ��Ʈ������ ������ Ŭ���� �Ǵ� �������̽��� ��θ� �˸�
			Class.forName("oracle.jdbc.OracleDriver"); //����Ŭ ����̹�
			
			//2.DB����
			
			//����������� �ڽ��� ��ǻ��(localhost �Ǵ� 127.0.0.1)�� ����
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="member"; //����Ŭ�� ������ �����ͺ��̽� ��
			String pass="12345";
			
			Connection con=DriverManager.getConnection(url, user, pass);
			

			//3.SQL �������� PreParedStatement Ÿ���� �����濡 ����
			PreparedStatement pstmt=con.prepareStatement
					("insert into memberjoin values(?,?)");
			//�信�� �Ѿ�� ������
			String id="sol2022";
			int pwd=12345;
			
			pstmt.setString(1, id);
			pstmt.setInt(2, pwd);
			
			//4.������
			int cnt=pstmt.executeUpdate();
			
			
			//5.��� ó��
			if(cnt > 0)
				System.out.println("���� �Ϸ�");
			
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
