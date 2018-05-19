<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/styles/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
<form method="post" action="" name="form1" >
<table width="98%"  border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td height="20" valign="bottom"><img src="<%=request.getContextPath()%>/styles/images/right/now.gif" width="11" height="12"> 
			当前位置：职业介绍 &gt; 推荐服务 &gt; 个人推荐服务 &gt; 个人详细信息</td >
	</tr>
	<tr>
		<td valign="bottom" background="<%=request.getContextPath()%>/styles/images/right/dsline.gif" height="8"><img src="<%=request.getContextPath()%>/styles/images/index/spacer.gif"></td >
	</tr>

      </table>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0"  
	onClick="collapseCon('1');" class="titlehand">
	<tr > 
		<td width="60"> <table width="38" border="0" cellspacing="0" cellpadding="0">
				<tr> 
					<td width="30"><img src="<%=request.getContextPath()%>/styles/css/bb_d.gif"></td >
					<td width="8"><img src="<%=request.getContextPath()%>/styles/images/right/ico_up.gif" id="imgmini1"></td >
				</tr >
		</table></td >
	</tr >
</table>
<table width="98%" border="0" cellspacing="0" cellpadding="0" style="display:block" id="c1" align="center">
  <tr >
    <td>
	    <table width="100%" border="0" cellspacing="1" cellpadding="0"   >
        <tr class="line1">
          <td width="14%" align="right">身份证号码</td >
          <td width="22%"><INPUT  name="bip_citizenid" style="WIDTH: 100%" value="${bip.bipCitizenid }" readonly/></td >
          <td width="12%" align="right" >性　　别</td >
          <td width="16%"><INPUT  name="bip_citizenid" style="WIDTH: 100%" value="${bip.bipSex }" readonly/></td >
          <td width="12%" align="right">年　　龄</td >
          <td width="15%"><INPUT  name="bip_age" style="WIDTH: 100%" value="${bip.bipAge }" readonly></td >
          <td width="9%" rowspan="5" align="center" class="line1" valign="top">

			</td >
        </tr>
        <tr class="line2">
          <td align="right">姓　　名</td >
          <td ><INPUT  name="bip_name" maxlength="32"  style="WIDTH: 100%" value="${bip.bipName }"></td >
          <td align="right">民　　族</td >
          <td ><INPUT  name="bip_minzu" style="WIDTH: 100%" value="${bip.bipMinzu }" readonly></td >
          <td align="right">政治面貌</td >
          <td ><INPUT  name="bip_zzmm" style="WIDTH: 100%" value="${bip.bipZzmm }" readonly></td >
        </tr > 
        <tr class="line1">
          <td align="right">婚姻状况</td >
          <td ><INPUT  name="hyzk" style="WIDTH: 100%" value="${bip.bipHyzk }" readonly></td >
          <td align="right">户籍性质</td >
          <td ><INPUT  name="hjxz" style="WIDTH: 100%" value="${bip.bipHjxz }" readonly></td >            
          <td align="right">人员类别</td >
          <td ><INPUT  name="rylb" style="WIDTH: 100%" value="${bip.bipRylb }" readonly></td >
        </tr >
        <tr class="line2">
          <td align="right" >健康状况</td >
          <td ><INPUT  name="jkzk" style="WIDTH: 100%" value="${bip.bipJkzk }" readonly>
		</td >
					<td align="right">
				     <table border="0" cellpadding="0" cellspacing="0">
							<tr class="line2" id="id1"  >
                <td align="right">残疾状况</td >
             </tr >
				    </table></td>
				 <td class="line2" colspan="3">
			     <table border="0" cellpadding="0" cellspacing="0" width="100%" > 
             <tr id="id2"  >
               <td ><INPUT  name="cjzk" style="WIDTH: 100%" value="${bip.bipCjqk }" readonly></td >				
             </tr >
		      </table></td >
        </tr >
        <tr class="line1">
          <td align="right">视　　力</td >
          <td >左<INPUT  name="leftsl" maxlength="3" style="WIDTH: 29%" value="${bip.bipEyesightleft }">
            右

            <INPUT  name="rightsl"   maxlength="3"  style="WIDTH: 29%" value="${bip.bipEyesightright }">
            </td >
          <td align="right">身　　高</td >
          <td ><INPUT  name="sg"   maxlength="3" style="WIDTH: 50%" value="${bip.bipLong }">(厘米)</td >
          <td align="right">体　　重</td >
          <td ><INPUT  name="tz"   maxlength="3"  style="WIDTH: 45%" value="${bip.bipWeight }">(公斤)</td >
        </tr >
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="1">
        <tr class="line2">
         <td width="13%" align="right">户口所在</td >
          <td ><input name="bip_hkszss" size="1" style="WIDTH: 100%" value="${bip.bipHkszd }" readonly></td >
        </tr >
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center"  style="word-break:break-all;width:fixed">
        <tr class="line1"> 
          <td width="13%" align="right" >工作简历</td >
					<td class="line1"><textarea name="gzjl" style="width:100%" readonly>${bip.bipResume }</textarea> 
	      <div align="left">
		  </div></td >
          </tr >
      </table>
			<table width="100%"border="0" cellpadding="0" cellspacing="1" style="display:block"  style="word-break:break-all;width:fixed">
				<tr class="line2">
					<!-- 文化程度连动 modify by ys -->
					<td width="13%" align="right">文化程度</td >
					<td width="30%"><INPUT  name="whcd1" style="WIDTH: 100%" value="${bip.bipWhcd }" readonly></td >
					<td width="13%" align="right">所学专业</td >
					<td width="13%" colspan="3"><input  name="sxzy" maxlength="32"   style="WIDTH: 100%" value="${bip.bipSubject }" readonly></td >
				</tr>
				<tr class="line1">
					<td align="right">毕业学校</td >
					<td ><input  name="byxx" maxlength="32"   style="WIDTH: 100%" value="${bip.bipGraduateschool }" readonly></td >
					<td width="20%" align="right">毕业时间(YYYY-MM)</td >
					<td width="13%" colspan="3"><input  name="bysj" maxlength="32"   style="WIDTH: 100%" value="${bip.bipBysj }" readonly></td >
				</tr>
				<tr class="line2">
					<td align="right">第二学历</td >
					<td colspan="5"><textarea name="qtxl" maxlength="15" style="width:100%" value="${bip.bipEducationallevel2 }" readonly></textarea></td >
				</tr>
				<tr class="line1">
					<td align="right"><span class="redtxt">*</span>固定电话</td >
					<td><INPUT  name="lxdh"    style="WIDTH: 100%" value="${bip.bipConTelephone }" maxlength="32" readonly></td >
					<td width="12%" align="right" ><span class="redtxt">*</span>手　机</td >
					<td width="21%" ><INPUT  name="sj"   maxlength="11"  style="WIDTH: 100%" value="${bip.bipConMobile }" readonly>
					</td>
					<td align="right">E-mail</td >
					<td><INPUT  name="email" maxlength="48"  style="WIDTH: 100%" value="${bip.bipConEmail }" readonly>
					</td >
				</tr>
				<tr class="line2">
					<td align="right">邮政编码</td >
					<td ><INPUT  name="yzbm" maxlength="6"   style="WIDTH: 100%" value="${bip.bipConPostcode }" readonly></td >
					<td align="right">联系人</td >
					<td ><INPUT  name="lxr" maxlength="32"    style="WIDTH: 100%" value="${bip.bipConContact }" readonly></td >
					<td align="right" >联系人电话</td >
					<td ><INPUT  name="lxrdh" maxlength="32"   style="WIDTH: 100%" value="${bip.bipConContacttel }" readonly></td >
				</tr>
				<tr class="line1">
				<td width="13%" align="right">居住地址</td >
				 <td colspan="5"><INPUT  name="jzdz" maxlength="32"   style="WIDTH: 100%" value="${bip.bipResAddress }" readonly></td >
				</tr >
				<tr class="line2">
				<td width="13%" align="right">其他说明</td >
				 <td colspan="5"><textarea name="qtsm" style="width:100%" readonly>${bip.bipQtsm }</textarea></td >
				</tr >
			</table>
		</td >
	</tr>
</table>
	
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="titlehand" onClick="collapseCon('4');">
	<tr >
		<td width="60"> 
			<table width="37" border="0" cellpadding="0" cellspacing="0">
				<tr > 
					<td width="30"><img src="<%=request.getContextPath()%>/styles/css/bb_d.gif" height="19"></td >
					<td width="7"><img src="<%=request.getContextPath()%>/styles/images/right/ico_up.gif" id="imgmini4"></td >
				</tr >
			</table>
		</td >
		<td valign="bottom">其它信息</td >
	</tr >
</table>
	 
<TABLE width="98%" border=0  align="center" cellPadding=0 cellSpacing=1  class="tablebody" style="display:block" id="c4">
  <tr class="line2">
      <td width="12%" align="right">
      	<c:choose>
      		<c:when test="${bip.bipTLowersecurity == 1 }">
      			<input name="sfdb" type="checkbox"  class="radio" checked >
      		</c:when>
      		<c:otherwise>
      		 	<input name="sfdb" type="checkbox"  class="radio" >
      		</c:otherwise>
      	</c:choose>
     </td >
      <td colspan="18%">          低保人员</td >
      <td width="12%" align="right" >
      	<c:choose>
      		<c:when test="${bip.bipTDestitute == 1 }">
      			<input name="sftk" type="checkbox" class="radio" checked >
      		</c:when>
      		<c:otherwise>
      		 	<input name="sftk" type="checkbox" class="radio" >
      		</c:otherwise>
      	</c:choose>
      </td >
      <td width="18%" >          特困人员</td >
      <td width="12%" align="right" >
      	<c:choose>
      		<c:when test="${bip.bipTNewgraduate == 1 }">
      			<input type="checkbox" name="sfyjgxbys"  class="radio" checked >  
      		</c:when>
      		<c:otherwise>
      		 	<input type="checkbox" name="sfyjgxbys"  class="radio" >  
      		</c:otherwise>
      	</c:choose>
      </td >
      <td width="26%" > 应届高校毕业生 </td >
  </tr >
  <tr class="line1">
      <td width="12%" align="right">
      	<c:choose>
      		<c:when test="${bip.bipTVeteran == 1 }">
      			<input name="sffytw" type="checkbox"  class="radio" checked >
      		</c:when>
      		<c:otherwise>
      		 	<input name="sffytw" type="checkbox"  class="radio" > 
      		</c:otherwise>
      	</c:choose>
      </td >
      <td colspan="18%">          复员退伍</td >
      <td width="12%" align="right" >
      	<c:choose>
      		<c:when test="${bip.bipTOthercities == 1 }">
      			<input type="checkbox" name="sfwfzr"  class="radio"  checked >
      		</c:when>
      		<c:otherwise>
      		 	<input type="checkbox" name="sfwfzr"  class="radio"  >
      		</c:otherwise>
      	</c:choose>
      </td >
      <td width="18%" >          外埠转入</td >
      <td width="12%" align="right" >
      	<c:choose>
      		<c:when test="${bip.bipTRhfl == 1 }">
      			<input type="checkbox" name="sfrhfl"  class="radio" checked >  
      		</c:when>
      		<c:otherwise>
      		 	<input type="checkbox" name="sfrhfl"  class="radio" >  
      		</c:otherwise>
      	</c:choose>
      </td >
      <td width="26%" > 是否人户分离 </td >
  </tr >
  <tr class="line2">
      <td width="12%" align="right">
      	<c:choose>
      		<c:when test="${bip.bipTPeasant == 1 }">
      			<input name="sfnzf" type="checkbox"  class="radio" checked >
      		</c:when>
      		<c:otherwise>
      		 	<input name="sfnzf" type="checkbox"  class="radio" >
      		</c:otherwise>
      	</c:choose>
      </td >
      <td colspan="18%">          农转非</td >
      <td width="12%" align="right" >
      	<c:choose>
      		<c:when test="${bip.bipTCriminal == 1 }">
      			<input type="checkbox" name="sfllsf"  class="radio" checked >
      		</c:when>
      		<c:otherwise>
      		 	<input type="checkbox" name="sfllsf"  class="radio" >
      		</c:otherwise>
      	</c:choose>
      </td >
      <td width="18%" >          两劳释放</td >
      <td width="12%" align="right" >
      	<c:choose>
      		<c:when test="${bip.bipTCzjyyhz == 1 }">
      			<input type="checkbox" class="radio" name="sfczjyyhz" checked >  
      		</c:when>
      		<c:otherwise>
      		 	<input type="checkbox" class="radio" name="sfczjyyhz" >  
      		</c:otherwise>
      	</c:choose>
      </td >
      <td width="26%" > 是否持再就业优惠证</td >
  </tr >
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="titlehand" onClick="collapseCon('5');">
  <tr>
    <td width="60"> 
      <table width="37" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td width="30"><img src="<%=request.getContextPath()%>/styles/css/bb_d.gif" height="19"></td >
          <td width="7"><img src="<%=request.getContextPath()%>/styles/images/right/ico_up.gif" id="imgmini5"></td >
        </tr >
      </table>
    </td >
    <td valign="bottom">具有信息</td >
  </tr >
</table>
	
      <table width="98%" border="0" cellspacing="0"  align="center" cellpadding="0" style="display:block" id="c5">
        <tr  align="center" >
          <td valign="top"> 
            <table id="zyjnTable" width="100%" border="0" cellpadding="0" cellspacing="1">
              
              <c:forEach items="${skill }" var="ls">
              	<tr class="line1">
                 	<td width="13%" align="left">职业技能</td >
                	<td width="19%"><input type="text" name="init_zyjn" style="WIDTH: 100%" value="${ls.bipSZyjn }" readonly></td >
                	<td width="10%" align="left">技术等级</td >
                	<td width="18%"><input type="text" name="init_jsdj" style="WIDTH: 100%" value="${ls.bipSJsdj }" readonly></td >
                	<td width="10%" align="left">从事年限</td >
                	<td width="15%"> <INPUT  name="init_csnx" style="WIDTH: 100%" maxlength="2" value="${ls.bipSYears }" readonly></td >
             	</tr >
              </c:forEach>
              
            </table>
            <table id="jywyTable" width="100%"  align="center" border="0" cellpadding="0" cellspacing="1"  style="word-break:break-all;width:fixed">
              
              <c:forEach items="${foreign }" var="lf">
              	<tr class="line2" align="center" > 
                	<td width="13%" align="left">具有外语 </td >
                	<td width="19%"><input type="text" name="init_jywy" style="WIDTH: 100%" value="${lf.bipFlJywy }" readonly></td >
                	<td width="10%" align="left">熟练程度 </td >
                	<td width="18%"><input type="text" name="init_wyslcd" style="WIDTH: 100%" value="${lf.bipFlYears }" readonly></td >
                	<td width="10%" align="left">外语说明 </td >
                	<td width="15%"><INPUT  name="init_wysm" style="WIDTH: 100%" value="${lf.bipFlWysm }" readonly></td >
              	</tr > 
              </c:forEach>
              
			 </table>
			  <table  width="100%" border="0" cellpadding="0" align="center"  cellspacing="1">
              <tr class="line1" align="center" >
                <td width="13%" align="left">计算机等级</td >
                <td width="19%"><input name="jsjdj" size="1"  style="WIDTH: 100%" value="${bip.bipPcDj }" readonly></td >
                <td width="10%" align="left">熟练程度</td >
                <td width="18%"><input name="jsjslcd" size="1" style="WIDTH: 100%" value="${bip.bipPcSlcd }" readonly></td >
              </tr >
            </table>
            </td >
        </tr >
      </table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="titlehand" onClick="collapseCon('6');">
  <tr>
    <td width="60"> 
      <table width="37" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td width="30"><img src="<%=request.getContextPath()%>/styles/css/bb_d.gif" height="19"></td >
          <td width="7"><img src="<%=request.getContextPath()%>/styles/images/right/ico_up.gif" id="imgmini6"></td >
        </tr >
      </table>
    </td >
    <td valign="bottom">择业信息</td >
  </tr >
</table>
<table width="98%" border="0" cellspacing="0" align="center"  cellpadding="0" id="c6" style="display:block">
  <tr align="center" >
    <td>
    	<TABLE width="100%" border=0 cellPadding=0 cellSpacing=1 class="tablebody">
        <tr class="line1">
          <td width="13%" align="left">单位性质</td >
          <td width="19%"><input name="dwxz" style="WIDTH: 100%" value="${djb.dwxx }" readonly></td >
          <td width="10%" align="left">单位行业</td >
          <td width="18%"><input name="dwhy" style="WIDTH: 100%" value="${djb.dwhy }" readonly></td >
          <td width="10%" align="left">经济类型</td >
          <td width="15%"><input name="dwjjlx" style="WIDTH: 100%" value="${djb.dwjjlx }" readonly></td >
        </tr>
        <tr class="line2">
          <td align="left">工作地区</td >
          <td><input name="gzdq" size="1"  style="WIDTH: 100%" value="${djb.gzdq }" readonly></td>
        </tr>
      </table>
		  <table width="100%" border="0" cellpadding="0" cellspacing="1">
		    <tr class="line2">
		      <td width="14%" align="right">是否接收短信</td >
		      <td width="17%">
		      	<c:choose>
      				<c:when test="${djb.sfjsdx == 1 }">
      					<input name="sfjsdx" type="checkbox" value="1"  class="radio" checked >
      				</c:when>
      				<c:otherwise>
      		 		 	<input name="sfjsdx" type="checkbox" value="1"  class="radio" >
      				</c:otherwise>
      			</c:choose>
		      </td >
		      <td width="14%" align="right">是否参加培训</td >
		      <td width="14%">
		      	<c:choose>
      				<c:when test="${djb.sfcjpx == 1 }">
      					<input name="sfcjpx" type="checkbox" value="1"  class="radio" checked >
      				</c:when>
      				<c:otherwise>
      		 		 	<input name="sfcjpx" type="checkbox" value="1"  class="radio" >
      				</c:otherwise>
      			</c:choose>
		      </td >
		      <td width="18%" align="right">是否接受职业指导</td >
		      <td width="23%">
		      	<c:choose>
      				<c:when test="${djb.sfjszyzd == 1 }">
      					<input name="sfjszyzd" type="checkbox" value="1"  class="radio" checked >
      				</c:when>
      				<c:otherwise>
      		 		 	<input name="sfjszyzd" type="checkbox" value="1"  class="radio" >
      				</c:otherwise>
      			</c:choose>
		      </td >
		    </tr>
		</table>
			<%-- <div id="dxsj" style="display:none">
			<table width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
			    <td width="80" align="right">接受短信时间</td >
			    <td ><textarea name="jsdxkssj" style='width:100%' class='mask'  htcurl="url(<%=request.getContextPath() %>/common/htc/format.htc)"  rows="1" cols="10" mask='date' maxlength='10' readonly></textarea></td >
			    <td width="55" align="right">结束时间</td >
			    <td ><textarea name="jsdxjssj" style='width:100%' class='mask'  htcurl="url(<%=request.getContextPath() %>/common/htc/format.htc)"  rows="1" cols="10" mask='date' maxlength='10' readonly></textarea></td >
			  </tr>
			</table>
			</div> --%>
    </td >
  </tr >
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="titlehand" onClick="collapseCon('7');">
  <tr >
    <td width="60"> 
      <table width="37" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td width="30"><img src="<%=request.getContextPath()%>/styles/css/bb_d.gif" height="19"></td >
          <td width="7"><img src="<%=request.getContextPath()%>/styles/images/right/ico_up.gif" id="imgmini7"></td >
        </tr >
      </table>
    </td >
    <td valign="bottom">择业工种</td >
  </tr >
</table>
<table width="98%"  id="c7"
  border=0 cellPadding=0 cellSpacing=1 align="center"   class="tablebody" style="display:block"  >
  <tr align="center" >
  	<td>
			<table id="qzgzTable" width="100%" 
			  border=0 cellPadding=0 cellSpacing=1  class="tablebody" style="display:block"  >
			  
			  <c:forEach items="${gzb }" var="gz">
			  	<tr class="line1" align="center">
			    	<td width="40"><span class="redtxt">*</span>工种</td>
					<td width="110"><input name="qzgz1" type="text" style="width:100%" value="${gz.gz }" readonly></td>
			    <td width="50">用工形式</td>
				<td width="70"><input name="ygxs1" type="text" style="width:100%" value="${gz.ygxs }" readonly></td >
			    <td width="50" align="left"><input name="xs" type="text" size="6" value="月薪"  class='inputline' readonly></td>
				<td width="140">
					<div id="yx" style="display:">
					<table><tr><td><input name="zdyx1" type="text" style="width:50px" value="${gz.zdyx }">
                  至

                  <input name="zgyx1" type="text" style="width:50px" value="${gz.zgyx }">
					元</td></tr></table>
					</div>
					<!-- <div id="rx" style="display:none">
					<table><tr><td><br><input name="zdrx1" type="text" style="width:40px" onblur="checkJe(this);">
                  至

                  <input name="zgrx1" type="text" style="width:40px" onblur="checkJe(this);">
					元<br><br></td></tr></table>
					</div> -->
				</td >
			  </tr >
			  
			  </c:forEach>
			</table>
		</td>
	</tr>	
</table>	

</form>
</body>
</html>