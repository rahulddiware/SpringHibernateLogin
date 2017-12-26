<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">

<meta name="author" content="">

<title>Welcome</title>

<link href="${contextPath}/resources/css/style.css" rel="stylesheet">

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</head>
<body>

	<sec:authentication var="user" property="principal" />

	<sec:authorize access="isAuthenticated()">

		<div class="container-fluid">

			<div class="row">

 			<div class="col-sm-2" ><jsp:include page="${request.contextPath}/loadMenuItem"></jsp:include></div>

				<div class="col-sm-10 myStyle" >
	
						<!-- Page contents goes here -->
	
				</div>
			</div>
		</div>

	</sec:authorize>
</body>


</html>
