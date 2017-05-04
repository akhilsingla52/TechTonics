<%-- <jsp:forward page="/index"/> --%>

<%@ page contentType="text/html"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%
     request.getRequestDispatcher("/index").forward(request, response);
%>