<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device=width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0, minimum-scale=1.0">
    <title>LaFi</title>
    <link rel="stylesheet" href="css/Main.css">
</head>
<body>

<div class="background">
<div id="LogoIMG">
    <img class="logo" src="IMG/MainLogo.png" alt="No Logo">
    <div><img src="IMG/pencil_line.png" alt="line"></div>

</div>

<div id="form">
<form action="DBphp/login.php" method="post">
    <table>

        <tr>
            <td>ID&nbsp;
                <input class="font" type="text" name="getID" placeholder="  ID">
            </td>
        </tr>

        <tr>
            <td>PW
                <input class="font" type="password" name="getPW" placeholder="  Password">
            </td>
        </tr>

        <tr>
            <td>
            <input class="font" type="hidden" value=" ">
            </td>
        </tr>

        <tr>
            <td>    
                <input class="button font" type="submit" name="" value="Login">
                <input class="button font" type="button" name="button" value="Sign" onclick="location.href='Sign.php'">
            </td>
        </tr>
    </table>
</form>
<br>
</div>

</div>
</body>
</html>
