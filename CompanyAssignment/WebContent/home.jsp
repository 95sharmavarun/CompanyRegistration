<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<s:include value="bootstrap.jsp"></s:include>
<s:include value="Style.jsp"></s:include>
</head>
<s:include value="logoutheader.jsp"></s:include>
<body>
<div class="container-fluid">

<h1  style="color:#003366;">Welcome...<B style="color:red;"><s:property value="#session['username']" /> </B></h1>
<s:form action="logout">
<s:submit class="btn btn-success"  value="Logout"></s:submit>
</s:form>
<br><br>
<s:if test="#session.username==null">
<%
response.sendRedirect("login.jsp");
%>
</s:if>
<s:if test='#session.role== "normal_user"'>
<%
response.sendRedirect("user.jsp");
%>
   
</s:if>
<div class="row center" >
<div class="col-md-4">
<s:form action="showcompanies">
<s:submit class="btn btn-warning"  value="Show Companies"></s:submit>
</s:form>
</div>
<div class="col-md-4">
<Button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">ADD New Admin</Button>
</div>
<div class="col-md-2">
<Button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal1">ADD New Company</Button>
</div>
</div>
<br>
<div align="center">
<table class="table table-striped">
<tr>

<th>Company Name</th>
<th>Created By</th>
<th>Company Address</th>
<th>Action</th>
</tr>

<s:iterator value="list" var="m">

<tr>

<td><b><s:property value="#m.CompanyName" /></b> </td>
<td><b><s:property value="#m.CreatedBy" /></b> </td>
<td><b><s:property value="#m.CompanyAddress" /></b> </td>
<td>
<div class="row " >
<div class="col-xs-2">
<s:if test='#m.CreatedBy!= "admin"'>
<s:form action="approve">
<s:hidden name="CompanyName" value="%{CompanyName}"/> 
<s:submit theme="simple" class=" col-xs-4 btn btn-primary"  value="Approve" name="#m.CompanyName"></s:submit>
</s:form>
</s:if></div>&nbsp;&nbsp;&nbsp;
<div class="col-xs-2">
<s:form action="edit">
<s:submit theme="simple" class=" col-xs-4 btn btn-success"  value="Edit"></s:submit>
</s:form>
</div>&nbsp;&nbsp;&nbsp;
<div class="col-xs-2">
<s:form action="delete">
<s:hidden name="CompanyName" value="%{CompanyName}"/> 
<s:submit theme="simple" class=" col-xs-4  btn btn-danger"  value="Delete" name="#m.CompanyName"></s:submit>
</s:form>
</div>
</div>
 </td>

</tr>
</s:iterator>
</table>

</div>


</div>







  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      
      <div class="modal-content">
        <div class="modal-header">
         <center><h2 class="modal-title"><b>Add New Company</b></h2></center>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
         
        </div>
        <div class="modal-body">
          
           <div class="col">
<h2><b>Signup for New Admin</b></h2>
<s:form theme="simple"  action="registeradmin"> 
 <div class="col-10">
 <s:label theme="simple"   class="col-sm-2 col-form-label col-form-label-sm"><b>Username</b></s:label>
<s:textfield class="form-control" placeholder="username" name="username" label="UserName"></s:textfield>  
</div></br>
<div class="col-10">
<s:label theme="simple"   class="col-sm-2 col-form-label col-form-label-sm"><b>Password</b></s:label>
<s:password class="form-control" placeholder="password" name="password" label="Password"></s:password>  
</div></br>
<div class="col-10">
<s:label theme="simple"   class="col-sm-2 col-form-label col-form-label-sm"><b>Email</b></s:label>
<s:textfield class="form-control" placeholder="email" name="email" label="Email"></s:textfield>  
</div></br>
<div class="col-10">
<s:label theme="simple"   class="col-sm-2 col-form-label col-form-label-sm"><b>Phone Number</b></s:label>
<s:textfield class="form-control" placeholder="mobile" name="mobile" label="Mobile"></s:textfield>  
</div></br>
<s:hidden name="role" value="admin"/> 

  <div class="col-10" align="center">
<s:submit  class="btn btn-success" value="Register Admin"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp; <s:reset type="button" key="reset" class="btn btn-info" value="Reset"/>
</div>  

</s:form>


</div>
          
          
          
          
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>






<div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
    
      
      <div class="modal-content">
        <div class="modal-header">
         <center><h2 class="modal-title"><b>Add New Company</b></h2></center>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
         
        </div>
        <div class="modal-body">
          
           <div class="col">

<s:form theme="simple"  action="addcompanybyadmin"> 
 <div class="col-10">
 <s:label theme="simple"   class="col-sm-2 col-form-label col-form-label-sm"><b>Company Name</b></s:label>
<s:textfield class="form-control" placeholder="Company Name" name="CompanyName" label="Company Name"></s:textfield>  
</div></br>
<div class="col-10">
<s:label theme="simple"   class="col-sm-2 col-form-label col-form-label-sm"><b>Company Address</b></s:label>
<s:textfield class="form-control" placeholder="Company Address" name="CompanyAddress" label="Company Address"></s:textfield>  
</div></br>
<s:hidden name="CreatedBy" value="admin"/> 
  <div class="col-10" align="center">
<s:submit  class="btn btn-success" value="register"></s:submit>
</div>  
</s:form>


</div>
          
          
          
          
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>




</body>

</html>