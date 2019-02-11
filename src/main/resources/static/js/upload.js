    

var xhrOnProgress=function(fun) {
        xhrOnProgress.onprogress = fun; //绑定监听
         //使用闭包实现监听绑
        return function() {
            //通过$.ajaxSettings.xhr();获得XMLHttpRequest对象
            var xhr = $.ajaxSettings.xhr();
             //判断监听函数是否为函数
              if (typeof xhrOnProgress.onprogress !== 'function')
                   return xhr;
               //如果有监听函数并且xhr对象支持绑定时就把监听函数绑定上去
                if (xhrOnProgress.onprogress && xhr.upload) {
                      xhr.upload.onprogress = xhrOnProgress.onprogress;
                }
                return xhr;
         }
     }