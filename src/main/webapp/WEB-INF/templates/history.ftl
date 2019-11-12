<#ftl encoding='UTF-8'>
<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "История заказов">
    <@p.page/>
    <div class="main">

        <div class="main_left">

            <h2>История заказов</h2>
            <div class="stations_list">

                <#if rents?has_content>
                <#list rents as rent>
                    <div class="stations_list_item">
                        <div class="stations_list_item_content">
                            <p><strong>${rent.getValue().startTime}</strong></p>
                            <p>Улица: ${rent.getKey()}</p>
                            <p>Стоимость: ${rent.getValue().cost}</p>
                            <#if rent.getValue().status == "PAID">
                                <p>Статус: Оплаченно</p>
                            <#else >
                                <p>Статус: Неоплаченно</p>
                            </#if>
                            <form method="get" action="/pay">
                                <p>
                                    <input type="hidden" name="id" value="${rent.getValue().id}">
                                    <button type="submit" id="pay" class="btn btn-primary">Оплатить</button>
                                </p>
                            </form>

                        </div>
                    </div>
                </#list>
            </div>

        </div>
        <div class="main_right">
            <p>Total orders: ${total}</p>
            <p>Unpaid: ${unpaid}</p>
        </div>
        <#else>
            История заказов пуста
        </#if>
<#--    </div>-->
    <@p.menu/>
</@h.html>