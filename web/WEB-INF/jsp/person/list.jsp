<%-- 
    Document   : list
    Created on : Aug 30, 2012, 9:00:54 PM
    Author     : bahrie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Daftar Person</h1>
        <a href="person?action=insert">Tambah Person</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nama</th>
                <th>Alamat</th>
                <th>action</th>
            </tr>
            <c:if test="${not empty data}">
                <c:forEach var="person" items="${data}">
                    <tr>
                <td>${person.id}</td>
                <td>${person.nama}</td>
                <td>${person.alamat}</td>
                <td><a href="person?action=update&id=${person.id}">Update</a>   <a href="person?action=delete&id=${person.id}">Delete</a></td>
            </tr>
                </c:forEach>
            </c:if>
        </table>
    </body>
</html>
