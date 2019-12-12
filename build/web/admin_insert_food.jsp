<%-- 
    Document   : admin_insert_account
    Created on : Aug 13, 2019, 6:39:04 PM
    Author     : Unlucky Spider
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Food Page</title>
    </head>
    <body>
        <%@include file="admin_sidehead.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                    <li class="active">Add Food</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Add Food</h1>
                </div>
            </div><!--/.row-->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Form Elements</div>
                        <div class="panel-body">
                            <div class="col-md-6">
                                
                                <form role="form" action="MainController" method="POST">
                                    <div class="form-group">
                                        <label>FoodID</label>
                                        <input class="form-control" name="txtFoodId" value="${param.txtFoodId}">
                                        <font color="red"> ${requestScope.INVALID.foodIdError}</font>
                                    </div>

                                    <div class="form-group">
                                        <label>Name</label>
                                        <input class="form-control" name="txtName" value="${param.txtName}">
                                        <font color="red"> ${requestScope.INVALID.foodNameError}</font>
                                    </div>
                                    <div class="form-group">
                                        <label>Price</label>
                                        <input class="form-control" name="txtPrice" value="${param.txtPrice}">
                                        <font color="red"> ${requestScope.INVALID.priceError}</font>
                                    </div>
                                    <div class="form-group">
                                        <label>Desciption</label>
                                        <textarea class="form-control" rows="3" name="txtDescription" ></textarea>
                                        <font color="red"> ${requestScope.INVALID.descriptionError}</font>
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
                                    <button type="submit" class="btn btn-primary" name="action" value="InsertFood">Add Food</button>
                                    <button type="reset" class="btn btn-default">Reset Button</button>
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
