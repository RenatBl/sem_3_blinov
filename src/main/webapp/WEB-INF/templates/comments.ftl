<#ftl encoding='UTF-8'>
<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Обсуждение">
    <@p.page/>
    <div class="main">
        <div class="main_left">
            <h2>Обсуждение</h2>
                <div class="stations_list">
                    <div>
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
                    <#if items?has_content>
                        <#list items as item>
                            <div class="stations_list_item">
                                <div class="stations_list_item_content">
                                    <strong>${item.getValue().getUsername()}</strong>
                                    <p>${item.getKey().getDate()}</p>
                                    <p>${item.getKey().getText()}</p>
                                </div>
                            </div>
                            </#list>
                    </div>
                    <#else>
                        <div class="com-error">Комментарии отсутсвуют</div>
                    </#if>
        </div>
<#--    </div>-->
    <@p.menu/>
</@h.html>