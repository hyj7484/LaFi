<?php
include("user.php");
include("DBphp/DBConect.php");
if($_POST['sendYear'] != ''){
  unset($_SESSION['today']);
  $_SESSION['today'] = $_POST['sendYear'];
}
$getYear = $_SESSION['today'];
$getNum = $_SESSION['Num'];
?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device=width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0, minimum-scale=1.0">

    <title> getMemo </title>
    <link rel="stylesheet" href="css/getMemo.css">
  </head>
  <body>


<div class="center">
    <button type="button" name="button" onclick="addMemo()"> + </button>
    <br><br>
    <?php
    // echo str_replace("-","월",substr($_SESSION['today'],5,10))."일";
    $date1 = date_create($_SESSION['today']);
    echo date_format($date1, "Y")."년 ".date_format($date1, "m")."월 ".date_format($date1,"d")."일";
    $query = "SELECT * from memo WHERE date = '$getYear' AND getNum = '$getNum'";
    $result = mysqli_query($conn, $query);
    echo "<br>";
    while($getDB = mysqli_fetch_array($result)){
      ?>

<form class="" action=".html" method="post">
      <?php
      $getTime = $getDB[time];
      $getMemo = $getDB[memo];
      echo " 시간 : '$getTime'";
      echo " 내용 : '$getMemo'";
      $memonum = $getDB[memonum];
      ?>
        <button type="button" name="button" onclick="delMemo(<?php echo $memonum ?>)"> X </button>
        <br>
    </form>

      <?php
    }

    ?>
    <br><br>
    <button type="button" name="button" onclick="location.href='cal.php'"> 뒤로가기 </button>


    <script type="text/javascript">

    function addMemo(){
      location.href = "addMemo.php";
    }
      function delMemo(e){

        var form = document.createElement("form");
        form.setAttribute("charset", "UTF-8");
        form.setAttribute("method", "Post"); // Get 또는 Post 입력
        form.setAttribute("action", "DBphp/delMemo.php");

        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "memonum");
        hiddenField.setAttribute("value", e);
        form.appendChild(hiddenField);

        document.body.appendChild(form);
        form.submit();
      }
      </script>


</div>
  </body>
</html>
