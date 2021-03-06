<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>  
<%@ page import="com.springbook.biz.board.BoardVO" %> 
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@ taglib uri = "http://www.springframework.org/tags" prefix="spring" %>

<%
	/* BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> boardList = boardDAO.getBoardList(vo); */
	
	//List<BoardVO> boardList = (List)session.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1><spring:message code="message.board.list.mainTitle"></spring:message></h1>
		<h3>
			${ userName }<spring:message code="message.board.list.welcomeMsg"></spring:message><a href="logout.do">Log-out</a>
		</h3>
		
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
					<select name="searchCondition">
						<c:forEach items="${conditionMap }" var="option">
							<option value="${option.value }">${option.key }
						</c:forEach>							
					</select> 
					<input name="searchKeyword" type="text" /> 
					<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"></spring:message>" /></td>
				</tr>
			</table>
		</form>
		<!-- 검색 끝 -->
		
		<!-- 게시판 목록 출력 -->
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.seq"></spring:message></th>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.title"></spring:message></th>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.writer"></spring:message></th>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.regDate"></spring:message></th>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt"></spring:message></th>
			</tr>
			<c:forEach items="${boardList }" var="board">
			<tr>
				<td>${board.seq }</td>
				<td><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.regDate }</td>
				<td>${board.cnt }</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<a href="insertBoard.jsp">새글 등록</a>
		<!-- 
				<h1>글 목록</h1>
		<h3>
			${ userName }님 환영합니다....<a href="logout.do">Log-out</a>
		</h3>
		 -->
		<!-- 검색 시작 -->
		<!-- 
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
					<select name="searchCondition">
						<c:forEach items="${conditionMap }" var="option">
							<option value="${option.value }">${option.key }
						</c:forEach>							
					</select> 
					<input name="searchKeyword" type="text" /> 
					<input type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>
		 -->
		<!-- 검색 끝 -->
		
		<!-- 게시판 목록 출력 -->
<!-- 
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="100">제목</th>
				<th bgcolor="orange" width="100">작성자</th>
				<th bgcolor="orange" width="100">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			<c:forEach items="${boardList }" var="board">
			<tr>
				<td>${board.seq }</td>
				<td><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.regDate }</td>
				<td>${board.cnt }</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<a href="insertBoard.jsp">새글 등록</a>  -->
	</center>
</body>
</html>










