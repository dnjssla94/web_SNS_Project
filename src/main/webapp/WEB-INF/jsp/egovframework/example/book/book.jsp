<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main>
    <div class="contentsList">
    	<c:forEach items="${bookImagesList}" var="bookImagesInfo">
   	  		<article class="content">
	   	  		<div style="height: 20px;">${bookImagesInfo.uploaderId}</div>
            	<img src="${bookImagesInfo.path}" alt="업로드 중(일수도 있어요).">
            	<p>${bookImagesInfo.message}</p>
        	</article>
	    </c:forEach>
	    
    </div>
</main>

