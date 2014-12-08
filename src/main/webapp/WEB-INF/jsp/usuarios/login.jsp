<%-- 
    Document   : form
    Created on : 05/11/2014, 21:32:36
    Author     : Joao Henrique
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login AJAX</title>
        <link href="<c:url value="/css/estilo.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/login.css"/>" rel="stylesheet"></link>
        <script type="text/javascript" src="<c:url value="/js/jquery.form.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/login.js"/>"></script>
    </head>
    <body>
        < form id = "login" action = "<c:url value=" / login"/>" method = "POST" >
        < div id = "loader" ><!-- Criamos essa div apenas para mostrar que estamos fazendo uma requisição no servidor. como chamamos só "perfumaria" rsrsrsr -->
        < img src = "<c:url value=" / img / ajax - loader.gif"/>" > < /img>
        < /div>
        < fieldset >
        < div >
        < label for = "nome" > Usuario: < /label>
        < br / >
        < input type = "text" id = "login" name = "login" style = "width: 200px;" > < /input>
        < /div>
        < div >
        < label for = "email" > Senha: < /label>
        < br / >
        < input type = "password" id = "senha" name = "senha" style = "width: 200px;" > < /input>
        < /div>
        < button type = "submit" > Entrar < /button>
        < /fieldset>
        < /form>
        < /body>
        < /html>