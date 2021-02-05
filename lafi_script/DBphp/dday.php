<?php
include("DBConect.php");
session_start();

$getDay = $_POST['day'];
$getMemo = $_POST['memo'];
$getNum = $_SESSION['Num'];

$Query = "SELECT usedday FROM dday WHERE getnum = '$getNum'";
$result = mysqli_query($conn, $Query);
$getDB = mysqli_fetch_array($result);
// echo $getDay;
if(1 == $getDB['usedday']){
//UPDATE
  $query_update = "UPDATE dday set date='$getDay', memo='$getMemo' where getnum = '$getNum'";
  $result = mysqli_query($conn, $query_update);
  // $getDB = mysqli_fetch_array($result);
  if($result){echo "???";}else{ echo "?!?!?!?!?";}
}else{
// INSERT
  $query_insert = "INSERT INTO dday(getnum, date, memo, usedday)
          VALUES('$getNum', '$getDay', '$getMemo', 1)";
  $result = mysqli_query($conn, $query_insert);
  // $getDB = mysqli_fetch_array($getresult);
}

echo '<script>
  window.onload = function(){
        location.href = "/lafi/cal.php";
  }
 </script>';
?>
