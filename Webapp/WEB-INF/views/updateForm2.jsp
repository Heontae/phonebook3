<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 수정</h1>
	<p>
		전화번호를 수정하려면 <br>아래 항목을 입력하고 "수정"버튼을 클릭하세요
	</p>

	<form action="${pageContext.request.contextPath }/phone/update" method="get">

		이름(name): <input type="text" name="name" value=${vo.NAME }> <br>
		핸드폰(hp): <input type="text" name="hp" value=${vo.HP }> <br>
		회사(company): <input type="text" name="company" value=${vo.COMPANY }>
		<br> <input type="hidden" name="personId" value=${vo.PERSONID }>
		<button type="submit">수정</button>
	</form>
	
	<p>
		<a href="${pageContext.request.contextPath }/phone/list">리스트로 바로가기</a>
	</p>
</body>
</html>