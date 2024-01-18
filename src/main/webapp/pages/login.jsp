<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vacancy aggregator - вход</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../resources/styles.css">
</head>
<body>
<header class="main-header">
    <table>
        <tr>
            <td class="td_img">
                <img class="logoimg" src="../resources/image_logo.png" alt="Logo was here">
            </td>
            <td class="td_text">
                <span class="logospantop">Vacancy Aggregator</span>
                <br>
                <br>
                <span class="logospanbot">Все вакансии в одном месте</span>
            </td>
        </tr>
    </table>
</header>
<div class="backimg_login">
    <nav class="border"></nav>
    <aside class="border"></aside>
    <section class="sectionclass">
        <div class="box">
            <form>
                <span class="text-center">Вход</span>
                <div class="input-container">
                    <input type="text" required=""/>
                    <label>Login</label>
                </div>
                <div class="input-container">
                    <input type="password" required=""/>
                    <label>Password</label>
                </div>
                <div class="login_button_login">
                    <button type="button" class="button-28 login_buttons" onclick="location.href='../index.jsp'">login</button>
                </div>
                <div class="login_button_register">
                    <button type="button" class="button-28 login_buttons" onclick="location.href='register.jsp'">register</button>
                </div>
            </form>
        </div>
    </section>
</div>
</body>
</html>
