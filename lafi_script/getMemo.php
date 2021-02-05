<div class="userInfo">
<?php
session_start();
include_once("user.php");
include_once("DBphp/DBConect.php");
if($_POST['sendYear'] != ''){
  unset($_SESSION['today']);
  $_SESSION['today'] = $_POST['sendYear'];
}
$getYear = $_SESSION['today'];
$getNum = $_SESSION['Num'];
?>
</div>
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


<div id="background">
  <div>
  <button id = "add" name="button" onclick="location.href='addMemo.php'"> 일정 추가</button>

  </div>
    <br><br>
    <div class="date">
    <?php
    $date1 = date_create($getYear);
    echo date_format($date1, "Y")."년 ".date_format($date1, "m")."월 ".date_format($date1,"d")."일";

    $query = "SELECT * from memo WHERE date = '$getYear' AND getNum = '$getNum' order by time" ;
    $result = mysqli_query($conn, $query);
    echo "<br><br><br>";
// 일정 출력
    while($getDB = mysqli_fetch_array($result)){
      ?>
      <div class="MemoList">
      <?php
      $getTime = $getDB[time];
      $getMemo = $getDB[memo];
      echo " 시간 : '$getTime'";
      echo " 내용 : '$getMemo'";
      $memonum = $getDB[memonum];
      ?>
        <button name="button" onclick="delMemo(<?php echo $memonum ?>)"> 삭제하기 </button>
        <br></div>
      <?php
    }
    ?>
    <br><br>
    <button id = backBtn name="button" onclick="location.href='cal.php'"> 뒤로가기 </button>
</div>
    <script type="text/javascript">
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



  </body>
</html>
