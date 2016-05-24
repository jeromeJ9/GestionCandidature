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

            <h2> Candidats pour la session:</h2>
            <h2 id="titre_session">${detailsSession.getIntituleSession()}&emsp;${detailsSession.getDateSessionMA()}</h2>
            <h4 style="margin-top: -10px;">Nombre de places restantes:&emsp;<c:out value="${detailsSession.getNbPlacesRestantes()}"/></h4>
            <h4 style="color:red;"><c:if test="${tropInscris != null }">trop de candidats validés !!</c:if></h4>
            <form action="DetailCandidatures" METHOD="POST">
                <table style="margin-top: 60px;">
                    
                    <tr>
                        <th style ="width: 23%;"></th>
                        <th style ="width: 23%;"></th>
                        <th style ="width: 35%;"></th>
                        <th><p class="titreDetail" style="padding: inherit;top: 185px;">Acceptée</p></th>
                        <th><p class="titreDetail" style="padding: inherit;top: 189px;">Refusée</p></th>
                        <th><p class="titreDetail" style="padding: inherit;top: 164px;right: 56px">Mise en attente</p></th>
                    </tr>

                    <c:forEach items="${detailsSession.getListeDePersonnes()}" var="candidat">
                    <tr style="border-bottom:  1px #7C7900 solid;">
                        
                        <td class="nom" >
                           <a  id="detailCandid" href ="DetailCandidatures?idCandidat=${candidat.getId()}&idSession=${detailsSession.getIdSession()}" >
                           <c:out value="${candidat.getNom()}"/></a>
                        </td>
                       
                        
                        <td class="prenom" style="text-align: left;">
                           <c:out value="${candidat.getPrenom()}"/>
                        </td>
                        <td class="attente">
                           <c:if test="${candidat.getId_etatCandidature() == 0}" >
                                En attente de traitement
                           </c:if>
                          
                        </td>
                        
                                              
                        <td>
                           <INPUT type="radio" name="<c:out value="${candidat.getId()}"/>" value="2" 
                                  <c:if test="${(candidat.getId_etatCandidature() == 2) }">checked</c:if> >
                        </td>
                        
                        <td class="refuse">
                           <INPUT type="radio" name="<c:out value="${candidat.getId()}"/>" value="3"
                                    <c:if test="${candidat.getId_etatCandidature() == 3}" >
                                        checked
                                    </c:if>>
                        </td>
                        
                        <td class="mise">
                           <INPUT type="radio" name="<c:out value="${candidat.getId()}"/>" value="1"
                                    <c:if test="${candidat.getId_etatCandidature() == 1}" >
                                        checked
                                    </c:if>>
                        </td>
                        
                        <c:if test="${idCandidatPourDetail == candidat.getId()}">
                            <c:if test="${listeCandidature.size() > 1}">
                            <tr id="fondDetail" >
                                
                                <td style ="border:none;text-align: left; " colspan="6">
                                    <span style="margin-bottom: 10px;">
                                        Autre candidatures:
                                    </span>
                                </td>
                            </tr>
                            
                                <c:forEach items="${listeCandidature}" var="sessions">
                                   <c:if test="${sessions.key != detailsSession.getIntituleSession()}">
                                       <tr style="border: none;" id="fondDetail">
                                           <td colspan="2" style ="text-align: left;border: none;">
                                               <div style="margin-left: 25px;">
                                                      . <c:out value="${sessions.key}"/> 
                                                      
                                               </div>
                                           </td>
                                           <td>
                                               
                                              <c:if test="${sessions.value[0] == 'En attente de traitement'}" >
                                                 En attente de traitement
                                               </c:if>
                                               
                                                  
                                           </td>
                                           <td class="valide">
                                               <INPUT type="radio"  disabled="true"
                                                <c:if test="${sessions.value[0] == 'Validée'}" >
                                                   checked
                                               </c:if>
                                                   
                                           </td>

                                           <td class="refuse">
                                               <INPUT type="radio" disabled="true" 
                                               <c:if test="${sessions.value[0] == 'Refusé'}" >
                                                   checked
                                               </c:if>
                                           </td>

                                           <td class="mise">
                                               <INPUT type="radio" disabled="true"
                                               <c:if test="${sessions.value[0]== 'En attente'}" >
                                                   checked
                                               </c:if>
                                           </td>
                                       </tr>
                                       <tr style="border: none;" id="fondDetail">
                                           <td colspan="6">
                                               <div style="margin-left: 38px;">
                                                    <c:out value="${sessions.value[1]}"/> 
                                               </div>
                                           </td>
                                       </tr>
                                   </c:if>
                                </c:forEach>
                            </c:if>     
                        </c:if> 
                    </tr >
                    
                    </c:forEach>
                </table>
               <input type="submit" value="Valider" style="margin-top: 3%;padding: 5px;">
            </form>
         <img  id="logo" src="css/images/footerLogob.png" alt=""/>   
        </div>
    <%--CORPS--%>


    <%--FOOTER--%>
        <div id="footer">
        </div>
    <%--FOOTER--%>
                
    </body>
</html>