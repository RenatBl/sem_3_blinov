<#macro page>
    <div id="header">
        <div class="header_name">
            <span class="green">B</span>ike <span class="green">S</span>haring
        </div>

        <div class="header_logo">
            <span class="green">BS</span>
        </div>

        <div class="header_logout">
            <form method="get" action="/logout">
                <input type="submit" value="�����"/>
            </form>
        </div>
    </div>

    <div class="main_right">
        <div class="menu">
            <a href="/main">
                <div class="menu_item active">������� ��������</div>
            </a>
            <a href="/profile">
                <div class="menu_item">�������</div>
            </a>
            <a href="/history">
                <div class="menu_item">������� �������</div>
            </a>
            <a href="/comments">
                <div class="menu_item">�����������</div>
            </a>
        </div>
    </div>
</div>
</#macro>