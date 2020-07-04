/*
 * @Author      : acmaker
 * @Date        : 2020-06-15 20:21:23
 * @LastEditTime: 2020-06-20 16:05:02
 * @FilePath    : \ElevenTableManageSystem_front\js\index.js
 * @Website     : http://csdn.acmaker.vip
 * @Description : 
 */



var signUpButton = document.getElementById('signUp')
var signInButton = document.getElementById('signIn')
var container = document.getElementById('dowebok')

signUpButton.addEventListener('click', function () {
    container.classList.add('right-panel-active')
})

signInButton.addEventListener('click', function () {
    container.classList.remove('right-panel-active')
})


$('#btn_login').click(function () {
    $('#error_1').html();
    MY.ajax(
        "AccountController", {
            "method": "login",
            "username": $('#usernameA').val(),
            "userpass": $('#userpassA').val()
        },
        function (response) {
            if (response.code == 1) {
                location.replace("./platform.html");
            } else {
                $('#error_1').html(response.message);
            }
        },
        function () {
            $('#error_1').html('无法连接到服务器，请联系网站管理员！');
        }
    )
});

$('#btn_register').click(function () {
    let name = $('#usernameB').val();
    let pass1 = $('#userpassB1').val();
    let pass2 = $('#userpassB2').val();
    let pattern = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$/;
    if (pattern.test(name) == false) {
        $('#error_2').html('用户名格式有误！');
        return;
    }
    if (pattern.test(pass1) == false) {
        $('#error_2').html('密码格式有误！');
        return;
    }
    if (pass1 != pass2) {
        $('#error_2').html('两次密码不匹配！');
        return;
    }
    $('#error_2').html();
    MY.ajax(
        "AccountController", {
            "method": "register",
            "username": name,
            "userpass": pass1,
        },
        function (response) {
            if (response.code == 1) {
                location.reload();
                alert("注册成功！");
            } else {
                alert("注册失败！请联系网站管理员！")
            }
        },
        function () {
            $('#error_2').html('无法连接到服务器，请联系网站管理员！');
        }
    )
});



$(document).keydown(function (event) {
    if (event.keyCode == 13) {
        $("#btn_login").click();
    }
});