<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<style type="text/css">
#apDiv1 {
	position: absolute;
	width: 687px;
	height: 355px;
	z-index: 1;
	left: 309px;
	top: 159px;
	text-align: center;
}
.aa {
	font-weight: bold;
	font-size: xx-large;
}
</style>
</head>

<body background="image/nature_05.jpg">
<div id="apDiv1">
  <form id="form1" name="form1" method="post" action="check_Users.action">
    <p><br />
    <span class="aa">人力资源管理职员工管理</span></p>
    <p>&nbsp; </p>
    <table width="450" border="0" align="center" cellpadding="0" cellspacing="10">
      <tr>
        <td height="33" colspan="2" align="center" bgcolor="#C9BDBD">用户登录</td>
      </tr>
      <tr>
        <td width="60">账号:</td>
        <td width="360"><label for="us.aname"></label>
        <input type="text" name="us.aname" id="us.aname" /></td>
      </tr>
      <tr>
        <td>密码:</td>
        <td><label for="us.passwd"></label>
        <input type="password" name="us.passwd" id="us.passwd" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center" bgcolor="#C9BDBD"><input type="submit" name="button" id="button" value="提交" />
          　
        <input type="reset" name="button2" id="button2" value="重置" /></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>