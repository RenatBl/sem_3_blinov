<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Аренда">
<div class="rent">
    <form action="paying.ftl" method="post">
        <div class="timer"><label>Время аренды: <input type="time"/></label></div>
    <#--Здесь позже будет ajax для таймера аренды-->
        <div class="stop_rent"><input type="submit" value="Закончить аренду"/></div>
    </form>
</div>
</@h.html>