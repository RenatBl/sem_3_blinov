<#ftl encoding='UTF-8'>
<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Оплата">
    <@p.page/>
    <div class="main">

    <div class="main_left">

        <h2>Оплата заказа</h2>

        <div class="main_left_content">
            <div class="main_left_left">
                <p>Дата:&nbsp;</p>
                <p>Станция:&nbsp;</p>
                <p>Время аренды:&nbsp;</p>
                <p>Стоимость:&nbsp;</p>
            </div>
            <div class="main_left_right">
                <p>&nbsp;${rent.startTime}</p>
                <p>&nbsp;${station.name}</p>
                <p>&nbsp;${rent.time}</p>
                <p>&nbsp;${rent.cost} рублей</p>
            </div>
        </div>
        <form method="post">
            <p>&nbsp;<button type="submit" class="btn btn-outline-secondary btn-paying">Pay</button>
            </p>
        </form>
    </div>
    <@p.menu/>
</@h.html>