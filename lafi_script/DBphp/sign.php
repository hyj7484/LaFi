<?php
  include("DBConect.php");

$ID = $_POST['setID'];
$PW1 = $_POST['setPW1'];
$PW2 = $_POST['setPW2'];
$NumPW = $_POST['setNumPW'];
$Name = $_POST['setName'];
$Birth = $_POST['setBirth'];

$getQuery = "SELECT id FROM user WHERE id = '$ID'";
$getresult = mysqli_query($conn, $getQuery);
$getDB = mysqli_fetch_array($getresult);

  if($ID == $getDB['id']){
    echo '<script>alert("동일한 아이디가 있습니다.");</script>';
    echo '<script>
      window.onload = function(){
            location.href = "/lafi/sign.php";
      }
     </script>';
  }else{
    if($PW1 == $PW2){
      $Query = "INSERT INTO user(id, pw, NumPW, name, year)
                VALUES('$ID', '$PW1','$NumPW', '$Name', '$Birth')";
      $result = mysqli_query($conn, $Query);
      if($result == false){
        echo '<script>alert("등록이 실패했습니다.");</script>';
        echo '<script>
          window.onload = function(){
              location.href = "/lafi/sign.php";
            }
            </script>';
        }else{
          echo '<script>alert("등록이 완료되었습니다.");</script>';
          echo '<script>
          window.onload = function(){
            location.href = "/lafi/Main.php";
          }
          </script>';

    }
  }else{
    echo '<script>alert("비밀번호가 일치하지 않습니다.");</script>';
    echo '<script>
      window.onload = function(){
          location.href = "/lafi/sign.php";
        }
        </script>';
  }
  }

  ?>
