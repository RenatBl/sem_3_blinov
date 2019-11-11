<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "������� ${station.name}">
    <@p.page/>
    <div class="station-name"><h2>${station.name}</h2></div>
    <div class="map"></div><#--����� ����� ����� ����� ���������� ������ � ������.������-->
    <#if error_no_station?has_content>
        ${error_no_station}
    <#else>
        <#list items as item>
            <div class="bike-station">
                <div class="bike-station_info"><label>��������: ${item.getValue().getBrand()}</label></div>
                <div class="bike-station_info"><label>������: ${item.getValue().getName()}</label></div>
                <div class="bike-station_info"><label>���: ${item.getValue().getType()}</label></div>
                <div class="bike-station_info"><label>����: ${item.getKey().getPrice()} ������ � ���</label></div>
                <div class="bike-station_info"><label>������: ${item.getKey().getAvailable()}</label></div>
                <#--����� �������� ���������, ����� ������ �������� enum'a FREE, BROKEN, BUSY ������������
                ����� "��������", "�����" � "������"-->
                <div class="follow">
                    <form action="/bike" method="get">
                        <input type="hidden" name="id" value="${item.getKey().getId()}">
                        <input type="submit" value="����������"/>
                    </form>
                    <#--����� ���� ����� �������� ������, ������� ��������� ��������� ����������. ���� �� ����� ��� ������,
                     �� ������ disabled, ���� ��������, �� ������ �������-->
                </div>
            </div>
        </#list>
    </#if>
</@h.html>