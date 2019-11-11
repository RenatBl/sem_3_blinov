<#import "parts/html.ftl" as h>

<@h.html "¬ход">
    <div class="login_page">
        <form method="post">
            <div class="username"><label> »м€ аккаунта: <input type="text" id="username" name="username"/> </label></div>
            <div class="password"><label> ѕароль: <input type="password" id="password" name="password"/> </label></div>
            <div class="submit"><input type="submit" value="¬ход"/></div>
        </form>
    </div>
</@h.html>