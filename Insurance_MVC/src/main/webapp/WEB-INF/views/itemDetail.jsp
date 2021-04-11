<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>보험 상세 화면</title>
</head>
<body>
<div align="center" class="body">
<h2>보험 상세 화면</h2>
<h4>가입하시려면 가입하기 버튼을 눌러주세요.</h4>
<table border="2">
	<tr class="header">
		<th align="center" width="80">보험ID</th>
		<th align="center" width="80">보험종류</th>
		<th align="center" width="80">이름</th>
		<th align="center" width="80">납입주기</th>
		<th align="center" width="80">납입기간</th>		
		<th align="center" width="80">보상금액</th>
		<th align="center" width="100">설명</th>
	</tr>
	<tr class="record">
		<td align="center">${item.itemId}</td>
		<td align="center">${item.itemClass}</td>
		<td align="center">${item.itemName}</td>
		<td align="center">${item.frequency}</td>
		<td align="center">${item.term}</td>
		<td align="center">${item.money}</td>
		<td align="center">${item.description}</td>
	</tr>
	
</table>
		<button onclick="location.href='itemList.html'">☜ 목록 보기</button>
		<button onclick="location.href='itemEntry.html'">☜ 설계화면으로</button>
		<button onclick="location.href='userEntry.html'">☜ 가입 하기</button>

</div>
</body>
</html>