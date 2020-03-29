<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function confirmDelete(){
return confirm("Are you sure,you want to delete record?");
}
</script>
</head>
<body>
      <h1 style = "text-align:center;color:red">View All Contacts</h1>
      <font style="text-align:center;color:green">${deletemsg}</font><br>
      <a href="/displayForm">(+)Add Contact</a>
      <table  border="1">
      <thead style="background: cyan" >
        <tr>
        <td>ContactId</td>
        <td>ContactName</td>
        <td>ContactEmail</td>
        <td>ContactNumber</td>
        <td>Action</td>
        </tr>
      </thead>
         <tbody>
            <c:forEach items="${contacts}" var="c"></td>
             <tr>
             <td>${c.contactId}</td>
              <td>${c.contactName}</td>
               <td>${c.contactEmail}</td>
                <td>${c.contactNumber}</td>
                <td>
                <a href="editContact?cid=${c.contactId}">Edit</a> &nbsp;
                 <a href="deleteContact?cid=${c.contactId}"  onclick="confirmDelete()">Delete</a>
                </td>
            </tr>
             </c:forEach>
         </tbody>
      
      
      </table>
</body>
</html>