//date -> yyyy-mm-dd
function formatDateYyyyMMdd(date) {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
}

//yyyy-mm-dd -> mm월 dd일 요일
function formatDateMMdd(dateString) {
    const daysOfWeek = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];

    // 입력 날짜를 Date 객체로 변환
    const date = new Date(dateString);

    // 월, 일, 요일 추출
    const month = date.getMonth() + 1; // 월은 0부터 시작하므로 1을 더함
    const day = date.getDate();
    const dayOfWeek = daysOfWeek[date.getDay()]; // 요일 인덱스로 요일을 찾음

    // 포맷된 문자열 반환
    return `${month}월 ${day}일 ${dayOfWeek}`;
}

//시작일 부터 종료일까지의 날짜 배열 생성
function getDateRange(start, end) {
    const dateArray = [];
    let currentDate = new Date(start);

    while (currentDate <= new Date(end)) {
        dateArray.push(new Date(currentDate));
        currentDate.setDate(currentDate.getDate() + 1);
    }

    return dateArray.map(date => date.toISOString().split("T")[0]);
}

/**
 * MM/dd/yyyy 형식의 날짜로 변환
 * @param {Date} date
 * @returns {string} formattedDate
 */
function formatDateMmDdYyyy(date) {
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    const year = date.getFullYear();
    return `${month}/${day}/${year}`;
}

/**
 * yyyy년 MM월 dd일 형식으로 변환
 * @param {Date} date
 * @returns {string} formattedDate
 */
function formatDateKor(date) {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${year}년 ${month}월 ${day}일`;
}

/**
 * yyyy-MM-dd HH:mm:ss 형식으로 변환
 * @param {Date} date
 * @returns {string} formattedDate
 */
function formatDateTime(date) {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');
    const seconds = String(date.getSeconds()).padStart(2, '0');
    return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
}

/**
 * 날짜 차이 계산 (현재 시간과 비교하여 "X일 전", "Y시간 전" 등)
 * @param {Date} date
 * @returns {string} formattedDiff
 */
function getTimeAgo(date) {
    const now = new Date();
    const diffInMs = now - date;
    const diffInSeconds = Math.floor(diffInMs / 1000);
    const diffInMinutes = Math.floor(diffInSeconds / 60);
    const diffInHours = Math.floor(diffInMinutes / 60);
    const diffInDays = Math.floor(diffInHours / 24);

    if (diffInDays > 0) {
        return `${diffInDays}일 전`;
    } else if (diffInHours > 0) {
        return `${diffInHours}시간 전`;
    } else if (diffInMinutes > 0) {
        return `${diffInMinutes}분 전`;
    } else {
        return `${diffInSeconds}초 전`;
    }
}

/**
 * Date 객체로 변환 (yyyy-MM-dd 형식 문자열을 Date 객체로 변환)
 * @param {string} dateString
 * @returns {Date} date
 */
function parseDate(dateString) {
    return new Date(dateString);
}

// 현재 날짜 반환 (yyyy-MM-dd 형식)
function getCurrentDate() {
    return formatDateYyyyMMdd(new Date());
}