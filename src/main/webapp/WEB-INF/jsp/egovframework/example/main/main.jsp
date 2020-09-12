<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main>
    <div class="contentsList">
    	<c:forEach items="${deskImagesList}" var="deskImagesInfo">
   	  		<article class="content">
	   	  		<div style="height: 20px;">${deskImagesInfo.uploaderId}</div>
            	<img src="${deskImagesInfo.path}" alt="업로드 중(일수도 있어요).">
            	<p>${deskImagesInfo.message}</p>
        	</article>
	    </c:forEach>
	    
    </div>
</main>

