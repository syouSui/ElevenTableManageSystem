/*
 * @Author      : acmaker
 * @Date        : 2020-06-16 17:40:13
 * @LastEditTime: 2020-06-18 05:28:35
 * @FilePath    : \webapp\js\sys5.js
 * @Website     : http://csdn.acmaker.vip
 * @Description : 
 */


$(function () {
    $('#btn_findAll').click();
})

$('#btn_findAll').click(function () {
    // alert('findAll');
    MY.ajax(
        "HomeController", {
            "method": "findAll",
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("查找全部记录如下：").addClass('text-success');
                $('#box').append(
                    '<table id="table" class="table table-striped table-condensed table-hover" style="font-size:130%;">' +
                    '<tr class="warning">' +
                    '<th>id</th>' +
                    '<th>title</th>' +
                    '<th>price</th>' +
                    '<th>publishTime</th>' +
                    '<th>typeId(type)</th>' +
                    '</tr>' +
                    '</table>'
                );
                $.each(data, function (i, v) {
                    let type = "";
                    if (v.typeId == 1) type = '一室一厅';
                    else if (v.typeId == 2) type = '二室一厅'
                    else type = '三室一厅';
                    $('#table').append(
                        '<tr>' +
                        '<td>' + v.id + '</td>' +
                        '<td>' + v.title + '</td>' +
                        '<td>' + v.price + '</td>' +
                        '<td>' + v.publishTime + '</td>' +
                        '<td>' + type + '</td>' +
                        '</tr>'
                    );
                })
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

$('#btn_findBy_id').click(function () {
    // alert('id');
    MY.ajax(
        "HomeController", {
            "method": "findBy_id",
            "id": $('#ipt_id1').val()
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("按照id精确查找如下：").addClass('text-success');
                $('#box').append(
                    '<table id="table" class="table table-striped table-condensed table-hover" style="font-size:130%;">' +
                    '<tr class="warning">' +
                    '<th>id</th>' +
                    '<th>title</th>' +
                    '<th>price</th>' +
                    '<th>publishTime</th>' +
                    '<th>typeId(type)</th>' +
                    '</tr>' +
                    '</table>'
                );
                let v = data;
                let type = "";
                if (v.typeId == 1) type = '一室一厅';
                else if (v.typeId == 2) type = '二室一厅'
                else type = '三室一厅';
                $('#table').append(
                    '<tr>' +
                    '<td>' + v.id + '</td>' +
                    '<td>' + v.title + '</td>' +
                    '<td>' + v.price + '</td>' +
                    '<td>' + v.publishTime + '</td>' +
                    '<td>' + type + '</td>' +
                    '</tr>'
                );
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

$('#btn_findBy_title').click(function () {
    // alert('tile');
    MY.ajax(
        "HomeController", {
            "method": "findBy_title",
            "title": $('#ipt_title1').val()
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("按照标题模糊查找如下：").addClass('text-success');
                $('#box').append(
                    '<table id="table" class="table table-striped table-condensed table-hover" style="font-size:130%;">' +
                    '<tr class="warning">' +
                    '<th>id</th>' +
                    '<th>title</th>' +
                    '<th>price</th>' +
                    '<th>publishTime</th>' +
                    '<th>typeId(type)</th>' +
                    '</tr>' +
                    '</table>'
                );
                $.each(data, function (i, v) {
                    let type = "";
                    if (v.typeId == 1) type = '一室一厅';
                    else if (v.typeId == 2) type = '二室一厅'
                    else type = '三室一厅';
                    $('#table').append(
                        '<tr>' +
                        '<td>' + v.id + '</td>' +
                        '<td>' + v.title + '</td>' +
                        '<td>' + v.price + '</td>' +
                        '<td>' + v.publishTime + '</td>' +
                        '<td>' + type + '</td>' +
                        '</tr>'
                    );
                })
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

$('#btn_findBy_publishTime').click(function () {
    // alert('publishTime');
    MY.ajax(
        "HomeController", {
            "method": "findBy_publishTime",
            "publishTime": $('#ipt_publishTime1').val()
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("按照发布时间区间查找如下：").addClass('text-success');
                $('#box').append(
                    '<table id="table" class="table table-striped table-condensed table-hover" style="font-size:130%;">' +
                    '<tr class="warning">' +
                    '<th>id</th>' +
                    '<th>title</th>' +
                    '<th>price</th>' +
                    '<th>publishTime</th>' +
                    '<th>typeId(type)</th>' +
                    '</tr>' +
                    '</table>'
                );
                $.each(data, function (i, v) {
                    let type = "";
                    if (v.typeId == 1) type = '一室一厅';
                    else if (v.typeId == 2) type = '二室一厅'
                    else type = '三室一厅';
                    $('#table').append(
                        '<tr>' +
                        '<td>' + v.id + '</td>' +
                        '<td>' + v.title + '</td>' +
                        '<td>' + v.price + '</td>' +
                        '<td>' + v.publishTime + '</td>' +
                        '<td>' + type + '</td>' +
                        '</tr>'
                    );
                })
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

$('#btn_findBy_price').click(function () {
    // alert('findBy_price');
    MY.ajax(
        "HomeController", {
            "method": "findBy_price",
            "price": $('#ipt_price1').val()
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("按照价格区间查找如下：").addClass('text-success');
                $('#box').append(
                    '<table id="table" class="table table-striped table-condensed table-hover" style="font-size:130%;">' +
                    '<tr class="warning">' +
                    '<th>id</th>' +
                    '<th>title</th>' +
                    '<th>price</th>' +
                    '<th>publishTime</th>' +
                    '<th>typeId(type)</th>' +
                    '</tr>' +
                    '</table>'
                );
                $.each(data, function (i, v) {
                    let type = "";
                    if (v.typeId == 1) type = '一室一厅';
                    else if (v.typeId == 2) type = '二室一厅'
                    else type = '三室一厅';
                    $('#table').append(
                        '<tr>' +
                        '<td>' + v.id + '</td>' +
                        '<td>' + v.title + '</td>' +
                        '<td>' + v.price + '</td>' +
                        '<td>' + v.publishTime + '</td>' +
                        '<td>' + type + '</td>' +
                        '</tr>'
                    );
                })
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

$('#btn_findBy_typeId').click(function () {
    // alert('findBy_typeId');
    let typeId = '';
    let type = $('#ipt_typeId1').val();
    if (type == '一室一厅') typeId = 1;
    else if (type == '二室一厅') typeId = 2;
    else if (type == '三室一厅') typeId = 3;
    else {
        $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
        $('#info_box').html('请检查户型输入格式！').addClass('text-warning');
        return;
    }
    MY.ajax(
        "HomeController", {
            "method": "findBy_typeId",
            "typeId": typeId
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("按照类型查找如下：").addClass('text-success');
                $('#box').append(
                    '<table id="table" class="table table-striped table-condensed table-hover" style="font-size:130%;">' +
                    '<tr class="warning">' +
                    '<th>id</th>' +
                    '<th>title</th>' +
                    '<th>price</th>' +
                    '<th>publishTime</th>' +
                    '<th>typeId(type)</th>' +
                    '</tr>' +
                    '</table>'
                );
                $.each(data, function (i, v) {
                    let type = "";
                    if (v.typeId == 1) type = '一室一厅';
                    else if (v.typeId == 2) type = '二室一厅'
                    else type = '三室一厅';
                    $('#table').append(
                        '<tr>' +
                        '<td>' + v.id + '</td>' +
                        '<td>' + v.title + '</td>' +
                        '<td>' + v.price + '</td>' +
                        '<td>' + v.publishTime + '</td>' +
                        '<td>' + type + '</td>' +
                        '</tr>'
                    );
                })
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

$('#btn_removeById').click(function () {
    // alert('removeById');
    MY.ajax(
        "HomeController", {
            "method": "removeBy_id",
            "id": $('#ipt_id3').val()
        },
        function (response) {
            if (response.code == 1) {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("根据id删除记录成功！点击查找全部记录查看！").addClass('text-success');
            } else {
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html(response.message).addClass('text-warning');
            }
        },
        function () {
            $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:130%;"></div>');
            $('#info_box').html('请检查输入格式和用户登录状态！').addClass('text-danger');
        }
    )
});

$('#btn_add').click(function () {
    // alert('add')
    let typeId = '';
    let type = $('#ipt_typeId2').val();
    if (type == '一室一厅') typeId = 1;
    else if (type == '二室一厅') typeId = 2;
    else if (type == '三室一厅') typeId = 3;
    else {
        $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
        $('#info_box').html('请检查户型输入格式！').addClass('text-warning');
        return;
    }
    MY.ajax(
        "HomeController", {
            "method": "add",
            "id": $('#ipt_id2').val(),
            "title": $('#ipt_title2').val(),
            "price": $('#ipt_price2').val(),
            "publishTime": $('#ipt_publishTime2').val(),
            "typeId": typeId
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("添加记录成功！点击查找全部记录查看！").addClass('text-success');
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
    // alert('modify')
    let typeId = '';
    let type = $('#ipt_typeId2').val();
    if (type == '一室一厅') typeId = 1;
    else if (type == '二室一厅') typeId = 2;
    else if (type == '三室一厅') typeId = 3;
    else {
        $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
        $('#info_box').html('请检查户型输入格式！').addClass('text-warning');
        return;
    }
    MY.ajax(
        "HomeController", {
            "method": "modify",
            "id": $('#ipt_id2').val(),
            "title": $('#ipt_title2').val(),
            "price": $('#ipt_price2').val(),
            "publishTime": $('#ipt_publishTime2').val(),
            "typeId": typeId
        },
        function (response) {
            if (response.code == 1) {
                let data = JSON.parse(response.data);
                $('#box').html('').append('<div id="info_box" style="margin-bottom:2vh;font-weight:900;font-size:150%;"></div>');
                $('#info_box').html("根据id修改记录成功！点击查找全部记录查看！").addClass('text-success');
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


// $('<table></table>', {
//     id: "table",
//     class: "table table-striped table-hover"
// }).appendTo('#box');
// let row = $('<tr></tr>');
// row.append('<th>id</th>');
// row.append('<th>title</th>');
// row.append('<th>price</th>');
// row.append('<th>publishTime</th>');
// row.append('<th>typeId</th>');
// row.appendTo('#table');

// $.each(data, function (i, v) {
//     let row = $('<tr></tr>');
//     row.append('<td>' + v.id + '</td>');
//     row.append('<td>' + v.title + '</td>');
//     row.append('<td>' + v.price + '</td>');
//     row.append('<td>' + v.publishTime + '</td>');
//     row.append('<td>' + v.typeId + '</td>');
//     row.appendTo('#table');
//     // $('<tr>''</tr>',{

//     // }).appendTo('#table');
// });
// $('<input />', {
//     id: 'cbx',
//     name: 'cbx',
//     type: 'checkbox',
//     checked: 'checked',
//     click: function () {
//         alert("点我了~~");
//     }
// }).appendTo($('#box'));