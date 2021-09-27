
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Two factor Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
</head>
<style>
	
	html,body{
		background: linear-gradient(to right, #0f0c29, #302b63, #24243e);
		background-size: cover;
		background-repeat: no-repeat;
		height: 100%;
		font-family: 'Josefin Sans', sans-serif;
		}
	.card{
	margin-top: auto;
	margin-bottom: auto;
	width: 400px;
	/*background-image: linear-gradient(to right, #0F2027,#203A43,#2C5364)*/
	
	}
	.container{
		height: 100%;
		align-content: center;
		}
	
</style>
<body class="text-white  blue-grey lighten-5">
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card unique-color-dark">
						<c:if test="${msg != null}">
				<div class="alert alert-danger alert-dismissible fade show text-center" role="alert">
						${msg} 
			  		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    				<span aria-hidden="true">&times;</span>
  					</button>
	  			</div>
	
			</c:if>
			<div class="card-header text-center">
				<h3>Two Factor Authentication</h3>
				
			</div>
			<div class="card-body">
				<form method="POST" action="/submitOTP">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="text" name='totp' class="form-control" placeholder="Enter One Time Passcode">
						
					</div>
					<div class="form-group">
						<input type="submit" value="Submit OTP" class="btn float-right btn-purple">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Open Google Authenticator to find OTP !
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>