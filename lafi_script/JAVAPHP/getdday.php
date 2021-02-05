<?php
include("DBConect.php");

$getUser = $_GET['Num'];

$query = "SELECT datediff(date, curdate()) as date, memo FROM dday WHERE getnum = $getUser";
$result = mysqli_query($conn, $query);
while($getDB = mysqli_fetch_array($result)){
  print_r($getDB['date']);
  echo "/";
  print_r($getDB['memo']);
  echo "/";
}
?>
