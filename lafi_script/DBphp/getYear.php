<?php
session_start();
$getYear = $_POST['sendYear'];
$getNum = $_SESSION['Num'];
echo $getYear;
include("DBConect.php");

$query = "SELECT * from memo WHERE date == '$getYear' AND getNum =='$getNum'";
$result = mysqli_query($conn, $query);
//
// while($getDB = mysqli_fetch_array($result)){
//   $count = $count + 1;
//   echo " 시간 : "
//   print_r($getDB[time]);
//   echo " 내용 : ";
//   print_r($getDB[memo]);
// }
 ?>
