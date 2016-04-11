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
        <div id="entete"><img src="css/images/logo.png" alt="Agriote" width="208" height="58" border="0" title="Agriote" /></a>
            <ul>
                <li class="home"></li>
            </ul>
            <ul class="sousMenu">
            <li><a href="">Accueil</a></li>
            <li class="sousMenuAligne"><a href="">Mon profil</a></li>

            <ul>
                <li class="home"></li>
            </ul>
            <ul class="sousMenu">
                <form action="accueil" method="POST">
                   <li><a href="">ACCUEIL</a></li>
                </form>
                <form action="voirProfil" method="POST">
                   <li><a href="">PROFIL</a></li>
                </form>
                <form action="deconnexion" method="POST">
                   <li class="sousMenuAligne"><a href="">DECONNEXION</a></li>
                </form>
               
            </ul>
        </div>
    <%--ENTETE--%>


    <%--CORPS--%>
        <div id="corps">

            <h2> Candidats pour la session:</h2>
            <h2 id="titre_session">${detailsSession.getIntituleSession()}</h2>
                
            <form action="DetailCandidatures" METHOD="POST">
                <table>
                    <tr>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>En attente de traitement</th>
                        <th>Acceptée</th>
                        <th>Refusée</th>
                        <th>Mise en attente</th>
                    </tr>

                        <c:forEach items="${detailsSession.getListeDePersonnes()}" var="personne">
                            <tr>
                                <td class="nom">
                                   <c:out value="${personne.getNom()}"/></a>
                                </td>
                                <td class="prenom">
                                   <c:out value="${personne.getPrenom()}"/></a>
                                </td>
                                <td class="attente">
                                   <INPUT type="radio" name="<c:out value="${personne.getId()}"/>" value="0" <c:if test="${personne.getId_etatCandidature() == null}" >
                                                                                                        checked
                                                                                                    </c:if>>
                                </td>
                                <td class="valide">
                                   <INPUT type="radio" name="<c:out value="${personne.getId()}"/>" value="2" <c:if test="${personne.getId_etatCandidature() == 2}" >
                                                                                        checked
                                                                                    </c:if>>
                                </td>
                                <td class="refuse">
                                   <INPUT type="radio" name="<c:out value="${personne.getId()}"/>" value="3"<c:if test="${personne.getId_etatCandidature() == 3}" >
                                                                                    checked
                                                                                  </c:if>>
                                </td>
                                <td class="mise">
                                   <INPUT type="radio" name="<c:out value="${personne.getId()}"/>" value="1"<c:if test="${personne.getId_etatCandidature() == 1}" >
                                                                                            checked
                                                                                          </c:if>>
                                </td>
                            </tr>
                        </c:forEach>

                </table>
                <c:set var="message" value="Salut les zéros !" scope="request" />
                <input type="submit" value="Submit" style="margin-top: 1%">
                
            </form>
         <img style="margin-top: -39%;" id="logo" src="css/images/footerLogob.png" alt=""/>   
        </div>
    <%--CORPS--%>


    <%--FOOTER--%>
        <div id="footer">
        </div>
    <%--FOOTER--%>
                
    </body>
</html>