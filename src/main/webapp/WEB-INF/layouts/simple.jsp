<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>University of Hawaii :: CAS Demonstration</title>
    <link rel="stylesheet" href="<c:url value="/resources/styles/main-001.css" />" type="text/css" media="screen" />    
    <link rel="stylesheet" href="<c:url value="/resources/styles/gate.css" />" type="text/css" media="screen" />
    <link rel="stylesheet" href="<c:url value="/resources/styles/casdemo-footer.css" />" type="text/css" media="screen" />
</head>

<body>

    <div id="header">
        <div id="wrapper-header-left">
            <div id="site-id">CAS Demonstration</div>
            <div id="version-id"></div>
        </div>
    </div>

    <div id="main-wrapper">        
        <div id="wrapper-columns">
            <div id="container">
                <div id="middle">                                        
                    <tiles:insertAttribute name="body" />                        
                </div>
            </div>
        </div>
        <div id="footer_container">
            <div id="footer">
                <div id="campus-list">
                    <strong>Quick links:</strong>
                    <a href="http://manoa.hawaii.edu/">Manoa</a> &#124;
                    <a href="http://hilo.hawaii.edu/">Hilo</a> &#124;
                    <a href="http://westoahu.hawaii.edu/">West O'ahu</a> &#124;
                    <a href="http://hawaii.hawaii.edu/">Hawai'i</a> &#124;
                    <a href="http://honolulu.hawaii.edu/">Honolulu</a> &#124;
                    <a href="http://www.kapiolani.hawaii.edu/">Kapi'olani</a> &#124;
                    <a href="http://kauai.hawaii.edu/">Kaua'i</a> &#124;
                    <a href="http://www.lcc.hawaii.edu/">Leeward</a> &#124;
                    <a href="http://maui.hawaii.edu/">Maui</a> &#124;
                    <a href="http://windward.hawaii.edu/">Windward</a>
                </div>
            </div>
        </div>
    </div>
    
</body>

</html>
