
layui.use(['form'],function(){
	form = layui.form;
    form.verify({
        newPwd : function(value, item){
            if(value.length < 6){
                return "密码长度不能小于6位";
            }
        },
        confirmPwd : function(value, item){
            if(!new RegExp($("#oldPwd").val()).test(value)){
                return "两次输入密码不一致，请重新输入！";
            }
        }      
    })
    
    
    $(document).on('keydown', function(e){
    	if (e.keyCode === 13) {
    	$("#changepwd").click();
    	}
    	}
    )
    
    form.on("submit(changePwd)",function(data){
    	data.field.adminId=localStorage.getItem("administerId");
    	var name=data.field.adminNickname;
   	    $.ajax({
 		   type: "POST",
 		   url: baseurl+"/admin/changeadmin",
 		   data:data.field,
 		   success: function(data){
 			   if(data.meta.code==203){
 				  layer.close(index);
		          layer.msg("原密码错误！");
 			   }
			   if(data.meta.code==200){
				  localStorage.setItem("nickName",name);
			       top.layer.msg("修改成功！");
				   localStorage.clear();
				   parent.location.reload(); 
 			   }else{
 				  top.layer.msg("修改失败！");
 			   }

			   //parent.$(".userName").text(localStorage.getItem("nickName"));
 		   }
		}); 
    })
})