<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<spring:url var="images" value="/rs/images" />
<spring:url var="css" value="/rs/css" />
<spring:url var="js" value="/rs/js" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">

    

</head>
<body>

	<!-- Navigation-->
	<%@include file="./shared/nav.jsp"%>

	<!-- Content -->
	<c:if test="${userclickhome == true}">
	<%@include file="home.jsp"%>
	</c:if>
	
	<c:if test="${userclickaboutus == true}">
	<%@include file="about.jsp"%>
	</c:if>
	
	<c:if test="${userclickallproducts == true}">
	<%@include file="allproducts.jsp"%>
	</c:if>

	<!-- Footer-->
	<%@include file="./shared/footer.jsp"%>

    <!-- jQuery -->
    <script src="${js}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>

</body>

</html>