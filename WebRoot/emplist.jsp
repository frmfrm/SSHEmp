<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${pb==null}">
	<c:redirect url="findAll_Emp.action"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工列表</title>
<script>
	/*****更改记录数的方法************************/
	function dochangeRows(){
		var rows=document.form1.rows.value;
		if(isNaN(rows)){
			alert('请输入正确的整数值！');
			document.form1.rows.value=${pb.rows};
			return;
		}
		window.location='findAll_Emp.action?rows='+rows;
	}
	/*****************************************/
	/*****更改页数的方法************************/
	function dochangePage(){
		var page=document.form1.page.value;
		if(isNaN(page)){
			alert('请输入正确的整数值！');
			document.form1.page.value=${pb.page};
			return;
		}
		window.location='findAll_Emp.action?page='+page;
	}
	/*****************************************/
</script>
</head>

<body>
<p align="center">员工列表
</p>
<hr />
<table width="800" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr align="center" bgcolor="#FFFFCC">
    <td width="61">编号</td>
    <td width="98">姓名</td>
    <td width="71">性别</td>
    <td width="123">地址</td>
    <td width="137">生日</td>
    <td width="125">部门</td>
    <td width="155">操作</td>
  </tr>
  <s:iterator value="#session.pb.pagelist" var="emp">
  <tr align="center">
    <td>${emp.eid}</td>
    <td><a href="findDetail_Emp.action?eid=${emp.eid}" target="_blank">${emp.ename}</a></td>
    <td>${emp.sex}</td>
    <td>${emp.address}</td>
    <td><s:date name="#emp.birthday" format="yyyy-MM-dd"/></td>
    <td>${emp.dep.depname}</td>
    <td><a href="delById_Emp.action?eid=${emp.eid}" onclick="return window.confirm('是否真的删除!')">删除</a> <a href="findById_Emp.action?eid=${emp.eid}">修改</a></td>
  </tr>
  </s:iterator>
</table>
<form id="form1" name="form1" method="post" action="">
  <table width="800" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr align="center" bgcolor="#FFFFCC">
      <td>
      	<s:if test="#session.pb.page>1">
      		<a href="findAll_Emp.action?page=1">首页</a>
      	</s:if>	
      	<s:else>
      		首页
      	</s:else>
      </td>
      <td>
      	<s:if test="#session.pb.page>1">
      		<a href="findAll_Emp.action?page=${pb.page-1}">上页</a>
      	</s:if>
      	<s:else>
      		上页
      	</s:else>	
      </td>
      <td>
      	<s:if test="#session.pb.page<#session.pb.maxpage">	
      			<a href="findAll_Emp.action?page=${pb.page+1}">下页</a>
      	</s:if>
      	<s:else>
      		下页
      	</s:else>
      </td>
      <td>
      	<s:if test="#session.pb.page<#session.pb.maxpage">	
      		<a href="findAll_Emp.action?page=${pb.maxpage}">末页</a>
      	</s:if>
      	<s:else>
      		末页
      	</s:else>	
      		
      </td>
      <td>每页
        <label for="rows"></label>
      <input name="rows" value="${pb.rows}" type="text" id="rows" size="2" />
      条记录
      <input type="button" name="btchangerows" id="btchangerows" value="确定" onclick="dochangeRows()" /></td>
      <td>跳转到第
        <label for="page"></label>
        <input name="page" value="${pb.page}" type="text" id="page" size="2" />
页
<input type="button" name="btchangepage" id="btchangepage" value="确定" onclick="dochangePage()" /></td>
      <td>${pb.page}/${pb.maxpage}页</td>
    </tr>
  </table>
</form>
<hr />
<p align="center"><a href="empadd.jsp">返回添加</a></p>
</body>
</html>