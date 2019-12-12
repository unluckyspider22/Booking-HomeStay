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
        <title>Update Food Page</title>
    </head>
    <body>
        <%@include file="admin_sidehead.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                    <li class="active">Update Food</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Update Food</h1>
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
                                        <label>FoodID</label>
                                        <input class="form-control" name="txtFoodId" value="${requestScope.DTO.foodId}" readonly="true">
                                    </div>
                                    <div class="form-group">
                                        <label>Name</label>
                                        <input type="text" class="form-control" name="txtName" value="${requestScope.DTO.name}">
                                        <font color="red"> ${requestScope.INVALID.foodNameError}</font>
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <textarea class="form-control" name="txtDescription" value="${requestScope.DTO.description}"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Price</label>
                                        <input class="form-control" name="txtPrice" value="${requestScope.DTO.price}">
                                        <font color="red"> ${requestScope.INVALID.priceError}</font>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>Status</label>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="rdStatus" id="optionsRadios1" value="1" checked>Available
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="rdStatus" id="optionsRadios2" value="0">Not Available
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary" name="action" value="UpdateFood">Update</button>
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
