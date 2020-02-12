<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${oldemp==null }">
	<c:redirect url="findAll_Emp.action"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工修改</title>
</head>

<body>
<form action="update_Emp.action" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <table width="450" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
      <td colspan="3" align="center" bgcolor="#FFFFCC">员工修改</td>
    </tr>
    <tr>
      <td width="99">姓名：</td>
      <td width="225">
      	<s:textfield name="emp.ename" value="%{#session.oldemp.ename}"/>
      	<s:hidden name="emp.eid" value="%{#session.oldemp.eid}"/>
      
      </td>
      <td width="112" rowspan="7"><img src="uppic/${oldemp.photo}" width="112" height="150" /></td>
    </tr>
    <tr>
      <td>性别：</td>
      <td><s:radio name="emp.sex" list="#{'男':'男','女':'女'}" listKey="key" listValue="value" value="#session.oldemp.sex"/></td>
    </tr>
    <tr>
      <td>地址：</td>
      <td><s:textfield name="emp.address"  value="%{#session.oldemp.address}"/></td>
    </tr>
    <tr>
      <td>生日：</td>
      <td><input type="date" name="emp.birthday" value="<s:date name="#session.oldemp.birthday" format="yyyy-MM-dd"/>"/></td>
    </tr>
    <tr>
      <td>照片选择：</td>
      <td><s:file name="emp.pic"/></td>
    </tr>
    <tr>
      <td>部门：</td>
      <td><s:select name="emp.dep.depid" list="#session.lsdep" listKey="depid" listValue="depname" value="#session.oldemp.dep.depid"/></td>
    </tr>
    <tr>
      <td>薪资：</td>
      <td><s:textfield name="emp.emoney" value="%{#session.oldemp.emoney}"/></td>
    </tr>
    <tr>
      <td>福利</td>
      <td colspan="2">
      	<s:checkboxlist name="emp.wids" list="#session.lswf" listKey="wid" listValue="wname" value="#session.oldemp.wids"></s:checkboxlist>
      </td>
    </tr>
    <tr>
      <td colspan="3" align="center" bgcolor="#FFFFCC"><s:submit value="确定"/>&nbsp<s:reset value="重置"/></td>
    </tr>
  </table>
  <p align="center"><a href="findAll_Emp.action">显示列表</a></p>
</form>
</body>
</html>