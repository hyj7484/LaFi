<!doctype html>
<html lang="en">
<head>
    <title>일정등록</title>
    <link rel="stylesheet" href="css/addMemo.css">
    <meta name="viewport"
          content="width=device=width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0, minimum-scale=1.0">

    </head>
<body>
<?php
include("user.php");
$getNum = $_SESSION['Num'];
?>
<form action="DBphp/addmemo.php" METHOD="POST">
<div class="center">
<table>
    <tr><td><h2>일자</h2></td></tr>
    <tr><td><input type="hidden" name="date" value="<?php echo $_SESSION['today']; ?>">
            <?php echo $_SESSION['today']; ?></td></tr>
    <tr><td><h2>시간</h2></td></tr>
    <tr><td><input type="time" name="time"></td></tr>
    <tr><td><h2>일정</h2></td></tr>
    <tr><td><input type="text" name="memo"></td></tr>
</table>
    <br><br>
    <input class = "br" type="submit" name="button" value="등록하기">
    <input class = "br" type="button" value="뒤로가기" onclick="location.href='getMemo.php'">
    </div>
</form>
</body>
</html>
