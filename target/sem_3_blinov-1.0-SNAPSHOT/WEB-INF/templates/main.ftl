<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "������� ��������">
    <@p.page/>

    <div class="main">

    <div class="main_left">

    <h2>������ �������</h2>
    <div class="stations_list">
        <#if error_no_stations?has_content>
        ${error_no_stations}
        <#else>
        <#list stations as station>
        <div class="stations_list_item">
            <div class="stations_list_item_content">
                <p><strong>${station.name}</strong></p>
                <form action="/station" method="get">
                    <input type="hidden" name="id" value="${station.id}"/>
                    <input type="submit" class="btn btn-primary" value="�������"/>
                </form>
            </div>
        </div>
    </div>
    </div>
</#list>
</#if>
    <iframe src="https://yandex.ru/map-widget/v1/?um=constructor%3A628287bc834220e7447fd81d2720c2fcd450c9268209e7ff1ce8c23a2f819670&amp;source=constructor" width="60%" height="320" frameborder="0" amrgin-left="20%" style="border:3px solid grey"></iframe>
</@h.html>