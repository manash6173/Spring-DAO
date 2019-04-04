<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <c:choose>
      <c:when test="${not empty result}">
     <h1 style="color: navy;text-align: center">Dept Details</h1>
      <table border="5" bgcolor="cyan" style="text-align" align="center">
          <tr>
              <th>DAPTNO</th><th>DNAME</th><th>LOC</th>
          </tr>
          <c:forEach var="map" items="${result}">
             <tr>
                <td><c:out value="${map.DEPTNO}"/></td>
                <td><c:out value="${map.DNAME}"/></td>
                <td><c:out value="${map.LOC}"/></td>
             </tr>
          </c:forEach>
      </table>
      </c:when>
      <c:otherwise>
         Dept Not Found
      </c:otherwise>
 </c:choose>
 

