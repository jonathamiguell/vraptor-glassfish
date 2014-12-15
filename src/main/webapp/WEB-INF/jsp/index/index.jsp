
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Index</title>
        <link href="<c:url value="/css/estilo.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <title>Projeto</title>
    </head>
    <body>
        <c:if test="${not empty carrinho.total }">
            <h2>Carrinho: ${carrinho.total}</h2> <a href="<c:url value="/cart/clear" />"><button>Encerrar Compra</button></a>
        </c:if>
        <h1>Menu</h1>
        <a href="/vraptor-glassfish/categoria">Categorias</a>
        <a href="/vraptor-glassfish/produto">Produtos</a>
    </body>
</html>