  var path1='';
  
 
  
layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;
		

    
    
    form.on("submit(addOcument)",function(data){
			//如果有选择图片则上传图片
			console.log(data)
			var formData = new FormData();
			        //append是将信息文件放到formdata中
					formData.append('goodsName', data.field.category);//软件名称
					formData.append('path1',path1 );//软件logo
				$.ajax({
					type: "post",
					url: baseurl+'/document/adddoc',
					data: formData,
					async: true,
					processData: false,
					contentType: false,
					mimeType: "multipart/form-data",
					success: function(res) {
						console.log(res)
						var res= $.parseJSON(res);
						if(res.meta.code == 200){
							console.log(res)
							setTimeout(function() {
								location.reload();
								layer.closeAll();
								layer.msg("添加成功");
							}, 500);
						}else{
							setTimeout(function() {
								location.reload();
								layer.closeAll();
								layer.msg("添加失败");
							}, 500);
						}
					}
				},JSON)
        return false;
    })
    
})

function xmTanUploadImg1(obj) {
	var file = obj.files[0];
	var reader = new FileReader();
	var files = document.getElementById("file").files;
	var filedata;
	
	//读取文件过程方法
	reader.onload = function(e) {
		console.log("成功读取1111....");
	    //或者 img.src = this.result;  //e.target == this
	}
	reader.readAsDataURL(file)
	var formData = new FormData();
		if(files.length > 0) {
			for(var i = 0; i < files.length; i++) {
				//append是将信息文件放到formdata中
				formData.append('filedata', files[i]);
			}
		}
	$.ajax({
		type: "post",
		url: baseurl+"/document/uploadimg",
		data:formData,
		cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false, //必须
		success: function(res) {
			console.log(res)
			path1=path1+','+res.data;
			console.log(path1)
		}
	})
}




