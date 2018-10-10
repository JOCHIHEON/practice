<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<script>
window.addEventListener('load',function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/board');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var res = JSON.parse(xhr.responseText);
				var html = '';
				for(var bi of res){
					html += '<tr>';
					html += '<td>'+bi.binum+'</td>';
					html += '<td><input type="text" name="bititle" value="'+bi.bititle+'"></td>';
					html += '<td><textarea name="bitext" cols="40 row="10">'+bi.bitext+'</textarea></td>';
					html += '<td><input type="file" name="bifile" value="'+bi.bifile+'"></td>';
					html += '<td>'+bi.bicredat+'</td>';
					html += '<td>'+bi.bimoddat+'</td>';
					html += '<td>'+bi.bicnt+'</td>';
					html += '<td>'+bi.uinum+'</td>';
					html += '<td><button onclick="boardInfoUpdate('+bi.binum+')">수정</button><button onclick="boardInfoDelete('+bi.binum+')">삭제</button></td>';
					html += '</tr>';
				}
				document.querySelector('#biBody').insertAdjacentHTML('beforeend',html);
			}else{
				
			}
		}
	}
	xhr.send();
	alert(document.querySelector("#biBody"));
})
</script>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>게시물번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>파일</th>
				<th>생성일자</th>
				<th>수정일자</th>
				<th>조회수</th>
				<th>유저번호</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
		<tbody id="biBody">
		</tbody>
	</table>
	<button onclick="boardInfoAdd()">게시물추가</button>
<script>
	function boardInfoUpdate(binum){
		var bititle = document.querySelector('input[name=bititle'+binum+']').value;
		var bitext = document.querySelector('input[name=bitext'+binum+']').value;
		var bifile = document.querySelector('input[name=bifile'+binum+']').value;
		var param ={binum:binum,bititle:bititle,bitext:bitext,bifile:bifile};
		var xhr = new XMLHttpRequest();
		var url = "/boardInfo";
		xhr.open('PUT',url);
		xhr.setRequestHeader('Content-type','application/json');
		xhr.onredatstatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					if(xhr.responseText=='1'){
						
						alert('수정성공!')
						location.href='/uri/boardInfo/list';
					}
				}else{
					alert('수정실패');
				}
			}
		}
		alert(JSON.stringify(param));
		xhr.send(JSON.Stringify(param));
	}
	
	function boardInfoDelete(binum){
		var xhr = new XMLHttpRequest();
		var url = "/boardInfo/" + binum;
		xhr.open('DELETE',url);
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					if(xhr.responseText=='1'){
						alert('삭제성공!')
						location.href='/boardInfo';
					}
				}else{
					alert('삭제실패');
				}
			}
		}
		xhr.send();
	}
	
	function boardInfoInsert(binum){
		var bititle = document.querySelector('input[name=bititle]').value;
		var bitext = document.querySelector('input[name=bitext]').value;
		var bifile = document.querySelector('input[name=bifile]').value;
		var param ={binum:binum,bititle:bititle,bitext:bitext,bifile:bifile};
		var xhr = new XMLHttpRequest();
		var url = "/boardInfo";
		xhr.open('POST',url);
		xhr.setRequestHeader('Content-type','application/json');
		xhr.onredatstatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					if(xhr.responseText=='1'){
						
						alert('수정성공!')
						location.href='/uri/boardInfo/list';
					}
				}else{
					alert('수정실패');
				}
			}
		}
		
		xhr.send(JSON.Stringify(param));
	}
	
	function boardInfoAdd(){
		var html ='<tr>'
		html += '<td>&nbsp;</td>';
		html += '<td><input type="text" name="bititle"></td>';
		html += '<td><input type="text" name="bitext"></td>';
		html += '<td><input type="text" name="bifile"></td>';
		html += '<td></td>';
		html += '<td></td>';
		html += '<td></td>';
		html += '<td><input type="text" name="uinum"></td>';
		html += '<td><button onclick="boardInsert()">저장</button></td>';
		html += '<tr>';
		document.querySelector("tbody").insertAdjacentHTML('beforeend',html);
	}
</script>​
</body>
</html>