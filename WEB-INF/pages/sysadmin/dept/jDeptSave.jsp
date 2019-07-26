<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>部门新增</title>
	<script type="text/javascript">
		//使用jquery框架，完成ajax
		$(function(){//页面加载时,执行js函数
			//ajax:当input文本框失去焦点时，校验
			$("#deptId").blur(function(){
				var deptId = $("#deptId").val();
			
				//ajax的异步请求
				$.ajax({
					url:"/sysadmin/dept/checkDeptId",//请求的路径
					data:{deptId:deptId},//传值的参数
					type:"post",//请求的方式
					dataType:"json",//ajax验证结果的格式
					success:function(jieguo){//该结果为json的格式
						//json 其实是key:value的键值对形式
						//举例:{reslt:true} 或者{result:false}
						if(jieguo.result == "true"){
							alert("该部门编号已存在");
						}else{
							alert("该部门编号不存在");
						}
					}
				})
			});
			
		})
	</script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="formSubmit('list','_self');this.blur();">返回</a></li>
	<li id="new"><a href="#" onclick="formSubmit('save','_self');this.blur();">保存</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    部门新增
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr class="odd">
		<td>部门编号：</td>
		<td><input id="deptId" type="text" name="deptId" />${errorInfo }</td>
	</tr>
	<tr class="odd">
		<td>部门名称：</td>
		<td><input type="text" name="deptName" /></td>
	</tr>
	<tr class="odd">
		<td>上级部门：</td>
		<td>
			<select name="parentDept.deptId">
				<option>---无上级---</option>
				<!-- <option value="1">达内集团</option>
				<option value="2">研发部</option>
				<option value="3">教学部</option> -->
				<c:forEach items="${parentDeptList }" var="p" >
					<option value="${p.deptId }">${p.deptName}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr class="odd">
		<td>部门状态：</td>
		<td>
			<input type="radio" name="state" value="1" />启动
			<input type="radio" name="state" value="0" />停用
		</td>
	</tr>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

