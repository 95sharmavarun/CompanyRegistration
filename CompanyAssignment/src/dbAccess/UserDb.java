package dbAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import viewThings.*;
public class UserDb {

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	private ArrayList<User> user=new ArrayList<>();

	public ArrayList<User> getUser() {
		return user;
	}

	public void setUser(ArrayList<User> user) {
		this.user = user;
	}
	
	public User findByUsername(String name) throws ClassNotFoundException, SQLException
	{
		User user=new User();
		con=Connect.connecttodb();
		pstmt=con.prepareStatement("select username,password,role from register where username=?");
		pstmt.setString(1, name);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			user=new User(rs.getString(1),rs.getString(2),rs.getString(3));
		}
		return user;
	}
}
