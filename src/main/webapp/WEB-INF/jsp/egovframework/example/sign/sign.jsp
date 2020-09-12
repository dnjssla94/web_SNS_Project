<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function(){
		// 취소
		$(".cencle").on("click", function(){
			
			location.href = "/login";
					    
		})
	
		$(function() {
			$("#submit").click(function(){
				if($("#userId").val()==""){
					alert("아이디를 입력해주세요.");
					$("#userId").focus();
					return false;
				}
				if($("#userPass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#userPass").focus();
					return false;
				}
				if($("#userName").val()==""){
					alert("성명을 입력해주세요.");
					$("#userName").focus();
					return false;
				}
			});
		});
		
		$(function() {
			$("#signIn").click(function(){
				if($("#id").val()==""){
					alert("아이디를 입력해주세요.");
					$("#id").focus();
					return false;
				}
				if($("#password").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#password").focus();
					return false;
				}
				/*alert('${idInfo}'); 
				 document.write("이거 맞나.");
				document.write("${idInfo}");
				/*console.log('이거 맞나.');
				console.log('${idInfo}');
				alert('이거 맞나.');  */ 
				
			});
		});
		
			
		
	})
</script>

<form action="/signIn.do" id="signInBox" method="post">
    <div class="form-group has-feedback">
        <label class="control-label" for="id">아이디</label><br>
        <input class="form-control" type="text" id="id" name="id" />
    </div>
    <div class="form-group has-feedback">
        <label class="control-label" for="password">패스워드</label><br>
        <input class="form-control" type="password" id="password" name="password" />
    </div>
    <div class="form-group has-feedback">
        <button class="btn btn-success" type="submit" id="signIn">로그인</button>
    </div>
	<c:if test="${errorMsg == false}">
		<p style="color:red;">아이디 혹은 패스워드를 확인해주세여~ </p>	
	</c:if>
</form>

<form action="/register.do" id="signUpBox" method="post">
    <div class="form-group has-feedback">
        <label class="control-label" for="userId">아이디</label><br>
        <input class="form-control" type="text" id="userId" name="userId" />
    </div>
    <div class="form-group has-feedback">
        <label class="control-label" for="userPass">패스워드</label><br>
        <input class="form-control" type="password" id="userPass" name="userPass" />
    </div>
    <div class="form-group has-feedback">
        <label class="control-label" for="userName">성명</label><br>
        <input class="form-control" type="text" id="userName" name="userName" />
    </div>
    <div class="form-group has-feedback">
        <button class="btn btn-success" type="submit" id="submit">회원가입</button>
        <button class="cencle btn btn-danger" type="button">취소</button><br><br>
    </div>
</form>
        
