<#ftl encoding='UTF-8'>
<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Велосипед">
    <@p.page/>
    <div class="main">
    <div class="main_left">
        <div class="main_left_content">
            <div class="main_left_left">
                <p>Название:&nbsp;</p>
                <p>Модель:&nbsp;</p>
                <p>Тип:&nbsp;</p>
                <p>Цвет:&nbsp;</p>
                <p>Год:&nbsp;</p>
                <p>Цена:&nbsp;</p>
            </div>
            <div class="main_left_right">
                <p>&nbsp;${model.brand}</p>
                <p>&nbsp;${model.name}</p>
                <p>&nbsp;${model.type}</p>
                <p>&nbsp;${model.color}</p>
                <p>&nbsp;${bike.year}</p>
                <p>&nbsp;${bike.price} - ₽ в час</p>
            </div>

            <form action="/rent" method="get">
                <input type="hidden" name="id" value="${bike.getId()}"/>
                <input class="btn btn-outline-secondary" type="submit" value="Арендовать"/>
            </form>
        </div>
    </div>

    <@p.menu/>

</@h.html>