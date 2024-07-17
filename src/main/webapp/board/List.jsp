<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<style>

</style>
</head>
<body>
	<h2>자유게시판</h2>

	<!-- 검색 폼 -->
	<form method="get">
		<table border="1" width="90%">
			<tr>
				<td align="center"><select name="searchField">
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="name">작성자</option>
				</select> <input type="text" name="searchWord" /> <input type="submit"
					value="검색하기" /></td>
			</tr>
		</table>
	</form>

	<!-- 목록 테이블 -->
	<table border="1" width="90%">
		<tr>
			<th width="10%">번호</th>
			<th width="*">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
			<th width="8%">첨부</th>
		</tr>
		<c:choose>
			<c:when test="${empty boardLists }">
				<!-- 게시물이 없을 때 -->
				<tr>
					<td colspan="6" align="center">등록된 게시물이 없습니다^^*</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${boardLists }" var="row" varStatus="loop">
				
<%-- 				${status.current} 현재 for문의 해당하는 번호
					${status.index} 0부터의 순서				
					${status.count} 1부터의 순서				
					${status.first} 첫 번째인지 여부				
					${status.last} 마지막인지 여부				
					${status.begin} for문의 시작 번호				
					${status.end} for문의 끝 번호				
					${status.step} for문의 증가값 --%>
				
					<!-- 출력할 게시물이 있을때 -->
					<tr align="center">
						<td>
						${map.totalCnt - (((map.pageNum-1)*map.pageSize) +loop.index)}
						</td>
						<td align="left">
						<a href="../board/view.do?idx=${row.idx }">${row.title }</a>
						</td>
						<td>${row.name }</td>
						<td>${row.visitcount }</td>
						<td>${row.postdate }</td>
						<td>
						<c:if test="${not empty row.ofile }">
							<a href="../mvcboard/download.do?ofile=${row.ofile }
							&sfile=${row.sfile }&idx=${row.idx }">[Down]</a>
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>


	</table>

	<table border="1" width="90%">
		<tr align="center">
			<td>
			${map.pagingImg }
			</td>
			<td width="100"><button type="button"
					onclick="location.href='../mvcboard/write.do';">글쓰기</button></td>
		</tr>
	</table>
</body>
</html>
