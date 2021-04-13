<?php

#connect to MySQL
require_once 'login.php';
	
session_start();

#Site Header
websiteHeader();
echo nl2br ("\nSearch for Friends:\n");

if (isset($_POST["search"])){
	echo nl2br ("\nSearch Results:\n");
	
	$search = sanatizeName($conn, 'search');
	
	$query = "SELECT username FROM users WHERE username = '$search'";
	$result = $conn->query($query);
	if (!$result)die("Search Error");
	$rows = $result->num_rows;
		$result->data_seek(0);
		$row = $result->fetch_array(MYSQLI_NUM);
		echo <<<_END
	<pre>
	$row[0]
	</pre>
_END;
}


#adds sign in function
else if (isset($_SESSION['username'])){
	#add the session variables
	$user = $_SESSION['username'];
	$id = $_SESSION['id'];
	
	getFriends($id, $conn);
	
	searchFriends();

}
else{
	echo "Please <a href='SignIn.php'>click here</a> to sign in and access friends. ";
}

function sanatizeName($conn, $var){ 
  return $conn->real_escape_string($_POST[$var]);
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
	 <form method='post' action='Friends.php' enctype="multipart/form-data"><pre>
     <input type="submit" value="Find Friends" name="friendsearch"></pre></form>
	 <a href="SignIn.php">
	 <img src="nouserpic.PNG" alt="icon" width="50" height="50"></a>
_END;
return;
}

function searchFriends(){
echo <<<_END
     <html><body><form method='post' action='Friends.php' enctype="multipart/form-data"><pre>
     Search by Username: <input type="text" name="search">
	 <input type="submit" value="Search"></pre></form>
_END;
return;
}

?>

