<?php
session_start();
include("DBConect.php");

$ID = $_POST['getID'];
$PW = $_POST['getPW'];

$query = "SELECT * FROM user WHERE id = '$ID'";
$reqult = mysqli_query($conn, $query);
$getDB = mysqli_fetch_array($reqult);

if($ID == $getDB['id'] && $ID != ''){
  if($PW == $getDB['pw']){
    $_SESSION['id'] = $getDB['id'];
    $_SESSION['name'] = $getDB['name'];
    $_SESSION['year'] = $getDB['year'];
    $_SESSION['Num'] = $getDB['userNum'];
    echo '<script>alert("로그인 성공");</script>';
    echo '<script>
          window.onload = function(){
            location.href = "/LAFI/cal.php";
          }</script>';
  }else{
    echo '<script>alert("비밀번호가 틀렸습니다.");</script>';
    echo '<script>
      window.onload = function(){
            location.href = "/LAFI/Main.php";
      }
     </script>';
  }

}else{
  echo '<script>alert("아이디가 존재하지 않습니다.");</script>';
  echo '<script>
    window.onload = function(){
          location.href = "/lafi/Main.php";
    }
   </script>';
}

 ?>
