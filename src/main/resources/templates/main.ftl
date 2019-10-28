<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Главная страница">
    <@p.page/>
<div class="map"></div><#--Здесь позже нужно будет прикрепить скрипт с яндекс.картой-->
    <#list stations as station>
    <div class="station">
        <div class="station_name">
            ${station.name}
        </div>
        <div class="follow">
            <form action="station.ftl" method="get">
                <input type="button" value="Перейти"/>
            </form>
        </div>
    </div>
    </#list>
</@h.html>