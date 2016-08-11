<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.sungkyul.mysite.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="board">
	<form id="search_form" action="/mysite/board?a=search" method="post">
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
	
		<c:set var="firstIndex" value="${totalCount - (currentPage - 1)*sizeList }" />
		<c:forEach var='vo' items='${list}' varStatus='status'>
			<tr>
				<td>${firstIndex - status.index }</td>	
				<td style="text-align:left;padding-left:${(vo.depth-1)*20}px">
	                <c:if test='${vo.depth > 1 }'>
    		            >>>>
            	    </c:if>
					<a href="/mysite/board?a=viewform&no=${vo.no}">${vo.title }</a>
				</td>
				<td>${vo.name }</td>
				<td>${vo.count }</td>
				<td>${vo.date }</td>
				<td><c:choose>
						<c:when test='${not empty authUser && authUser.no == vo.userNo }'>

							<a href="/mysite/board?a=delete&no=${vo.no}" class="del">삭제</a>
						</c:when>
						<c:otherwise>
					&nbsp;
					</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>

	<!-- begin:paging -->
	<div class="pager">
		<ul>
			<c:if test="${prevPage > 0 }">
				<li><a href="/mysite/board?a=listform&p=${prevPage }">◀</a></li>
			</c:if>
			<c:forEach begin='${firstPage }' end='${lastPage }' step='1' var='i'>
				<c:choose>
					<c:when test='${currentPage == i }'>
						<li class="selected">${i }</li>
					</c:when>

					<c:when test='${i > pageCount }'>
						<li>${i }</li>
					</c:when>

					<c:otherwise>

						<li><a href="/mysite/board?a=listform&p=${i }">${i }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test='${nextPage > 0 }'>
				<li><a href="/mysite/board?a=listform&p=${nextPage }">▶</a></li>
			</c:if>
		</ul>
	</div>

	<!-- end:paging -->
	<c:choose>
		<c:when test='${empty authUser }'>

			<div class="bottom"></div>
		</c:when>
		<c:otherwise>
			<div class="bottom">

				<a href="/mysite/board?a=writeform&userno=${authUser.no}"
					id="new-book">글쓰기</a>
			</div>

		</c:otherwise>
	</c:choose>
</div>