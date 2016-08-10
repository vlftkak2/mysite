<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.sungkyul.mysite.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
    <div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach var = 'vo' items='${list}' varStatus='s'>
					<tr>
						<td>${vo.no }</td>
						<td><a href="/mysite/board?a=viewform&no=${vo.no}">${vo.title }</a></td>
						<td>${vo.name }</td>
						<td>${vo.count }</td>
						<td>${vo.date }</td>
						<td><a href="/mysite/board?a=delete" class="del">삭제</a></td>
					</tr>
					</c:forEach>
					
					<!-- 
					<tr>
						<td>2</td>
						<td><a href="">두 번째 글입니다.</a></td>
						<td>안대혁</td>
						<td>3</td>
						<td>2015-10-02 12:04:12</td>
						<td><a href="" class="del">삭제</a></td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href=""></a></td>
						<td>안대혁</td>
						<td>3</td>
						<td></td>
						<td><a href="" class="del">삭제</a></td>
					</tr>
					 -->
				</table>
				
				<!-- begin:paging --> 
 				<div class="pager"> 
 					<ul> 
 						<li><a href="">◀</a></li> 
 						<li><a href="">1</a></li> 
 						<li class="selected">2</li> 
 						<li><a href="">3</a></li> 
 						<li><a href="">4</a></li> 
 						<li><a href="">5</a></li> 
 						<li><a href="">▶</a></li> 
 					</ul> 
 				</div> 
 				<!-- end:paging --> 
 				<c:choose>
 				<c:when test='${empty authUser }'>
			
				<div class="bottom">

				</div>
			</c:when>
			<c:otherwise>
				<div class="bottom">

					<a href="/mysite/board?a=writeform" id="new-book">글쓰기</a>
				</div>
			
			</c:otherwise>
			</c:choose>
			</div>