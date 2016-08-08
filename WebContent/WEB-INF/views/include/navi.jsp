<%@page import="kr.ac.sungkyul.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserVo authUser = (UserVo) session.getAttribute("authUser");
%>

<div id="navigation">
	<ul>
		<%
			if (authUser == null) {
		%>
		<li><a href="/mysite/main">최형민</a></li>
		<li><a href="/mysite/guest?a=list">방명록</a></li>
		<%
			} else {
		%>
		<li><a href="/mysite/board?a=viewform">게시판</a></li>
		<li><a href="/mysite/guest?a=list">방명록</a></li>
		<%
			}
		%>
	</ul>
</div>