<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/update.css">
    <meta name="viewport"
          content="width=device=width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0, minimum-scale=1.0">

    <script type="text/javascript">
        function numcheck(argID) {
            var argValue = document.getElementById(argID).value;
            var reValue = "";
            for (let i = 0; i < argValue.length; i++) {
                if (argValue.charAt(i) >= 0 && argValue.charAt(i) <= 9) {
                    reValue += argValue.charAt(i);
                } else {
                    alert("숫자를 입력해 주세요.");
                    break;
                }
            }
            document.getElementById(argID).value = reValue;
        }
    </script>
    <title>정보 업데이트</title>
</head>
<body>
    <div class="userInfo">
    <?php include("user.php") ?>
    </div>


<form action="DBphp/update.php" method="post">
    <div id="background" class="font">
        <table>
            <tr>
                <td>이 름</td>
                <td>
                    <div id="nickName"><?php echo "{$_SESSION['name']}" ?></div>
                </td>
            </tr>
            <tr>
                <td> 비밀번호 입력</td>
                <td><input type="password" name="nowPW" placeholder="&nbsp;*필수 입력"></td>
            </tr>
            <tr>
                <td> 비밀번호 변경</td>
                <td><input type="password" name="chPW1"></td>
            </tr>
            <tr>
                <td> 비밀번호 확인</td>
                <td><input type="password" name="chPW2"></td>
            </tr>

            <tr>
                <td> 2차 PW</td>
                <td><input type="password" name="nowPW_2" id="PW2_1" placeholder="&nbsp;숫자 4자리 입력" maxlength="4"
                           onkeyup="numcheck(this.id)"></td>
            </tr>
            <tr>
                <td> 2차 PW 변경</td>
                <td><input type="password" name="chPW1_2" id="PW2_2" maxlength="4" onkeyup="numcheck(this.id)"></td>
            </tr>
            <tr class="font">
                <td> 2차 PW 확인</td>
                <td><input type="password" name="chPW2_2" id="PW2_3" maxlength="4" onkeyup="numcheck(this.id)"></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
            </tr>
        </table>
        <div id="button">
            <button class="font back button" type="button" onclick="location.href='cal.php'"> 뒤로가기</button>
            <input class="font update button" type="submit" value="변경하기">
        </div>
    </div>
</form>
</body>
</html>
