<?php
session_start();
include("DBConect.php");

$getNPW = $_POST['nowPW'];
$getchPW1 = $_POST['chPW1'];
$getchPW2 = $_POST['chPW2'];
$getNPW_2 = $_POST['nowPW_2'];
$getchPW1_2 = $_POST['chPW1_2'];
$getchPW2_2 = $_POST['chPW2_2'];

$getuserID = $_SESSION['id'];

if($getNPW != null){
  $query = "SELECT * from user where id = '$getuserID'";
  $result = mysqli_query($conn, $query);
  while($getDB = mysqli_fetch_array($result)){
    $userID = $getDB['id'];
    $userPW = $getDB['pw'];
  }
  echo $getNPW." : ".$userPW;
  if($getNPW == $userPW){
    $check = false;

    // 1차 비밀번호 변경
    if($getchPW1 == $getchPW2){
      if($getchPW1 != null){
        $query = "UPDATE user set pw = '$getchPW1' where id = '$userID'";
        $result = mysqli_query($conn, $query);
        if($result){ $ch1 = "PW 변경 완료"; }
        $check = true;
      }
    }else{
      echo '<script>alert("변경할 비밀번호가 일치하지 않습니다.");</script>';
    }
    // 2차 비밀번호 변경
    if($getchPW1_2 == $getchPW2_2){
      if($getchPW1_2 != null){
        $query = "UPDATE user set numPW = '$getchPW1_2' where id = '$userID'";
        $result = mysqli_query($conn, $query);
        if($result){ $ch2 = "2차 PW 변경 완료"; }
        $check = true;
      }
    }else{
      echo '<script>alert("변경할 비밀번호가 일치하지 않습니다.");</script>';
    }
    $prt = $ch1.$ch2;
    if($check){
      echo "<script>alert('$prt');</script>";
      echo '<script>
        window.onload = function(){
              location.href = "/lafi/cal.php";
          }
      </script>';
    }else{
      fail();
    }
  }else{
      // echo "<script>alert('$userPW');</script>";
      echo '<script>alert("비밀번호가 일치하지 않습니다.");</script>';
      fail();
    }
}else{
  echo '<script>alert("비밀번호를 입력해 주세요.");</script>';
  fail();
}

function fail(){
  echo '<script>
    window.onload = function(){
          location.href = "/lafi/update.php";
    }
   </script>';
}
?>
