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
                    <div class="span12">
                        <div class="well" id="div-carrinho">
                            <c:if test="${not empty carrinho.total }">
                                <h3>Carrinho: ${carrinho.total}</h3> <a href="<c:url value="/produto/carrinho/clear" />"><button>Encerrar Compra</button></a>
                            </c:if>
                        </div>
                        <div class="well" id="form-cadastro" >
                            <c:if test="${not empty mensagem}">
                                <span style="color:green">${mensagem}</span>
                            </c:if>
                            <form method="POST" action="${linkTo[ProdutoController].salvar}">
                                <fieldset> 
                                    <legend> Cadastrar Produto</legend>
                                    <div class="row">
                                        <label class="span3">Nome</label>
                                        <label class="span3">Descrição</label>
                                        <label class="span3">Categoria</label>
                                        <label class="span3">Preço</label>
                                    </div> 
                                    <br />
                                    <div class="row">
                                        <span class="span3">
                                            <input type="text" id="nome" class="input-medium" name="p.nome" required/>
                                        </span>
                                        <span class="span3">
                                            <input type="text" id="descricao" class="input-medium" name="p.descricao" required/>
                                        </span>
                                        <span class="span3">
                                            <select id="idCat" name="p.categoria.id">
                                                 <option selected="idCat">--Selecione--</option> 
                                                    <c:forEach items="${categorias}" var="cat">
                                                        <option value="${cat.id}">${cat.descricao}</option>
                                                    </c:forEach>
                                            </select>    
                                        </span>
                                        <span class="span3">
                                            <input type="text" id="preco" class="input-medium" name="p.preco" required />
                                        </span>
                                        <br />
                                        <br />
                                       
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
                            <legend>
                                <h3>Produtos Cadastrados</h3>
                            </legend>
                            <table id="produtos-cadastrados" class="table-list">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nome</th>
                                        <th>Descrição</th>
                                        <th>Categoria</th>
                                        <th>Preço</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <c:if test="${not empty produtos}">
                                    <c:forEach items="${produtos}" var="p">
                                        <tr>
                                            <td>${p.id}</td>
                                            <td>${p.nome}</td>
                                            <td>${p.descricao}</td>
                                            <td>${p.categoria.descricao}</td>
                                            <td>${p.precoFormatado}</td>
                                            <td><button  class="btn btn-info" id=btn-detalhes" onclick="mostraDetalhe(${p.id});">Detalhes</button></td>
                                            <td><a href="<c:url value="/produto/carrinho/${p.id}/adicionar" />"><button  class="btn btn-success" id=btn-comprar">Comprar</button></a></td>   
                                            </tr>

                                    </c:forEach>
                                </c:if>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="overlay">
            <div>
                <h3>Detalhes do produto</h3>
                ID: <span id="pID"></span> <br>
                NOME: <span id="pNOME"></span> <br>
                DESCRIÇÃO: <span ID="pDESCRICAO"></span> <br>
                PREÇO: <span id="pPRECO"></span> <br>
                <button id="btn-fechar">Fechar</button>
            </div>
        </div>
        <script src="<c:url value="/js/jquery.js"/>"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="<c:url value="/js/script.js"/>"></script>
    </body>
</html>
