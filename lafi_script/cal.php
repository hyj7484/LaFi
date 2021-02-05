<?php
session_start();
?>
<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8" >
    <!-- <meta name="viewport" content="width=device=width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0, minimum-scale=1.0"> -->
    <!-- <link rel="stylesheet" href="css/cal1.css"> -->

    <style>
    table { border-collapse: collapse;}
    *{
     text-align: center;
     margin: 0 auto;
     font-family: "THE선인장" , sans-serif ;
    }
    div{width: 100%; height: 100%; background-repeat: no-repeat;}
    label{line-height: 75px;}
    .redDay{
      background-color : rgb(255,163,191);
      color : white;
    }
    .blueDay{
      background-color : rgb(163,187,255);
      color : white;
    }
    body{
      background-image : url('IMG/stripe.png');
      background-position : center;
      background-size : cover;
    }
    #koko {
      width :900px;
      height : 670px;
      padding-top: 30px;
      background-image : url('IMG/calendar2.png');
      -webkit-box-shadow: -7px 24px 22px 0px rgba(0,0,0,0.75);
    -moz-box-shadow: -7px 24px 22px 0px rgba(0,0,0,0.75);
    box-shadow: -7px 24px 22px 0px rgba(0,0,0,0.75);
    }
    #modifyInfo, #dday {
      background-color : #2457c1;
      color: white;
      border: none;
      border-radius: 3px;
    }

    </style>


    <title>calendar</title>
    <script type="text/javascript" >
    function mouseOver(id) {
       document.getElementById(id).style.backgroundImage = "url('IMG/chcal_blue.png')";
       document.getElementById(id).style.backgroundSize = "contain";
    }
    function mouseOut(id) {
      document.getElementById(id).style.backgroundImage = "none";
    }
    var today = new Date();//오늘 날짜
    function prevClaendar(){//이전 달력
      today = new Date(today.getFullYear(), today.getMonth()-1,today.getDate());
      buildCalendar();
    }
    //다음 달력을 오늘을 저장하고 달력에 뿌려줌
    function nextCalendar(){
      today = new Date(today.getFullYear(), today.getMonth()+1,today.getDate());
      buildCalendar();
    }
    function buildCalendar(){
      var nMonth = new Date(today.getFullYear(),today.getMonth(),1);// 이번달의 첫번째날
      var lastDate =new Date(today.getFullYear(),today.getMonth()+1,0);//이번달의 마지막날
      var tblCalendar =document.getElementById("calendar");    //테이블 달력을 만드는 테이블
      var tblCalendarYM =document.getElementById("calendarYM"); ///XXXX년도XX월 출력
      var tbCal = document.getElementById("cal");
      tblCalendarYM.innerHTML = today.getFullYear()+"년"+(today.getMonth()+1)+"월";

      //기존에 테이블에 잇던 달력 내용 삭제
      while(tbCal.rows.length>0){
        tbCal.deleteRow(tbCal.rows.length -1);
      }
      var row = null;
      row =tbCal.insertRow();
      var cnt =0;
      // 1일이 시작되는 칸을 맞추어줌

      for ( i=0; i < nMonth.getDay(); i++) {
        cell =row.insertCell();
        cnt = cnt + 1;
    }
      //달력 출력
      for(i=1; i<=lastDate.getDate(); i++){
        cell = row.insertCell();

        cell.innerHTML ='<div id="cell'+ i +'" onmouseover="mouseOver(id)"  onmouseout="mouseOut(id)" align="center" onclick="getVal('+ i +')"><label>' + i + '</label></div>';
        cnt = cnt + 1;
        if (cnt%7 == 0)    //1주=7일
         row = calendar.insertRow();
      }
      if(cnt %7 == 0){
          tbCal.deleteRow(tbCal.rows.length -1);
      }
      for(i = cnt; ;i++){
        if(i%7 == 0)
          break;
        cell =row.insertCell();
        cell.innerHTML="";
      }
    }
      function getVal(e){
        var getDay = today.getFullYear()+"-"+(today.getMonth()+1)+"-"+e;
        goPost(getDay);
      }

      function goPost(e){
        var set = e;
        var form = document.createElement("form");
        form.setAttribute("charset", "UTF-8");
        form.setAttribute("method", "Post"); // Get 또는 Post 입력
        form.setAttribute("action", "getMemo.php");

        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "sendYear");
        hiddenField.setAttribute("value", e);
        form.appendChild(hiddenField);
        document.body.appendChild(form);

        form.submit();
      }
    </script>
  </head>
  <body>
    <p id="information">
  <?php
     echo " 아이디 : ".$_SESSION['id']." ┃ ";
     echo " 이름 : ".$_SESSION['name']." ┃ ";
     echo " 생년월일 : ".$_SESSION['year'];
     // echo " 번호 : ".$_SESSION['Num'];
      ?>
      <button id="modifyInfo" type="button" name="button" onclick="location.href='update.php'"> 정보수정 </button>
      <button id="dday" type="button" name="button" onclick="location.href='Dday.html'"> D-Day </button>
    </p>
    <br><br>
    <div id="koko">
      <br><br><br>
    <table id="calendar"  border="3" align="center" width="800" height="500"  >
      <tr >
        <td align ="center"> <div onclick="prevClaendar()"><label> < </label> </div></td>
        <td colspan="5" align ="center" id="calendarYM">yyyy년 m월</td>
        <td align ="center"> <div onclick="nextCalendar()"><label> > </label> </div> </td>
      </tr>
      <tr>
        <td class="redDay" align="center">일</td>
        <td  align="center">월</td>
        <td  align="center">화</td>
        <td  align="center">수</td>
        <td  align="center">목</td>
        <td  align="center">금</td>
        <td class="blueDay" align="center">토</td>
      </tr>
      <tbody id="cal">

      </tbody>
    </table>
    </div>
        <script type="text/javascript" >
          buildCalendar();
        </script>
  </body>
</html>
