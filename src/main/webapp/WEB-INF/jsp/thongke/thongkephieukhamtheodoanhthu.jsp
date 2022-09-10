<%-- 
    Document   : thongkephieukhamtheodoanhthu
    Created on : Sep 2, 2022, 6:49:50 PM
    Author     : ADMIN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <h1 style="text-align:center;color:#FA4EAB; font-size: 30px;"> 
        THỐNG KÊ PHIẾU KHÁM THEO DOANH THU  
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
        <canvas id="myphieukhamstatsChart"></canvas>
    </div>

    <table class="table"style="background-color:#E79CC2 ">
        <tr style="text-align:center;">
            <th>Mã phiếu khám</th>
            <th>Doanh thu tiền khám</th>
            <th>Doanh thu tiền thuốc</th>
            <th>Doanh thu tổng</th>


        </tr>
        <c:forEach items="${phieukhamstats}" var="p">
            <tr style="text-align:center;">
                <td>${p[0]}</td>
                <td> <fmt:formatNumber value="${p[1]}" type = "currency"/>VND</td>
                <td> <fmt:formatNumber value="${p[2]}" type = "currency"/>VND</td>
                <td> <fmt:formatNumber value="${p[3]}" type = "currency"/>VND</td>
            </tr>
        </c:forEach>
    </table>
</html>
<script>
    let catePKLabels = [], catePKInfo = [], catePKInfo1 = [], catePKInfo2 = [];
    <c:forEach items="${phieukhamstats}" var="p">
    catePKLabels.push('${p[0]}')
    catePKInfo.push(${p[3]})
    catePKInfo1.push(${p[1]})
    catePKInfo2.push(${p[2]})

    </c:forEach>
    window.onload = function () {
        phieukhamChart("myphieukhamstatsChart", catePKLabels, catePKInfo, catePKInfo1, catePKInfo2)

    }
</script>
