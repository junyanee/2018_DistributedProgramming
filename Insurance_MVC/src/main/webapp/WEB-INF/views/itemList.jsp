<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>보험 확정 화면</title>
</head>
<body>
<div align="center" class="body">
<h2>보험 확정 화면</h2>
<h4>확정 거절할 상품을 체크하여 삭제해주세요</h4>
<h5>상품명을 누르면 상세화면으로 이동하며, 보험가입을 신청할 수 있습니다</h5>
<table border="1">
	<tr class="header">
		<th align="center" width="80">선택</th>
		<th align="center" width="80">보험ID</th>
		<th align="center" width="80">보험종류</th>
		<th align="center" width="250">보험명</th>
		<th align="center" width="80">납입주기</th>
		<th align="center" width="80">납입기간</th>
		<th align="center" width="80">보상금액</th>
	</tr>
	<c:forEach items="${itemList}" var="item">
		<tr class="record">
			<td align="center">
			<input type="checkbox" name="checkedItemName"></td>
			<td align="center">${item.itemId}</td>
			<td align="center">${item.itemClass}</td>
			<td align="left"><a href="itemDetail.html?itemId=${item.itemId}">${item.itemName}</a></td>
			<td align="right">${item.frequency}달</td>
			<td align="right">${item.term}년</td>
			<td align="right">${item.money}원</td>
		</tr>
	</c:forEach>
</table>
<table>
	<tr>
	<td height="40px" align="center"><input type="submit"
				name="btnClear" value="확정 거절"></td> 
	</tr>
</table>
<button onclick="location.href='itemEntry.html'">☜ 입력화면으로</button>
</div>
</body>
</html>