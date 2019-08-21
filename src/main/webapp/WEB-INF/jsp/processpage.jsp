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
		<link rel="stylesheet" href="../../css/sb-admin-2.css">
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
		<link rel="stylesheet" href="css/sb-admin-2.css">
		<!-- Custom styles for this page -->
		<link href="css/dataTables.bootstrap4.min.css" rel="stylesheet">
		<link rel="stylesheet" href="css/dataTables.bootstrap4.css">
		<script src="https://kit.fontawesome.com/85cfd1cc6c.js"></script>
</head>

<body id="page-top">
<!-- Get Data From API -->
<c:set var="list" value="${requestScope.REQUEST}"/>

<!-- Page Wrapper -->
<div id="wrapper">

		<!-- Sidebar -->
		<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

				<!-- Sidebar - Brand -->
				<a class="sidebar-brand d-flex align-items-center justify-content-center"
				   href="${pageContext.request.contextPath}/home">
						<div class="sidebar-brand-icon rotate-n-15">
								<i class="fas fa-laugh-wink"></i>
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
								<i class="fas fa-fw fa-cog"></i>
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
								<i class="fas fa-fw fa-cog"></i>
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
								<i class="fas fa-fw fa-cog"></i>
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
												<h6 class="m-0 font-weight-bold text-primary">Data Process New Request</h6>
										</div>
										<div class="card-body">
												<div class="table-responsive">
														<c:if test="${list != null}">
																<table class="table table-hover" id="dataTable" width="100%" cellspacing="0">
																		<thead class="thead-dark">
																		<tr>
																				<th>No.</th>
																				<th>Store Name</th>
																				<th>Product Name</th>
																				<th>Status</th>
																				<th>Product Image</th>
																				<th><label>If reject tell the reason</label></th>
																				<th></th>
																		</tr>
																		</thead>
																		<tbody>
																		<c:forEach var="rs" items="${list}" varStatus="count">
																				<tr>
																						<form action="${pageContext.request.contextPath}/admin/request/handle"
																						      method="POST">
																								<td>${count.count}
																										<input type="text" value="${rs.nPRId}" name="txtId" hidden>
																								</td>
																								<td>${rs.storeName}</td>
																								<td>
																												${rs.productName}
																														<input type="text" value="${rs.productId}" name="txtProId" hidden>
																								</td>
																								<td>
																										<div class="form-group">
																												<div class="checkbox-inline">
																														<label>
																																<input type="checkbox" value="${rs.status}"
																																       id="chkStatus" name=""
																																<c:if test="${rs.status}">
																																       checked="checked"
																																</c:if>
																																>
																																(Check if Active)
																														</label>
																														<label class="radio-inline">
																																<input type="radio" name="chkStatus" id="true"
																																       value="true" style="opacity: 0 "
																																<c:if test="${rs.status}">
																																       checked="checked"
																																</c:if>>
																														</label>
																														<label class="radio-inline">
																																<input type="radio" name="chkStatus" id="false"
																																       value="false" style="opacity: 0 "
																																<c:if test="${not rs.status}">
																																       checked="checked"
																																</c:if>
																														</label>
																												</div>
																										</div>
																								</td>
																								<td>
																										<img src="${rs.imageProduct}" alt="" width="100px" height="100px">
																								</td>
																								<td>
																										<textarea class="form-control" rows="5" cols="15" name="txtDes"
																										          style="width: 300px" id="comment"></textarea>
																								</td>

																								<td>
																										<input type="submit" class="btn btn-primary" value="Change Status">
																								</td>
																						</form>
																				</tr>
																		</c:forEach>
																		</tbody>
																</table>
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

<script type="text/javascript">
    $(document).ready(function () {
        $('#chkStatus').click(function () {
            if ($(this).prop("checked") == true) {
                $("#true").prop("checked", true);
            } else if ($(this).prop("checked") == false) {
                $("#false").prop("checked", true);
            }
        });
    });
</script>
<script>
    $(document).ready(function () {
        $("input.submit").click(function (event) {
            event.preventDefault();
            var comment = $.trim($('#comment').val());
            if ($('#chkStatus').prop("checked") == false && comment == '') {
                $('#comment').focusin;
                alert('Nhập Lý do Từ chối');
            }
        });
    });
</script>
<!-- Page level custom scripts -->
<%--<script src="js/datatables-demo.js"></script>--%>

</body>

</html>