<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
   pageContext.setAttribute("newLine", "\n");
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet"
   type="text/css">
</head>
<body>
   <div id="container">
      <jsp:include page="/WEB-INF/views/include/header.jsp" />

      <div id="content">
         <div id="guestbook">
            <form action="/mysite/guest" method="post">
               <input type="hidden" name="a" value="insert">
               
               <table>
                  <tr>
                     <td>이름</td>
                     <td><input type="text" name="name"></td>
                     <td>비밀번호</td>
                     <td><input type="password" name="pass"></td>
                  </tr>
                  <tr>
                     <td colspan=4><textarea name="content" id="content"></textarea></td>
                  </tr>
                  <tr>
                     <td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
                  </tr>
               </table>
            </form>
               
            <ul>
            <c:set var='countList' value='${fn:length(mylist) }'/>
            <c:forEach var = 'vo' items='${mylist}' varStatus='s'>
               <li>
                  <table>
                     <tr>
                        <td>[${countList - s.index }]</td>
                        <td>${vo.name }</td>
                        <td>${ vo.reg_date}</td>
                        <td><a href="/mysite/guest?a=deleteform&no=${vo.no }">삭제</a></td>
                     </tr>
                     <tr>
                        <td colspan=4>
                        ${fn:replace(vo.introduction,newLine,"<br>")}
                        </td>
                     </tr>
                  </table>
                  
               
                   <br>
               </li>
            </c:forEach>
               
            </ul>
               
         </div>
      </div>
      <jsp:include page="/WEB-INF/views/include/navi.jsp" />

      <jsp:include page="/WEB-INF/views/include/footer.jsp" />

   </div>
</body>
</html>