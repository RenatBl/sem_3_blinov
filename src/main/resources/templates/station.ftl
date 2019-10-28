<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "������� " + ${station.name}>
    <@p.page/>
    <div class="map"></div><#--����� ����� ����� ����� ���������� ������ � ������.������-->
    <#list bikes as bike>
    <div class="bike-station">
        <div class="bike-station_info"><label>��������: ${bike.model.brand}</label></div>
        <div class="bike-station_info"><label>������: ${bike.model.name}</label></div>
        <div class="bike-station_info"><label>���: ${bike.model.type}</label></div>
        <div class="bike-station_info"><label>����: ${bike.price} ������ � ���</label></div>
        <div class="bike-station_info"><label>������: ${bike.available}</label></div>
    <#--����� �������� ���������, ����� ������ �������� enum'a FREE, BROKEN, BUSY ������������
    ����� "��������", "�����" � "������"-->
        <div class="follow">
            <form action="rent.ftl" method="get">
                <input type="button" value="����������"/>
            </form>
        <#--����� ���� ����� �������� ������, ������� ��������� ��������� ����������. ���� �� ����� ��� ������,
         �� ������ disabled, ���� ��������, �� ������ �������-->
        </div>
    </div>
    </#list>
</@h.html>