<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<c:if test="${lsdep==null}">
	<c:redirect url="findAll_Dep.action"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>

<body>
<p>部门管理</p>
<hr/>
<p>
	<table id="tt" width="600" border="1">
		<tr>
			<td>编号</td>
			<td>部门名称</td>
			<td>操作</td>
		</tr>
		<s:iterator value="#session.lsdep" var="dep">
		<tr>
			<td>${dep.depid }</td>
			<td>${dep.depname }</td>
			<td><a href="delById_Dep.action?id=${dep.depid }">删除</a></td>
		</tr>
		</s:iterator>
	</table>
</p>
<hr/>
<form action="save_Dep.action" method="post">
	部门名称:<s:textfield name="dep.depname"></s:textfield><s:submit value="确定"/>
</form>
</body>
</html>