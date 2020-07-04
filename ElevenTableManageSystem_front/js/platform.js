/*
 * @Author      : acmaker
 * @Date        : 2020-06-15 21:30:55
 * @LastEditTime: 2020-06-18 12:21:17
 * @FilePath    : \webapp\js\platform.js
 * @Website     : http://csdn.acmaker.vip
 * @Description : 
 */


$(function () {
    $('#box_sys').load("./home.html");
    // $('#box_sys').load("./sys5.html");
    // $('#box_sys').load("./user.html");
    // $('#box_sys').load("./403.html");
    MY.ajax(
        "AccountController", {
            "method": "showUserInlineCounter"
        },
        function (response) {
            $('#userInlineCounter').html(response.data);
        },
        function () {
            $('#userInlineCounter').html('Without permission.');
        }
    );
    MY.ajax(
        "AccountController", {
            "method": "showMaxUserInlineCounter"
        },
        function (response) {
            $('#maxUserInlineCounter').html(response.data);
        },
        function () {
            $('#maxUserInlineCounter').html('Without permission.');
        }
    );
    MY.ajax(
        "AccountController", {
            "method": "showUserdetailName"
        },
        function (response) {
            let arr = response.data.split('"');
            $('#span_username').html(arr[1]);
        },
        function () {
            $('#span_username').html('请先登录');
        }
    );
});

$('#a_exit').click(function () {
    MY.ajax(
        "AccountController", {
            "method": "exit"
        },
        function (response) {
            location.replace('./index.html');
        },
        function () {
            alert("服务器发生为止错误！请联系网站管理员！");
        }
    );
});

$('#home').click(function () {
    $('#box_sys').load("./home.html");
});

$('#sys5').click(function () {
    $('#box_sys').load("./sys5.html");
});

$('#user').click(function () {
    $('#box_sys').load("./user.html");
});