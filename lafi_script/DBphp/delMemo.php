<?php
include("DBConect.php");
$memonum = $_POST['memonum'];

echo $memonum;



$query = "DELETE FROM memo WHERE memonum = '$memonum'";
$result = mysqli_query($conn, $query);

echo '<script>
      window.onload = function(){
        location.href = "/LAFI/getMemo.php";
      }</script>';


 ?>
