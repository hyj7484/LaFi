<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device=width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="css/sign.css">
    <title>회원가입</title>
</head>
<body>
<script type="text/javascript">

  function checkPW(){
    var PW1 = document.getElementById('setPW1').value;
    var PW2 = document.getElementById('setPW2').value;

    let checkBoxPW = document.getElementById('PWcheck');
    if(PW1 == PW2 && PW1.length >= 8 && PW1.length <= 15){
      checkBoxPW.checked = true;
    }else{
      checkBoxPW.checked = false;
    }
  }

  function numcheck(){
    var PW = document.getElementById('setNumPW').value;
    var reValue = "";
    for(let i = 0; i < PW.length; i++){
      if(PW.charAt(i) >= 0 && PW.charAt(i) <= 9){
        reValue += PW.charAt(i);
      }else{
        alert("숫자를 입력해 주세요.");
        break;
      }
    }
    document.getElementById('setNumPW').value = reValue;
  }
</script>

<form action="DBphp/sign.php" method="post">
    <div id="background" class = "font">
      <br>
      <h1>회 원 가 입</h1>
        <table>
            <!-- ID -->
            <tr>
                <td class="list">아이디</td>
                <td><input class="input" type="text" name="setID" autocomplete="off"></td>
            </tr>
            <!-- PW -->
            <tr>
                <td class="list">비밀번호</td>
                <td><input class="input" type="password" id="setPW1" name="setPW1" onchange="checkPW()" onkeyup="off"></td>
            </tr>
            <tr>
                <td class="list">비밀번호 확인</td>
                <td><input class="input" type="password" id="setPW2" name="setPW2" autocomplete="off" onkeyup="checkPW()"></td>
                <td><input type="checkbox" id="PWcheck" disabled="disabled"> </td>
            </tr>

            <tr>
                <td class="list">2차 비밀번호</td>
                <td><input class="input" type="password" id="setNumPW" name="setNumPW" placeholder="&nbsp;&nbsp;숫자4자리"
                           maxlength="4" autocomplete="off" onkeyup="numcheck()"></td>
            </tr>
            <!-- Name -->
            <tr>
                <td class="list">이름</td>
                <td><input class="input" type="text" name="setName" autocomplete="off"></td>
            </tr>
            <!-- Birth -->
            <tr>
                <td class="list">생년월일</td>
                <td><input class="input" type="date" name="setBirth" autocomplete="off"></td>
            </tr>
        </table>
            <!--button-->
        <div id="button">
        <input class = "font" type="submit" value="가입하기">
        <button class = "font back" type="button" onclick="location.href='Main.php'">뒤로가기</button>
        </div>
    </div>
  </form>
</body>
</html>
