/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.utfpr.dao.UsuarioDao;
import br.edu.utfpr.model.Usuario;
import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author Joao Henrique
 */
@Controller
public class UsuariosController {
    
//    @Inject
//    private UsuarioDao dao;
//    
//    @Inject
//    private Result result;
//    
//    public List<Usuario> usuarios(){
//        return dao.listaTodos();
//    }
//     public void adiciona(Usuario usuario){
//        dao.adicionar(usuario);
//        result.redirectTo(UsuariosController.class).usuarios();
//    }
}
