package dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public static Connection connecttodb() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("checking...!!11");
		String url = "jdbc:mysql://localhost:3306/companyassignment";
		System.out.println("checking...!!12");
		String userid = "root";
		System.out.println("checking...!!13");
		String pswd="varun";
		System.out.println("checking...!!14");
		Connection con=DriverManager.getConnection(url,userid,pswd);
		System.out.println("checking...!!15");
		return con;
	}
	
	
}
