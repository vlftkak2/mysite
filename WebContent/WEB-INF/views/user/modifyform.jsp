<%@page import="kr.ac.sungkyul.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	UserVo Uservo=(UserVo)request.getAttribute("userVo");
	String result=request.getParameter("r");
	%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet"
	type="text/css">
	<script>
	
	<%
	if("success".equals(result)){
	%>
	alert("성공적으로 수정을 완료하였습니다.");
	
	<%
	}
	%>
	
	</script>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
		
		<div id="content">
			<div id="user">
			
				<form id="join-form" name="modifyForm" method="post" action="/mysite/user?a=modify">
					<label class="block-label" for="name">이름</label> 
					<input id="name" name="name" type="text" value="<%=Uservo.getName() %>"> 
						<input type="button"
						value="id 중복체크"> <label class="block-label">패스워드</label> <input
						name="password" type="password" value="">

					<fieldset>
						<legend>성별</legend>
						<%
						if("FEMALE".equals(Uservo.getGender())){
						%>
						<label>여</label> <input type="radio" name="gender" value="female"
							checked="checked"> 
						<label>남</label> <input type="radio"
							name="gender" value="male">
							
							<%
						}else{
							%>
							
							<label>여</label> <input type="radio" name="gender" value="female"> 
						<label>남</label> <input type="radio"
							name="gender" value="male" checked="checked">
							
							<%
						}
							%>
					</fieldset>

				

					<input type="submit" value="수정하기">
					
					<%
					if("success".equals(result)){
						
					%>
					<p>수정 완료</p>
					
					<%
					}
					%>

				</form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/navi.jsp" />
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />

	</div>
</body>
</html>