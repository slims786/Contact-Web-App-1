<%@ page language="java"  isELIgnored="false"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contact</title>
</head>
<body  style="text-align:center">
        <h1 style = "text-align:center;color:red">Contact Save</h1>
        <font style = "text-align:center;color:green">${succesMsg}</font>
        <font style = "text-align:center;color:red">${failedMsg}</font>
        <form:form action= "addContact?contactId=${contact.contactId}" method= "POST" modelAttribute= "contact">
        <table border="1" style="text-align:center">
        <tr>
        <td>Contact Name</td>
        <td><form:input path="contactName" /></td>
        </tr>
        <tr>
        <td>Contact Email</td>
        <td><form:input path="contactEmail"/></td>
        </tr>
         <tr>
        <td>Contact Number</td>
        <td><form:input path="contactNumber"/></td>
        </tr>
        <tr>
        <td><input type = "submit" value = "Submit"/></td>
        <td><input type = "reset" value="Reset"></td>
        </tr>
        </table>
        </form:form>
        <a href = "viewActiveContacts" >View All Contacts</a>
</body>
</html>