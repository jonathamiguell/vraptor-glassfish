/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.edu.utfpr.model.CarrinhoDeCompras;
import javax.inject.Inject;

/**
 *
 * @author marcio
 */
@Controller
public class IndexController {
    
    private CarrinhoDeCompras carrinho;
    private Result result;

    public IndexController() {
        this(null, null);
    }
    @Inject
    public IndexController(CarrinhoDeCompras carrinho, Result result) {
        this.result = result;
        this.carrinho = carrinho;
    }
    
    @Path("/")
    public void index(){
        result.include("carrinho", carrinho);
    }
}
