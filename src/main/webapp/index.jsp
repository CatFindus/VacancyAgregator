<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Агрегатор Вакансий</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="resources/styles.css">
    <script src="resources/script.js" defer></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="bodyclass">
    <header class="main-header">
        <table>
            <tr>
                <td class="td_img">
                    <img class="logoimg" src="resources/image_logo.png" alt="Logo was here">
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
    <div class="backimg">
        <nav class="border"></nav>
        <aside class="border"></aside>
        <section class="sectionclass">
            <div class="box">
                <form>
                    <span class="text-center">Поиск ваканский</span>
                    <div class="input-container">
                        <input id="searchRequest" type="text" minlength="1" maxlength="30"/>
                        <label>Укажите запрос</label>
                    </div>
                    <button type="button" class="button-28 index_button_search" onclick="doSearch()">Поиск</button>
                </form>
            </div>
        </section>
    </div>
    <footer class="footerclass">
        <table>
           <tr>
               <td class="footer_border border_td_footer"></td>
               <td class="footer_border">
                    <img  class="footer_img" src="resources/habr.png" class="select_finder" alt="Habr was here">
               </td>
               <td class="footer_border footer_border_after">
                   <div class="checkbox-wrapper-14">
                       <input id="s1-14" type="checkbox" class="switch">
                       <label for="s1-14">Искать на хабре</label>
                   </div>
               </td>
               <td class="footer_border">
                   <img  class="footer_img" src="resources/hh.png" class="select_finder" alt="HH was here">
               </td>
               <td class="footer_border footer_border_after">
                   <div class="checkbox-wrapper-14">
                       <input id="s2-14" type="checkbox" class="switch">
                       <label for="s2-14">Искать на HH</label>
                   </div>
               </td>
               <td class="footer_border">
                   <img  class="footer_img" src="resources/linked_in.png" class="select_finder" alt="Lin was here">
               </td>
               <td class="footer_border footer_border_after">
                   <div class="checkbox-wrapper-14">
                       <input id="s3-14" type="checkbox" class="switch">
                       <label for="s3-14">Искать на LinkedIn</label>
                   </div>
               </td>
               <td class="footer_border">
                   <img  class="footer_img" src="resources/rabota_ru.png" class="select_finder" alt="HH was here">
               </td>
               <td class="footer_border footer_border_after">
                   <div class="checkbox-wrapper-14">
                       <input id="s4-14" type="checkbox" class="switch">
                       <label for="s4-14">Искать на Работа.ру</label>
                   </div>
               </td>
               <td  class="footer_border border_td_footer"></td>
           </tr>
        </table>
    </footer>

</body>
</html>
