
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet">
	
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
				<h3>USER PROFILE</h3>
				
			</div>
			<div class="card-body">
				
					<div class="input-group form-group">
						<p class="h5">First Name : ${user.firstname}</p>
					</div>
					
					<div class="input-group form-group">
						<p class="h5">Last Name : ${user.lastname}</p>
					</div>
					
					<div class="input-group form-group">
						<p class="h5">Mobile Number : ${user.mobile}</p>
					</div>		
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					<a href="/logout" > &nbsp; Logout </a>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>