<%-- 
    Document   : lienlac
    Created on : Aug 17, 2022, 9:01:58 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>DANH SÁCH BÁC SĨ</h1>
<D1>
    <c:forEach var="p" items="nguoidungs">
        <h1>${p.taiKhoan}</h1>
    </c:forEach>
</D1>
