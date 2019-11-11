<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Обсуждение">
    <@p.page/>
    <div class="comment-list">
        <#if items?has_content>
            <#list items as item>
                <div class="com-user"><h3>${item.getKey().getUsername}</h3></div>
                <div class="com-date">${item.getValue().getDate()}</div>
                <div class="com-text">${item.getValue().getText()}</div>
            </#list>
        <#else>
            <div class="com-error">Комментарии отсутсвуют</div>
        </#if>
    </div>

    <div class="crt-comment">
        <form method="post">
        <div class="text-input">
            <label>
                Введите текст комментария: <textarea rows="4" cols="40" name="text"></textarea>
            </label>
        </div>
            <div class="com-submit">
                <input type="submit" value="Отправить">
            </div>
        </form>
    </div>
</@h.html>
