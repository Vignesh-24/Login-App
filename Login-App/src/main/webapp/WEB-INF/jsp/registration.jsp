
<!DOCTYPE html>
<html>
<head>
	<title>Register</title>
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
			<div class="card-header text-center">
				<h3>Sign Up</h3>
				
			</div>
			<div class="card-body">
				<form method="POST" action="">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user-tag"></i></span>
						</div>
						<input type="text" name='firstname' class="form-control" placeholder="First Name">
					</div>
					
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user-edit"></i></span>
						</div>
						<input type="text" name='lastname' class="form-control" placeholder="Last Name">
					</div>
					
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-mobile"></i></span>
						</div>
						<input type="number" name='mobile' class="form-control" placeholder="Mobile Number">
					</div>
					
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-id-card"></i></span>
						</div>
						<input type="text" name='username' class="form-control" placeholder="User ID">
					</div>
					
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" name='password' class="form-control" placeholder="Password">
					</div>
					
					<div class="form-group">
						<input type="submit" value="Register" class="btn float-right btn-purple">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Already have an account? <a href="/" > &nbsp; SIGN IN </a>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>