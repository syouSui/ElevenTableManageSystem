/*
 * @Author      : acmaker
 * @Date        : 2020-06-15 20:21:46
 * @LastEditTime: 2020-06-20 16:55:50
 * @FilePath    : \ElevenTableManageSystem_front\js\MY.js
 * @Website     : http://csdn.acmaker.vip
 * @Description : 
 */



// 1.0.0

var MY = {
    // 测试用URL 1
    URL: "http://localhost:8080/ElevenTableManageSystem/",
    // 测试用URL 2
    // URL: "",
    // 生产环境URL
    // URL: "http://etms.acmaker.vip/",
    ajax: function (url, parameter, func_success, func_error) {
        $.ajax({
            url: MY.URL + url,
            type: "POST",
            dataType: "json",
            async: true,
            data: parameter,
            success: function (response, status, xhr) {
                func_success(response, status, xhr);
            },
            error: function () {
                func_error();
            },
            crossDomain: true,
            xhrFields: {
                withCredentials: true
            }
        });
    },
    ajax_sync: function (url, parameter, func_success, func_error) {
        $.ajax({
            url: MY.URL + url,
            type: "POST",
            dataType: "json",
            async: false,
            data: parameter,
            success: function (response, status, xhr) {
                func_success(response, status, xhr);
            },
            error: function () {
                func_error();
            },
            crossDomain: true,
            xhrFields: {
                withCredentials: true
            }
        });
    },

}