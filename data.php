<?php
 // database connection...........
$con = mysqli_connect("localhost", "id19564156_myusername", "@YASnat786@#", "id19564156_myname"); 

if ( mysqli_connect_errno()){
	echo "connection Faield! <br>".mysqli_connect_error();
}else{
	echo "Connection Successful \n";
}

//$_GET['']; Function collect data from URL ............
$name = $_GET['name'];
$phone = $_GET['phone'];
$email = $_GET['email'];
 
// INSERT INTO `user_info` (`id`, `name`, `email`, `phonenumber`) VALUES (NULL, 'rakib', 'sjfdf@fsf.com', '14542154');
$sql = "INSERT INTO user_info(name, phone, email) VALUES ('$name','$phone', '$email' )";
$input_data = mysqli_query($con, $sql);
if ($input_data ) echo "Data Inputed Successfully";
else echo "Data Input Error ";
 
// nexr class 262
// https://earningaide.000webhostapp.com/app/data.php?name=myName&phone=0184546403&email=yasind@gmail.com    //success
// http://localhost/data/data.php?n=MD%20YASIN%20ARAFAT&p=313134&e=yasin@gmail.com

// UPDATE `user_info` SET `name` = 'MD RAKIB' WHERE `user_info`.`id` = 13;
?>
