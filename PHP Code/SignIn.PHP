<?php

#connect to MySQL
require_once 'login.php';

	
#Site Header
websiteHeader();

#set max session time to 1 day, start session
ini_set('session.gc_maxlifetime', 60 * 60 * 24);
session_start();

#if user is logged in
if (isset($_SESSION['username'])){
	#add the session variables
	$user = $_SESSION['username'];
	$pass = $_SESSION['password'];
	$id = $_SESSION['id'];

	echo "Hello " . $user ."! ";
	
	echo "Please <a href='UserProfile.php'>click here</a> to log in.";
}

else {
#adds sign in function
echo nl2br ("\nSign In");
signIn();

#enter input into database
if (isset($_POST["name"]) && isset($_POST['pw'])){ 

    #sanatize values 
	$name = sanatizeName($conn, 'name');
	$pw = sanatizeName($conn, 'pw');


	$query = "SELECT id FROM users WHERE (username='$name' OR email='$name') AND password='$pw'";
	$result = $conn->query($query);
	if (!$result) die ("Not a correct login");
	$rows = $result->num_rows;
	$result->data_seek(0);
	$row = $result->fetch_array(MYSQLI_NUM);
	$id = $row[0];
	if($rows > 0) {
		$_SESSION['username'] = $name;
		$_SESSION['password'] = $pw;
		$_SESSION['id'] = $id;

		
		echo "Hello " . $name ."! ";
		echo "Please <a href='UserProfile.php'>click here</a> to log in.";
	}
	else{
		echo "incorrect login";
	}
}
}


function sanatizeName($conn, $var){ 
  return $conn->real_escape_string($_POST[$var]);
}

function websiteHeader(){
echo <<<_END
     <html><body><a href="FoodFinderHome.php">
	 <img src="foodfindericon.PNG" alt="icon" width="50" height="50"></a>
	 <form method='post' action='FoodFinderHome.php' enctype="multipart/form-data"><pre>
     <input type="submit" value="Home" name="home"></pre></form>
	 <form method='post' action='Search.php' enctype="multipart/form-data"><pre>
     <input type="submit" value="Search" name="search"></pre></form>
	 <form method='post' action='Friends.php' enctype="multipart/form-data"><pre>
     <input type="submit" value="Find Friends" name="friendsearch"></pre></form>
	 <a href="SignIn.php">
	 <img src="nouserpic.PNG" alt="icon" width="50" height="50"></a>
_END;
return;
}

function signIn(){
echo <<<_END
     <html><body><form method='post' action='SignIn.php' enctype="multipart/form-data"><pre>
     Username or Email: <input type="text" name="name">
	 Password: <input type="password" name="pw">
     <input type="checkbox" id="stayin" name="stayin" value="stayin">
     <label for="stayin"> Stay Signed In</label>
	 <input type="submit" value="Sign In"></pre></form>
	 <form method='post' action='Forgot.php' enctype="multipart/form-data"><pre>
     <input type="submit" value="Forgot Username or Password" name="forgot"></pre></form>
	 <form method='post' action='CreateAccount.php' enctype="multipart/form-data"><pre>
     <input type="submit" value="Create New User" name="createaccount"></pre></form>
_END;
return;
}
?>
