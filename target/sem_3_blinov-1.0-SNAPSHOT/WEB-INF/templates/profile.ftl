<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Профиль">
    <@p.page/>
    <div class="user_inf"><label>Имя аккаунта: ${user.username}</label></div>
    <div class="user_inf"><label>Имя: ${user.name}</label></div>
    <div class="user_inf"><label>Фамилия: ${user.surname}</label></div>
    <div class="user_inf"><label>Email: ${user.email}</label></div>
    <div class="user_inf"><label>Номер телефона: ${user.phoneNumber}</label></div>
</@h.html>