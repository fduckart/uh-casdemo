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
            <a class="navbar-brand" href="#">
                <img src="resources/images/seal.jpg" alt="">
            </a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="about">About</a>
                </li>
                <li>
                    <a href="faq">FAQ</a>
                </li>
                <li  class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Campuses <span class="caret"></span></a>

                    <ul class="dropdown-menu" role="menu">
                      <li><a href="http://manoa.hawaii.edu/" target="_uhhi">Hilo</a></li>
                      <li><a href="http://manoa.hawaii.edu/" target="_uhma">Manoa</a></li>
                      <li><a href="http://manoa.hawaii.edu/" target="_uhwo">West Oahu</a></li>
                      <li class="divider"></li>
                      <li><a href="http://manoa.hawaii.edu/" target="_uhcchi">Hawaii</a></li>
                      <li><a href="http://manoa.hawaii.edu/" target="_uhccho">Honolulu</a></li>
                      <li><a href="http://manoa.hawaii.edu/" target="_uhccka">Kapiolani</a></li>
                      <li><a href="http://manoa.hawaii.edu/" target="_uhccku">Kauai</a></li>
                      <li><a href="http://manoa.hawaii.edu/" target="_uhccle">Leeward</a></li>
                      <li><a href="http://manoa.hawaii.edu/" target="_uhccmu">Maui</a></li>
                      <li><a href="http://manoa.hawaii.edu/" target="_uhccwi">Windward</a></li>
                    </ul>

                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<div class='container-fluid'>
    <div class='row'>
        <div class='col-xs-offset-1 col-xs-11 col-sm-offset-1 col-sm-3 col-md-offset-1 col-md-3'>
            <h3>CAS&nbsp;Demonstration</h3>
            <a href="home" class="btn btn-lg btn-primary" role="button" style='width: 12.2em'>Login</a>
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
