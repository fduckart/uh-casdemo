<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class='container-fluid'>
    <security:authorize access="hasRole('ROLE_UH')">
        <div class='row'>
            <div class='col-xs-offset-1 col-xs-10'>
                <h3>Login Attributes</h3>
                <table class='table table-bordered table-hover'>
                    <tbody>
                        <tr>
                            <td colspan="3">Selected CAS Login Details</td>
                        </tr>
                        <tr>
                            <td colspan="1">uid</td>
                            <td colspan="2">${currentUser.uid}</td>
                        </tr>
                        <tr>
                            <td colspan="1">username</td>
                            <td colspan="2">${currentUser.username}</td>
                        </tr>
                        <tr>
                            <td colspan="1" nowrap>uhuuid</td>
                            <td colspan="2">${currentUser.uhuuid}</td>
                        </tr>
                        <tr>
                            <td colspan="1">cn</td>
                            <td colspan="2">${currentUser.name}</td>
                        </tr>
                        <tr>
                            <td colspan="1" style="white-space: nowrap">All Attributes</td>
                            <td colspan="2" class="uh-pre">${currentUser.attributes.map}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class='row'>
            <div class='col-xs-offset-1 col-xs-10'>
                <a href="<c:url value="logout" />" class="btn btn-sm btn-primary" role="button" style='width: 12.2em'>Logout</a>
            </div>
        </div>
    </security:authorize>
</div>
