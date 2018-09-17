package dbAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import action.CompanyAction;
import viewThings.Company;



public class CompanyDb {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	private List<Company>list;

	public List<Company> getList() {
		return list;
	}

	public void setList(List<Company> list) {
		this.list = list;
	}

	public CompanyDb(List<Company> list) {
		super();
		this.list = list;
	}
	
public List<Company>searchAll() throws ClassNotFoundException, SQLException{
		
		con=Connect.connecttodb();
		pstmt=con.prepareStatement("select CompanyName,CreatedBy,CompanyAddress,Action from company");
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			list.add(new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			System.out.println("$$$$$$$$$$$");
		}
		System.out.println(Arrays.toString(list.toArray()));
		return list;
	}
	
	public void approve(CompanyAction r) throws SQLException, ClassNotFoundException
	{
		 Statement stmt = null;
		con=Connect.connecttodb();
		System.out.println("lalala12 "+ r.getCompanyName());
		stmt = con.createStatement();
		pstmt=con.prepareStatement("UPDATE company SET Action = '1' WHERE CompanyName= ? ");
		//int rs=
		pstmt.setString(1, r.getCompanyName());
		int rs1=pstmt.executeUpdate();
		System.out.println("Updated queries1212: "+rs1);
				//stmt.executeUpdate(query);
		System.out.println("Updated queries: "+rs1);
		//return rs;
	}
	public void delete(CompanyAction r) throws SQLException, ClassNotFoundException
	{
		 Statement stmt = null;
		con=Connect.connecttodb();
		System.out.println("lalala12 "+ r.getCompanyName());
		stmt = con.createStatement();
		pstmt=con.prepareStatement("DELETE from company WHERE CompanyName= ? ");
		//int rs=
		pstmt.setString(1, r.getCompanyName());
		int rs1=pstmt.executeUpdate();
		System.out.println("Updated queries1212: "+rs1);
				//stmt.executeUpdate(query);
		System.out.println("Updated queries: "+rs1);
		//return rs;
	}
}
