<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<s:include value="bootstrap.jsp"></s:include>
</head>
<body background="images/form.jpg">

<div class="container-fluid">
<s:include value="header.jsp"></s:include>





<div align="center">
<h1><B>Company Registration</B></h1>

</div>

<br>
<br>
<br>
<br>
<br>
<div class="row">
 <div class="col">
<h2 ><b>login</b></h2>

<s:form action="login" >

<s:fielderror value="msg"></s:fielderror>
<div class="col-7">
 <s:label theme="simple"   class="col-sm-2 col-form-label col-form-label-sm"><b>Username</b></s:label>
 
<s:textfield theme="simple" class="form-control mb-2 mr-sm-2" name="username" placeholder="username"></s:textfield>
</div>
<div class="col-7">
 <s:label theme="simple"   class="col-sm-2 col-form-label col-form-label-sm"><b>Password</b></s:label>
 
<s:password theme="simple" class="form-control mb-2 mr-sm-2" name="password" placeholder="password" ></s:password>
</div>
<div class="col-7" align="center">
<s:submit  theme="simple"  class="btn btn-primary" value="Login"> </s:submit>
</div>
</div>
</s:form>

</div>
<hr>
 <div class="col">
<h2><b>Signup for new user</b></h2>
<s:form theme="simple"  action="register"> 
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


  <div class="col-10" align="center">
<s:submit  class="btn btn-success" value="Register"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp; <s:reset type="button" key="reset" class="btn btn-info" value="Reset"/>
</div>  

</s:form>


</div>


</div>
</div>

</body>
</html>