<#ftl encoding='UTF-8'>
<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Профиль">
    <@p.page/>
    <div class="main">
        <div class="main_left">

            <h2>Профиль пользователя</h2>

            <div class="main_left_content">
                <div class="main_left_left">
                    <p>Имя пользователя:&nbsp;</p>
                    <p>Имя:&nbsp;</p>
                    <p>Фамилия:&nbsp;</p>
                    <p>Email:&nbsp;</p>
                    <p>Номер телефона:&nbsp;</p>
                </div>
                <div class="main_left_right">
                    <p>&nbsp;${user.getUsername()}</p>
                    <p>&nbsp;${user.getName()}</p>
                    <p>&nbsp;${user.getSurname()}</p>
                    <p>&nbsp;${user.getEmail()}</p>
                    <p>&nbsp;${user.getPhoneNumber()}</p>
                </div>
            </div>
        </div>
    <@p.menu/>
</@h.html>