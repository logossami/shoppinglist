<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Shopping List</title>
	<link rel="stylesheet" href="/styles/demo.css"> 
	<script src="/js/app.js"></script>
</head>
<body>
	<h1>Your shopping list</h1>

	<form method="post">
		<input name="title" required type="text"
			placeholder=" type item here..." autofocus /> <input type="submit"
			value="Add to list" />
	</form>
	<h2>Titles:</h2>
	<ul>
		<c:forEach items="${ listaNakyviin }" var="shoppingListItem">
			<li id="product-${ shoppingListItem.getId() }"><c:out value="${ shoppingListItem.getTitle() }" />
				<button class="button" onclick="removeProduct(${ shoppingListItem.getId() })">Remove</button>
			</li>
		</c:forEach>
	</ul>

</body>
</html>