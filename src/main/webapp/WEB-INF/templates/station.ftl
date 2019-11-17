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
    <@p.menu_with_map/>
</@h.html>