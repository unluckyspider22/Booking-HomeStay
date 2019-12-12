<%-- 
    Document   : admin_room_manager
    Created on : Aug 17, 2019, 9:19:55 PM
    Author     : Unlucky Spider
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="admin_sidehead.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                    <li class="active">Room Type Management</li>
                </ol>
            </div>

            <!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" style="text-align: center">Room Type Management</h1>
                </div>
            </div>

            <!--/.row-->
            <form role="search" action="MainController" method="POST">
                <div class="form-group">
                    Search Room Type <input type="text" class="form-control" placeholder="Search" name="txtSearch">
                    <input type="submit" value="SearchRoomType" name="action" />
                </div>
            </form>
            <div class="full-size">
                <div class="col-md-6" style="width: 1250px">
                    <div class="panel panel-default">
                        <div class="panel-heading" style="text-align: center">RoomType List</div>
                        <div class="panel-custom-title" >
                            <a  href="admin_insert_room_type.jsp"><span class="glyphicon glyphicon-pencil"></span> Add More Room Type</a>
                            <c:if test="${requestScope.RESULTSEARCHROOMTYPE != null}">
                                <c:if test="${not empty requestScope.RESULTSEARCHROOMTYPE}" var="checkINFO">
                                    <table data-toggle="table" >
                                        <thead>
                                            <tr>
                                                <th >No</th>
                                                <th >RoomType</th>
                                                <th >Description</th>
                                                <th >Quantity</th>
                                                <th >Capacity</th>
                                                <th >Price</th>
                                                <th >Status</th>
                                                <th >UPDATE</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requestScope.RESULTSEARCHROOMTYPE}" var="dto" varStatus="counter">
                                                <tr>
                                                    <td>${counter.count}</td>
                                                    <td>${dto.roomType}</td>
                                                    <td>${dto.description}</td>
                                                    <td>${dto.quantity}</td>
                                                    <td>${dto.capacity}</td>
                                                    <td>${dto.price}</td>
                                                    <td>
                                                        <c:if test="${dto.status == 1}">Available</c:if>
                                                        <c:if test="${dto.status == 0}">Unavailable</c:if>
                                                    </td>
                                                    <td>
                                                        <c:url var="UpdateLink" value="MainController">
                                                            <c:param name="action" value="EditRoomType"/>
                                                            <c:param name="id" value="${dto.roomType}"/>
                                                            <c:param name="txtSearch" value="${param.txtSearch}"/>
                                                        </c:url>
                                                        <a href="${UpdateLink}">Update</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </c:if>
                                <c:if test="${!checkINFO}">
                                    NO RECORD FOUND
                                </c:if>
                            </c:if>
                        </div>
                    </div>
                </div>
                    <script>
                        $(function () {
                            $('#hover, #striped, #condensed').click(function () {
                                var classes = 'table';

                                if ($('#hover').prop('checked')) {
                                    classes += ' table-hover';
                                }
                                if ($('#condensed').prop('checked')) {
                                    classes += ' table-condensed';
                                }
                                $('#table-style').bootstrapTable('destroy')
                                        .bootstrapTable({
                                            classes: classes,
                                            striped: $('#striped').prop('checked')
                                        });
                            });
                        });

                        function rowStyle(row, index) {
                            var classes = ['active', 'success', 'info', 'warning', 'danger'];

                            if (index % 2 === 0 && index / 2 < classes.length) {
                                return {
                                    classes: classes[index / 2]
                                };
                            }
                            return {};
                        }
                    </script>
                </div>
            </div>
        </div>
    </div><!--/.row-->	
<%@include file="admin_script_table.jsp" %>
</body>
</html>
