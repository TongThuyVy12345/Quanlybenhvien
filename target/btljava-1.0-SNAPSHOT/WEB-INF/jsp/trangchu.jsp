<%-- 
    Document   : trangchu
    Created on : Aug 9, 2022, 3:41:26 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<body>

    <div class="container-fluid p-5 bg-primary text-white text-center">
        <h1>PHÒNG MẠCH AN KHANG</h1>
        <p></p> 
    </div>

    <div class="container mt-5">
        <div class="row">
            <div class="col-sm-4">
                <h3  style="text-align:center; color: blue"> Giới thiệu</h3>
                <p style="text-align:justify">Phòng khám An Khang nằm trên số 1168 đường Lạc Long Quân, quận 8, phường Tân Bình, thành phố Hồ Chí Minh. Đây là một trong những địa chỉ khám sản phụ khoa uy tín do Giáo sư, Tiến sĩ, Bác sĩ Trần Thị Lợi thành lập vào đưa vào hoạt động. Với mong muốn mang đến sự tiện lợi và một dịch vụ khám chữa bệnh tốt cho bệnh nhân, phòng khám đã không ngừng cải thiện cơ sở vật chất và đào tạo đội ngũ y bác sĩ...</p>
                <p style="text-align:justify">Cơ sở vật chất tại Phòng khám An Khang – Chuyên Sản phụ khoa đều là hệ thống máy móc hiện đại, thiết bị y tế tiên tiến giúp quá trình thăm khám và điều trị tại phòng khám trở nên tốt hơn, an toàn và đạt hiệu quả hơn. Bên cạnh đó, đội ngũ y bác sĩ tại phòng khám là những người có nhiều năm kinh nghiệm trong lĩnh vực y tế, thân thiện, có trách nhiệm và tận tâm với nghề.</p>
            </div>
            <div class="col-sm-4">
                <h3 style="text-align:center; color: blue">Đội ngũ bác sĩ</h3>
                <p style="text-align:justify">Phòng khám do chính Giáo sư, Tiến sĩ, Bác sĩ Trần Thị Lợi thành lập và chịu trách nhiệm chuyên môn. Bên cạnh đó bác sĩ Lợi còn là người trực tiếp thăm khám, trực tiếp điều trị tại Phòng khám Bác sĩ Trần Thị Lợi – Chuyên Sản phụ khoa. Bác sĩ Lợi đã từng học tập và tốt nghiệp trong một trường đại học tốt và uy tín tại thành phố Hồ Chí Minh. Bên cạnh đó bác sĩ còn có nhiều năm kinh nghiệm trong lĩnh vực sản phụ khoa, giàu y đức, có trách nhiệm và luôn thân thiện với bệnh nhân.</p>
                <p style="text-align:justify">
                    Quá trình đào tạo:Tốt nghiệp Bác sĩ chuyên ngành Sản phụ khoa tại trường Đại học Y dược thành phố Hồ Chí Minh. Hoàn thành khóa luận và tốt nghiệp Tiến sĩ tại trường Đại học Y dược thành phố Hồ Chí Minh
                    Được phong hàm Giáo sư.</p>
            </div>
            <div class="col-sm-4">
                <h3 style="text-align:center; color: blue">Cơ sở vật chất</h3>        
                <p style="text-align:justify">Phòng khám An Khang – Chuyên Sản phụ khoa được xây dựng với phòng ốc khang trang, rộng rãi, sạch sẽ, thông thoáng, có hệ thống làm mát mang đến sự dễ chịu cho bệnh nhân trong suốt quá trình thăm khám và điều trị. Bên cạnh đó phòng khám còn trang bị hệ thống máy móc hiện đại, thiết bị y tế tiên tiến giúp quá trình chẩn đoán bệnh lý trở nên chính xác hơn. Quá trình thăm khám và điều trị tại Phòng khám Bác sĩ Trần Thị Lợi – Chuyên Sản phụ khoa cũng trở nên tốt hơn, an toàn và đạt hiệu quả hơn</p>
                <p style="text-align:justify">Ngoài ra, Phòng khám An Khang – Chuyên Sản phụ khoa còn trang bị đầy đủ thiết bị y tế chuyên dụng đã được làm sạch thông qua máy hấp thiết bị vô khuẩn. Điều này giúp bệnh nhân tránh khỏi tình trạng nhiễm trùng và lây nhiễm mầm bệnh từ người này sang người khác.</p>
            </div>
        </div>
    </div>
    <div id="demo" class="carousel slide" data-bs-ride="carousel">

        <!-- Indicators/dots -->
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
        </div>

        <!-- The slideshow/carousel -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://res.cloudinary.com/dbevamq2u/image/upload/v1660670115/130781700-international-doctors-day-background-medical-health-care-banner-design-with-doctor-stethoscope-and-b_bm2i9v.webp" alt="Los Angeles" class="d-block w-100">
            </div>
            <div class="carousel-item">
                <img src="https://res.cloudinary.com/dbevamq2u/image/upload/v1660670116/130781703-international-doctors-day-background-medical-health-care-banner-design-with-doctor-stethoscope-and-b_tkvxix.webp" alt="Chicago" class="d-block w-100">
            </div>
            <div class="carousel-item">
                <img src="https://res.cloudinary.com/dbevamq2u/image/upload/v1660670116/130781703-international-doctors-day-background-medical-health-care-banner-design-with-doctor-stethoscope-and-b_tkvxix.webp" alt="New York" class="d-block w-100">
            </div>
        </div>

        <!-- Left and right controls/icons -->
        <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
            <span class="carousel-control-next-icon"></span>
        </button>
    </div>
    

</body>