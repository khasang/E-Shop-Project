<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title><tiles:getAsString name="title"/></title>
    <tiles:insertAttribute name="head"/>
</head>
<body>
    <tiles:insertAttribute name="navbar"/>
    <div class="container">
        <tiles:insertAttribute name="body"/>
    </div> <!-- /container -->
    <tiles:insertAttribute name="footer"/>
    <tiles:insertAttribute name="scripts"/>
</body>
