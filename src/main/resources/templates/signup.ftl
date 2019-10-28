<#import "parts/html.ftl" as h>

<@h.html "Регистрация">
    <div><label> Имя аккаунта: <input type="text" name="username"/> </label></div>
    <div><label> Имя: <input type="text" name="name"/> </label></div>
    <div><label> Фамилия: <input type="text" name="surname"/> </label></div>
    <div><label> Email: <input type="email" name="email"/> </label></div>
    <div><label> Номер телефона: <input type="text" name="phoneNumber"/> </label></div>
    <div><label> Пароль: <input type="password" name="password"/> </label></div>
    <div><label> Повторите пароль: <input type="password"/> </label></div>
    <div><input type="submit" value="Регистрация"/></div>
</@h.html>