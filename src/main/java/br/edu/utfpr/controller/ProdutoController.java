/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.utfpr.dao.CategoriaDao;
import br.edu.utfpr.dao.ProdutoDao;
import br.edu.utfpr.model.CarrinhoDeCompras;
import br.edu.utfpr.model.Categoria;
import br.edu.utfpr.model.Produto;
import javax.inject.Inject;

/**
 *
 * @author Joao Henrique
 */
@Controller
public class ProdutoController {

    private ProdutoDao dao;
    private CategoriaDao cdao;
    private Result result;
    private CarrinhoDeCompras carrinho;

    public ProdutoController() {
        this(null, null, null, null);
    }

    @Inject
    public ProdutoController(Result result, ProdutoDao dao, CategoriaDao cdao, CarrinhoDeCompras carrinho) {
        this.result = result;
        this.dao = dao;
        this.cdao = cdao;
        this.carrinho = carrinho;
    }

    @Path("/produto")
    public void index() {
        result.include("categorias", cdao.listaTodos());
        result.include("produtos", dao.listaTodos());
        result.include("carrinho", carrinho);
    }

    @Post("/produto/salvar")
    public void salvar(Produto p) {
        dao.adicionar(p);
        result.include("mensagem", "Produto adicionado com Sucesso").redirectTo(this).index();
//        result.forwardTo(this).index();
    }

   

    @Get("/produto/{id}/produto.json")
    public void produtoID(Long id) {
        Produto produto = dao.listarId(id);
        result.use(Results.json()).indented().from(produto).serialize();
    }

  
    @Get("/produto/carrinho/{id}/adicionar")
    public void adicionaNoCarrinho(Long id) {
        Produto p = dao.listarId(id);
        carrinho.adicionaItem(p);
        result.redirectTo(IndexController.class).index();
    }

    @Get("/produto/carrinho/clear")
    public void clear() {
        carrinho.encerraCarrinho();
        result.redirectTo(IndexController.class).index();
    }

  

 

}
