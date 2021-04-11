<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<html>
<head>
<title>보험 설계 화면</title>
</head>
<body>
<div align="center" class="body">
<h2>보험 설계 화면</h2>
<form:form modelAttribute="item" method="post" action="itemEntry.html">
	<spring:hasBindErrors name="item">
		<font color="red"><c:forEach items="${errors.globalErrors}"
			var="error">
			<spring:message code="${error.code}" />
		</c:forEach> </font>
	</spring:hasBindErrors>
	<table>
		<tr height="40px">
				<td>보험ID</td>
				<td><form:input path="itemId" placeholder="ID" maxlength="20" cssClass="itemId" /><font
						color="red"><form:errors path="itemName" /></font></td>
		</tr>
		<tr height="40px">
			<td>보험종류</td>
			<td><form:select path="itemClass" cssClass="itemClass">
				<form:option value="종신보험" label="종신보험" />
				<form:option value="연금보험" label="연금보험" />
				<form:option value="암보험" label="암보험" />
				<form:option value="실비보험" label="실비보험" />
			</form:select></td>
		</tr>
		<tr height="40px">
			<td>보험이름</td>
			<td><form:input path="itemName" placeholder="이름" maxlength="20" cssClass="itemName" /><font
				color="red"><form:errors path="itemName" /></font></td>
		</tr>
		<tr height="40px">
			<td>설명</td>
			<td><form:input path="description" placeholder="설명" maxlength="50" cssClass="description" /><font
				color="red"><form:errors path="description" /></font></td>
		</tr>
		<tr height="40px">
			<td>납입주기</td>
			<td><form:input path="frequency" placeholder="(월)단위" maxlength="50" cssClass="frequency" /><font
				color="red"><form:errors path="frequency" /></font></td>
		</tr>
		<tr height="40px">
			<td>납입기간</td>
			<td><form:input path="term" placeholder="(년)단위" maxlength="50" cssClass="term" /><font
				color="red"><form:errors path="term" /></font></td>
		</tr>
		<tr height="40px">
			<td>보상금액</td>
			<td><form:select path="money" cssClass="money">
				<form:option value="1억" label="1억" />
				<form:option value="5천만" label="5천만" />
				<form:option value="3천만" label="3천만" />
				<form:option value="2천만" label="2천만" />
				<form:option value="1천5백만" label="1천5백만" />
				<form:option value="1천만" label="1천만" />
				<form:option value="5백만" label="5백만" />
				<form:option value="2백만" label="2백만" />
				<form:option value="1백만" label="1백만" />
			</form:select></td>
		</tr>
		
	</table>
	<table>
		<tr>
			<td height="40px" align="center"><input type="submit"
				name="btnSubmit" value="등록"></td>
			<td height="40px" align="center"><input type="reset"
				name="btnReset" value="리셋"></td>
		</tr>
	</table>
	
			<button onclick="location.href='itemList.html'">☜ 목록 보기</button>
</form:form></div>
</body>
</html>