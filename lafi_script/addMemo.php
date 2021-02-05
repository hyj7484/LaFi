

<!doctype html>
<html lang="en">
<head>
    <title>일정등록</title>
    <link rel="stylesheet" href="css/addMemo.css">
    <meta name="viewport"
          content="width=device=width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0, minimum-scale=1.0">

</head>

<body>
    <div class="user">
    <?php
            session_start();
            $getNum = $_SESSION['Num'];
            $getDay = $_SESSION['today'];

            $date1 = date_create($getDay);
            $date = date_format($date1, "Y")."년 ".date_format($date1, "m")."월 ".date_format($date1,"d")."일";
    ?>
    </div>
<div class="center">
<form action="DBphp/addmemo.php" METHOD="POST">

<table>
    <tr>
        <h2>일정 등록</h2>
    </tr>
    <tr>
        <th>일자</th><td><input class="schedule" type="hidden" name="date" value="<?php echo $_SESSION['today']; ?>">
            <?php echo $date; ?></td>
    </tr>
    <tr>
        <th>시간</th><td><input class="schedule" type="time" name="time"></td>
    </tr>
    <tr>
        <th>일정</th><td><input class="schedule" type="text" name="memo"></td>
    </tr>

</table>
    <br><br>
    <div class="buttons">
    <input class = "button submit" type="submit" name="button" value="등록하기">
    <input class = "button back" type="button" value="뒤로가기" onclick="location.href='getMemo.php'">
    </div>

</form>
</div>

</body>
</html>
