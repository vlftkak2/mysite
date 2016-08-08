<%@page import="java.util.List"%>
<%@page import="kr.ac.sungkyul.mysite.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%
	List<BoardVo> list=(List<BoardVo>)request.getAttribute("list");
	%>
	

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
					<%for(BoardVo vo : list){ %>
					<tr>
						<td><%=vo.getNo() %></td>
						<td><a href=""><%=vo.getTitle()%></a></td>
						<td><%=vo.getName() %></td>
						<td><%=vo.getCount() %></td>
						<td><%=vo.getDate() %></td>
						<td><a href="/mysite/board?a=delete" class="del">삭제</a></td>
					</tr>
					<%} %>
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
				
				<div class="bottom">
					<a href="/mysite/board?a=writeform" id="new-book">글쓰기</a>
				</div>
			</div>