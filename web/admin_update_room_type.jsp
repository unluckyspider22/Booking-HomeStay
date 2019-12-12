<%-- 
    Document   : admin_insert_account
    Created on : Aug 13, 2019, 6:39:04 PM
    Author     : Unlucky Spider
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update RoomType Page</title>
    </head>
    <body>
        <%@include file="admin_sidehead.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                    <li class="active">Update Room Type</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Update Room Type</h1>
                </div>
            </div><!--/.row-->
            <form>

            </form>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Form Elements</div>
                        <div class="panel-body">
                            <div class="col-md-6">
                                <form role="form" method="POST" action="MainController">
                                    <div class="form-group">
                                        <label>RoomType</label>
                                        <input class="form-control" name="txtRoomType" value="${requestScope.DTO.roomType}" readonly="true">
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <input type="text" class="form-control" name="txtDescription" value="${requestScope.DTO.description}">
                                    </div>
                                    <div class="form-group">
                                        <label>Capacity</label>
                                        <input type="text" class="form-control" name="txtCapacity" value="${requestScope.DTO.capacity}">
                                        <font color="red"> ${requestScope.INVALID.capacityError}</font>
                                    </div>
                                    <div class="form-group">
                                        <label>Price</label>
                                        <input class="form-control" name="txtPrice" value="${requestScope.DTO.price}">
                                        <font color="red"> ${requestScope.INVALID.priceError}</font>
                                    </div>
                                    <button type="submit" class="btn btn-primary" name="action" value="UpdateRoomType">Update</button>
                                </form>
                            </div>
                        </div>
                    </div><!-- /.col-->
                </div><!-- /.row -->
            </div><!--/.main-->
        </div>
        <%@include file="admin_script_insert_account.jsp" %>
    </body>
</html>
