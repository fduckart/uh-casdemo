<div class='container-fluid'>
    <security:authorize access="hasRole('ROLE_ADMIN')">        
        <a href="/casdemo/admin/actions">View Action codes</a>
        <br>
        <hr/>            
        <p>
            This project includes some exception handling that is <br/> 
            able to be handled at the controller level.<br/>
            Here are some exceptions that the Administration section<br/>
            has been coded to throw just for demonstration of their<br/>
            handling within the application.
        </p>        
        <a href="/casdemo/admin/npe">Null Pointer Exception</a><br/>
        <a href="/casdemo/admin/ioexception">I/O Exception</a><br/>
        <hr/>
    </security:authorize>    
</div>
    
