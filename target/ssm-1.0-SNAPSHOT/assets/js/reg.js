// 点击获取验证码操作
function verify() {
    //发送验证码
    $.get("http://" + window.location.host + "/user/getCode/" + $("#telephone").val(),
        function (data) {
            if (data == 'okay') {
                alert("已发送验证码！")
            }
        });
    var count = 60;
    var countdown = setInterval(CountDown, 1000);

    function CountDown() {
        $("#getCode").attr("disabled", true);
        $("#getCode").text("请等待" + count + "秒");
        if (count == 0) {
            $("#getCode").text("重新获取").removeAttr("disabled");
            clearInterval(countdown);
        }
        count--;
    }
}