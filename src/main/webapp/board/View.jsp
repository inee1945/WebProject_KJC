<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
</head>
<body>
<h2>상세정보</h2>

<table border="1" width="90%">
    <colgroup>
        <col width="15%"/> <col width="35%"/>
        <col width="15%"/> <col width="*"/>
    </colgroup>

    <!-- 게시글 정보 -->
    <tr>
        <td>번호</td> <td>${ dto.idx }</td>
        <td>작성자</td> <td>${ dto.name }</td>
    </tr>
    <tr>
        <td>작성일</td> <td>${ dto.postdate }</td>
        <td>조회수</td> <td>${ dto.visitcount }</td>
    </tr>
    <tr>
        <td>제목</td>
        <td colspan="3">${ dto.title }</td>
    </tr>
    <tr>
        <td>내용</td>
        <td colspan="3" height="100">
        	${ dto.content }
     <%--    	<c:choose>
        		<c:when test="${ not empty dto.ofile and (extension eq 'jpg') }">
        		<br><img src="../Uploads/${ dto.sfile }" style="max-width:100%;"/>
        		</c:when>
        		<c:when test="${ not empty dto.ofile and (extension eq 'png') }">
        		<br><img src="../Uploads/${ dto.sfile }" style="max-width:100%;"/>
        		</c:when>
        		<c:when test="${ not empty dto.ofile and (extension eq 'gif') }">
        		<br><img src="../Uploads/${ dto.sfile }" style="max-width:100%;"/>
        		</c:when>
        		<c:when test="${ not empty dto.ofile and (extension eq 'mp3') }">
        		<br><img src="../Uploads/${ dto.sfile }" style="max-width:100%;"/>
        		</c:when>
        		<c:when test="${ not empty dto.ofile and (extension eq 'mp4') }">
        		<video id="video_Position" oncontextmenu="return false;" width="50px" height="50px" autoplay loop>
  					<source src="../Uploads/${ dto.sfile }"  type="video/mp4">
				</video>
        		<br><video src="../Uploads/${ dto.sfile }" style="max-width:10%;"/>
        		</c:when>
        	<c:otherwise>
        	<br><img src="../Uploads/${ dto.sfile }" style="max-width:100%;"/>
        	</c:otherwise>
        	</c:choose>
        	<c:if test="${ not empty dto.ofile and extension == true }">
        		<br><img src="../Uploads/${ dto.sfile }" style="max-width:100%;"/>
        	</c:if> --%>
        </td>
    </tr>

    <!-- 첨부파일 -->
    <tr>
        <td>첨부파일</td>
        <td>
            <c:if test="${ not empty dto.ofile }">
            ${ dto.ofile }
            <a href="../mvcboard/download.do?ofile=${ dto.ofile }&sfile=${ dto.sfile }&idx=${ dto.idx }">
                [다운로드]
            </a>
            </c:if>
        </td>
        <td>다운로드수</td>
        <td>${ dto.downcount }</td>
    </tr>

    <!-- 하단 메뉴(버튼) -->
    <tr>
        <td colspan="4" align="center">
            <button type="button" onclick="location.href='../mvcboard/pass.do?mode=edit&idx=${ param.idx }';">
                수정하기
            </button>
            <button type="button" onclick="location.href='../mvcboard/pass.do?mode=delete&idx=${ param.idx }';">
                삭제하기
            </button>
            <button type="button" onclick="location.href='../board/list.do';">
                목록 바로가기
            </button>
        </td>
    </tr>
</table>
</body>
</html>