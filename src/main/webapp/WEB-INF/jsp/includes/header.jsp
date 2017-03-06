<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Onebox Rest Utils</title>

    <link rel="shortcut icon" href="favicon.ico" />

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <!-- http://www.eslinstructor.net/vkbeautify/ -->
    <script src="/js/vkbeautify.js"></script>

    <!-- Bootstrap -->
    <link href="/public/lib/bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link href="/public/css/styles.css" rel="stylesheet">

</head>
<body>

<c:if test="${embeded == true}">
    <br />
</c:if>

<div class="container">

    <div role="navigation" class="navbar navbar-inverse">
        <div class="container-fluid">
            <c:set var="homeUrl" value="/restClientHome"/>
            <c:if test="${embeded == false}">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">
                        <img alt="Onebox" src="/ob-logo2.png">
                    </a>
                </div>
                <c:set var="homeUrl" value="/"/>
            </c:if>

            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li ${activeTab['home']}><a href="${homeUrl}">Rest Client Home</a> </li>
                    <li ${activeTab['authentication']}><a href="/authentication">Authentication</a></li>
                    <li ${activeTab['query']}><a href="/query">Request</a></li>
                    <li ${activeTab['error_codes']}><a href="/error-codes">Error Codes</a></li>
                </ul>
            </div>
        </div>
    </div>

    <c:if test="${not empty flashMessage}">
        <div class="alert alert-${flashKind} alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                ${flashMessage}
        </div>
    </c:if>