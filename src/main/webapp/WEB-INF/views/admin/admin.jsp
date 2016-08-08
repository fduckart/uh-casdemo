<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<div class='container-fluid'>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <div class='row'>
            <div class='col-xs-offset-1 col-xs-10'>
                <h3>Administration</h3>
                <hr/>
                <a href="<c:url value="/admin/actions" />">View Action codes</a><br/>                
                <br>
                <hr/>
                <p>
                    This project includes some exception handling that is <br/>
                    able to be handled at the controller level.<br/>
                    Here are some exceptions that the Administration section<br/>
                    has been coded to throw just for demonstration of their<br/>
                    handling within the application.
                </p>
                <a href="<c:url value="/admin/npe" />">Null Pointer Exception</a><br/>
                <a href="<c:url value="/admin/ioexception" />">I/O Exception</a><br/>                                
                <hr/>
            </div>
        </div>
    </security:authorize>
</div>

