<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "������">
<div class="rent">
    <form action="paying.ftl" method="post">
        <div class="timer"><label>����� ������: <input type="time"/></label></div>
    <#--����� ����� ����� ajax ��� ������� ������-->
        <div class="stop_rent"><input type="submit" value="��������� ������"/></div>
    </form>
</div>
</@h.html>