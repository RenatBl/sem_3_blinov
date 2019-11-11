<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "История заказов">
    <@p.page/>
    <#if error_no_rents?has_content>
        ${error_no_rents}
    <#else>
        <#list rents as rent>
            <div class="rent-history">
                <div class="rent-history_info"><h4>${rent.startTime}</h4></div>
                <div class="rent-history_info"><label>Начальная станция: ${rent.start}</label></div>
                <div class="rent-history_info"><label>Конечная станция: ${rent.finish}</label></div>
                <div class="rent-history_info"><label>Стоимость: ${rent.cost}</label></div>
                <div class="rent-history_info"><label>Статус заказа: ${rent.status}</label></div>
                <form action="paying.ftl" method="get">
                    <input type="button" value="Оплатить">
                    <#--Здесь надо будет написать скрипт, который проверяет статус заказа. Если он полачен, то кнопка disabled,
                    если нет, то кнопка активна-->
                </form>
            </div>
        </#list>
        <div class="total_orders">${total}</div>
        <div class="unpaid">${unpaid}</div>
    </#if>
</@h.html>