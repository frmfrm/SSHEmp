<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${demp==null }">
	<c:redirect url="findAll_Emp.action"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工详细信息</title>
</head>

<body>
<table width="450" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr>
    <td colspan="3" align="center" bgcolor="#FFFFCC">员工详细信息</td>
  </tr>
  <tr>
    <td width="99">姓名：</td>
    <td width="225">${demp.ename}</td>
    <td width="112" rowspan="7"><img src="uppic/${demp.photo}" alt="" width="112" height="150" /></td>
  </tr>
  <tr>
    <td>性别：</td>
    <td>${demp.sex}</td>
  </tr>
  <tr>
    <td>地址：</td>
    <td>${demp.address}</td>
  </tr>
  <tr>
    <td>生日：</td>
    <td><s:date name="#session.demp.birthday" format="yyyy-MM-dd"/></td>
  </tr>
  <tr>
    <td>照片：</td>
    <td>${demp.photo}</td>
  </tr>
  <tr>
    <td>部门：</td>
    <td>${demp.dep.depname}</td>
  </tr>
  <tr>
    <td>薪资：</td>
    <td>${demp.emoney}</td>
  </tr>
  <tr>
    <td>福利</td>
    <td colspan="2">
    	<s:iterator value="#session.demp.empwelfares" var="ewf">
    		${ewf.welfare.wname }<br>
    	</s:iterator>
    </td>
  </tr>
  <tr>
    <td colspan="3" align="center" bgcolor="#FFFFCC"><a href="findAll_Emp.action">显示列表</a></td>
  </tr>
</table>
</body>
</html>