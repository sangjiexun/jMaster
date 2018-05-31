<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--
	■問題４
	下記仕様の通りにアプリケーションを作成してください。
	<仕様>
	・JSPファイルにてユーザ名・パスワードを入力し、サーブレットへ渡すこと
	・サーブレットで予め用意しておいたユーザ名とパスワードを受け取ったデータと比較して
	合致すればユーザページへ遷移すること
	・ユーザページはJSPとして用意すること
	・ユーザページではユーザの名前を表示すること
	----------------------------
	初期表示JSP：no004
	ユーザページJSP：userpage
	配置場所：WebContent/practice/chapter7
	        ****
	サーブレット名：Ch7No001
	パッケージ名：sht.practice.chapter7
	URLマッピング：/Ch7No001（デフォルト）
	----------------------------
-->
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		${ name }
	</body>
</html>