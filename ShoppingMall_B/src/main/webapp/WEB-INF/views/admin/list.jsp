<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>
<table>
	<c:forEach var="product" items="${list }" >
	<tr>
		<td><a href="/admin/product/view?productCode=${product.productCode}">${product.productCode }</a></td>
	</tr>
	</c:forEach>
</table>
<%@include file="../includes/footer.jsp"%>