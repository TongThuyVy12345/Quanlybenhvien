//function deleteLoaiThuocById(idLoaiThuoc) {
//    if (confirm("Xóa loại thuốc ?") == true) {
//        fetch(`/btljava/admin/quanlyLT/loaithuoc/delete/${idLoaiThuoc}`, {
//            method: 'post',
//            body:JSON.stringify({
//              "idLoaiThuoc":idLoaiThuoc           
//            })
//        }).then(function (res) {
//            return res.json();
//        }).then(function (code) {
//            console.log(code);
//            location.reload();
//        })
//    }
//}
