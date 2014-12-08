<%-- 
    Document   : form
    Created on : 05/11/2014, 21:32:36
    Author     : Joao Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <h1>Cadastro de Produtos</h1>
        <form action="<c:url value='/produtos/adiciona'/>">
             <!--<form method="POST" action="${linkTo[ProdutosController].adiciona}">-->
            Nome:
            <input type="text" name="produto.nome" value="${produto.nome}"/><br/>
            Descrição:
            <input type="text" name="produto.descricao" value="${produto.descricao}"/><br/>
            Preço:
            <input type="text" name="produto.preco" value="${produto.preco}"/><br/>

            <input type="submit" value="Salvar" />
        </form>
    </body>
</html>
