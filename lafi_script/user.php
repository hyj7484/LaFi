<?php
session_start();
echo " 아이디 : ".$_SESSION['id']." / ";
echo " 이름 : ".$_SESSION['name']." / ";
echo " 생년월일 : ".$_SESSION['year'];
?>
