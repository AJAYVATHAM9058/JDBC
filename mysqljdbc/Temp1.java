package mysqljdbc;

import java.util.*;
import java.sql.*;
public class Temp1 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		try {
		
		Scanner sc = new Scanner(System.in);
		
		//Loading and Registering the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establishing a connection
		String url ="jdbc:mysql://localhost:3306/mysql";
		String uname = "root";
		String pwd = "Jaibalayya123";
		
		Connection con = DriverManager.getConnection(url,uname,pwd);
		
		//Creating a statement object to execute sql queries
		Statement stmt = con.createStatement();
		
		/* Enter Age to check*/
		
		System.out.println("Enter Age : ");
		int age1 = sc.nextInt(); 
		
		//For PreparedStatement
		String sql  = "SELECT * FROM STUDENTDETAILS WHERE AGE = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,age1);
		
		//Executing SQL Query
		ResultSet rs = ps.executeQuery();
		
		//Process the result set
		while(rs.next()) {
			String name = rs.getString(1);
			int age = rs.getInt(2);
			String location = rs.getString(3);
			
			System.out.println("Name : "+name+"  ,  Age  : "+age+" ,   Location : "+location);
			
		}
		
		//Closing the connections
		con.close();
		rs.close();
		stmt.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
