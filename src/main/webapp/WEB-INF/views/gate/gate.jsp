<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class='container-fluid'>
    <div class='row'>
        <div class='col-sm-3 col-sm-offset-1 col-xs-11 col-xs-offset-1'>
            <h3>CAS&nbsp;Demonstration</h3>            
            <p><a href='home'><img src='<c:url value="/resources/images/gw-login-bttn.jpg" />' alt='Login Here'/></a></p>
        </div>
        <div class='col-sm-7 col-sm-offset-1 col-xs-11 col-xs-offset-1'>
            <h3>Latest News &amp; Announcements</h3>
            <p>${systemMessage}</p>
        </div>
    </div>
</div>
