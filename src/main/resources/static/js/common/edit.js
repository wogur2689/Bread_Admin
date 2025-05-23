//Quill.js를 이용한 에디터 폼
const quill = new Quill('#editor-container', {
    theme: 'snow',
    placeholder: 'Write your content here...',
    modules: {
        toolbar: [
            [{ header: [1, 2, false] }],
            ['bold', 'italic', 'underline'],
            [{ list: 'ordered' }, { list: 'bullet' }],
            ['link', 'image'],
            ['clean']
        ]
    }
});

//전송 버튼 클릭시 vaildtion 체크 후 api 호출
document.getElementById('submit-btn').addEventListener('click', function (event) {
    event.preventDefault();
    const id = document.getElementById('id').value;                 //id
    const url = document.getElementById('url').value;               //url
    const subject = document.getElementById('subject').value;       //제목
    const contents = quill.root.innerHTML;                             //Quill editor에 입력된 HTML 값

    if (!subject || !contents.trim()) {
        alert('제목, 내용을 입력해주세요');
        return;
    }

    // Simulate form submission
    const params = {
        id,
        subject,
        contents
    };

    const res = fnCommonPostCall(url, params);
    if(res === '9999') {
        alert('시스템 에러');
        return;
    }
    alert('게시글이 등록되었습니다.');
});