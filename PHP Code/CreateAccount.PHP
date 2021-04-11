<?php

#connect to MySQL
require_once 'login.php';
	
#Site Header
websiteHeader();

#Start Session
ini_set('session.gc_maxlifetime', 60 * 60 * 24);
session_start();

#adds sign in function
echo nl2br ("\nCreate Account");
create();

#enter input into database
if (isset($_POST["username"]) && isset($_POST['pw']) && isset($_POST['email'])){ 

	#destroy previous session
	$_SESSION = array();
	setcookie(session_name(), '', time() - 2592000, '/');
	session_destroy();

    #sanatize values 
	$username = sanatizeName($conn, 'username');
	$pw = sanatizeName($conn, 'pw');
	$email = sanatizeName($conn, 'email');
	
	if (isset($_POST["name"])){
		$name = sanatizeName($conn, 'name');
	}
	
	if (isset($_POST["loc"])){
		$loc = sanatizeName($conn, 'loc');
	}
	
	if (isset($_POST["low"])){
		$low = sanatizeName($conn, 'low');
	}
	
	if (isset($_POST["high"])){
		$high = sanatizeName($conn, 'high');
	}
	
	if (isset($_POST["fav"])){
		$fav = sanatizeName($conn, 'fav');
	}
	
	if (isset($_FILES['pic'])){
		$pic = sanatizeFile($conn, 'pic');
	}
	
	
	if($low > $high){
		$temp = $low;
		$low = $high;
		$high = $temp;
	}
	
	#search if username already taken
	$query = ("SELECT * FROM users WHERE username = '$username'");
	$result = $conn->query($query);
	if (!$result)die("Error");
	$rows = $result->num_rows;
		
	#if user already exists
	if($rows > 0) {
		die("username not avaliable");
	}
	
	#else create user
	else{
		$query = "INSERT INTO users(`username`, `name`, `email`, `password`, `location`, `budgetlow`, `budgethigh`, `favorite_cuisine`, `pic`) VALUES('$username', '$name', '$email', '$pw', '$loc', '$low', '$high', '$fav', '$pic')";
		$result = $conn->query($query);
		if (!$result) die("error");
		else{
			#signs user in, starts session
			session_start();
			$_SESSION['username'] = $username;
			$_SESSION['password'] = $pw;
			echo "Please <a href='UserProfile.php'>click here</a> to log in.";
		}
	}
}

else{
	echo "Enter a username, password, and email.";
}


function sanatizeName($conn, $var){ 
  return $conn->real_escape_string($_POST[$var]);
}

#makes sure file is safe
function sanatizeFile($name){ 
  return htmlentities($name);
}

function websiteHeader(){
echo <<<_END
     <html><body><a href="FoodFinderHome.php">
	 <img src="foodfindericon.PNG" alt="icon" width="50" height="50"></a>
	 <form method='post' action='FoodFinderHome.php' enctype="multipart/form-data"><pre>
     <input type="submit" value="Home" name="home"></pre></form>
	 <form method='post' action='Search.php' enctype="multipart/form-data"><pre>
     <input type="submit" value="Search" name="search"></pre></form>
	 <form method='post' action='FriendSearch.php' enctype="multipart/form-data"><pre>
     <input type="submit" value="Find Friends" name="friendsearch"></pre></form>
	 <a href="SignIn.php">
	 <img src="nouserpic.PNG" alt="icon" width="50" height="50"></a>
_END;
return;
}

function create(){
echo <<<_END
     <html><body><form method='post' action='CreateAccount.php' enctype="multipart/form-data"><pre>
     Username: <input type="text" name="username">
	 Name: <input type="text" name="name">
	 Email: <input type="email" name="email">
	 Password: <input type="password" name="pw">
	 City: <input type="text" name="loc">
	 Low End of Budget: <input type="number" name="low" min="1" max="1000">
	 High End of Budget: <input type="number" name="high" min="1" max="1000">
	 Favorite Cuisine: <input type="text" name="fav">
	 Upload Profile Picture:<input type="file" name="pic" id="pic">
	 <input type="submit" value="Create Account"></pre></form>
_END;
return;
}
?>
