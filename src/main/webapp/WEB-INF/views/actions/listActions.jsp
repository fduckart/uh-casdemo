<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Action Codes</h1>
<div id="typeResults">
<c:if test="${not empty actionList}">
    <table class="bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Code</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="type" items="${actionList}">
                <tr>
                    <td>${type.id}</td>
                    <td>${type.code}</td>
                    <td>${type.description}</td>
                </tr>
            </c:forEach>
            <c:if test="${empty actionList}">
                <tr>
                    <td colspan="5">No Action codes found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</c:if>
</div>  

