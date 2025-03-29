const domain = 'http://localhost:8081'
function fnCommonPostCall(url, data) {
    return fetch(domain + url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('API 호출 실패');
            }
            return response.json();
        })
        .then(data => data)
        .catch(error => {
            console.error(error);
            return '9999';
        });
}

function fnCommonGetCall(url, data) {
    return fetch(domain + url + '?' + new URLSearchParams(data), {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('API 호출 실패');
            }
            return response.json();
        })
        .then(data => data)
        .catch(error => {
            console.error(error);
            return '9999';
        });
}