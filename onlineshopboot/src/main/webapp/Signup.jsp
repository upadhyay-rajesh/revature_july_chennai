
<!DOCTYPE html>
<html lang="en">
<body>
	 <section>
		<div id="agileits-sign-in-page" class="sign-in-wrapper">
			<div class="agileinfo_signin">
			<h3>Sign Up</h3>
				<form action="signup" method="post">
					<input type="text" name="name" placeholder="Your Name" required=""> 
					<input type="email" name="em" placeholder="Your Email" id="email" required onKeyup="validateEmail()"> <div id="emresult"></div>
					 
					<input type="password" name="pass" placeholder="Password" required=""> 
					<input type="text" name="ad" placeholder="Your City">
					
					<input type="submit" value="Sign Up">
				</form>
			</div>
		</div>
	</section>
	</body>
</html>