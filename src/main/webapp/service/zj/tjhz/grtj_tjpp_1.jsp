<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/common/import.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<title>条件匹配人员列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/styles/css/common.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function(){
		if($("#like").val() == "[null]" || $("#like").val() == ""){
			alert("该人员有未回执推荐信或已冻结");
			history.back(-1);
		}
	})
</script>
</head>
<body onload="name()">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td><table width="98%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr> 
          <td height="20" valign="bottom"><img src="<%=request.getContextPath()%>/styles/images/right/now.gif" width="11" height="12">当前位置：职业介绍 
            &gt; 推荐服务 &gt; 个人推荐服务</td>
        </tr>
        <tr> 
          <td valign="bottom" background="<%=request.getContextPath()%>/styles/images/right/dsline.gif" height="8"><img src="<%=request.getContextPath()%>/styles/images/index/spacer.gif"></td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td align="center" valign="top">
	<table width="98%" border="0" cellpadding="0" cellspacing="0"   class="title">
      <tr>
        <td width="30">
		<table border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td ><img src="<%=request.getContextPath()%>/styles/css/bb_d.gif"></td>
          </tr>
        </table></td>
        <td  valign="bottom">查询结果&nbsp;&nbsp;&nbsp;提示：[请选择个人进行推荐服务，点击姓名查看详细信息]</td>
      </tr>
    </table>
    	<input id="like" type="hidden" value="${list }">
  <tr> 
    <td align="center" > 
    <TABLE width="98%" border=1 cellPadding=0 cellSpacing=0 bordercolor="#FFFFFF" class=tablebody>
		<!-- 页面跳转标志，1代表使用个人编号查询 -->    
            <TR> 
              <TD align="center" class="line4">操作</TD>
              <TD align="center" class="line4">姓名</TD>
              <TD align="center" class="line4">性别</TD>
              <TD align="center" class="line4">年龄</TD>
              <TD align="center" class="line4">居住地址</TD>
              <TD align="center" class="line4">联系电话</TD>
              <TD align="center" class="line4">登记日期 </TD>
            </TR>  
      
             <c:forEach items="${list }" var="info">
            <TR> 
              <TD align="center" class="line4"><a href="<%=request.getContextPath()%>/grtj/tj/tj?bipName=${info.bipName }&bipSex=${info.bipSex }&address=${info.bipResAddress }&bipId=${info.bipId }">推荐</a></TD>
              <TD align="center" class="line4">${info.bipName }</TD>
              <TD align="center" class="line4">${info.bipSex }</TD>
              <TD align="center" class="line4">${info.bipAge }</TD>
              <TD align="center" class="line4">${info.bipResAddress }</TD>
              <TD align="center" class="line4">${info.bipConMobile }</TD>
              <TD align="center" class="line4">${info.djsj }</TD> 
            </TR>  
            </c:forEach>
</table>
<br>
<table align="center" width="98%"  border="0" cellspacing="0" cellpadding="0">
  <tr> 
    	<td class="line2" align="center">
			<input name="button2" type="button"class=BUTTONs3  value="返 回" onClick="javascript:history.back(-1);">
		</td>
    </tr>
</table>
</body>
</html>
