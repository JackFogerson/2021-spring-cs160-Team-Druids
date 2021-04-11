<?php
	
#Site Header
websiteHeader();

#asks for email
echo nl2br ("\nForgot Username/Password\n");
echo nl2br ("Enter your email address to reset your username or password");
forgot();

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

function forgot(){
echo <<<_END
     <html><body><form method='post' action='EmailSent.php' enctype="multipart/form-data"><pre>
     Email: <input type="text" name="email">
	 <input type="submit" value="Reset Username" name="username">
     <input type="submit" value="Reset Password" name="password"></pre></form>
_END;
return;
}
?>
