<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<div id="register">
	<form action="registerNewUserExtranet" method="post">
		<table>
			<tr>
				<td>Nombre de usuario:</td>
				<td><input type="text" name="newUser" required/></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type="password" name="newPdw" required/></td>
			</tr>
			<tr>
				<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>
			</tr>
			<tr>
				<td><button type="submit">Register</button> </td>
			</tr>
		</table>
	</form>
</div>