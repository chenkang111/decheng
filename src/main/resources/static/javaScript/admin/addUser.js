var $;
layui.use([ 'form', 'layer', 'jquery' ], function() {
	var form = layui.form, layer = parent.layer === undefined ? layui.layer
			: parent.layer, laypage = layui.laypage;
	$ = layui.jquery;

	var addUserArray = [], addUser = "";
	form.on("submit(addUser)",
			function(data) {
				// 是否添加过信息
				if (window.sessionStorage.getItem("addUser")) {
					addUserArray = JSON.parse(window.sessionStorage.getItem("addUser"));
				}

				$.ajax({
					type : "POST",
					url : baseurl + "/admin/register",
					data :data.field,
					success : function(data) {
						if (data.meta.code == 200) {
							setTimeout(function() {
								top.layer.msg("用户添加成功！");
								location.reload();
                                window.location.href = baseurl+"/back/page/admin/adminList.html";
							}, 1000);

						} else if (data.meta.code == 452) {
							top.layer.msg("用户名重复");
						}
					}
				});
			})

})

// 格式化时间
function formatTime(_time) {
	var year = _time.getFullYear();
	var month = _time.getMonth() + 1 < 10 ? "0" + (_time.getMonth() + 1)
			: _time.getMonth() + 1;
	var day = _time.getDate() < 10 ? "0" + _time.getDate() : _time.getDate();
	var hour = _time.getHours() < 10 ? "0" + _time.getHours() : _time
			.getHours();
	var minute = _time.getMinutes() < 10 ? "0" + _time.getMinutes() : _time
			.getMinutes();
	return year + "-" + month + "-" + day + " " + hour + ":" + minute;
}
