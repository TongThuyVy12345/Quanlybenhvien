<%-- 
    Document   : dangnhap
    Created on : Aug 17, 2022, 9:03:39 PM
    Author     : ADMIN
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${errMg !=null}">
    <div class="alert alert-danger">
        ${errMg}
    </div>
</c:if>
<c:url value="/admin/quanlyLT/form_LT" var="action"/>

<div class="text-center">
    <div class="container">
        <div class="row" style="background-image: url(https://res.cloudinary.com/dbevamq2u/image/upload/v1661792358/213-2134956_trees-tree-forest-background-wallpaper-nature-black-tree_i5zh65.png);	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
            <div class="mx-auto col-lg-6 col-10">
                <h1 style="text-align: center;color:#554994; font-size:30px"> FORM LOẠI THUỐC &nbsp;</h1>
                <form:form method="post" action="${action}"
                           modelAttribute="dsLTF">
                
                    <div class="form-group" style="margin-top: 20px">
                        <a STYLE="margin-RIGHT:350px"></a>
                        <form:input type="text" class="form-control" id="tenLoaiThuoc" placeholder="Tên Loại Thuốc" path="tenLoaiThuoc" 
                                   />
                    </div>
                    <div class="form-group" style="margin-top: 20px;"> 
                        <div class="form-floating" >
                            <input type="submit"
                                   value="SUBMIT"class="btn btn-primary" style="margin: 20px 0px">
                        </div>
                    </div>
                </form:form>



            </div>
        </div>
    </div>
</div>
<div class="spinner-border text-secondary" id="myLoading" style="visibility: hidden"></div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>

