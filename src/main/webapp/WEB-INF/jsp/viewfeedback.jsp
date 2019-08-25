<%@page pageEncoding="UTF-8" contentType="text/html; ISO-8859-1" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SNEF - Admin Page</title>

    <!-- Custom fonts for this template -->
    <link href="../../css/all.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="../css/sb-admin-2.css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="../../css/sb-admin-2.css">
    <!-- Custom styles for this page -->
    <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/dataTables.bootstrap4.css">
    <script src="https://kit.fontawesome.com/85cfd1cc6c.js"></script>
    <style>
        * {
            box-sizing: border-box;

        }

        .sidebar-dark .nav-item .nav-link[data-toggle="collapse"]::after {
            color: rgba(255, 255, 255, 0.5);
            opacity: 0;
        }

        .no-active {
            pointer-events: none;
            cursor: default;
            text-decoration: none;
            opacity: 0.8;
        }
    </style>
</head>

<body id="page-top">
<!-- Get Data From API -->
<c:set var="list" value="${requestScope.FEEDBACK}"/>
<c:set var="total" value="${requestScope.NOOFPAGE}"/>
<c:set var="currentPage" value="${requestScope.CURRENTPAGE}"/>
<c:set var="storeId" value="${requestScope.STOREID}"/>

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center"
           href="${pageContext.request.contextPath}/home">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-users-cog"></i>
            </div>
            <div class="sidebar-brand-text mx-3">Admin Management</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Stores -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/home" data-toggle="collapse"
               data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-store-alt"></i>
                <span>Stores</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="${pageContext.request.contextPath}/admin/create">Add Store</a>
                    <a class="collapse-item" href="${pageContext.request.contextPath}/home">Store Data</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Customer Account -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/customer"
               data-target="#collapseUtilities"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-users"></i>
                <span>Customer Account</span>
            </a>
            <div id="collapseUtilities" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="${pageContext.request.contextPath}/admin/customer">Customer Data</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Process New Request-->

        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/request">
                <i class="fas fa-bullhorn"></i>
                <span>Process New Request</span></a>
        </li>

        <!-- Nav Item - Process New Configuration-->
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/config" data-toggle="collapse"
               data-target="#collapseThree"
               aria-expanded="true" aria-controls="collapseThree">
                <i class="fas fa-fw fa-cog"></i>
                <span>Configuration</span>
            </a>
            <div id="collapseThree" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="${pageContext.request.contextPath}/admin/config/create">Add New
                        Configuration</a>
                    <a class="collapse-item" href="${pageContext.request.contextPath}/admin/config">Configuration
                        Data</a>
                </div>
            </div>
        </li>


    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <%-- Search Store Name Here--%>
                <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
                      method="POST" action="${pageContext.request.contextPath}/admin/search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                               aria-label="Search" aria-describedby="basic-addon2" name="name" value="${param.name}">
                        <div class="input-group-append">
                            <input class="btn btn-primary" type="submit" value="Search"/>

                        </div>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->

                    </li>


                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 large">${sessionScope.USERNAME} | Logout</span>

                        </a>


                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Change Status Accounts</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive table-hover">
                            <c:if test="${list != null}">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>No.</th>

                                        <th>Customer Name</th>
                                        <th>Customer Contact</th>
                                        <th>Feed Back</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="rs" items="${list}" varStatus="counter">

                                        <tr>
                                            <td>
                                                    ${counter.count}
                                                <input type="text" value="${rs.storeId}" name="storeId" hidden>
                                            </td>
                                            <td>${rs.username}</td>
                                            <td>${rs.userPhone}</td>
                                            <td>${rs.comment}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <%--Pagination --%>
                                <nav aria-label="Page navigation example ">
                                    <ul class="pagination justify-content-center">
                                        <c:choose>
                                            <c:when test="${(currentPage - 1) < 1 }">
                                                <li class="page-item">
                                                    <a class="page-link no-active"
                                                       href="${pageContext.request.contextPath}/admin/view/page?page=${currentPage-1}&storeId=${storeId}">
                                                        <span class="font-weight-bold">Previous</span>
                                                    </a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="page-item" aria-disabled="false">
                                                    <a class="page-link"
                                                       href="${pageContext.request.contextPath}/admin/view/page?page=${currentPage-1}&storeId=${storeId}">
                                                        <span class="font-weight-bold">Previous</span>
                                                    </a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:forEach var="page" begin="1" end="${total}" step="1">
                                            <li class="page-item">
                                                <c:choose>
                                                    <c:when test="${currentPage eq page}">
                                                        <a class="page-link"
                                                           href="${pageContext.request.contextPath}/admin/view/page?page=${page}&storeId=${storeId}"
                                                           style="color: grey;">
																																		<span class="font-weight-bolder">
                                                                                                                                                ${page}
                                                                                                                                        </span>
                                                        </a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a class="page-link"
                                                           href="${pageContext.request.contextPath}/admin/view/page?page=${page}&storeId=${storeId}">
																																			<span class="font-weight-bolder">
                                                                                                                                                    ${page}
                                                                                                                                            </span>
                                                        </a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </li>

                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${(currentPage + 1) > total}">
                                                <li class="page-item" aria-disabled="true">
                                                    <a class="page-link no-active"
                                                       href="${pageContext.request.contextPath}/admin/view/page?page=${currentPage + 1}&storeId=${storeId}">
                                                        <span class="font-weight-bolder">Next</span>
                                                    </a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="page-item" aria-disabled="false">
                                                    <a class="page-link"
                                                       href="${pageContext.request.contextPath}/admin/view/page?page=${currentPage + 1}&storeId=${storeId}">
                                                        <span class="font-weight-bolder">Next</span>
                                                    </a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </ul>
                                </nav>
                                <%--End Of Pagination--%>
                            </c:if>

                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; SNEF 2019</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>


<!-- Bootstrap core JavaScript-->
<%--<script src="js/jquery.min.js"></script>--%>
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js">
<%--<script src="js/bootstrap.bundle.min.js"></script>--%>
<script src="js/bootstrap.bundle.js"></script>

<!-- Core plugin JavaScript-->
<%--<script src="js/jquery.easing.min.js"></script>--%>
<script src="js/jquery.easing.js"></script>

<!-- Custom scripts for all pages-->
<%--<script src="js/sb-admin-2.min.js"></script>--%>
<script src="js/sb-admin-2.js"></script>

<!-- Page level plugins -->
<%--<script src="js/jquery.dataTables.min.js"></script>--%>
<script src="js/jquery.dataTables.js"></script>
<%--<script src="js/dataTables.bootstrap4.min.js"></script>--%>
<script src="js/dataTables.bootstrap4.js"></script>

<!-- Page level custom scripts -->
<%--<script src="js/datatables-demo.js"></script>--%>

</body>

</html>