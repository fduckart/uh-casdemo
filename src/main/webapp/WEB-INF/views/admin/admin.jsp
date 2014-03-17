<div>    
    <security:authorize access="hasRole('ROLE_ADMIN')">        
        <a href="/casdemo/admin/actions">View Action codes</a>
        <br>
        <hr/>            
        <a href="/casdemo/admin/message">Gate message</a>
        <br>                       
        <hr/>
        <p>
            This project include exception at the mapping level.<br/>
            Here are some exceptions that the Administration section<br/>
            has been coded to throw just for demonstration of their<br/>
            handling within the application.
        </p>
        <a href="/casdemo/admin/404">404 Page Not Found Error</a><br/>
        <a href="/casdemo/admin/npe">Null Pointer Exception</a><br/>
        <a href="/casdemo/admin/ioexception">I/O Exception</a><br/>
        <hr/>
    </security:authorize>    
</div>
    
