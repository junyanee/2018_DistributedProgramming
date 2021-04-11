<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/jsp_header.jsp"%>
<html>
<head>
<title>보험 가입 화면</title>
</head>
<body>
<div align="center" class="body">
<h2>보험 가입 화면</h2>
<h5>가입자의 정보를 입력하세요</h5>
<form:form modelAttribute="user" method="post" action="userEntry.html">
	<spring:hasBindErrors name="user">
		<font color="red"><c:forEach items="${errors.globalErrors}"
			var="error">
			<spring:message code="${error.code}" />			
		</c:forEach> </font>
	</spring:hasBindErrors>
	<table>
		<tr height="40px">
			<td>유저ID</td>
			<td><form:input path="userId" maxlength="20" cssClass="userId" /><font
				color="red"><form:errors path="userId" /></font></td>
		</tr>
		
		<tr height="40px">
			<td>이름</td>
			<td><form:input path="userName" maxlength="20" cssClass="userName" /><font
				color="red"><form:errors path="userName" /></font></td>
		</tr>
	
		<tr height="40px">
			<td>나이</td>
			<td><form:input path="age" maxlength="3" cssClass="age" /><font
				color="red"><form:errors path="age" /></font></td>
		</tr>
		
		<tr height="40px">
			<td>주민등록번호</td>
			<td><form:input path="ssn" maxlength="20" cssClass="ssn" /><font
				color="red"><form:errors path="ssn" /></font></td>
		</tr>
		<tr height="40px">
			<td>주소</td>
			<td><form:input path="address" maxlength="50" cssClass="address" /><font
				color="red"><form:errors path="address" /></font></td>
		</tr>
		<tr height="40px">
			<td>E-MAIL</td>
			<td><form:input path="email" maxlength="50" cssClass="email" /><font color="red"><form:errors
				path="email" /></font></td>
		</tr>
		<tr height="40px">
			<td>직업</td>
			<td><form:select path="job" cssClass="jobs">
				<form:option value="직장인" label="직장인" />
				<form:option value="학생" label="학생" />
				<form:option value="일용직" label="일용직" />
				<form:option value="현장직" label="현장직" />				
				<form:option value="사업가" label="사업가" />				
				<form:option value="미취학아동" label="미취학아동" />				
				<form:option value="기타" label="기타" />			
				<form:option value="무직" label="무직" />
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
	<button onclick="location.href='itemEntry.html'">☜ 설계화면으로</button>
</form:form></div>
</body>
</html>