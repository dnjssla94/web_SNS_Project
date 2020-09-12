<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">

		$(function() {
			$("#signIn").click(function(){
				if($("#file").val()==""){
					alert("사진을 선택해 주세요.");
					return false;
				}
				if($("#text").val()==""){
					alert("글을 입력해주세요.");
					$("#text").focus();
					return false;
				}
				if($("#timeLine").val()==""){
					alert("타임라을 선택해주세요.");
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
		
			
		
</script>
<form action="fileUpload.do" id="fileUpload" name="fileUpload" method="post" enctype="multipart/form-data">
    <div id="uploadbox">
        사진 선택: <input id="file" type="file" name="file"><br><br>
        <textarea id="text" name="message" autofocus placeholder="어떤 사진인가요?"></textarea>
        <br><br>
        <select id="timeLine" name="timeLine">
            <option value="desk">시작하기 전 책상</option>
            <option value="book">오늘 읽은 책</option>
            <option value="sight">오늘 오래 들여다 본 것</option>
        </select><br><br>
        <input type="submit" name="업로드" value="업로드">

    </div>
</form>