<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Dashboard</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
    <c:if test="${sessionScope.ROLE ne 'admin'}"><jsp:forward page="login.jsp"/></c:if>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Admin</span>Page</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> <c:if test="${sessionScope.USERNAMEADMIN != null}">${sessionScope.USERNAMEADMIN}</c:if> <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
							<li><a href="LogoutController"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<ul class="nav menu">
			<li><a href="admin_search_account.jsp"><span class="glyphicon glyphicon-list-alt"></span> Account Management</a></li>
			<li><a href="admin_insert_account.jsp"><span class="glyphicon glyphicon-pencil"></span> Add Account</a></li>
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> Food/Drink/Service/Room <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="admin_food_manager.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> Food
						</a>
					</li>
					<li>
						<a class="" href="admin_drink_manager.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> Drink
						</a>
					</li>
					<li>
						<a class="" href="admin_service_manager.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> Service
						</a>
					</li>
                                        <li>
						<a class="" href="admin_room_manager.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> Room
						</a>
					</li>
					<li>
						<a class="" href="admin_room_type_manager.jsp">
							<span class="glyphicon glyphicon-share-alt"></span> RoomType
						</a>
					</li>
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
		</ul>
	</div><!--/.sidebar-->
        