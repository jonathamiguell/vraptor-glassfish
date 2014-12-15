/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.utfpr.dao.CategoriaDao;
import br.edu.utfpr.model.Categoria;
import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author Joao Henrique
 */
@Controller
public class CategoriaController {
    
    private CategoriaDao dao;
    private Result result;
    
    public CategoriaController() {
        this(null,null);
    }
    @Inject
    public CategoriaController(Result result, CategoriaDao dao) {
        this.result = result;
        this.dao = dao;
    }
    @Path("/categoria")
    public void formulario(){
        result.include("categorias", dao.listaTodos());
    }
    
    @Post("/categoria/salvar")
    public void salvar(Categoria categoria){
        dao.adicionar(categoria);
        result.include("mensagem", "Categoria cadastrada com sucesso!").redirectTo(this).formulario();
    }
}
