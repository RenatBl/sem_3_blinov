<#import "parts/html.ftl" as h>

<@h.html "����">
    <div class="login_page">
        <form method="post">
            <div class="username"><label> ��� ��������: <input type="text" id="username" name="username"/> </label></div>
            <div class="password"><label> ������: <input type="password" id="password" name="password"/> </label></div>
            <div class="submit"><input type="submit" value="����"/></div>
        </form>
    </div>
</@h.html>