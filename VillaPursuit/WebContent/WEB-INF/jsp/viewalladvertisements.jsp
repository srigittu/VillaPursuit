<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>view all advertisements</title>
        <style> 
        .textbox { 
            border: 1px solid #848484; 
            -webkit-border-radius: 30px; 
            -moz-border-radius: 30px; 
            border-radius: 30px; 
            outline:0; 
            height:25px; 
            width: 275px; 
            padding-left:10px; 
            padding-right:10px; 
         } 
         
         p {
             font-size: 200%;
         }
      </style> 
        
    </head>
    <body>
    <h1>Advertisements</h1>
       <p>
        <c:forEach var="advertisement" items="${advertisements}">
            <c:out value="${advertisement.title}"></c:out> <br>
            <c:out value="${advertisement.status}"></c:out> <br>
            <input type = "button" value = "Add Review" onclick = "window.location.href='insertanreview?advertisementId=${advertisement.getAdvertisementId()}'"/>
            <input type = "button" value = "View All Reviews" onclick = "window.location.href='viewallreviews?advertisementId=${advertisement.getAdvertisementId()}'"/> <br>
        </c:forEach>
        <div style="position: absolute; top: 0; right: 30; width: 50px; text-align:right;">
            <a href="logout"><img src="https://t4.ftcdn.net/jpg/00/62/89/77/240_F_62897778_Mpe0AmVF2IdNaAz7eNIW1vvpJQ7gSGne.jpg" width="100" height="50"></a> 
        </div>
    </p>
    </body>
</html>                                  