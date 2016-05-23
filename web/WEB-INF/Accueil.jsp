<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
        <link href="css/agrioteCSS.css" rel="stylesheet" type="text/css"/>
        <link href="css/cssPlus.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    
    <body>
        
    <%--ENTETE--%>
        <c:import url="Entete.jsp"></c:import>
    <%--ENTETE--%>


    <%--CORPS--%>
        <div id="corps">

            <h2> Gestion des sessions: </h2>
            
            
            <table style="margin-top: 40px;">
                <tr class="thAcceuil">
                    <th>
                        
                    </th>
                     <th>
                        
                    </th>
                    <th style = "width: 0%;border-top: 1px #7C7900 solid;">
                        <p class="titreDetail" style="padding: inherit;width: 185px;">Debut de la session</p>
                    </th>
                    <th style = "width: 6%;border-top: 1px #7C7900 solid;">
                        <p class="titreDetail" style="padding: inherit;width: 158px;right: 7%;">Nombre de places</p>
                    </th>
                    <th style = "width: 6%;border-top: 1px #7C7900 solid;">
                        <p class="titreDetail" style="padding: inherit;width: 158px;right: 2%;">Candidats inscrits</p>
                    </th>
                </tr>
                <c:forEach items="${LesSessionsCandidates}" var="sessions">
                    
                    <tr id="detail">
                        <td style ="text-align: left;">
                           <a  style="text-decoration: blink;" href ="AffichageSessions?session=${sessions.getIdSession()}">                  
                           <img id="puce" src="css/images/triangle.png" alt="" style="margin-right: 15px;"/>
                            </a>
                            <a href = "<c:url value="DetailCandidatures">
                                            <c:param name="idSession" value="${sessions.getIdSession()}"/>
                                       </c:url>" id="detailCandid" > 
                            <c:out value="${sessions.getIntituleSession()}"/></a>
                        </td>
                        <td >
                            
                        </td>
                        <td style="font-size: 0.8em;">
                            <c:out value="${sessions.getDateDebutSessionJMA()}"/>
                        </td>
                        <td style="font-size: 0.8em;">
                            <c:out value="${sessions.getNbPlaces()}"/>
                        </td>
                        <td style="font-size: 0.8em;">
                             <c:out value="${sessions.nbInscrit()}"/>
                        </td>

                    </tr>
                    
                    <c:if test="${laSessionDemandee.getIdSession() == sessions.getIdSession()}">
                      

                            <tr id="fondDetail">
                                <td colspan="5" style="padding-left: 60px">Debut des inscriptions: <c:out value="${laSessionDemandee.getDebutInscription()}"/></td>
                            </tr>
                            <tr id="fondDetail">
                                <td colspan="5" style="padding-left: 60px">Fin des inscriptions: <c:out value="${laSessionDemandee.getFinInscription()}"/></td>
                            </tr>
                        
                        
                    </c:if>
                </c:forEach>
            </table>
            <div style="text-align: start;margin-top: 48px;font-size: 0.7em;">
                cliquer sur<img id="puce" src="css/images/triangle.png" alt="" style="margin:2px 9px 0 11px;"/>pour avoir plus de details !
            </div>
                    <img  id="logo" src="css/images/footerLogob.png" alt=""/>
        </div>
        
    <%--CORPS--%>


    <%--FOOTER--%>
        <div id="footer">
        </div>
    <%--FOOTER--%>
                
    </body>
</html>
