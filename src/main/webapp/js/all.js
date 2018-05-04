
function deleteBath(basePath){
    $("#mainForm").attr("action",basePath);
    $("#mainForm").submit();
}


function checkAll() {  
	var all=document.getElementById('all');//获取到点击全选的那个复选框的id  
	var one=document.getElementsByName('checkId');//获取到复选框的名称  
	//因为获得的是数组，所以要循环 为每一个checked赋值  
	for(var i=0;i<one.length;i++){  
		one[i].checked=all.checked; //直接赋值不就行了嘛  
	}  
} 
function goPage(pages){
    var pageNum = $("#pageGo").val();
    if(pageNum > pages || typeof pageNum == "string" ){
    	pageNum = pages;
	}
	$("#pageNum").val(pageNum);
   $("#mainForm").submit();
}



