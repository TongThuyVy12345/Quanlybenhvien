function themThuoc(id, name, loai) {
    event.preventDefault();

    fetch("/btljava/api/Thuoc", {
        method: 'post',
        body: JSON.stringify({
            "idThuoc": id,
            "tenThuoc": name,
            "cachDung": "",
            "gia": 0,
            "active": 1,
            "idLoaiThuoc": loai
        }),
        headers: {
            "Content-Type": "application/json"
        }
    })
    location.reload();
//    
}

function xoaThuoc(idthuoc){
    fetch('/btljava/api/Thuoc/'+idthuoc.toString(),{
        method: "delete"
    })
    location.reload();
    
}