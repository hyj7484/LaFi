
<?php
session_start();
/*
include("user.php");
// include("DBphp/DBConect.php");

$day = $_POST['day'];       // 디데이 날짜
$memo = $_POST['memo'];     // 일정이름
$today = date('yy-m-d');    // 오늘날짜


$Dday = floor(( strtotime(substr($day,0,10)) -
              strtotime($today) )/86400);
if($Dday < 0){
  $Dday = '00'; //D-Day 가 -로 넘어 갔을때 00으로 맞춤
}
echo 'D-'.$Dday;
*/
include("DBphp/DBConect.php");


$getDay = $_POST['day'];
$getNum = $_SESSION['id'];
$getMemo = $_POST['memo'];
echo "<script> alert({$getNum}) </script>";
$getQuery = "SELECT usedday FROM dday WHERE getnum = '$getNum'";
$getresult = mysqli_query($conn, $getQuery);
$getDB = mysqli_fetch_array($getresult);

if(1 == $getDB['usedday']){
//UPDATE
  echo "<script> alert('1') </script>";
  $query = "UPDATE dday set date = '$getDay', memo = '$getMemo' where getnum = '$getNum'";
  $getresult = mysqli_query($conn, $getQuery);
  $getDB = mysqli_fetch_array($getresult);
}else{
// INSERT
echo "<script> alert('2') </script>";
  $getQuery = "INSERT INTO dday(getnum, date, memo, usedday)
          VALUES('$getNum', '$getDay', '$getMemo', 1)";
  $getresult = mysqli_query($conn, $getQuery);
  $getDB = mysqli_fetch_array($getresult);
}
echo "<script> location.href='cal.php' </script>";
?>
