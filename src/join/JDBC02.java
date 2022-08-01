package join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC02 {

	public static void main(String[] args) {
		
		try {
			
			//������ ��Ʈ������ ������ Ŭ���� �Ǵ� �������̽��� ��θ� �˸�
			Class.forName("oracle.jdbc.OracleDriver"); //����Ŭ ����̹�
			
			//2.DB����
			
			//����������� �ڽ��� ��ǻ��(localhost �Ǵ� 127.0.0.1)�� ����
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="member"; //����Ŭ�� ������ �����ͺ��̽� ��
			String pwd="12345";
			
			Connection con=DriverManager.getConnection(url, user, pwd);
			
			//3. Statement : �������̽��� �̿��Ͽ� SQL������ ���
			Statement st=con.createStatement(); //SQL�������� Statement �۵�
			//4.SQL �������� ResultSet Ÿ���� �����濡 ����
			ResultSet rs=st.executeQuery("select * from memberjoin");
			
			//5.��� ó��
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
