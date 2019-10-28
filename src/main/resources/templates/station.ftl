<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Станция " + ${station.name}>
    <@p.page/>
    <div class="map"></div><#--Здесь позже нужно будет прикрепить скрипт с яндекс.картой-->
    <#list bikes as bike>
    <div class="bike-station">
        <div class="bike-station_info"><label>Название: ${bike.model.brand}</label></div>
        <div class="bike-station_info"><label>Модель: ${bike.model.name}</label></div>
        <div class="bike-station_info"><label>Тип: ${bike.model.type}</label></div>
        <div class="bike-station_info"><label>Цена: ${bike.price} рублей в час</label></div>
        <div class="bike-station_info"><label>Статус: ${bike.available}</label></div>
    <#--Потом написать обработку, чтобы вместо значений enum'a FREE, BROKEN, BUSY отображались
    слова "Свободен", "Занят" и "Сломан"-->
        <div class="follow">
            <form action="rent.ftl" method="get">
                <input type="button" value="Арендовать"/>
            </form>
        <#--Здесь надо будет написать скрипт, который проверяет состояние велосипеда. Если он занят или сломан,
         то кнопка disabled, если свободен, то кнопка активна-->
        </div>
    </div>
    </#list>
</@h.html>