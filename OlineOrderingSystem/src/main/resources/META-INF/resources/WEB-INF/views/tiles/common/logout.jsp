<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .top-bar, .top-bar ul {
        background-color: #eee;
    }
</style>
<a:url value="/j_spring_security_logout" var="logoutUrl" />
<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>
<li style="margin-top: 15px">
    <a:if test="${pageContext.request.userPrincipal.name != null}">
       <label> Welcome : ${pageContext.request.userPrincipal.name} |</label>
    </a:if>
</li>
<li><a href="javascript:formSubmit()">Logout</a></li>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>
