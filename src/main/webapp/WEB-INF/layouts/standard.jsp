<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>University of Hawaii :: CAS Demonstration</title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/styles/casdemo-main-000.css" />"   type="text/css" media="screen" />
    <link rel="stylesheet" href="<c:url value="/resources/styles/casdemo-header-000.css" />" type="text/css" media="screen" />    
    <link rel="stylesheet" href="<c:url value="/resources/styles/casdemo-footer-000.css" />" type="text/css" media="screen" />    
</head>
<body>    

    <div class="page-container">      
        <!-- top navbar -->
        <div id='uh-header'>
            <div class="navbar navbar-default navbar-fixed-top" role="navigation">
               <div class="container-fluid">
                <div class="navbar-header">
                   <button type="button" class="navbar-toggle" data-toggle="offcanvas" data-target=".sidebar-nav">
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                   </button>
                   <a class="navbar-brand" href="<c:url value="/gate" />">CAS&nbsp;Demonstration</a>
                </div>
               </div>
            </div>
        </div>
        
        <div class="container-fluid">
            <div class="row row-offcanvas row-offcanvas-left">                        
                <div class="col-xs-6 col-sm-2 sidebar-offcanvas" id="sidebar" role="navigation">                              
                    <ul class="nav">
                        <li><a href="<c:url value="/home" />">Home</a></li>
                        <li><a href="<c:url value="/about" />">About</a></li>
                        <li><a href="<c:url value="/faq" />">FAQ</a></li>
                        <li><a href="<c:url value="/contact" />">Contact Us</a></li>
                        <security:authorize access="hasAnyRole('ROLE_ADMIN')">                        
                            <li>
                                <a href="<c:url value="/admin" />">Admin</a>                                
                            </li>
                        </security:authorize>
                        <li><a href="<c:url value="/logout" />">Logout</a></li>
                    </ul>
                </div>
    
                <div class="col-xs-12 col-sm-10">
                    <tiles:insertAttribute name="body"/>          
                </div>
                
            </div><!--/.row-->
        </div><!--/.container-->
    </div><!--/.page-container-->
    
    <tiles:insertAttribute name="footer" />

    <script type="text/javascript" src="<c:url value="/resources/javascript/jquery/jquery-2.1.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/javascript/casdemo/casdemo-000.js" />"></script>
    
</body>
</html>
