package dbAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import action.RegisterAction;

public class RegisterDao {
static Connection con=null;
ResultSet rs=null;
public static int save(RegisterAction r)
{
	int status=0;  
	try {
		con=Connect.connecttodb();
		PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,DEFAULT)");
		ps.setString(1, r.getUsername());
		ps.setString(2, r.getPassword());
		ps.setString(3, r.getEmail());
		ps.setString(4, r.getMobile());
		//ps.setString(5,);
		
		status=ps.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return status;
}
public static int newadmin(RegisterAction r)
{
	int status=0;  
	try {
		con=Connect.connecttodb();
		PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
		ps.setString(1, r.getUsername());
		ps.setString(2, r.getPassword());
		ps.setString(3, r.getEmail());
		ps.setString(4, r.getMobile());
		ps.setString(5,r.getRole());
		
		status=ps.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return status;
}

}
