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

            <h2> Les Formations candidatées: </h2>
             <div id = "menu" style = "margin-right: 7%; margin-top: -5.2%;"> 
                <p>Debut de la session</p>
            </div>
            <div id = "menu" style = "margin-right: -8%; margin-top: -5%;"> 
                <p>Candidats inscrits</p>
            </div>
            <div id = "menu" style = "margin-right: 2%; margin-top: -3%;"> 
                <p>Nb places</p>
            </div>
            
            
            <br>
                
            <hr class="tab">
            <c:forEach items="${LesSessionsCandidates}" var="sessions">
                <div id="intitule">
                    <img id="puce" src="css/images/triangle.png" alt=""/>
                    <a href = "<c:url value="DetailCandidatures">
                                    <c:param name="idSession" value="${sessions.getIdSession()}"/>
                               </c:url>" > 
                    <c:out value="${sessions.getIntituleSession()}"/></a>
                    <span id="nbCandid"><c:out value="${sessions.getCandidatsInscrits()}"/></span>
                    <span id="nbCandid" style="margin-right: 4%;"><c:out value="${sessions.getNbPlaces()}"/></span>
                    
                    
                    <hr>
                                                     
                </div>
                
                
                <!--    <c:forEach items="${sessions.getListeDePersonnes()}" var="lesCandidats">
                        <div style="margin-left:  20px; ">
                            <c:out value="${lesCandidats.getNom()}" />
                        </div>
                    </c:forEach>   -->
            </c:forEach>
                    <img style="margin-top: -73%;" id="logo" src="css/images/footerLogob.png" alt=""/>
        </div>
        
    <%--CORPS--%>


    <%--FOOTER--%>
        <div id="footer">
        </div>
    <%--FOOTER--%>
                
    </body>
</html>
