<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="loginMsg-row">
    <div class="loginMsg">
        <span>${requestScope.Msg}</span>
        <button onclick="goBack();">이전페이지</button>
    </div>
</div>