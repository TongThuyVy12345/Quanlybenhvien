function generateColor() {
    let r = parseInt(Math.random() * 255);
    let g = parseInt(Math.random() * 255);
    let b = parseInt(Math.random() * 255);

    return `rgb(${r},${g},${b})`
}
function cateCharts(id, cateNDLabels = [], cateNDInfo1 = []) {
    let colors = []
    for (let i = 0; i < cateNDInfo1.length; i++)
        colors.push(generateColor())
    const data = {
        labels: cateNDLabels,
        datasets: [{
                label: 'Thống kê số người dùng theo chức vụ',
                data: cateNDInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'doughnut',
        data: data,
    };
    let ctx = document.getElementById(id).getContext("2d")
    new Chart(ctx, config)
}

function phieukhamChart(id, catePKLabels = [], catePKInfo = [], catePKInfo1 = [], catePKInfo2 = []) {
    let colors = []
    for (let i = 0; i < catePKInfo.length; i++)
        colors.push(generateColor())

    const data = {
        labels: catePKLabels,
        datasets: [{
                label: 'Thống kê số phiếu khám theo doanh thu tổng',
                data: catePKInfo,
                backgroundColor: colors,
                hoverOffset: 4
            },
            {
                label: 'Thống kê số phiếu khám theo doanh thu tiền khám',
                data: catePKInfo1,
                backgroundColor: colors,
                hoverOffset: 4
            },
            {
                label: 'Thống kê số phiếu khám theo doanh thu tiền thuốc',
                data: catePKInfo2,
                backgroundColor: colors,
                hoverOffset: 4
            }
        ]

    };
    const config = {
        type: 'line',
        data: data,
    };
    let ctx = document.getElementById(id).getContext("2d")
    new Chart(ctx, config)
}

function thuocChart(id, catePKLabels = [],catePKInfo = [] ) {
    let colors = []
    for (let i = 0; i < catePKInfo.length; i++)
        colors.push(generateColor())
    const data = {
        labels: catePKLabels,
        datasets: [{
                label: 'Thống kê số lần sử dụng thuốc ',
                data: catePKInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }                  
        ]
    };
    const config = {
        type: 'bar',
        data: data,
    };
    let ctx = document.getElementById(id).getContext("2d")
    new Chart(ctx, config)
}
