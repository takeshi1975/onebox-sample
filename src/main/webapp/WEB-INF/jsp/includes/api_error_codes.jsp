<div class="panel panel-danger">

    <div class="panel-heading">
        <h3 class="panel-title">Response HTTP Header Error Codes (OB_Error_Code)</h3>
    </div>

    <table class="table">
        <tr>
            <th>OB_Error_Code</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        <c:forEach var="error_code" items="${error_codes}">
            <tr>
                <td>${error_code.code}</td>
                <td>${error_code.name}</td>
                <td>${error_code.description}</td>
            </tr>
        </c:forEach>
    </table>

</div>
