<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <h3>Gate Message</h3>

        <form:form id="form" method="POST" action="/admin/message" modelAttribute="messageAttribute">
            <form:errors path="*" cssClass="error" />
    
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="typeId"/>
            <form:input type="hidden" path="enabled"/>
    
            <table class="gate-message">
                <tr>
                    <td><form:textarea path="text" rows="15" cols="70" /></td>
                </tr>
                <tr>
                    <td><form:errors path="text" cssClass="error"/><td>
                </tr>
                <tr>
                    <td><input type="submit" value="Update" class="btn"/></td>
                </tr>
            </table>
        </form:form>

    </security:authorize>
</div>

