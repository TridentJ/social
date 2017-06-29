$('#datepickerDateRange').daterangepicker({
    timePicker: true,
    timePickerIncrement: 30,
    timePicker12Hour:false,
    separator:' To ',
    format: 'YYYY-MM-DD hh:mm:ss',
});
/*
$('#datepickerDate').datepicker({
	format: 'mm-dd-yyyy'
});
*/	

function searchWyDrops(pageNum){
	var dateRange = $("#datepickerDateRange").val();
	var noteTitle = $("#note_title").val();
	var noteTag = $("#note_tag").val();
	var noteType = $("#note_type").val();
	var pageSize = 10;
	$.ajax({
		type:'post',
		url:'searchNote.htm',
		data:{
			'date':dateRange,
			'type':noteType,
			'title':noteTitle,
			'tag':noteTag,
			'pageNum':pageNum,
			'pageSize':pageSize
		},
		success:function(data){
			if(data.code != 0){
				alert(data.msg);
			}else{
				res = data.content;
				$("#search_results").html("");
				jQuery.each(
					res,function(key,value){
						$("#search_results").append("<div class=\"col-md-12\"><h2 class=\"title\"><a href=\"showWyDrops.htm?id=" + value.id + "\">" + BASE64.decode(value.title) + "</a></h2>" + 
								"<div class=\"clearfix\">" + 
								"<div class=\"meta-info\">作者：<span>" + BASE64.decode(value.username) + 
								"<div class=\"link-title\"></div>" +
								"</div></div></div>"
						);
					}		
				);
				if(pageNum == 1){
					$("#a_left").addClass="disable";
					$(".pagination").html("<li><a href=\"#\" class=\"disabled\">&laquo;</a></li>" + 
						"<li class=\"active\"><a href=\"javascript:searchWyDrops(1)\">1</a></li>" + 
						"<li><a href=\"javascript:searchWyDrops(2)\">2</a></li><li><a href=\"javascript:searchWyDrops(3)\">3</a></li>" + 
						"<li><a href=\"javascript:searchWyDrops(4)\">4</a></li>" + "<li><a href=\"javascript:searchWyDrops(5)\">5</a></li>" + 
						"<li><a href=\"#\">&raquo;</a></li>"
					);
				}else if(pageNum == 2){
					$(".pagination").html("<li><a href=\"javascript:searchWyDrops(1)\">&laquo;</a></li>" + 
							"<li><a href=\"javascript:searchWyDrops(1)\">1</a></li>" + 
							"<li class=\"active\"><a href=\"javascript:searchWyDrops(2)\">2</a></li>" +
							"<li><a href=\"javascript:searchWyDrops(3)\">3</a></li>" + 
							"<li><a href=\"javascript:searchWyDrops(4)\">4</a></li>" + "<li><a href=\"searchWyDrops(5)\">5</a></li>" + 
							"<li><a href=\"javascript:searchWyDrops(3)\">&raquo;</a></li>"
						);
				}else{
					$(".pagination").html("<li><a href=\"javascript:searchWyDrops(" + (pageNum-1) + ")\">&laquo;</a></li>" + 
							"<li><a href=\"javascript:searchWyDrops(" + (pageNum-2) + ")\">" + (pageNum-2) + "</a></li>" + 
							"<li class=\"active\"><a href=\"javascript:searchWyDrops(" + (pageNum-1) + ")\">" + (pageNum-1) + "</a></li>" + 
							"<li><a href=\"javascript:searchWyDrops(" + pageNum + ")\">" + pageNum + "</a></li>" + 
							"<li><a href=\"javascript:searchWyDrops(" + (pageNum+1) + ")\">" + (pageNum+1) + "</a></li>" + 
							"<li><a href=\"javascript:searchWyDrops(" + (pageNum+2) + ")\">" + (pageNum+2) + "</a></li>" + 
							"<li><a href=\"javascript:searchWyDrops(" + (pageNum+1) + ")\">&raquo;</a></li>"
						);
				}
			}
		}
	});
}


function getWyDropsList(pageNum){
	var pageSize = 20;
	$.ajax({
		type:'post',
		url:'getWyDropsList.htm',
		data:{
			'pageNum':pageNum,
			'pageSize':pageSize
		},
		success:function(data){
			if(data.code != 0){
				alert(data.msg);
			}else{
				res = data.content;
				$("#search_results").html("");
				jQuery.each(
					res,function(key,value){
						$("#search_results").append("<div class=\"col-md-12\"><h2 class=\"title\"><a href=\"showWyDrops.htm?id=" + value.id + "\">" + BASE64.decode(value.title) + "</a></h2>" + 
								"<div class=\"clearfix\">" + 
								"<div class=\"meta-info\">作者：<span>" + BASE64.decode(value.author) + 
								"<div class=\"link-title\"></div>" +
								"</div></div></div>"
						);
					}		
				);
				if(pageNum == 1){
					$("#a_left").addClass="disable";
					$(".pagination").html("<li><a href=\"#\" class=\"disabled\">&laquo;</a></li>" + 
						"<li class=\"active\"><a href=\"javascript:getWyDropsList(1)\">1</a></li>" + 
						"<li><a href=\"javascript:getWyDropsList(2)\">2</a></li><li><a href=\"javascript:getWyDropsList(3)\">3</a></li>" + 
						"<li><a href=\"javascript:getWyDropsList(4)\">4</a></li>" + "<li><a href=\"javascript:getWyDropsList(5)\">5</a></li>" + 
						"<li><a href=\"#\">&raquo;</a></li>"
					);
				}else if(pageNum == 2){
					$(".pagination").html("<li><a href=\"javascript:getWyDropsList(1)\">&laquo;</a></li>" + 
							"<li><a href=\"javascript:getWyDropsList(1)\">1</a></li>" + 
							"<li class=\"active\"><a href=\"javascript:getWyDropsList(2)\">2</a></li>" +
							"<li><a href=\"javascript:getWyDropsList(3)\">3</a></li>" + 
							"<li><a href=\"javascript:getWyDropsList(4)\">4</a></li>" + "<li><a href=\"getWyDropsList(5)\">5</a></li>" + 
							"<li><a href=\"javascript:getWyDropsList(3)\">&raquo;</a></li>"
						);
				}else{
					$(".pagination").html("<li><a href=\"javascript:getWyDropsList(" + (pageNum-1) + ")\">&laquo;</a></li>" + 
							"<li><a href=\"javascript:getWyDropsList(" + (pageNum-2) + ")\">" + (pageNum-2) + "</a></li>" + 
							"<li class=\"active\"><a href=\"javascript:getWyDropsList(" + (pageNum-1) + ")\">" + (pageNum-1) + "</a></li>" + 
							"<li><a href=\"javascript:getWyDropsList(" + pageNum + ")\">" + pageNum + "</a></li>" + 
							"<li><a href=\"javascript:getWyDropsList(" + (pageNum+1) + ")\">" + (pageNum+1) + "</a></li>" + 
							"<li><a href=\"javascript:getWyDropsList(" + (pageNum+2) + ")\">" + (pageNum+2) + "</a></li>" + 
							"<li><a href=\"javascript:getWyDropsList(" + (pageNum+1) + ")\">&raquo;</a></li>"
						);
				}
			}
		}
	});
}
getWyDropsList(1);