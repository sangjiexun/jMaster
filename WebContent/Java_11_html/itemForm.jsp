<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

並び順：
<a href="/jMaster/ItemServlet?action=sort&key=price_asc">昇順</a>
<a href="/jMaster/ItemServlet?action=sort&key=price_dasc">降順</a>



<form action="/jMaster/ItemServlet" method="post">
	追加：
	商品名		<input type="text" name="name">
	価格		<input type="text" name="price" size="5">
	：		<input type="submit" value="追加">
			<input type="hidden" name="action" value="add">
</form>



<form action="/jMaster/ItemServlet" method="post">
	検索：
	<input type="text" name="price" size="5">円以下の商品：
	<input type="submit" value="検索">
	<input type="hidden" name="action" value="search">
</form>



<form action="/jMaster/ItemServlet" method="post">
	削除：
	商品番号	<input type="text" name="code" size="5">
	：		<input type="submit" value="削除">
			<input type="hidden" name="action" value="delete">
</form>
<hr>