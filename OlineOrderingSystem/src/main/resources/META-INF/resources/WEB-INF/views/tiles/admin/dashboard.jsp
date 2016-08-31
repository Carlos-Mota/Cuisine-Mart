<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <%--<link href="/restaurant/restaurantList.css" rel="stylesheet" type="text/css"/>--%>
    <style>
        .box-table
        {
            background-color: #d5d5d5;
            border:1px solid #d5d5d5;
            padding:10px;
            color:#6e6f72;
            border-radius:5px;
            width: 90%;
            margin-left: 20px;
        }
        .menuHolder
        {
            background-color: #f4f4f4;
            border:1px solid #bdbdbd;
            padding:10px;
            color: #dde0e5;
            border-radius:5px;
            width: auto;
            margin-left: 20px;
            display: table-cell;
        }
        .heading_allcap_c1
        {
            font-size:20px;
            font-family: Arial Cambria Verdana
        font-weight:5000;
            color:#990000; /*#414141;*/
            text-align:left;
            padding:10px 0 10px 0;
            border-bottom:3px solid #616161;
        }
        #mainHolder{
            display: table-row;
        }
    </style>
</head>
<body>
<section class="container">
    <div id="mainHolder">
        <div class="menuHolder">
            <div class="heading_allcap_c1">Restaurants: </div>
            <div><a href="/admin/addRestaurant"><h4>Add new Restaurant</h4></a> </div>
            <table>
                <tbody>
                <c:forEach items="${restaurants}" var="restaurant">
                    <tr>
                        <td>
                            <div class="box-table">
                                <table>
                                    <tr>
                                        <td><a href="#">
                                            <img src=""/>
                                        </a>
                                        </td>
                                        <td>
                                            <div>
                                                <table>
                                                    <tr>
                                                        <td><a href="#">${restaurant.name}</a></td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="menuHolder">
            <div class="heading_allcap_c1">Menus: </div>
            <div><a href="/admin/addMenu"><h4>Add new Menu</h4></a> </div>
            <table>
                <tbody>
                <c:forEach items="${menus}" var="menu">
                    <tr>
                        <td>
                            <div class="box-table">
                                <table>
                                    <tr>
                                        <td><a href="#">
                                            <img src=""/>
                                        </a>
                                        </td>
                                        <td>
                                            <div>
                                                <table>
                                                    <tr>
                                                        <td><a href="#">${menu.name}</a></td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="menuHolder">
            <div class="heading_allcap_c1">Foods: </div>
            <div><a href="/admin/addFood"><h4>Add new Food</h4></a> </div>
            <table>
                <tbody>
                <c:forEach items="${foods}" var="food">
                    <tr>
                        <td>
                            <div class="box-table">
                                <table>
                                    <tr>
                                        <td><a href="#">
                                            <img src=""/>
                                        </a>
                                        </td>
                                        <td>
                                            <div>
                                                <table>
                                                    <tr>
                                                        <td><a href="#">${food.name}</a></td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>
</body>
</html>
