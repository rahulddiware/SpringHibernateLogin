<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<sec:authentication var="user" property="principal" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h4>
				[${user.message}] ${pageContext.request.userPrincipal.name} 
						<sec:authorize access="hasAnyRole('ROLE_USER')">
								[${user.username}]
						</sec:authorize>
				</h4>				
						
   			   <a onclick="document.forms['logoutForm'].submit()">Logout</a>
		

		</c:if>

	</br>
</br>
<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN', 'ROLE_SU')">

<c:forEach items="${menuList}" var="menu">
    <sec:authorize url="${menu.url}">
        <a href=${contextPath}${menu.url}>${menu.label}</a> </br>
    </sec:authorize>
</c:forEach>

</sec:authorize>

