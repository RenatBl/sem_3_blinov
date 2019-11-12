<#ftl encoding='UTF-8'>
<#import "parts/html.ftl" as h>
<#import "parts/page.ftl" as p>

<@h.html "Аренда">
    <div class="main">
        <div class="container">
            <form method="post">
                <input type="hidden" name="time" value="${time}"/>
                <input type="hidden" name="id" value="${id}"/>
                <p>
                    <input class="btn btn-outline-secondary btn-paying" type="submit" value="Закончить аренду"/>
                </p>
            </form>
        </div>
    </div>
</@h.html>