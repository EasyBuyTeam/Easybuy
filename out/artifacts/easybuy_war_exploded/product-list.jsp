<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="#" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a><a href="guestbook.jsp">留言</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="product-list.jsp">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach var="category" items="${categoryList}">
					<c:if test="${category.epcparentId  == 0}">
						<dt>${category.epcName}</dt>
					</c:if>
					<c:forEach var = "childcategory" items="${categoryList}">
						<c:if test="${childcategory.epcparentId == category.epcId}">
							<dd><a href="product.do?action=list">${childcategory.epcName}</a></dd>
						</c:if>
					</c:forEach>
				</c:forEach>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<c:forEach var="recent" items="${recentList}">
					<dt><img src="${recent.epPicture2}"></dt>
					<dd><a href="product.do?id=${recent.epId}&action=detail" target="_blank">${recent.epName}</a></dd>
				</c:forEach>
			</dl>
			<script type="text/javascript">
				document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
			</script>
		</div>
	</div>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>
			<div class="pager">
				<ul class="clearfix">
					<input type="text" size="5" id="toPage"/><button onclick="goPage()">Go</button>
					<li><a href="/product.do?action=list&pageIndex=1">首页</a></li>
					<c:if test="${pageIndex>1}"><li><a href="/product.do?action=list&pageIndex=${pageIndex-1}">上一页</a></li></c:if>
					<c:forEach var="page" begin="1" end="${totalPage}">
						<li><a href="/product.do?pageIndex=${page}&action=list" target="_blank">${page}</a></li>
					</c:forEach>
					<c:if test="${pageIndex<totalPage}"><li><a href="/product.do?action=list&pageIndex=${pageIndex+1}">下一页</a></li></c:if>
					<li><a href="/product.do?action=list&pageIndex=${totalPage}">尾页</a></li>
				</ul>
			</div>
			<div class="clear"></div>
			<ul class="product clearfix">
				<c:forEach var="pro" items="${productList}">
					<li>
						<dl>
							<dt><a href="product.do?id=${pro.epId}&action=detail" target="_blank"><img src="${pro.epPicture}" /></a></dt>
							<dd class="title"><a href="/product.do?id=${pro.epId}&action=detail" target="_blank">${pro.epName}</a></dd>
							<dd class="price">￥${pro.epPrice}</dd>
						</dl>
					</li>
				</c:forEach>

			</ul>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
