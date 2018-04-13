


function myMessage(basePath,id) {
	$("#id2").val(id);
	$("#messageForm").submit();
}


function deleteBath(basePath,username,currentPage){
    $("#mainForm").attr("action",basePath+"deleteUserBach");
    $("#username").val(username);
    $("#currentPage").val(currentPage);
    $("#mainForm").submit();
}


function deleteOne(basePath,id,username,currentPage){
     $("#mainForm").attr("action",basePath+"deleteUser");
     $("#username").val(username);
     $("#id").val(id);
     $("#currentPage").val(currentPage);
    $("#mainForm").submit();
}

function update(basePath,id,username,currentPage) {
	 $("#mainForm").attr("action",basePath+"queryUpdate");
	 $("#username").val(username);
     $("#id").val(id);
     $("#currentPage").val(currentPage);
    $("#mainForm").submit();
   
}

function findPage(basePath,username,currentPage){
    $("#username").val(username);
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
function goPage(basePath,username){
    $("#username").val(username);
    var currentPage = document.getElementById("pageGo").value;
    $("#currentPage").val(currentPage);
   $("#mainForm").submit();
}



