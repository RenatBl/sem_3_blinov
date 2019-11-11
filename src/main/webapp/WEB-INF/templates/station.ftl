<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Станция ${station.name}">
    <@p.page/>
    <div class="station-name"><h2>${station.name}</h2></div>
    <div class="map"></div><#--Здесь позже нужно будет прикрепить скрипт с яндекс.картой-->
    <#if error_no_station?has_content>
        ${error_no_station}
    <#else>
        <#list items as item>
            <div class="bike-station">
                <div class="bike-station_info"><label>Название: ${item.getValue().getBrand()}</label></div>
                <div class="bike-station_info"><label>Модель: ${item.getValue().getName()}</label></div>
                <div class="bike-station_info"><label>Тип: ${item.getValue().getType()}</label></div>
                <div class="bike-station_info"><label>Цена: ${item.getKey().getPrice()} рублей в час</label></div>
                <div class="bike-station_info"><label>Статус: ${item.getKey().getAvailable()}</label></div>
                <#--Потом написать обработку, чтобы вместо значений enum'a FREE, BROKEN, BUSY отображались
                слова "Свободен", "Занят" и "Сломан"-->
                <div class="follow">
                    <form action="/bike" method="get">
                        <input type="hidden" name="id" value="${item.getKey().getId()}">
                        <input type="submit" value="Арендовать"/>
                    </form>
                    <#--Здесь надо будет написать скрипт, который проверяет состояние велосипеда. Если он занят или сломан,
                     то кнопка disabled, если свободен, то кнопка активна-->
                </div>
            </div>
        </#list>
    </#if>
</@h.html>