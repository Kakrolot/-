<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户修改</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="back"><a href="#" onclick="window.history.go(-1)">返回</a></li>
	<li id="update"><a href="#" onclick="formSubmit('update','_self');this.blur();">保存</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户修改
  </div> 
  
<div>


<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
			<td><input type="hidden" name="userId" value="${user.userId }"/></td>
			<td><input type="hidden" name="userInfo.userInfoId" value=${user.userInfo.userInfoId }/></td>
		<tr class="odd">
			
			<td>用户名:</td>	
			<td><input type="text" name="username" value="${user.username }"/></td>
			<td>密码:</td>
			<td><input type="password" name="password" value=${user.password }/></td>
		</tr>
		<tr class="odd">
			<td>所属部门:</td>
			<td>
				<select name="dept.deptId" style="width:120px" >
					<option value="${user.dept.deptId }">${user.dept.deptName }</option>
					<c:forEach items="${deptList}" var="d">
						<option value="${d.deptId}">${d.deptName}</option>
					</c:forEach>	
				</select>
			</td>
			<td>真实姓名:</td>
			<td><input type="text" name="userInfo.name" value="${user.userInfo.name }"/></td>
		</tr>
		<tr class="odd">
			<td>身份证号:</td>
			<td><input type="text" name="userInfo.cardNo" value="${user.userInfo.cardNo }"/></td>
			<td>上级领导:</td>
			<td>
				<select name="userInfo.managerInfo.userInfoId" style="width:120px" >
					<option value="${user.userInfo.managerInfo.userInfoId }">${user.userInfo.managerInfo.name }</option>
					<c:forEach items="${userInfoList}" var="p">
						<option value="${p.userInfo.userInfoId}">${p.userInfo.name}</option>
					</c:forEach>	
				</select>
			</td>
		</tr>
		<tr class="odd">
			<td>入职日期:</td>
			<td>
			<!-- <input type="text" style="width:90px;" name="userInfo.joinDate"
	   	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/> -->
	   	
	   		<fmt:formatDate value="${user.userInfo.joinDate }" pattern="yyyy-MM-dd"/>
			</td>
			<td>薪资:</td>
			<td><input type="text" name="userInfo.salary" value="${user.userInfo.salary }"/></td>
		</tr>
		<tr class="odd">
			<td>出生日期:</td>
			<td>
				<!-- <input type="text" style="width:90px;" name="userInfo.birthday"
	   	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/> -->
	   		<fmt:formatDate value="${user.userInfo.birthday }" pattern="yyyy-MM-dd"/>
			</td>
			<td>性别:</td>
			<td>
			
				<input type="radio" name="userInfo.gender" value="男" <c:if test="${user.userInfo.gender=='男' }">checked="checked"</c:if> />男
				<input type="radio" name="userInfo.gender" value="女" <c:if test="${user.userInfo.gender=='女' }">checked="checked"</c:if>/>女
			</td>
		</tr>
		<tr class="odd">
			<td>岗位描述:</td>
			<td><input type="text" name="userInfo.station" value="${user.userInfo.station }"/></td>
			<td>电话号码:</td>
			<td><input type="text" name="userInfo.telephone" value="${user.userInfo.telephone }"/></td>
		</tr>
		<tr class="odd">
			<td>用户级别:</td>
			<td>
				<select name="userInfo.userLevel" style="width:120px" >
					<option value="4" <c:if test="${user.userInfo.userLevel =='4'}">selected="selected"</c:if>>普通用户</option>
					<option value="1" <c:if test="${user.userInfo.userLevel =='1'}">selected="selected"</c:if>>总经理</option>
					<option value="2" <c:if test="${user.userInfo.userLevel =='2'}">selected="selected"</c:if>>副总</option>
					<option value="3" <c:if test="${user.userInfo.userLevel =='3'}">selected="selected"</c:if>>部门经理</option>
				</select>
			</td>
			<td>排序号:</td>
			<td><input type="text" name="userInfo.orderNo"/></td>
		</tr>
		<tr class="odd">
			<td>状态:</td>
			<td colspan="3">
				<input  type="radio" name="state" value="1" <c:if test="${user.state=='1' }">checked="checked"</c:if>/>启用
				<input  type="radio" name="state" value="0" <c:if test="${user.state=='0' }">checked="checked"</c:if>/>停用
			</td>
		</tr>
		<tr class="odd">
			<td>备注信息:</td>
			<td colspan="3">
				<textarea name="userInfo.remark" style="height:80px;width:100%" value="${user.userInfo.remark }"></textarea>
			</td>
		</tr>
	</table>
</div>
 
</div>
</form>
</body>
</html>

