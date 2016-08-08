<%@page import="kr.ac.sungkyul.mysite.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BoardVo vo=(BoardVo)request.getAttribute("BoardVo");
%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td><%=vo.getTitle() %></td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								<%=vo.getContent() %>
							</div>
						</td>
					</tr>
				</table>
				
				<div class="bottom">
					<a href="/mysite/board?a=listform">글목록</a> <a href="/mysite/board?a=modifyform">글수정</a>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/navi.jsp" />

		<jsp:include page="/WEB-INF/views/include/footer.jsp" />

	</div>
</body>
</html>