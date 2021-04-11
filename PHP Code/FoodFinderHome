<?php

#Site Header
appIcon();

#adds button for signin, create account, search
SiteFunctions();

function appIcon(){
echo <<<_END
<html><body><a href="FoodFinderHome.php">
<img src="foodfindericon.PNG" alt="icon" width="50" height="50"></a>Food Finder:
_END;
return;
}

function SiteFunctions(){
echo <<<_END
     <html><body><form method='post' action='SignIn.php' enctype="multipart/form-data"><pre>
     <input type="submit" value="Sign In" name="signin"></pre></form>
     <form method='post' action='CreateAccount.php' enctype="multipart/form-data"><pre>
     <input type="submit" value="Create Account" name="createaccount"></pre></form>
     <form method='post' action='Search.php' enctype="multipart/form-data"><pre>
	 <input type="submit" value="Search" name="search"></pre></form>
_END;
return;
}
?>
