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
    <body><div class="container" id="container">
            <div class="container-fluid main">
                <div class="row-fluid">
                    <h1>Categorias</h1>
                    <c:if test="${not empty mensagem}">
                        <span style="color:green">${mensagem}</span>
                    </c:if>
                    <div class="well" id="form-cadastro" >
                        <form method="post" action="${linkTo[CategoriaController].salvar}">
                            <fieldset> 
                                <legend> Cadastrar Categoria</legend>
                                <div class="row">
                                    <label class="span3">Descrição</label>
                                </div>
                                <br />
                                <div class="row">
                                    <span class="span3">
                                        <input type="text" id="descricao" class="input-medium" name="categoria.descricao" required/>
                                    </span>
                                    <span class="span3">
                                        <button type="submit" id="btn-salvar" class="btn btn-primary">Salvar</button>
                                        <button type="button" id="btn-cancelar" class="btn btn-danger">Cancelar</button>
                                    </span>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                    <div class="well" id="div-btn-form">
                        <button type="button" id="btn-novo" class="btn btn-primary">Novo +</button>
                    </div>

                    <div class="well">
                        <c:if test="${not empty categorias}">
                            <table id="categorias-cadastradas" class="table-list">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Descrição</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${categorias}" var="categoria">
                                    <tr>
                                        <td>${categoria.id}</td>
                                        <td>${categoria.descricao}</td>
                                    </tr>
                                </c:forEach>
                            </c:if >
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value="/js/jquery.js"/>"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="<c:url value="/js/script.js"/>"></script>
    </body>
</html>
