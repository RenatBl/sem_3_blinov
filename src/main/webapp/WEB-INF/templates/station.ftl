<#ftl encoding='UTF-8'>
<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Станция ${station.name}">
    <@p.page/>
    <div class="main">

    <div class="main_left">

        <h2>Велосипеды на станции ${station.name}</h2>
        <#if error_no_station?has_content>
            ${error_no_station}
        <#else>
            <div class="stations_list">
                <#list items as item>
                    <div class="stations_list_item">
                        <div class="stations_list_item_content">
                            <p><strong>${item.getValue().getBrand()} (${item.getValue().getName()})</strong></p>
                            <p>Тип: ${item.getValue().getType()}</p>
                            <p>Цена: ${item.getKey().getPrice()} - ₽ в час</p>
                            <form action="/bike" method="get">
                                <input type="hidden" name="id" value="${item.getKey().getId()}">
                                <p><input type="submit" class="btn btn-primary" value="Перейти"/></p>
                            </form>
                        </div>
                    </div>
                </#list>
            </div>
        </#if>
    </div>
    <div class="main_right_" style="float: right">
        <iframe src="https://yandex.ru/map-widget/v1/?um=constructor%3A628287bc834220e7447fd81d2720c2fcd450c9268209e7ff1ce8c23a2f819670&amp;source=constructor"
                width="60%" height="320" frameborder="0" amrgin-left="20%" style="border:3px solid grey"></iframe>
    </div>
<#--    </div>-->
    <@p.menu/>
</@h.html>