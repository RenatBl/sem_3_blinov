<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "�������">
    <@p.page/>
    <div class="user_inf"><label>��� ��������: ${user.username}</label></div>
    <div class="user_inf"><label>���: ${user.name}</label></div>
    <div class="user_inf"><label>�������: ${user.surname}</label></div>
    <div class="user_inf"><label>Email: ${user.email}</label></div>
    <div class="user_inf"><label>����� ��������: ${user.phoneNumber}</label></div>
</@h.html>