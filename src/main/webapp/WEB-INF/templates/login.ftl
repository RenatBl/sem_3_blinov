<#ftl encoding='UTF-8'>
<#import "parts/html.ftl" as h>

<@h.html "Вход">
    <div class="main">
        <div class="card text-center">
            <div class="card-header" style="font-size:2em;">
                Вход
            </div>
            <form method="post">
                <div class="card-body">
                    <form>
                        <div class="form-group row">
                            <label for="email" class="col-sm-2 col-form-label">Логин</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="email" name="username"
                                       placeholder="Введите имя пользователя">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="password" class="col-sm-2 col-form-label">Пароль</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="password" name="password"
                                       placeholder="Введите пароль">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Войти</button>
                    </form>
                </div>
            </form>
            <div class="card-footer text-muted">
                У Вас нет аккаунта? <a href="/signup">Регистрация</a>
            </div>
        </div>
    </div>
</@h.html>