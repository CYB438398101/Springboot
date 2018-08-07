$(document).ready(function () {


    //按钮点击事件
    $('.btn').click(function (e) {
        var id = $(this).attr("id");
        //如果是点击请求按钮
        if (id == 'send') {
            var url = $('#input').val();
            if (url == '') {
                alert('地址不能为空');
                return;
            }
            postData(url);
            return;
        }
        //如果是点击清除按钮
        if (id == 'clear') {
            $('#output').val('');
            $('#input').val('');
            return;
        }
        var content = getIndex(id, CFG.TEST_URL);
        $('#input').val(content);
        $('#output').val('');
    });
    getPath();
});

//获取请求url地址
function getIndex(id, urls) {
    var l = id.indexOf('-');
    var type = id.substring(0, l);
    var len = id.length;
    var index = id.substring(len - 1).toString();
    return urls[type][index];
}
function getPath(){

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    console.log('路径'+result);
   return result
}

//get请求
function getData(url) {
    console.log('发送get请求：');
    console.log(url);
    $.get(url, function (data, status) {
        console.log('get返回结果：');
        console.log(status);
        var content = JSON.stringify(data);
        $('#output').val(content);
    });
}


function  postData(url) {
    console.log('发送post请求：');
    console.log(url);
    var data={
          url:url,
          method:"get"
    }
    var serverURL =CFG.SERVER+'/testAPI';
    console.log(serverURL);
    $.post(serverURL,data,function (data, status) {
        console.log('post返回结果：');
        console.log(status);
        var content = JSON.stringify(data);
        $('#output').val(content);
    });
}

