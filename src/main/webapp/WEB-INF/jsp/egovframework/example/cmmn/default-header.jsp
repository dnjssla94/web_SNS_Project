<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- header -->
<header id="header" class="main">
	<div class="headerTitle">
	    익명의 SNS
	</div>
	<div class="menu">
		<c:if test="${UserSession != null}">
			<div><a href="/logout.do">로그아웃 </a></div>
	    	<div  style="margin-right: 20%; margin-left: 20px; width: 300px;">${UserSession.userName}님 안녕하세요오</div>    	
	    </c:if>
		<div class="menuList"><a href="/upload.do">업로드</a></div>
        <div class="menuList"><a href="/main.do">시작하기 전 책상</a></div>
        <div class="menuList"><a href="/book.do">오늘 읽은 책 표지</a></div>
        <div class="menuList"><a href="/sight.do">오늘 오래 들여다 본 것</a></div>
    </div>

</header>
<!--// header -->

