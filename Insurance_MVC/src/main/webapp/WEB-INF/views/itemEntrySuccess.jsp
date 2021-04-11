<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>보험 생성 완료 화면</title>
</head>
<body>
<div align="center" class="body">
<h2>보험 생성 완료 화면</h2>
<b><font color="red">보험 생성이 완료되었습니다.</font></b><br>
<table border="1">
	<tr height="40px">
		<td>상품ID</td>
		<td>${item.itemClass}</td>
	</tr>
	<tr height="40px">
			<td>상품ID</td>
			<td>${item.itemId}</td>
		</tr>
	<tr height="40px">
		<td>보험명</td>
		<td>${item.itemName}</td>
	</tr>
	<tr height="40px">
		<td>납입주기</td>
		<td>${item.frequency}</td>
	</tr>
	<tr height="40px">
		<td>납입기간</td>
		<td>${item.term}</td>
	</tr>
	<tr height="40px">
		<td>보상금액</td>
		<td>${item.money}</td>
	</tr>
	<tr height="40px">
		<td>설명</td>
		<td>${item.description}</td>
	</tr>
	
</table>
		<button onclick="location.href='itemList.html'">☜ 목록 보기</button>
		<button onclick="location.href='itemEntry.html'">☜ 입력화면으로</button>
</div>
</body>
</html>