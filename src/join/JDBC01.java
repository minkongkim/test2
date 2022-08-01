package join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC01 {

	public static void main(String[] args) {
		//DB�� �����ϱ� ���� ��ü
				Connection con = null; //�������� (�ݵ�� �ʱ�ȭ)
				
				//SQL������ ����ϱ� ���� Statement��ü
				Statement st = null;
				
				try{
				// 1. ����̹� �ε�
				//������ ��Ʈ������ ������ Ŭ���� �Ǵ� �������̽��� ��θ� �����ش�.
				Class.forName("oracle.jdbc.OracleDriver"); 

				// 2. DB����
				con = DriverManager.getConnection(  ///1521 ����Ŭ ��Ʈ��ȣ 
						"jdbc:oracle:thin:@localhost:1521:xe", "member", "12345");
                                          ///@�Ƹ�������?(���̳�����?)
				// 3. Statement ���
				String sql = "insert into memberjoin values('soldesk01', 12345)";
				st = con.createStatement();
				    
				// 4. ���� ����
				st.executeUpdate(sql);
				System.out.println("�Է¼���");

				}catch(Exception e){
					
				  e.printStackTrace();
				  
				}finally{
					
				  try{
				     if(st != null)
				       st.close();
				     if(con != null)
				       con.close();
				  }catch(Exception e){}
				  
				}
	}

}
