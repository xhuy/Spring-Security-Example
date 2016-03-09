<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div id="login">

	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>

	<c:url var="loginUrl" value="/login" />

	<form name="loginForm" action="${loginUrl}" method="post">
		<table>
			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="user" required/></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type="password" name="pwd" required/></td>
			</tr>
			<tr>
				<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>
			</tr>
			<tr>
				<td><button type="submit">Log In</button></td>
			</tr>
		</table>
	</form>
</div>