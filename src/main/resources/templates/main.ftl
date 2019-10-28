<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "������� ��������">
    <@p.page/>
<div class="map"></div><#--����� ����� ����� ����� ���������� ������ � ������.������-->
    <#list stations as station>
    <div class="station">
        <div class="station_name">
            ${station.name}
        </div>
        <div class="follow">
            <form action="station.ftl" method="get">
                <input type="button" value="�������"/>
            </form>
        </div>
    </div>
    </#list>
</@h.html>