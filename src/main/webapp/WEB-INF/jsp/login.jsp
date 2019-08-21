<%@page pageEncoding="UTF-8" contentType="text/html; ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
		<title>Login V1</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--===============================================================================================-->
		<link rel="icon" type="image/png" href="../../image/img-01.png"/>
		<!--===============================================================================================-->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.css">
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.css">
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/hamburgers/1.1.3/hamburgers.min.css">
		<!--===============================================================================================-->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.8/css/select2.min.css" rel="stylesheet" />

		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="../../css/util.css">
		<link rel="stylesheet" type="text/css" href="../../css/main.css">
		<!--===============================================================================================-->
</head>
<body>

<div class="limiter">
		<div class="container-login100">
				<div class="wrap-login100">
						<div class="login100-pic js-tilt" data-tilt>
								<img src="https://res.cloudinary.com/dr4hpc9gi/image/upload/v1565864524/img-01.png" alt="IMG">
						</div>
						<form class="login100-form validate-form" action="/login/check" method="POST">
							<span class="login100-form-title">
								Admin Management
							</span>

										<div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
												<input class="input100" type="text" name="txtName" placeholder="Name">
												<span class="focus-input100"></span>
												<span class="symbol-input100">
									<i class="fa fa-envelope" aria-hidden="true"></i>
								</span>
										</div>

										<div class="wrap-input100 validate-input" data-validate="Password is required">
												<input class="input100" type="password" name="txtPass" placeholder="Password">
												<span class="focus-input100"></span>
												<span class="symbol-input100">
									<i class="fa fa-lock" aria-hidden="true"></i>
								</span>
										</div>

										<div class="container-login100-form-btn">
												<input type="submit" class="login100-form-btn" value="Login"/>
										</div>

						</form>
				</div>
		</div>
</div>


<!--===============================================================================================-->
<script src="../../js/jquery.js"></script>
<!--===============================================================================================-->
<script src="../../js/bootstrap.js"></script>
<!--===============================================================================================-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.8/js/select2.min.js"></script>
<!--===============================================================================================-->
<script>
    $('.js-tilt').tilt({
        scale: 1.1
    })
</script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>