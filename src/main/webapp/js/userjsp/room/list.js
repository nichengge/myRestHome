
function openedQuery(basePath,id){
	 $("#mainForm").attr("action",basePath+"openedQuery");
	$("#id").val(id);
   $("#mainForm").submit();
}

function findPage(basePath,name,currentPage){
    $("#name").val(name);
    $("#currentPage").val(currentPage);
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
function goPage(basePath,name){
    $("#name").val(name);
    var currentPage = document.getElementById("pageGo").value;
    $("#currentPage").val(currentPage);
   $("#mainForm").submit();
}



