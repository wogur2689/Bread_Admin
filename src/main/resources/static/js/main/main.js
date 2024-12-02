// User count chart
const userCtx = document.getElementById('userChart').getContext('2d');
new Chart(userCtx, {
    type: 'bar',
    data: {
        labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
        datasets: [{
            label: 'Users',
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
        labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
        datasets: [{
            label: 'Sales',
            data: [100, 200, 150, 300, 250, 400, 350],
            borderColor: '#8b5a2b',
            backgroundColor: 'rgba(139, 90, 43, 0.2)',
        }]
    }
});