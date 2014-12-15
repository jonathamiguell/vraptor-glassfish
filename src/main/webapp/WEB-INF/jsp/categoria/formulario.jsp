<%-- 
    Document   : formulario
    Created on : Dec 5, 2014, 8:38:58 AM
    Author     : marcio
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Categorias</title>
    </head>
    <body>
        <h1>Categorias</h1>
        <c:if test="${not empty mensagem}">
            <span style="color:green">${mensagem}</span>
        </c:if>
            <form method="post" action="${linkTo[CategoriaController].salvar}">
            Descrição: <input name="categoria.descricao" value="${categoria.descricao}" required placeholder="Descrição da categoria" /><br>
            <button type="submit">Gravar</button>
        </form>

        <hr>
        <c:if test="${not empty categorias}">
            <table>
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Descrição</td>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${categorias}" var="categoria">
                        <tr>
                            <td>${categoria.id}</td>
                            <td>${categoria.descricao}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
</body>
</html>
