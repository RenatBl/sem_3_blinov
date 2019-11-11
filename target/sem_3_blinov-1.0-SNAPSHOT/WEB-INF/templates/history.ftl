<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "������� �������">
    <@p.page/>
    <#if error_no_rents?has_content>
        ${error_no_rents}
    <#else>
        <#list rents as rent>
            <div class="rent-history">
                <div class="rent-history_info"><h4>${rent.startTime}</h4></div>
                <div class="rent-history_info"><label>��������� �������: ${rent.start}</label></div>
                <div class="rent-history_info"><label>�������� �������: ${rent.finish}</label></div>
                <div class="rent-history_info"><label>���������: ${rent.cost}</label></div>
                <div class="rent-history_info"><label>������ ������: ${rent.status}</label></div>
                <form action="paying.ftl" method="get">
                    <input type="button" value="��������">
                    <#--����� ���� ����� �������� ������, ������� ��������� ������ ������. ���� �� �������, �� ������ disabled,
                    ���� ���, �� ������ �������-->
                </form>
            </div>
        </#list>
        <div class="total_orders">${total}</div>
        <div class="unpaid">${unpaid}</div>
    </#if>
</@h.html>