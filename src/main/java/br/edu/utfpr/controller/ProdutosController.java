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
import br.edu.utfpr.model.Produto;
import javax.inject.Inject;

/**
 *
 * @author Joao Henrique
 */
@Controller
public class ProdutosController {
    

    private ProdutoDao dao;
    private Result result;
    
    public ProdutosController(){
        this(null, null);
    }
    
    @Inject
    public ProdutosController(Result result, ProdutoDao dao){
       this.result =  result;
       this.dao = dao;          
    }
    @Get("/")
    public void index(){
        result.include("produtos", dao.listaTodos());
    }
    
    @Post("adicionar")
    public void adicionar(Produto p){
        dao.adicionar(p);
//        result.include("mensagem", "Produto adicionado com Sucesso");
        result.forwardTo(this).index();
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
//    public void  editar(Produto p) { 
//        dao.editar(p);
//        result.forwardTo(this).index();
//
//    }
//    
//    @Delete
//    @Path("remover")
//    public void remover(Long id) { 
//        dao.remover(id);
//        result.forwardTo(this).index();
//    
//    }
    
}
