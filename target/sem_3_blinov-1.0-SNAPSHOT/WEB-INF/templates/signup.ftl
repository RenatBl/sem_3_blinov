<#import "parts/html.ftl" as h>

<@h.html "�����������">
    <div class="card text-center">
        <div class="card-header" style="font-size:2em;">
            �����������
        </div>
        <div class="card-body">
            <form method="post">
                <div class="form-group row">
                    <label for="username" class="col-sm-2 col-form-label">��� ������������</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username" name="username"
                               placeholder="������� ��� ������������">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">���</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" placeholder="������� ���">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="surname" class="col-sm-2 col-form-label">�������</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="surname" name="surname"
                               placeholder="������� �������">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="phoneNumber" class="col-sm-2 col-form-label">����� ��������</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
                               placeholder="������� ����� ��������">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" placeholder="������� email">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">������</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="������� ������">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="repeat" class="col-sm-2 col-form-label">��������� ������</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="repeat" placeholder="��������� ������">
                    </div>
                </div>
                    <input type="submit" class="btn btn-primary" value="�����������" />
            </form>
        </div>
        <div class="card-footer text-muted">
            ��� ���� �������? <a href="/login">����</a>
        </div>
    </div>
</@h.html>