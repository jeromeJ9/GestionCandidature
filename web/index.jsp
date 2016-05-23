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
            <li><a href="AffichageSessions">Accueil</a></li>
           

           
</div>
    <%--ENTETE--%>


    <%--CORPS--%>
        <div id="corps" style="padding-bottom: 13%;">
            <h2>Gestion des candidatures</h2>
          <form action="AffichageSessions" method="GET" style="margin-left: 30%;margin-top: 10.5%;">
             
              
            <input type="submit" value="Gerer les candidatures">
            
        </form>
           
        </div>
        
    <%--CORPS--%>


    <%--FOOTER--%>
        <div id="footer">
        </div>
    <%--FOOTER--%>
                
    </body>
</html>









<!--




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>
        <form action="AffichageSessions" method="GET">
            <input type="submit" value="Gerer les candidatures">
            
        </form>
    </body>
</html>
-->