<#ftl encoding='UTF-8'>
<#import "style.ftl" as s>
<#macro page>
    <@s.style/>
    <div id="header">
        <div class="header_name">
            <span class="green">B</span>ike<span class="green">S</span>haring
        </div>

        <div class="header_logo">
            <span class="green">BS</span>
        </div>

        <div class="header_logout">
            <form method="get" action="/logout">
                <button type="submit" class="btn btn-primary">Выйти</button>
            </form>
        </div>
    </div>
</#macro>

<#macro menu>
    <div class="main_right">
        <div class="menu">
            <a href="/main">
                <div class="menu_item">Главная страница</div>
            </a>
            <a href="/profile">
                <div class="menu_item">Профиль</div>
            </a>
            <a href="/history">
                <div class="menu_item">История заказов</div>
            </a>
            <a href="/comments">
                <div class="menu_item">Комментарии</div>
            </a>
        </div>
    </div>
</#macro>

<#macro menu_with_map>
    <div class="main_right">
        <div class="menu">
            <a href="/main">
                <div class="menu_item">Главная страница</div>
            </a>
            <a href="/profile">
                <div class="menu_item">Профиль</div>
            </a>
            <a href="/history">
                <div class="menu_item">История заказов</div>
            </a>
            <a href="/comments">
                <div class="menu_item">Комментарии</div>
            </a>
        </div>
        <iframe src="https://yandex.ru/map-widget/v1/?um=constructor%3A628287bc834220e7447fd81d2720c2fcd450c9268209e7ff1ce8c23a2f819670&amp;source=constructor"
                width="60%" height="320" frameborder="0" amrgin-left="20%" style="border:3px solid grey"></iframe>
    </div>

</#macro>

