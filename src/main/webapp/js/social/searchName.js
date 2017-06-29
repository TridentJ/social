function searchByName(fuzzy){
		var name = $("#name").val();
		if(name == ""){
			alert("姓名不能为空");
			return;
		}
		$.ajax({
			type:'POST',
			url:'searchByName.htm',
			data:{
				'search':name,
				'fuzzy':fuzzy
			},
			success:function(res){
				if(res.code == 0){
					var content = res.content;
					var col = res.column;
					$("#mb").removeClass("hidden");
					$("#div_table").html('<table class="table"><thead id="table_th"></thead><tbody id="table_tb"></tbody></table>');
					if(col == 8){
						$("#table_th").html('<th class="text-center">ID</th>\
								<th class="text-center">用户名</th>\
								<th class="text-center">邮箱</th>\
								<th class="text-center">密码</th>\
								<th class="text-center">身份证</th>\
								<th class="text-center">电话</th>\
								<th class="text-center">未知</th>\
								<th class="text-center">来源</th>');
					}else if(col == 4){
						$("#table_th").html('<th class="text-center">ID</th>\
								<th class="text-center">邮箱</th>\
								<th class="text-center">密码</th>\
								<th class="text-center">来源</th>');
					}else if(col == 5){
						$("#table_th").html('<th class="text-center">ID</th>\
								<th class="text-center">用户名</th>\
								<th class="text-center">邮箱</th>\
								<th class="text-center">密码</th>\
								<th class="text-center">来源</th>');
					}
					if(!(content instanceof Array)){
						$("#table_tb").html("");
						$("#table_tb").append('<tr>');
						$.each(content,function(key,value){
							$("tr:last").append('<td class="text-center">' + value + '</td>');
						});
						$("#table_tb").append("</tr>");
					}else{
						$("#table_tb").html("");
						$.each(content,function(key,value){
							$("#table_tb").append('<tr title="' + key + '">');
							$.each(value,function(index,item){
								$("tr:last").append('<td class="text-center">' + item + '</td>');
							});
							$("#table_tb").append("</tr>");
						});
					}
				}else if(res.code == 100){
					$("#mb").removeClass("hidden");
					$("#div_table").html('<h1><p class="text-center"><strong id="alert_strong" class="red">未命中!</strong>结果为空</p></h1>');
				}else{
					$("#mb").addClass("hidden");
					$("#div_table").html("");
					$("#alert_strong").html(mail);
					$("#message").append(res.msg);
					$("#alert_div").removeClass("hidden");
				}
			}
		});
	}

function auto(){
	var name = $("#name").val();
	console.log(name);
	if(name == ""){
		return;
	}else{
		searchByName(0);
	}
}
auto();