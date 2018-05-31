<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--
	BMIを計算するアプリケーションを作成してください。
	また、BMIの結果によって肥満度を表示するようにしてください。
	＜仕様＞
	・BMIは小数点第二位まで表示すること
	・バリデーションチェックを行うこと（空の場合と数値以外の場合）
	・MVCアーキテクチャに基づいて作成すること
	・身長・体重・BMIをプロパティに持つJavaBeansを作成すること
-->
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		CH09 No002<br>
		( ${ bb.getH() }cm, ${ bb.getW() }kg ) >>> ${ bb.getBMI() }<br>
		${ rank }
	</body>
</html>