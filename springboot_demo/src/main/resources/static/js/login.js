$(function () {
    $("#login").click(function () {

        console.log("login");
        var username = $("#username").val();
        var password = $("#password").val();
        if (username == "" || password == "") {
            alert("用户名或密码不能为空")
        }
        $("form").submit();
    });
});
