// User count chart
const userCtx = document.getElementById('userChart').getContext('2d');
new Chart(userCtx, {
    type: 'bar',
    data: {
        labels: ['월', '화', '수', '목', '금', '토', '일'],
        datasets: [{
            label: '사용자',
            data: [12, 19, 3, 5, 2, 3, 7],
            backgroundColor: '#d9b382',
        }]
    }
});

// Sales chart
const salesCtx = document.getElementById('salesChart').getContext('2d');
new Chart(salesCtx, {
    type: 'line',
    data: {
        labels: ['월', '화', '수', '목', '금', '토', '일'],
        datasets: [{
            label: '매출액',
            data: [100, 200, 150, 300, 250, 400, 350],
            borderColor: '#8b5a2b',
            backgroundColor: 'rgba(139, 90, 43, 0.2)',
        }]
    }
});