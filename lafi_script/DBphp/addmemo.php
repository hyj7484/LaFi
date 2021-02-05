<?php
session_start();
include("DBConect.php");
$getDate = $_POST['date'];
$getTime = $_POST['time'].":00";
$getMemo = $_POST['memo'];
$getNum = $_SESSION['Num'];
// echo $getDate;
// echo "<br><br>";
// echo $getTime;
// echo "<br><br>";
// echo $getMemo;
// echo "<br><br>";
// echo $getNum;


$query = "INSERT INTO memo(date, time, memo, getnum)
          VALUES('$getDate', '$getTime', '$getMemo', '$getNum')";

$result = mysqli_query($conn, $query);

if($result == false){
  echo '<script>
        alert("실패");
        window.onload = function(){
          location.href = "/LAFI/addMemo.php";
        }</script>';
}else{
  echo '<script>
        window.onload = function(){
          location.href = "/LAFI/getMemo.php";
        }</script>';
}



 ?>
