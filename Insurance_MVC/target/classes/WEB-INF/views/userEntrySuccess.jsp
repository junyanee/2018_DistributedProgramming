<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/jsp_header.jsp"%>
<html>
<head>
<title>보험 가입신청 완료 화면</title>
</head>
<body>
<div align="center" class="body">
<h2>보험 가입신청 완료 화면</h2>
<b><font color="red">보험 가입신청이 완료되었습니다.</font></b><br>
<b> UW가 완료되면 보험 가입 여부를 알려드립니다. </b>
<table border="1">
	<tr height="40px">
		<td>유저ID</td>
		<td>${user.userId}</td>
	</tr>
	<tr height="40px">
		<td>이름</td>
		<td>${user.userName}</td>
	</tr>
	<tr height="40px">
		<td>나이</td>
		<td>${user.age}</td>
	</tr>
	<tr height="40px">
		<td>주민등록번호</td>
		<td>${user.ssn}</td>
	</tr>
	<tr height="40px">
		<td>주소</td>
		<td>${user.address}</td>
	</tr>
	<tr height="40px">
		<td>E-MAIL</td>
		<td>${user.email}</td>
	</tr>
	<tr height="40px">
		<td>직업</td>
		<td>${user.job}</td>
	</tr>
</table>
	<button onclick="location.href='itemList.html'">☜ 목록 보기</button>
</div>
</body>
</html>