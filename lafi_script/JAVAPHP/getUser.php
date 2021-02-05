<?php
include("DBConect.php");

$query = "SELECT usernum, name, numPW FROM user ORDER BY usernum";
$result = mysqli_query($conn, $query);
while($getDB = mysqli_fetch_array($result)){
  print_r($getDB['usernum']);
  echo "/";
  print_r($getDB['name']);
  echo "/";
  print_r($getDB['numPW']);
  echo "/";
}
 ?>
