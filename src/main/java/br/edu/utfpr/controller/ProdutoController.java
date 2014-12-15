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
import br.edu.utfpr.dao.ProdutoDao;
import br.edu.utfpr.model.CarrinhoDeCompras;
import br.edu.utfpr.model.Produto;
import javax.inject.Inject;

/**
 *
 * @author Joao Henrique
 */
@Controller
public class ProdutoController {
    

    private ProdutoDao dao;
    private Result result;
    private CarrinhoDeCompras carrinho;
    
    public ProdutoController(){
        this(null, null, null);
    }
    
    @Inject
    public ProdutoController(Result result, ProdutoDao dao, CarrinhoDeCompras carrinho){
       this.result =  result;
       this.dao = dao;          
       this.carrinho = carrinho;
    }
    @Get("/produto")
    public void index(){
        result.include("produtos", dao.listaTodos());
        result.include("carrinho", carrinho);
    }
    
    @Post("/produto/adicionar")
    public void adicionar(Produto p){
        dao.adicionar(p);
        result.include("mensagem", "Produto adicionado com Sucesso").redirectTo(this).index();
//        result.forwardTo(this).index();
    }
     @Get("/carrinho/{id}/adicionar")
    public void adicionaNoCarrinho(Long id){
        Produto p = dao.listarId(id);
        carrinho.adicionaItem(p);
        result.redirectTo(ProdutoController.class).index();
    }
    
    @Get("/carrinho/clear")
    public void clear(){
        carrinho.encerraCarrinho();
        result.redirectTo(ProdutoController.class).index();
    }
    @Get("/{id}/produto.json")
    public void produtoID(Long id){
        Produto produto = dao.listarId(id);
        result.use(Results.json()).indented().from(produto).serialize();
    }
//    @Get("/produtos/{produto.id}")
//    public void visualiza(Produto produto) { 
//    
//    }
//    @Put("/produtos/{produto.id}")

    /**
     *
     * @param id
     */
    @Get("/cart/{id}/adicionar")
    public void adddNoCarrinho(Long id){
        Produto p = dao.listarId(id);
        carrinho.adicionaItem(p);
        result.redirectTo(ProdutoController.class).index();
    }
    
    public Produto editar(Long id) { 
        Produto p = dao.listarId(id);
        return p;

    }
    public void altera(Produto p){
        dao.adicionar(p);
        result.forwardTo(this).index();
    }
//    
//    @Delete ("/produtos")
//    @Path("remover")
    
    @Get("/produto/{id}/remover")
    public void remover(Long id) { 
        dao.remover(id);
        result.forwardTo(this).index();
//    
    }
    
}
