<#import "parts/html.ftl" as h>

<@h.html "�����������">
    <div><label> ��� ��������: <input type="text" name="username"/> </label></div>
    <div><label> ���: <input type="text" name="name"/> </label></div>
    <div><label> �������: <input type="text" name="surname"/> </label></div>
    <div><label> Email: <input type="email" name="email"/> </label></div>
    <div><label> ����� ��������: <input type="text" name="phoneNumber"/> </label></div>
    <div><label> ������: <input type="password" name="password"/> </label></div>
    <div><label> ��������� ������: <input type="password"/> </label></div>
    <div><input type="submit" value="�����������"/></div>
</@h.html>