function postMemo() {
    let username = $('#username').val();
    console.log(username)
    let title = $('#title').val();
    let content = $('#content').val();
    let data = {'username': username , 'title': title, 'content': content};

    if (username == "" || title == "") {
        alert('이름과 제목을 확인해주세요!');
    }else if (content == "") {
        alert('내용을 입력해주세요!');
    } else {
        $.ajax({
            type: "POST",
            url: "/fanmemo",
            contentType: "application/json", // JSON 형식으로 전달함을 알리기
            data: JSON.stringify(data),
            success: function (response) {
                alert('게시물 등록!');
                window.location.href = "/";
            }

        });
    }

}