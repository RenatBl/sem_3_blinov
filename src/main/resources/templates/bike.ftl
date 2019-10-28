<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Велосипед">
    <@p.page/>
    <div class="bike">
        <div class="bike_info"><label>Название: ${bike.model.brand}</label></div>
        <div class="bike_info"><label>Модель: ${bike.model.name}</label></div>
        <div class="bike_info"><label>Тип: ${bike.model.type}</label></div>
        <div class="bike_info"><label>Цвет: ${bike.model.color}</label></div>
        <div class="bike_info"><label>Год выпуска: ${bike.year}</label></div>
        <div class="bike_info"><label>Цена: ${bike.price} рублей в час</label></div>
    </div>
</@h.html>