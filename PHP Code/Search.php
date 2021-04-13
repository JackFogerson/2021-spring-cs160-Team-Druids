<?php

#connect to MySQL
require_once 'login.php';
	
session_start();

#Site Header
websiteHeader();
echo nl2br ("\nSearch for Restaurants:\n");

if (isset($_POST["city"])){
	echo nl2br ("\nSearch Results:\n");
	
	$city = sanatizeName($conn, 'city');
	
	$query = "SELECT * FROM restaurants WHERE city = '$city'";
	$result = $conn->query($query);
	if (!$result)die("Search Error");
	$rows = $result->num_rows;
	for ($j = 0 ; $j < $rows ; ++$j){
		$result->data_seek($j);
		$row = $result->fetch_array(MYSQLI_NUM);
		echo <<<_END
	<pre>
	Name: $row[1]
	City: $row[3]
	Cuisine: $row[5]
	Budget: $row[6]
	</pre>
_END;
}
}


else{
	searchRestaurants();
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

function searchRestaurants(){
echo <<<_END
     <html><body><form method='post' action='Search.php' enctype="multipart/form-data"><pre>
     Restaurant Name: <input type="text" name="name">
	 City: <input type="text" name="city">
	 Cuisine: <input type="text" name="cuisine">
	 Budget Low: <input type="text" name="blow">
     Budget High: <input type="text" name="bhigh">
	 <input type="submit" value="Search"></pre></form>
_END;
return;
}

?>

