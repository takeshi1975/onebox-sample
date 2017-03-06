<%@include file="includes/header.jsp"%>

    <div class="panel panel-info">

        <div class="panel-heading">
            <h3 class="panel-title">Please Enter Authentication Parameters</h3>
        </div>

        <div class="panel-body">
            <p>All parameters are required.</p>

            <form:form action="/authentication" modelAttribute="authenticationForm" role="form" method="post">

                <form:errors />

                <div class="form-group">
                    <form:label path="user">User</form:label>
                    <form:errors cssClass="error" path="user" />
                    <form:input path="user" type="text" class="form-control" placeholder="Eg: user@somedomain.com" />
                </div>

                <div class="form-group">
                    <form:label path="terminal">Terminal</form:label>
                    <form:errors cssClass="error" path="terminal" />
                    <form:input type="text" path="terminal" name="terminal" class="form-control" placeholder="Terminal" />
                </div>

                <div class="form-group">
                    <form:label path="channelId">Channel ID</form:label>
                    <form:errors cssClass="error" path="channelId" />
                    <form:input type="text" path="channelId" name="channelId" class="form-control" placeholder="Channel ID" />
                </div>

                <div class="form-group">
                    <form:label path="pos">Point of sale</form:label>
                    <form:errors cssClass="error" path="pos" />
                    <form:input type="text" path="pos" name="pos" class="form-control" placeholder="Point of sale" />
                </div>

                <div class="form-group">
                    <form:label path="license">License</form:label>
                    <form:errors cssClass="error" path="license" />
                    <form:input type="text" path="license" name="license" class="form-control" placeholder="00000-0000-0000-0000" />
                </div>

                <div class="form-group">
                    <form:label path="password">MD5 Password</form:label>
                    <form:errors cssClass="error" path="password" />
                    <form:input type="text" path="password" name="password" class="form-control" placeholder="MD5 Password" />
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="button" class="btn btn-default" id="resetButton">Reset</button>

            </form:form>
        </div>
    </div>

<script>
    $(document).ready(function(){
        $('#resetButton').click(function(){
            $(".form-control").val("");
        });
    });
</script>

<%@include file="includes/footer.jsp"%>