<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/jsp/cabecalho.jsp"%>
<%@include file="/WEB-INF/jsp/rodape.jsp"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Produtos</title>
        <link href="<c:url value="/css/estilo.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container" id="container">
            <div class="container-fluid main">
                <div class="row-fluid">
                    <div class="well" id="div-carrinho">
                        <c:if test="${not empty carrinho.total }">
                            <h3>Carrinho: ${carrinho.total}</h3> <a href="<c:url value="/produto/carrinho/clear" />"><button>Encerrar Compra</button></a>
                        </c:if>
                    </div>
                    <h1>Menu</h1>
                    <div class="well" id="div-btn-form">
                        <a href="/vraptor-glassfish/categoria"><button  class="btn btn-info" id=btn-categoria">Categorias</button></a>
                        <a href="/vraptor-glassfish/produto"><button  class="btn btn-info" id=btn-produto">Produtos</button></a></td>
                    </div>
                    <hr>
                </div>
            </div>
        </div>
        <script src="<c:url value="/js/jquery.js"/>"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="<c:url value="/js/script.js"/>"></script>
    </body>
</html>