package dbAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import action.AddCompanyAction;
import action.AddCompanyByAdminAction;


public class CompanyAddDao {
	static Connection con=null;
	ResultSet rs=null;
	
	public static int addcompany(AddCompanyAction r)
	{
		int status=0;  
		try {
			con=Connect.connecttodb();
			System.out.println("^^^^^^^^ "+r.getCompanyName()+" &&&&&& "+r.getCompanyAddress());
			PreparedStatement ps=con.prepareStatement("insert into company (CompanyName, CompanyAddress) values(?,?)");
			ps.setString(1, r.getCompanyName());
			//ps.setString(2, r.getPassword());
			ps.setString(2, r.getCompanyAddress());
			//ps.setString(4, r.getMobile());
			//ps.setString(5,);
			
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static int addcompanybyadmin(AddCompanyByAdminAction r)
	{
		int status=0;  
		try {
			con=Connect.connecttodb();
			System.out.println("^^^^^^^^ "+r.getCompanyName()+" &&&&&& "+r.getCompanyAddress());
			PreparedStatement ps=con.prepareStatement("insert into company (CompanyName, CompanyAddress,CreatedBy,Action) values(?,?,'admin','1')");
			ps.setString(1, r.getCompanyName());
			//ps.setString(2, r.getPassword());
			ps.setString(2, r.getCompanyAddress());
			//ps.setString(4, r.getMobile());
			//ps.setString(5,);
			
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
