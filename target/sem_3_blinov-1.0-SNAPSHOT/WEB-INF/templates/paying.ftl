<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "������">
    <@p.page/>
    <div class="rent_info_block">
        <div class="rent_info"><h4>${rent.startTime}</h4></div>
        <div class="rent_info"><label>��������� �������: ${rent.start}</label></div>
        <div class="rent_info"><label>�������� �������: ${rent.finish}</label></div>
        <div class="rent_info"><label>���������: ${rent.cost}</label></div>
        <input type="button" value="PAID"/>
    </div>
</@h.html>