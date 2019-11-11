<#import "parts/html.ftl" as h>

<@h.html "Регистрация">
    <div class="card text-center">
        <div class="card-header" style="font-size:2em;">
            Регистрация
        </div>
        <div class="card-body">
            <form method="post">
                <div class="form-group row">
                    <label for="username" class="col-sm-2 col-form-label">Имя пользователя</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username" name="username"
                               placeholder="Введите имя пользователя">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Имя</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" placeholder="Введите имя">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="surname" class="col-sm-2 col-form-label">Фамилия</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="surname" name="surname"
                               placeholder="Введите фамилию">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="phoneNumber" class="col-sm-2 col-form-label">Номер телефона</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
                               placeholder="Введите номер телефона">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" placeholder="Введите email">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Пароль</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="Введите пароль">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="repeat" class="col-sm-2 col-form-label">Повторите пароль</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="repeat" placeholder="Повторите пароль">
                    </div>
                </div>
                    <input type="submit" class="btn btn-primary" value="Регистрация" />
            </form>
        </div>
        <div class="card-footer text-muted">
            Уже есть аккаунт? <a href="/login">Вход</a>
        </div>
    </div>
</@h.html>