<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class='container-fluid'>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <div class='row'>
            <div class='col-xs-offset-1 col-xs-10'>
                <h3>Administration</h3>
                <p class='lead'>Action Codes</p>
                <c:if test="${not empty actionList}">
                    <table class="table table-bordered table-hover">
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
        </div>
    </security:authorize>
</div>
