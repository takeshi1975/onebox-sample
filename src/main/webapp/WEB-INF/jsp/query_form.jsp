<%@include file="includes/header.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading">
	<h3 class="panel-title">Default querys<a data-toggle="collapse" data-parent="#accordion" href="#accordionDefault" class="btn btn-default btn-xs pull-right">show</a></h3>
	</div>
	<div id="accordionDefault" class="panel-collapse collapse">
		<div id="panel-body">
		<table class="table">
			<tr><td style="width:20%"> Availability</td><td><a href="javascript:loadQuery(1)" class="btn btn-default btn-xs pull-right">load</a></td></tr>
			<tr><td>Details of Product Id</td><td><a href="javascript:loadQuery(2)" class="btn btn-default btn-xs pull-right">load</a></td></tr>
			<tr><td>Create Shopping Cart</td><td> <a href="javascript:loadQuery(3)" class="btn btn-default btn-xs pull-right">load</a></td></tr>
			<tr><td>Add Individual Seats</td><td> <a href="javascript:loadQuery(4)" class="btn btn-default btn-xs pull-right">load</a></td></tr>
		</table>
		</div>
	</div>
</div>	
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Authentication Parameters To Use <a data-toggle="collapse" data-parent="#accordion" href="#accordionOne" class="btn btn-default btn-xs pull-right">show</a></h3>
    </div>
    <div id="accordionOne" class="panel-collapse collapse">
        <div class="panel-body">
            <!-- Table -->
            <table class="table">
                <tr>
                    <th width="200">Parameter</th>
                    <th>Value</th>
                </tr>
                <tr>
                    <td>User</td>
                    <td>${authenticationForm.user}</td>
                </tr>
                <tr>
                    <td>Terminal</td>
                    <td>${authenticationForm.terminal}</td>
                </tr>
                <tr>
                    <td>Channel ID</td>
                    <td>${authenticationForm.channelId}</td>
                </tr>
                <tr>
                    <td>Point Of Sale</td>
                    <td>${authenticationForm.pos}</td>
                </tr>
                <tr>
                    <td>License</td>
                    <td>${authenticationForm.license}</td>
                </tr>
                <tr>
                    <td>MD5 Password</td>
                    <td>${authenticationForm.password}</td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><p><a href="/authentication" class="btn btn-default">Change</a></p></td>
                </tr>
            </table>
        </div>
    </div>
</div>

<div class="panel panel-info">

    <div class="panel-heading">
        <h3 class="panel-title">Enter Request Parameters</h3>
    </div>

    <div class="panel-body">

        <form:form action="/query" modelAttribute="queryForm" role="form" method="post">

            <form:errors />

            <div class="row col-lg-12">
                <div class="well well-sm">
                    <div class="form-group">
                        <form:label path="url">Onebox Query URL</form:label>
                        <form:errors cssClass="error" path="url" />
                        <form:input path="url" type="text" class="form-control" placeholder="Eg: http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/events/search?cityPromoter=Barcelona" />
                    </div>

                    <div class="form-inline">
                        <div class="form-group">
                            <form:label path="method">Method&nbsp;</form:label>
                            <form:select path="method" id="methodSelect" class="form-control">
                                <form:option value="get" label="GET"/>
                                <form:option value="post" label="POST"/>
                            </form:select>
                        </div>

                        <div class="form-group">
                            <form:label path="accept">Accept&nbsp;</form:label>
                            <form:select path="accept" class="form-control">
                                <form:option value="xml" label="XML"/>
                                <form:option value="json" label="JSON"/>
                            </form:select>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group" id='requestContent' style='display:none;'>
                <br/><br/>
                <div class="row col-lg-12">
                    <div class="well well-sm">
                        <h5><b>Enter Post Parameters:</b></h5>
                        <input type="hidden" id="paramCount" name="paramCount" value="${queryForm.paramCount}">
                        <table class="table table-condensed" id="tab_logic">
                            <c:forEach var="name" items="${queryForm.names}" varStatus="status">
                            <tr id='${name.key}'>
                                <td><input type="text" class="form-control" name="names['${name.key}']"  value="${queryForm.names[name.key]}" placeholder="Name"></td>
                                <td><input type="text" class="form-control" name="values['${name.key}']" value="${queryForm.values[name.key]}" placeholder="Value"></td>
                                <c:if test="${status.index==0}">
                                    <td><button type="button" class="btn btn-success" id="add_row"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button></td>
                                </c:if>
                                <c:if test="${status.index!=0}">
                                    <td><a type='button' class='btn btn-danger' onclick='removeRow("${name.key}");'><span class='glyphicon glyphicon-minus' aria-hidden='true'></a></td>
                                </c:if>
                            </tr>
                            </c:forEach>
                            <tr id='param${queryForm.paramCount+1}'></tr>
                        </table>
                        <small>NOTE: Parameters with empty name or value will be removed from request.</small>
                    </div>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Send Request</button>

        </form:form>

    </div>
</div>

<c:if test="${responseDTO!=null}">
    <div class="panel panel-warning">

        <div class="panel-heading">
            <h3 class="panel-title">Request <a data-toggle="collapse" data-parent="#accordion" href="#accordionTwo" class="btn btn-default btn-xs pull-right">show</a></h3>
        </div>

        <div id="accordionTwo" class="panel-collapse collapse">
            <div class="panel-body">

                <table class="table">
                    <tr>
                        <th width="180">Date</th>
                        <td><fmt:formatDate value="${responseDTO.date}" pattern="dd-MM-yyyy"/></td>
                    </tr>
                    <tr>
                        <th>String to sign</th>
                        <td>${responseDTO.stringToSign}</td>
                    </tr>
                    <tr>
                        <th>Authorization String</th>
                        <td>${responseDTO.authorization}</td>
                    </tr>
                    <tr>
                        <th>HTTP Headers</th>
                        <td>
                            <table border="0">
                            <c:forEach var="entry" items="${responseDTO.httpHeaders}">
                                <tr>
                                    <td width="120"><c:out value="${entry.key}"/></td>
                                    <td width="30">-&#62;</td>
                                    <td><c:out value="${entry.value[0]}"/></td>
                                </tr>
                            </c:forEach>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

    <div class="panel panel-success">

        <div class="panel-heading">
            <h3 class="panel-title">Response</h3>
        </div>

        <div class="panel-body">

            <c:if test="${not empty responseDTO.error}">
                <div class="alert alert-danger alert-dismissable">
                    <span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>&nbsp;&nbsp;ERROR: ${responseDTO.error.message} (${responseDTO.additionalErrorMessage})<br/>
                    <c:if test="${not empty responseDTO.obResponseErrorCode}">
                        <br/>
                        <b>Onebox API Error</b>
                        <table>
                            <tr>
                                <th>Code</th>
                                <td>${responseDTO.obResponseErrorCode.code}</td>
                            </tr>
                            <tr>
                                <th>Name</th>
                                <td>${responseDTO.obResponseErrorCode.name}</td>
                            </tr>
                            <tr>
                            <tr>
                                <th>Description&nbsp;&nbsp;</th>
                                <td>${responseDTO.obResponseErrorCode.description}</td>
                            </tr>
                        </table>
                    </c:if>
                    <br/>

                </div>
            </c:if>

            <c:if test="${not empty responseDTO.responseEntity.headers}">
                <table class="table">
                    <tr>
                        <th width="180">Status Code</th>
                        <td>${responseDTO.responseEntity.statusCode}</td>
                    </tr>
                    <tr>
                        <th width="180">HTTP Headers</th>
                        <td>
                            <table border="0">
                                <c:forEach var="entry" items="${responseDTO.responseEntity.headers}">
                                    <tr>
                                        <td width="120"><c:out value="${entry.key}"/></td>
                                        <td width="30">-&#62;</td>
                                        <td><c:out value="${entry.value[0]}"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                <c:if test="${empty responseDTO.error}">
                    <tr>
                        <th width="180">Body Size</th>
                        <td><fmt:formatNumber value="${responseDTO.bodySizeInBytes}" pattern="##,###"/> Bytes - <fmt:formatNumber value="${responseDTO.bodySizeInKilobytes}" pattern="##,###.##"/> KB - <fmt:formatNumber value="${responseDTO.bodySizeInKilobytes/1024}" pattern="##,###.##"/> MB</td>
                    </tr>
                    <tr>
                        <th width="180">Response Body</th>
                        <td>
                            <textarea class="form-control" rows="25" id="responseBody">${responseDTO.responseEntity.body}</textarea>
                            <p><br/><a href="javascript:beautify('${queryForm.accept}')" class="btn btn-info">Beautify</a></p>
                        </td>
                    </tr>
                </c:if>
                </table>
            </c:if>
        </div>
    </div>

</c:if>

<script type="text/javascript">

    $(document).ready(function(){

        var i=${queryForm.paramCount+1};
        $("#add_row").click(function(){

            $('#param'+i).html("<td><input type='text' class='form-control' name='names[\"param" + i + "\"]' placeholder='Name'></td> <td><input type='text' class='form-control' name='values[\"param" + i + "\"]' placeholder='Value'></td> <td><a type='button' class='btn btn-danger' onclick='removeRow(\"param" + i + "\");'><span class='glyphicon glyphicon-minus' aria-hidden='true'></a></td>");
            $('#tab_logic').append('<tr id="param'+(i+1)+'"></tr>');
            i++;
            $("#paramCount").val(i);
        });

        if ($('#methodSelect').val()=='post') {
            $("#requestContent").show();
        }

        $('#methodSelect').change(function(){
            if ( this.value == 'post')
            {
                $("#requestContent").show();
            } else {
                $("#requestContent").hide();
            }
        });
    });

    function removeRow(id) {
        $("#"+id).html('');
    }

    function beautify(lang) {

        if (lang == 'json') {
            $("#responseBody").val(vkbeautify.json($("#responseBody").val(),4));
        } else {
            $("#responseBody").val(vkbeautify.xml($("#responseBody").val()));
        }
    }
    
    function loadQuery(type){
    	if (type==1)
    		$("#url").val("http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/events/search?eventType=ACTIVITY")    		
    	else if (type==2)
    		$("#url").val("http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/session/131156/info");
    	else if (type==3)
    		$("#url").val("http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/shoppingCart/create");
    	else
    		$("#url").val("http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/shoppingCart/addIndividualActivitySeats")
    }

</script>

<%@include file="includes/footer.jsp"%>