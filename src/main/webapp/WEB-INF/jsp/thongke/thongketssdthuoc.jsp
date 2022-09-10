<%-- 
    Document   : thongketssdthuoc
    Created on : Sep 2, 2022, 11:51:25 PM
    Author     : ADMIN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <h1 style="text-align:center;color:#FA4EAB; font-size: 30px;"> 
        THỐNG KÊ TẦN SUẤT SỬ DỤNG THUỐC THEO THÁNG
    </h1>
    <form>
        <div class="form-group">
            <label>
                Từ khóa
            </label>
            <input type="text"name="kw" class="form-control"/>
        </div>
        <div class="form-group">
            <label>
                Từ thời điểm
            </label>
            <input type="date"name="fromDate" class="form-control"/>
        </div>
        <div class="form-group">
            <label>
                Đến thời điểm
            </label>
            <input type="date"name="toDate" class="form-control"/>
        </div>
        <input type="submit" value="Báo cáo"  class="btn" style="margin: 20px 0px 10px 350px; background-color: pink; border-color: black">

    </form>
    <div>
        <canvas id="mythuocstatsChart"></canvas>
    </div>

    <table class="table"style="background-color:#E79CC2 ">
        <tr style="text-align:center;">

          
            <th>Tên thuốc</th>
            <th>Tổng số lần sử dụng thuốc</th>

        </tr>
        <c:forEach items="${tssdthuocStats}" var="p">
            <tr style="text-align:center;">
             
                <td>${p[0]}</td>
                <td>${p[1]}</td>

            </tr>
        </c:forEach>
    </table>
</html>
<script>
    let catePKLabels = [],catePKInfo = [];
    <c:forEach items="${tssdthuocStats}" var="p">
    catePKLabels.push('${p[0]}')
    catePKInfo.push(${p[1]})
    
    </c:forEach>
    window.onload = function () {
        thuocChart("mythuocstatsChart", catePKLabels, catePKInfo)

    }
</script>

