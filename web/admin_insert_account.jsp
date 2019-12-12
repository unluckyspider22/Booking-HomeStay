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
        <title>Insert Account Page</title>
    </head>
    <body>
        <%@include file="admin_sidehead.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                    <li class="active">Add Account</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Add Account</h1>
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
                                        <label>Username</label>
                                        <input class="form-control" name="txtUsername" value="${param.txtUsername}">
                                        <font color="red"> ${requestScope.INVALID.usernameError}</font>
                                    </div>

                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" class="form-control" name="txtPassword">
                                        <font color="red"> ${requestScope.INVALID.passwordError}</font>
                                    </div>
                                    <div class="form-group">
                                        <label>Fullname</label>
                                        <input class="form-control" name="txtFullname" value="${param.txtFullname}">
                                        <font color="red"> ${requestScope.INVALID.fullnameError}</font>
                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input class="form-control" name="txtEmail" value="${param.txtEmail}">
                                        <font color="red"> ${requestScope.INVALID.emailError}</font>
                                    </div>
                                    <div class="form-group">
                                        <label>Phone</label>
                                        <input class="form-control" name="txtPhone" value="${param.txtPhone}">
                                        <font color="red"> ${requestScope.INVALID.phoneError}</font>
                                    </div>
                                    <div class="form-group">
                                        <label>IDNumber</label>
                                        <input class="form-control" name="txtIdnumber" value="${param.txtIdnumber}">
                                        <font color="red"> ${requestScope.INVALID.idNumberError}</font>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>Gender</label>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="rdGender" id="optionsRadios1" value="0" checked>Male
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="rdGender" id="optionsRadios2" value="1">Female
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Nationality</label>
                                            <br>
                                            <select class="form-control" name="nationality">
                                                <option value="None" selected="">None</option>
                                                <option value="France">France</option>
                                                <option value="Denmark">Denmark</option>
                                                <option value="Switzerland">Switzerland</option>
                                                <option value="Spain">Spain</option>
                                                <option value="India">India</option>
                                                <option value="Arab">Arab</option>
                                                <option value="Vietnam">VietNam</option>
                                                <option value="Thailand">Thailand</option>
                                                <option value="Singapore">Singapore</option>
                                                <option value="Malaysia">Malaysia</option>
                                                <option value="Korea">Korea</option>
                                                <option value="Japan">Japan</option>
                                                <option value="US">US</option>
                                                <option value="UK">UK</option>
                                                <option value="Portugal">Portugal</option>
                                                <option value="Argentina">Argentina</option>
                                                <option value="Germany">Germany</option>
                                                <option value="Belgium">Belgium</option>
                                                <option value="Gabon">Gabon</option>
                                                <option value="Uruguay">Uruguay</option>
                                            </select>
                                            <font color="red"> ${requestScope.INVALID.nationalityError}</font>
                                        </div>
                                        <div class="form-group">
                                            <label>Day of Birth</label>
                                            <br>
                                            <input type="date" name="selectDate" > <br>
                                            <font color="red"> ${requestScope.INVALID.dobError}</font>
                                        </div>
                                        <div class="form-group">
                                            <label>Role</label>
                                            <select class="form-control" name="role">
                                                <option value="None">None</option>
                                                <option value="admin">Admin</option>
                                                <option value="staff">Staff</option>
                                                <option value="customer">Customer</option>
                                            </select>
                                            <font color="red"> ${requestScope.INVALID.roleError}</font>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary" name="action" value="Insert">Insert</button>
                                    <button type="reset" class="btn btn-default">Reset</button>
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
