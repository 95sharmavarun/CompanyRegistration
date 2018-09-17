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
<s:submit class="btn btn-success"  value="logout"></s:submit>
</s:form>
<br><Button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">ADD</Button><br>
<s:if test="#session.username==null">
<%
response.sendRedirect("login.jsp");
%>
</s:if>
<s:if test='#session.role== "admin"'>
<%
response.sendRedirect("home.jsp");
%>
   
</s:if>

<br>
<s:form action="showcompanies1">
<s:submit class="btn btn-warning"  value="Show Companies"></s:submit> 
</s:form><br>




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
<s:if test='#m.Action== "1"'>
<h5 style="color:blue;">Approved</h5>
</s:if>
<s:if test='#m.Action== "0"'>
<h5 style="color:red;">Not Approved</h5>
</s:if>

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

<s:form theme="simple"  action="addcompany"> 
 <div class="col-10">
 <s:label theme="simple"   class="col-sm-2 col-form-label col-form-label-sm"><b>Company Name</b></s:label>
<s:textfield class="form-control" placeholder="Company Name" name="CompanyName" label="Company Name"></s:textfield>  
</div></br>
<div class="col-10">
<s:label theme="simple"   class="col-sm-2 col-form-label col-form-label-sm"><b>Company Address</b></s:label>
<s:textfield class="form-control" placeholder="Company Address" name="CompanyAddress" label="Company Address"></s:textfield>  
</div></br>
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