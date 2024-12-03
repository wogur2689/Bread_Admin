function fnCommonPostCall(url, data) {
    let res;
    $.ajax({
        type: 'POST',
        async: false,
        url: url,
        dataType: 'json',
        data: data,
        success: function (response) {
            res = response.data;
        },
        error: function (error) {
            console.error('API 호출 실패', error);
            res = '9999';
        }
    });
    return res;
}

function fnCommonGetCall(url, data) {
    let res;
    $.ajax({
        type: 'GET',
        async: false,
        url: url,
        dataType: 'json',
        data: data,
        success: function (response) {
            res = response.data;
        },
        error: function (error) {
            console.error('API 호출 실패', error);
            res = '9999';
        }
    });
    return res;
}