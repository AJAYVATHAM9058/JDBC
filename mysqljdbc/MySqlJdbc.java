package mysqljdbc;

import java.sql.*;
import java.util.Arrays;

public class MySqlJdbc {

	public static void main(String args[]) throws ClassNotFoundException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Jaibalayya123");
			Statement st = con.createStatement();
		//	ResultSet rs = st.executeQuery("Select * from users1");
			
			ResultSet rs1 = st.executeQuery("select * from userdata");
			
			String name[] = new String[6];
			String password[] = new String[6];
			int i=0;
			int j=0;
			
			while(rs1.next()) {
				name[i++] = rs1.getString(1);
				password[j++] = rs1.getString(2);
			}
			con.close();
			

			for(int k=0;k<name.length;k++) {
				System.out.println(" "+name[k]+"   "+password[k]);
			}
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
