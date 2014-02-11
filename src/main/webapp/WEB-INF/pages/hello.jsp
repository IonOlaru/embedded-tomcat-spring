<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

HELLO.jsp
<c:forEach items="${objects1}" var="s">
    <li>${s}
</c:forEach>

<c:forEach items="${objects2}" var="s">
    <li>-${s}
</c:forEach>