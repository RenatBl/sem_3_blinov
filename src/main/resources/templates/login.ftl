<#import "parts/html.ftl" as h>

<@h.html "Вход">
    <div class="username"><label> Имя аккаунта: <input type="text" name="username"/> </label></div>
    <div class="password"><label> Повторите пароль: <input type="password"/> </label></div>
    <div class="submit"><input type="submit" value="Вход"/></div>
</@h.html>