/*
 * @Author      : acmaker
 * @Date        : 2020-06-16 18:29:36
 * @LastEditTime: 2020-06-18 14:16:09
 * @FilePath    : \webapp\js\user.js
 * @Website     : http://csdn.acmaker.vip
 * @Description : 
 */




$(function(){
    MY.ajax_sync(
        "AccountController", {
            "method": "checkRole"
        },
        function (response) {
            if ( response.data == 0){
                // location.replace('./403.html');
                $('#panel').html("");
                $('#box').load('./403.html');
                return;
            }
        },
        function () {}
    )
    $('#btn_findAll').click();
})

$('#btn_findAll').click(function () {
    MY.ajax(
        "UserdetailController", {
            "method": "findAll",
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("查找全部用户如下：").addClass('text-success');
                $('#box').append(
                    '<table id="table" class="table table-striped table-condensed table-hover" style="font-size:130%;">' +
                    '<tr class="warning">' +
                    '<th>username</th>' +
                    '<th>userpass</th>' +
                    '<th>role</th>' +
                    '<th>regtime</th>' +
                    '<th>lognum</th>' +
                    '</tr>' +
                    '</table>'
                );
                $.each(data, function (i, v) {
                    let role = "";
                    if (v.role == 1) role = '管理员';
                    else if (v.role == 2) role = '超级管理员'
                    else role = '普通用户';
                    $('#table').append(
                        '<tr>' +
                        '<td>' + v.username + '</td>' +
                        '<td>' + v.userpass + '</td>' +
                        '<td>' + role + '</td>' +
                        '<td>' + v.regtime + '</td>' +
                        '<td>' + v.lognum + '</td>' +
                        '</tr>'
                    );
                })
            } else if (response.code == 403) {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html('403 权限不足!').addClass('text-danger');
            } else {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html(response.message).addClass('text-warning');
            }
        },
        function () {
            $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
            $('#info_box').html('请检查输入格式和用户登录状态！').addClass('text-danger');
        }
    )
});

$('#btn_findBy_username').click(function () {
    MY.ajax(
        "UserdetailController", {
            "method": "findBy_username",
            "username": $('#ipt_username_find').val()
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("按用户名查找如下：").addClass('text-success');
                $('#box').append(
                    '<table id="table" class="table table-striped table-condensed table-hover" style="font-size:130%;">' +
                    '<tr class="warning">' +
                    '<th>username</th>' +
                    '<th>userpass</th>' +
                    '<th>role</th>' +
                    '<th>regtime</th>' +
                    '<th>lognum</th>' +
                    '</tr>' +
                    '</table>'
                );
                let v = data;
                let role = "";
                if (v.role == 1) role = '管理员';
                else if (v.role == 2) role = '超级管理员'
                else role = '普通用户';
                $('#table').append(
                    '<tr>' +
                    '<td>' + v.username + '</td>' +
                    '<td>' + v.userpass + '</td>' +
                    '<td>' + v.role + '</td>' +
                    '<td>' + v.regtime + '</td>' +
                    '<td>' + v.lognum + '</td>' +
                    '</tr>'
                );
            } else if (response.code == 403) {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html('403 权限不足!').addClass('text-danger');
            } else {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html(response.message).addClass('text-warning');
            }
        },
        function () {
            $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
            $('#info_box').html('请检查输入格式和用户登录状态！').addClass('text-danger');
        }
    )
});

$('#btn_removeBy_username').click(function () {
    MY.ajax(
        "UserdetailController", {
            "method": "removeBy_username",
            "username": $('#ipt_username_remove').val()
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("按用户名删除成功!点击查找全部用户查看!：").addClass('text-success');
            } else if (response.code == 403) {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html('403 权限不足!').addClass('text-danger');
            } else {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html(response.message).addClass('text-warning');
            }
        },
        function () {
            $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
            $('#info_box').html('请检查输入格式和用户登录状态！').addClass('text-danger');
        }
    )
});

$('#btn_showInlineUsername').click(function () {
    MY.ajax(
        "AccountController", {
            "method": "showUsernameInlineList",
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("当前在线用户显示如下：").addClass('text-success');
                $('#box').append(
                    '<table id="table" class="table table-striped table-condensed table-hover" style="font-size:130%;">' +
                    '<tr class="warning">' +
                    '<th>username</th>' +
                    '</tr>' +
                    '</table>'
                );
                $.each(data, function (i, v) {
                    $('#table').append(
                        '<tr>' +
                        '<td>' + v+ '</td>' +
                        '</tr>'
                    );
                })
            } else if (response.code == 403) {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html('403 权限不足!').addClass('text-danger');
            } else {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html(response.message).addClass('text-warning');
            }
        },
        function () {
            $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
            $('#info_box').html('请检查输入格式和用户登录状态！').addClass('text-danger');
        }
    )
});

$('#btn_add').click(function () {
    MY.ajax(
        "UserdetailController", {
            "method": "add",
            "username": $('#ipt_username').val(),
            "userpass": $('#ipt_userpass').val(),
            "role": $('#ipt_role').val(),
            "regtime": $('#ipt_regtime').val(),
            "lognum": $('#ipt_lognum').val()
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("添加用户成功!点击查找全部用户查看!：").addClass('text-success');
            } else if (response.code == 403) {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html('403 权限不足!').addClass('text-danger');
            } else {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html(response.message).addClass('text-warning');
            }
        },
        function () {
            $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
            $('#info_box').html('请检查输入格式和用户登录状态！').addClass('text-danger');
        }
    )
});

$('#btn_modify').click(function () {
    MY.ajax(
        "UserdetailController", {
            "method": "modify",
            "username": $('#ipt_username').val(),
            "userpass": $('#ipt_userpass').val(),
            "role": $('#ipt_role').val(),
            "regtime": $('#ipt_regtime').val(),
            "lognum": $('#ipt_lognum').val()
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("修改用户成功!点击查找全部用户查看!：").addClass('text-success');
            } else if (response.code == 403) {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html('403 权限不足!').addClass('text-danger');
            } else {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html(response.message).addClass('text-warning');
            }
        },
        function () {
            $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
            $('#info_box').html('请检查输入格式和用户登录状态！').addClass('text-danger');
        }
    )
});