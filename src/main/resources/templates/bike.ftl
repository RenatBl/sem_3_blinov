<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "���������">
    <@p.page/>
    <div class="bike">
        <div class="bike_info"><label>��������: ${bike.model.brand}</label></div>
        <div class="bike_info"><label>������: ${bike.model.name}</label></div>
        <div class="bike_info"><label>���: ${bike.model.type}</label></div>
        <div class="bike_info"><label>����: ${bike.model.color}</label></div>
        <div class="bike_info"><label>��� �������: ${bike.year}</label></div>
        <div class="bike_info"><label>����: ${bike.price} ������ � ���</label></div>
    </div>
</@h.html>