package mysqljdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CustomersData {

   
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		String url = "com.mysql.cj.jdbc.Driver";
		String connUrl = "jdbc:mysql://localhost:3306/mysql";
		String uname = "root";
		String pword = "Jaibalayya123";
		
		try {
		Class.forName(url);
		Connection con = DriverManager.getConnection(connUrl,uname,pword);
		Statement st = con.createStatement();
		System.out.println("connection created");
		
		
		ResultSet rs1= st.executeQuery("Select count(*) from userdata");
		
		int n=0;
		while(rs1.next()) {
			n = rs1.getInt(1);
		}
		
		
		System.out.println("The no. of users in the database "+n);
		
		List<String> username  = new ArrayList<>();
		List<String> password = new ArrayList<>();
		
		ResultSet rs = st.executeQuery("select * from userdata");
		
		while(rs.next()) {
			
		username.add(rs.getString(1));
		password.add(rs.getString(2));
			
		}
		
		con.close();

		System.out.println("Username "+"     Password  ");
		System.out.println("-----------------------------");
		for(int i=0;i<n;i++) {
			System.out.println(username.get(i)+"   | "+password.get(i));
		}
//		System.out.println(username.toString());
//		System.out.println(password.toString());
		
		
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
