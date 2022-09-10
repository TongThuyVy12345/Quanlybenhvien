<%--
    Document   : thongkenguoidungtheochucvu
    Created on : Sep 2, 2022, 12:48:34 AM
    Author     : ADMIN
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <h1 style="text-align:center;color:#FA4EAB; font-size: 30px;">THỐNG KÊ NGƯỜI DÙNG THEO CHỨC VỤ</h1>
   <div>
       <canvas id="mynguoidungstatsChart"></canvas>
</div>
 
    <table class="table"style="background-color:#E79CC2 ">
        <tr style="text-align:center;">
            <th>CHỨC VỤ</th>
            <th>SỐ LƯỢNG NGƯỜI DÙNG</th>
        </tr>
        <c:forEach items="${nguoidungstats}" var="c">
            <tr style="text-align:center;">
                <td>${c[0]}</td>
                <td>${c[1]}</td>
            </tr>
        </c:forEach>
    </table>


</html>
<script>
    let cateNDLabels = [], cateNDInfo = [];
    <c:forEach items="${nguoidungstats}" var="c">
    cateNDLabels.push('${c[0]}')
    cateNDInfo.push('${c[1]}')
    </c:forEach>
    window.onload = function () {
        cateCharts("mynguoidungstatsChart", cateNDLabels, cateNDInfo)
    }
</script>