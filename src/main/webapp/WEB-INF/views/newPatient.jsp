<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Enter the details of Patient</h3>
        <form:form method="POST" action="/patient/save" modelAttribute="patient">
       <table>
    <tr>
        <td>First Name :</td>
        <td><form:input path="firstName" /></td>
    </tr>
    <tr>
        <td>Last Name :</td>
        <td><form:input path="lastName" /></td>
    </tr>
     <tr>
        <td>Address  :</td>
        <td><form:input path="address" /></td>
    </tr>
     <tr>	
        <td>Mobile Number  :</td>
        <td><form:input path="phoneNumber" /></td>
    </tr>
      <tr>
        <td ><input type="submit" value="Register" ></td>
    </tr>
</table>
        </form:form>
    </body>
</html>