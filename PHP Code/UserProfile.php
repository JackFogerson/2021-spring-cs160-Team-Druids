<?php

#connect to MySQL
require_once 'login.php';

session_start();
	
#Site Header
websiteHeader();

	
#logs out user if button pressed
if (isset($_POST["logout"])){
	destroy_session_and_data();	
}

#adds sign in function
if (isset($_SESSION['username'])){
	#add the session variables
	$user = $_SESSION['username'];
	$pass = $_SESSION['password'];
	$id = $_SESSION['id'];

	echo "Hello " . $user ."! ";
	echo nl2br ("\nSearch Preferences:\n");


	$query = "SELECT * FROM users WHERE (username='$user') AND (password='$pass')";
	$result = $conn->query($query);
	if (!$result)die("Search Error");
	$rows = $result->num_rows;
	for ($j = 0 ; $j < $rows ; ++$j){
		$result->data_seek($j);
		$row = $result->fetch_array(MYSQLI_NUM);
		echo <<<_END
	<pre>
	Search within $row[5]
	Price Range: $$row[6] to $$row[7]
	Favorite Cuisine: $row[8]
	</pre>
_END;
	}
	
	getFriends($id, $conn);
	
	logoutbtn();
}
else{
	echo "Please <a href='SignIn.php'>click here</a> to sign in. ";
}

#logs out of session
function destroy_session_and_data() {
	$_SESSION = array();
	setcookie(session_name(), '', time() - 2592000, '/');
	session_destroy();
}

function getFriends($id, $conn){
	$query = "SELECT users.username FROM friendships, users WHERE friendships.user_id=$id AND friendships.follower_id = users.id";
	$result = $conn->query($query);
	if (!$result)die("Search Error");
	$rows = $result->num_rows;
	for ($j = 0 ; $j < $rows ; ++$j){
		$result->data_seek($j);
		$row = $result->fetch_array(MYSQLI_NUM);
		echo <<<_END
	<pre>
	Friends: $row[0]
	</pre>
_END;
	}
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

function logoutbtn(){
  echo <<<_END
    <html><body>
    <form method='post' action='UserProfile.php' enctype="multipart/form-data"><pre>
    <input type="submit" id="logout" name="logout" value="Logout">
    </pre></form>
_END;
return;
}
?>