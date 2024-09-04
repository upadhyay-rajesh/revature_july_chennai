
<!DOCTYPE html>
<html lang="en">
<body>
	 <section>
		<div id="agileits-sign-in-page" class="sign-in-wrapper">
			<div class="agileinfo_signin">
			<h3>Sign In</h3>
				<form action="login" method="post">
					
					<input type="email" name="em" placeholder="Your Email" id="email" required onKeyup="validateEmail()"> <div id="emresult"></div>
					 
					<input type="password" name="pass" placeholder="Password" required=""> 
					
					
					<input type="submit" value="Sign In">
				</form>
			</div>
		</div>
	</section>
	</body>
</html>