<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "����������">
    <@p.page/>
    <div class="comment-list">
        <#if items?has_content>
            <#list items as item>
                <div class="com-user"><h3>${item.getKey().getUsername}</h3></div>
                <div class="com-date">${item.getValue().getDate()}</div>
                <div class="com-text">${item.getValue().getText()}</div>
            </#list>
        <#else>
            <div class="com-error">����������� ����������</div>
        </#if>
    </div>

    <div class="crt-comment">
        <form method="post">
        <div class="text-input">
            <label>
                ������� ����� �����������: <textarea rows="4" cols="40" name="text"></textarea>
            </label>
        </div>
            <div class="com-submit">
                <input type="submit" value="���������">
            </div>
        </form>
    </div>
</@h.html>
