<div>
    <security:authorize access="hasRole('ROLE_UH')">
        <table class="bordered">
            <thead>
                <tr>
                    <th colspan="3">Home</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td colspan="3">Selected CAS Login Details</td>
                </tr>
                <tr onMouseOver="this.bgColor='#E5F9C5';" onMouseOut="this.bgColor='#FFFFFF';">
                    <td colspan="1">uid</td>
                    <td colspan="2">${currentUser.uid}</td>
                </tr>                    
                <tr onMouseOver="this.bgColor='#E5F9C5';" onMouseOut="this.bgColor='#FFFFFF';">
                    <td colspan="1">username</td>
                    <td colspan="2">${currentUser.username}</td>
                </tr>                    
                <tr onMouseOver="this.bgColor='#E5F9C5';" onMouseOut="this.bgColor='#FFFFFF';">
                    <td colspan="1" nowrap>uhuuid</td>
                    <td colspan="2">${currentUser.uhuuid}</td>
                </tr>                    
                <tr onMouseOver="this.bgColor='#E5F9C5';" onMouseOut="this.bgColor='#FFFFFF';">
                    <td colspan="1">cn</td>
                    <td colspan="2">${currentUser.name}</td>
                </tr>                    
                <tr>
                    <td colspan="3"></td>
                </tr>
                <tr onMouseOver="this.bgColor='#E5F9C5';" onMouseOut="this.bgColor='#FFFFFF';">
                    <td colspan="1" nowrap>All Attributes</td>
                    <td colspan="2">${currentUser.attributes.map}</td>
                </tr>                    
            </tbody>
        </table>
    </security:authorize>
</div>
