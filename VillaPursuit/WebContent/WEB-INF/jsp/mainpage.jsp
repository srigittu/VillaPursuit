<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <style>
         body {
         background: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5q-fRaVq0xdQu1AGAjEEpSKaYVg7sHnc7O2c_Xw77E-drQGupghibsrsB");
         background-size:cover;
         }
         body:hover {
         color:powderblue;
         }
         h1 {
             height: 200px;
             width: 400px;
             position: absolute;
             top: 50%;
             left: 25%;
             margin-top: -100px;
             margin-left: -200px;
         }
         h2 {
             height: 200px;
             width: 400px;
             position: absolute;
             top: 50%;
             left: 60%;
             margin-top: -100px;
             margin-right: -200px;
         }
        </style>
    </head>
    <body>
            <div style="position: absolute; top: 0; left: 0; width: 100px; text-align:left;">
                <p><a href="insertanaddress" style="text-decoration:none">Add address</a></p>
            </div>
            <h1>
            <a href="insertanadvertisement"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSY0dl6aU96izrpat5W1uH712zaYq0QLxAYC4ME1SY5DMG9tiRt" title="Post advertisement" width="300" height="200" /></a> <br>
            <center> <input type = "button" value = "Add Review"
            onclick = "window.location.href='insertanadvertisement'"/>
            <a href="insertanadvertisement"></a>  </center>
            </h1>
            <h2>
            <a href="viewalladvertisements"><img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSgYzVVNOXVzNWvlAEI_dNyMvS3GstbV_GkoaogQ_bGicM53Pon" title="visit all advertesments" width="300" height="200" /></a><br> 
            <center> <input type = "button" value = "View All Advertisements"
            onclick = "window.location.href='viewalladvertisements'"/> </center>            
            </h2>
             <div style="position: absolute; top: 0; right: 0; width: 100px; text-align:right;">
             <a href="logout"><img src="https://t4.ftcdn.net/jpg/00/62/89/77/240_F_62897778_Mpe0AmVF2IdNaAz7eNIW1vvpJQ7gSGne.jpg" width="100" height="50"></a>
             </div>
    </body>
</html>
