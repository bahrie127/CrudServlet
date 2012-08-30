<%-- 
    Document   : form
    Created on : Aug 30, 2012, 9:01:03 PM
    Author     : bahrie
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Person</title>
    </head>
    <body>
        <h1>Form</h1>
        <form method="POST" action="person">
            <table>
                <c:if test="${empty person}">
                    <input type="hidden" name="id"/>
                    <tr>
                        <td>Nama</td><td><input type="text" name="nama"/></td>
                    </tr>
                    <tr>
                        <td>Alamat</td><td><input type="text" name="alamat"/></td>
                    </tr>
                    
                </c:if>
                <c:if test="${not empty person}">
                    <input type="hidden" name="id" value="${person.id}"/>
                    <tr>
                        <td>Nama</td><td><input type="text" name="nama" value="${person.nama}"/></td>
                    </tr>
                    <tr>
                        <td>Alamat</td><td><input type="text" name="alamat" value="${person.alamat}"/></td>
                    </tr>
                </c:if>
                    <tr colspan="2">
                        <td><input type="submit"/></td>
                    </tr>
            </table>
        </form>
    </body>
</html>
