/*
 * @Author      : acmaker
 * @Date        : 2020-06-18 02:56:28
 * @LastEditTime: 2020-06-22 09:49:37
 * @FilePath    : \ElevenTableManageSystem_front\js\checkRole.js
 * @Website     : http://csdn.acmaker.vip
 * @Description : 
 */


$(function () {
    MY.ajax_sync(
        "AccountController", {
            "method": "checkRole"
        },
        function (response) {
            let url = window.location.href;
            let arr = url.split('/');
            let cur = arr[arr.length - 1];
            if (response.code != 1) {
                if (cur != 'index.html')
                    location.replace('./index.html');
            } else {
                if (cur === 'index.html' || cur==='' )
                    location.replace('./platform.html');
            }
        },
        function () {}
    )
})

// let sysFiles = ['home.html', 'platform.html', 'user.html',
//     'sys1.html', 'sys2.html', 'sys3.html', 'sys4.html', 'sys5.html',
//     'sys6.html', 'sys7.html', 'sys8.html', 'sys9.html', 'sys10.html'
// ];