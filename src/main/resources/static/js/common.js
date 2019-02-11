/*
 * 获取项目路径
 * */

var  baseurl=getPath();

function getPath(){
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}



function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) {
		return unescape(r[2]);
	}
	return null;
}


function formatTime(_time){
    var year = _time.getFullYear();
    var month = _time.getMonth()+1<10 ? "0"+(_time.getMonth()+1) : _time.getMonth()+1;
    var day = _time.getDate()<10 ? "0"+_time.getDate() : _time.getDate();
    var hour = _time.getHours()<10 ? "0"+_time.getHours() : _time.getHours();
    var minute = _time.getMinutes()<10 ? "0"+_time.getMinutes() : _time.getMinutes();
    return year+"-"+month+"-"+day+" "+hour+":"+minute;
}


function reset(){
    layer.close(layer.index);
}





function Format (datetime,fmt){
if(parseInt(datetime)==datetime){
	if(datetime.length==10){
		datetime=datetime*1000;
	}else if(datetime.length==13){
		datetime=parseInt(datetime);
	}
}
datetime =new Date();
var o = {   
 "M+" : datetime.getMonth()+1,                 // 月份
 "d+" : datetime.getDate(),                    // 日
 "h+" : datetime.getHours(),                   // 小时
 "m+" : datetime.getMinutes(),                 // 分
 "s+" : datetime.getSeconds(),                 // 秒
 "q+" : Math.floor((datetime.getMonth()+3)/3), // 季度
 "S"  : datetime.getMilliseconds()             // 毫秒
};   
if(/(y+)/.test(fmt))   
 fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));   
for(var k in o)   
 if(new RegExp("("+ k +")").test(fmt))   
fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
return fmt;   
} 
