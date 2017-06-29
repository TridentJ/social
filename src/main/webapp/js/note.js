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

function searchNote(pageNum){
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
						$("#search_results").append("<div class=\"col-md-12\"><h2 class=\"title\"><a href=\"showNote.htm?id=" + value.id + "\">" + value.title + "</a></h2>" + 
								"<div class=\"clearfix\">" + 
								"<div class=\"meta-info\">作者：<span>" + value.username + "</span> 时间：<span>" + value.lastTime + "</span>" +
								"<div class=\"link-title\"></div>" +
								"</div></div></div>"
						);
					}		
				);
				if(pageNum == 1){
					$("#a_left").addClass="disable";
					$(".pagination").html("<li><a href=\"#\" class=\"disabled\">&laquo;</a></li>" + 
						"<li class=\"active\"><a href=\"javascript:searchNote(1)\">1</a></li>" + 
						"<li><a href=\"javascript:searchNote(2)\">2</a></li><li><a href=\"javascript:searchNote(3)\">3</a></li>" + 
						"<li><a href=\"javascript:searchNote(4)\">4</a></li>" + "<li><a href=\"javascript:searchNote(5)\">5</a></li>" + 
						"<li><a href=\"#\">&raquo;</a></li>"
					);
				}else if(pageNum == 2){
					$(".pagination").html("<li><a href=\"javascript:searchNote(1)\">&laquo;</a></li>" + 
							"<li><a href=\"javascript:searchNote(1)\">1</a></li>" + 
							"<li class=\"active\"><a href=\"javascript:searchNote(2)\">2</a></li>" +
							"<li><a href=\"javascript:searchNote(3)\">3</a></li>" + 
							"<li><a href=\"javascript:searchNote(4)\">4</a></li>" + "<li><a href=\"searchNote(5)\">5</a></li>" + 
							"<li><a href=\"javascript:searchNote(3)\">&raquo;</a></li>"
						);
				}else{
					$(".pagination").html("<li><a href=\"javascript:searchNote(" + (pageNum-1) + ")\">&laquo;</a></li>" + 
							"<li><a href=\"javascript:searchNote(" + (pageNum-2) + ")\">" + (pageNum-2) + "</a></li>" + 
							"<li class=\"active\"><a href=\"javascript:searchNote(" + (pageNum-1) + ")\">" + (pageNum-1) + "</a></li>" + 
							"<li><a href=\"javascript:searchNote(" + pageNum + ")\">" + pageNum + "</a></li>" + 
							"<li><a href=\"javascript:searchNote(" + (pageNum+1) + ")\">" + (pageNum+1) + "</a></li>" + 
							"<li><a href=\"javascript:searchNote(" + (pageNum+2) + ")\">" + (pageNum+2) + "</a></li>" + 
							"<li><a href=\"javascript:searchNote(" + (pageNum+1) + ")\">&raquo;</a></li>"
						);
				}
			}
		}
	});
}


function getNoteList(pageNum){
	var noteType = $("#note_type").val();
	var pageSize = 10;
	$.ajax({
		type:'post',
		url:'getNoteListByType.htm',
		data:{
			'type':noteType,
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
						$("#search_results").append("<div class=\"col-md-12\"><h2 class=\"title\"><a href=\"showNote.htm?id=" + value.id + "\">" + value.title + "</a></h2>" + 
								"<div class=\"clearfix\">" + 
								"<div class=\"meta-info\">作者：<span>" + value.username + "</span> 时间：<span>" + value.lastTime + "</span>" +
								"<div class=\"link-title\"></div>" +
								"</div></div></div>"
						);
					}		
				);
				if(pageNum == 1){
					$("#a_left").addClass="disable";
					$(".pagination").html("<li><a href=\"#\" class=\"disabled\">&laquo;</a></li>" + 
						"<li class=\"active\"><a href=\"javascript:getNoteList(1)\">1</a></li>" + 
						"<li><a href=\"javascript:getNoteList(2)\">2</a></li><li><a href=\"javascript:getNoteList(3)\">3</a></li>" + 
						"<li><a href=\"javascript:getNoteList(4)\">4</a></li>" + "<li><a href=\"javascript:getNoteList(5)\">5</a></li>" + 
						"<li><a href=\"#\">&raquo;</a></li>"
					);
				}else if(pageNum == 2){
					$(".pagination").html("<li><a href=\"javascript:getNoteList(1)\">&laquo;</a></li>" + 
							"<li><a href=\"javascript:getNoteList(1)\">1</a></li>" + 
							"<li class=\"active\"><a href=\"javascript:getNoteList(2)\">2</a></li>" +
							"<li><a href=\"javascript:getNoteList(3)\">3</a></li>" + 
							"<li><a href=\"javascript:getNoteList(4)\">4</a></li>" + "<li><a href=\"getNoteList(5)\">5</a></li>" + 
							"<li><a href=\"javascript:getNoteList(3)\">&raquo;</a></li>"
						);
				}else{
					$(".pagination").html("<li><a href=\"javascript:getNoteList(" + (pageNum-1) + ")\">&laquo;</a></li>" + 
							"<li><a href=\"javascript:getNoteList(" + (pageNum-2) + ")\">" + (pageNum-2) + "</a></li>" + 
							"<li class=\"active\"><a href=\"javascript:getNoteList(" + (pageNum-1) + ")\">" + (pageNum-1) + "</a></li>" + 
							"<li><a href=\"javascript:getNoteList(" + pageNum + ")\">" + pageNum + "</a></li>" + 
							"<li><a href=\"javascript:getNoteList(" + (pageNum+1) + ")\">" + (pageNum+1) + "</a></li>" + 
							"<li><a href=\"javascript:getNoteList(" + (pageNum+2) + ")\">" + (pageNum+2) + "</a></li>" + 
							"<li><a href=\"javascript:getNoteList(" + (pageNum+1) + ")\">&raquo;</a></li>"
						);
				}
			}
		}
	});
}
getNoteList(1);