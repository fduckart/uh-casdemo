<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class='container-fluid'>
    <div class='row'>
        <div class='col-xs-offset-1 col-xs-11 col-sm-offset-1 col-sm-3 col-md-offset-1 col-md-3'>
            <h3>CAS&nbsp;Demonstration</h3>
            <p><a href='home'><img src='<c:url value="/resources/images/gw-login-bttn.jpg" />' alt='Login Here'/></a></p>
        </div>
        <div class='col-xs-offset-1 col-xs-11 col-sm-offset-1 col-sm-6 col-md-offset-1 col-md-5'>
            <h3>Latest News &amp; Announcements</h3>
            <p class='lead'>${systemMessage}</p>
            <p class='lead'>
                <a href="https://github.com/fduckart/uh-casdemo" target="_code_vw">View</a>
                the code for this application.
            </p>
        </div>
    </div>
</div>
