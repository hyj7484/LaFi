<?php
include("DBConect.php");

$getUser = $_GET['Num'];
$getToday = $_GET['Today'];

$query = "SELECT time, memo FROM memo WHERE date = $getToday AND getnum = $getUser order by time desc";
$result = mysqli_query($conn, $query);
$count = 0;
while($getDB = mysqli_fetch_array($result)){
  $count++;
  echo  $count.". ";
  print_r(substr($getDB['time'],0,5));
  echo "/";
  print_r($getDB['memo']);
  echo "/";
}
 ?>
