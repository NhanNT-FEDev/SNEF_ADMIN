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
		<link href="css/all.css" rel="stylesheet" type="text/css">
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
<%--Get Api From Controller--%>
<c:set var="search" value="${requestScope.SEARCHVALUE}"/>
<c:set var="info" value="${requestScope.STOREDETAIL}"/>
<!-- Page Wrapper -->
<div id="wrapper">

		<!-- Sidebar -->
		<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

				<!-- Sidebar - Brand -->
				<a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
						<div class="sidebar-brand-icon rotate-n-15">
								<i class="fas fa-laugh-wink"></i>
						</div>
						<div class="sidebar-brand-text mx-3">Admin Management</div>
				</a>

				<!-- Divider -->
				<hr class="sidebar-divider my-0">

				<!-- Nav Item - Stores -->
				<li class="nav-item">
						<a class="nav-link collapsed" href="index.html" data-toggle="collapse" data-target="#collapseTwo"
						   aria-expanded="true" aria-controls="collapseTwo">
								<i class="fas fa-fw fa-cog"></i>
								<span>Stores</span>
						</a>
						<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
								<div class="bg-white py-2 collapse-inner rounded">
										<a class="collapse-item" href="addStore.html">Add Store</a>
										<a class="collapse-item" href="addStore.html">Update Store</a>
										<a class="collapse-item" href="index.html">Store Data</a>
								</div>
						</div>
				</li>

				<!-- Nav Item - Customer Account -->
				<li class="nav-item">
						<a class="nav-link collapsed" href="account.html" data-toggle="collapse" data-target="#collapseUtilities"
						   aria-expanded="true" aria-controls="collapseTwo">
								<i class="fas fa-fw fa-cog"></i>
								<span>Customer Account</span>
						</a>
						<div id="collapseUtilities" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
								<div class="bg-white py-2 collapse-inner rounded">
										<a class="collapse-item" href="createUpdateCus.html">Create New Customer</a>
										<a class="collapse-item" href="createUpdateCus.html">Update Customer</a>
										<a class="collapse-item" href="account.html">Customer Data</a>
								</div>
						</div>
				</li>

				<!-- Nav Item - Product-->
				<li class="nav-item">
						<a class="nav-link" href="product.html">
								<i class="fas fa-shopping-cart"></i>
								<span>Products</span></a>
				</li>

				<!-- Sidebar Toggler (Sidebar) -->
				<div class="text-center d-none d-md-inline">
						<button class="rounded-circle border-0" id="sidebarToggle"></button>
				</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

				<!-- Main Content -->
				<div id="content">

						<!-- Topbar -->
						<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow" >

								<!-- Sidebar Toggle (Topbar) -->
								<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
										<i class="fa fa-bars"></i>
								</button>

								<!-- Topbar Search -->
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
												<div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
												     aria-labelledby="searchDropdown">
														<form class="form-inline mr-auto w-100 navbar-search">
																<div class="input-group">
																		<input type="text" class="form-control bg-light border-0 small"
																		       placeholder="Search for..."
																		       aria-label="Search" aria-describedby="basic-addon2">
																		<div class="input-group-append">
																				<button class="btn btn-primary" type="button">
																						<i class="fas fa-search fa-sm"></i>
																				</button>
																		</div>
																</div>
														</form>
												</div>
										</li>

										<!-- Nav Item - Alerts -->
										<li class="nav-item dropdown no-arrow mx-1">
												<a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
												   data-toggle="dropdown"
												   aria-haspopup="true" aria-expanded="false">
														<i class="fas fa-bell fa-fw"></i>
														<!-- Counter - Alerts -->
														<span class="badge badge-danger badge-counter">3+</span>
												</a>
												<!-- Dropdown - Alerts -->
												<div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
												     aria-labelledby="alertsDropdown">
														<h6 class="dropdown-header">
																Alerts Center
														</h6>
														<a class="dropdown-item d-flex align-items-center" href="#">
																<div class="mr-3">
																		<div class="icon-circle bg-primary">
																				<i class="fas fa-file-alt text-white"></i>
																		</div>
																</div>
																<div>
																		<div class="small text-gray-500">December 12, 2019</div>
																		<span class="font-weight-bold">A new monthly report is ready to download!</span>
																</div>
														</a>
														<a class="dropdown-item d-flex align-items-center" href="#">
																<div class="mr-3">
																		<div class="icon-circle bg-success">
																				<i class="fas fa-donate text-white"></i>
																		</div>
																</div>
																<div>
																		<div class="small text-gray-500">December 7, 2019</div>
																		$290.29 has been deposited into your account!
																</div>
														</a>
														<a class="dropdown-item d-flex align-items-center" href="#">
																<div class="mr-3">
																		<div class="icon-circle bg-warning">
																				<i class="fas fa-exclamation-triangle text-white"></i>
																		</div>
																</div>
																<div>
																		<div class="small text-gray-500">December 2, 2019</div>
																		Spending Alert: We've noticed unusually high spending for your account.
																</div>
														</a>
														<a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
												</div>
										</li>


										<div class="topbar-divider d-none d-sm-block"></div>

										<!-- Nav Item - User Information -->
										<li class="nav-item dropdown no-arrow">
												<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
												   data-toggle="dropdown"
												   aria-haspopup="true" aria-expanded="false">
														<span class="mr-2 d-none d-lg-inline text-gray-600 small">Valerie Luna</span>
														<img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
												</a>
												<!-- Dropdown - User Information -->
												<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
												     aria-labelledby="userDropdown">
														<a class="dropdown-item" href="#">
																<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
																Profile
														</a>
														<a class="dropdown-item" href="#">
																<i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
																Settings
														</a>
														<a class="dropdown-item" href="#">
																<i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
																Activity Log
														</a>
														<div class="dropdown-divider"></div>
														<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
																<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
																Logout
														</a>
												</div>
										</li>

								</ul>

						</nav>
						<!-- End of Topbar -->

						<!-- Begin Page Content -->
						<div class="container-fluid">

								<!-- Page Heading -->
								<div class="d-sm-flex align-items-center justify-content-between mb-4">
										<h1 class="h3 mb-0 text-gray-800">Stores Information</h1>

								</div>

								<!--Add Store -->
								<c:if test="${info == null}">
										<form action="/admin/insert" method="POST" enctype="multipart/form-data">
												<h3>Create New Store Account</h3>
												<div class="form-group">
														<label for="txtUsername">Username</label>
														<input type="text" id="txtUsername" class="form-control" placeholder="Enter Store Account"
														       value="" name="txtUsername">
												</div>

												<div class="form-group">
														<label for="txtPassword">Password</label>
														<input type="text" id="txtPassword" class="form-control" placeholder="Enter Account Password"
														       value="" name="txtPassword">
												</div>

												<div class="form-group">
														<label for="txtFirstname">First Name</label>
														<input type="text" id="txtFirstname" class="form-control" placeholder="Enter Account First Name"
														       value="" name="txtFirstname">
												</div>
												<div class="form-group">
														<label for="txtLastName">Last Name</label>
														<input type="text" id="txtLastName" class="form-control" placeholder="Enter Account Last Name"
														       value="" name="txtLastName">
												</div>

												<div class="form-group">
														<label for="txtContact"> Account Contact </label>
														<input type="text" id="txtContact" class="form-control" placeholder="Enter Account Contact"
														       value="" name="txtContact">
												</div>

												<div class="form-group">
														<label for="txtEmail"> Account Email </label>
														<input type="text" id="txtEmail" class="form-control" placeholder="Enter Account Email"
														       value="" name="txtEmail">
												</div>
												<div class="form-group">
														<label for="slGender"></label>
														<select class="mdb-select md-form" id="slGender" name="slGender">
																<option selected>Choose Gender</option>
																<option value="0">Female</option>
																<option value="1">Male</option>
																<option value="2">Other</option>
														</select>
												</div>

												<%-- Insert new Store --%>
												<div class="form-group">
														<label for="txtStoreName">Store Name</label>
														<input type="text" id="txtStoreName" class="form-control" placeholder="Enter Store Name"
														       value="" name="txtStoreName">
												</div>

												<div class="form-group">
														<label for="txtStoreAddress">Store Address</label>
														<input type="text" id="txtStoreAddress" class="form-control" placeholder="Enter Store Name"
														       value="" name="txtStoreAddress">
												</div>

												<div class="form-group">
														<label for="file">Upload Avatar</label>
														<input type="file" class="form-control" id="file" name="file" value="">

												</div>

												<div class="form-group">
														<label for="txtOpenHour">Store Open Hour</label>
														<input type="text" id="txtOpenHour" class="form-control" placeholder="Enter Store Open Hour"
														       value="" name="txtOpenHour">
												</div>

												<div class="form-group">
														<label for="txtCloseHour">Store Close Hour</label>
														<input type="text" id="txtCloseHour" class="form-control" placeholder="Enter Store Close Hour"
														       value="" name="txtCloseHour">
												</div>

												<div class="form-group">
														<label for="txtPhoneStore">Store Phone</label>
														<input type="text" id="txtPhoneStore" class="form-control" placeholder="Enter Store Phone"
														       value="" name="txtPhoneStore">
												</div>

												<input type="submit" class="btn btn-primary" name="Save">
												<input type="reset" name="Reset" class="btn btn-secondary">
										</form>
								</c:if>
								<%-- Update Store--%>
								<c:if test="${info != null}">
										<form action="/admin/save" method="POST" enctype="multipart/form-data">
												<c:forEach var="rs" items="${info}">
														<input type="text" value="${rs.storeId}" name="txtId" hidden/>
														<div class="form-group">
																<label for="txtName">Store Name</label>
																<input type="text" id="txtName" class="form-control" placeholder="Enter Store Name"
																       value="${rs.storeName}" name="txtName">
																<!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
														</div>
														<div class="form-group">
																<label for="txtAddress">Address</label>
																<input type="text" class="form-control" id="txtAddress" placeholder="Address"
																       name="txtAddress" value="${rs.address}">
														</div>
														<div class="form-group">
																<label for="customFile"> Choose Store Image</label>
																<img src="${rs.avatar}" width="100px" height="100px">
																<input type="file" class="form-control" id="customFile" name="file" value="">
																		<%--                        <label class="custom-file-label" for="customFile">Choose file</label>--%>
														</div>


														<div class="form-group">
																<label for="txtOpen">Open Hour</label>
																<input type="text" class="form-control" id="txtOpen" placeholder="Open Hour"
																       value="${rs.openHour}" name="txtOpen">
														</div>

														<div class="form-group">
																<label for="txtClose">Close Hour</label>
																<input type="text" class="form-control" id="txtClose" placeholder="Close Hour"
																       value="${rs.closeHour}" name="txtClose">
														</div>

														<div class="form-group">
																<label for="txtPhone">Store Contact</label>
																<input type="text" class="form-control" id="txtPhone" placeholder="Store Phone"
																       value="${rs.phone}" name="txtPhone">
														</div>


														<div class="form-group">
																<label for="txtAccount">Account Manager</label>
																<input type="text" class="form-control" id="txtAccount" placeholder="Open Hour"
																       value="${rs.storeManager}" name="txtAccount">
														</div>


														<div class="form-group">
																<label>Store Status</label> <br/>
																<input type="checkbox" name="chkStatus" value="${rs.status}"
																<c:if test="${rs.status}">
																       checked="checked"
																</c:if>
																> <span>(Check if Active)</span>
														</div>

														<input type="submit" class="btn btn-primary" value="Save">

												</c:forEach>
										</form>
								</c:if>

								<!-- /.container-fluid -->

						</div>
						<!-- End of Main Content -->

						<!-- Footer -->
						<footer class="sticky-footer bg-white">
								<div class="container my-auto">
										<div class="copyright text-center my-auto">
												<span>Copyright &copy; SNEF 2019 </span>
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

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		     aria-hidden="true">
				<div class="modal-dialog" role="document">
						<div class="modal-content">
								<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
										<button class="close" type="button" data-dismiss="modal" aria-label="Close">
												<span aria-hidden="true">×</span>
										</button>
								</div>
								<div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
								<div class="modal-footer">
										<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
										<a class="btn btn-primary" href="login.html">Logout</a>
								</div>
						</div>
				</div>
		</div>

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