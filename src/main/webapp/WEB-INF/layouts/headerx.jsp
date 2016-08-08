<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="gate">
                <img src="/casdemo/resources/images/seal.jpg" alt="">
            </a>
            <a class="navbar-brand uh-nav-app-name" href="gate">
                CAS Demonstration
            </a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/casdemo/gate">Home</a></li>
                <li><a href="/casdemo/contact">Contact</a></li>
                <li><a href="/casdemo/faq">About</a></li>
                <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <li>
                        <a href="<c:url value="/admin" />">Admin</a>
                    </li>
                </security:authorize>
                <li  class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Campuses <span class="caret"></span></a>

                    <ul class="dropdown-menu" role="menu">
                      <li><a href="https://hilo.hawaii.edu/"     target="_uhhi">Hilo</a></li>
                      <li><a href="https://manoa.hawaii.edu/"    target="_uhma">Manoa</a></li>
                      <li><a href="http://westoahu.hawaii.edu/" target="_uhwo">West Oahu</a></li>
                      <li class="divider"></li>
                      <li><a href="https://hawaii.hawaii.edu/" target="_uhcchi">Hawaii</a></li>
                      <li><a href="http://honolulu.hawaii.edu/" target="_uhccho">Honolulu</a></li>
                      <li><a href="http://kapiolani.hawaii.edu/" target="_uhccka">Kapiolani</a></li>
                      <li><a href="http://kauai.hawaii.edu/" target="_uhccku">Kauai</a></li>
                      <li><a href="http://www.leeward.hawaii.edu/" target="_uhccle">Leeward</a></li>
                      <li><a href="http://maui.hawaii.edu/" target="_uhccmu">Maui</a></li>
                      <li><a href="https://windward.hawaii.edu/" target="_uhccwi">Windward</a></li>
                    </ul>

                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
