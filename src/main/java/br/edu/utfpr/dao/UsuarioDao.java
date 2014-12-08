/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Joao Henrique
 */
@Stateless
public class UsuarioDao {
   private EntityManager manager;

    public UsuarioDao() { }
    
    
    public List<Usuario> listaTodos(){
        Query q = manager.createQuery("SELECT u FROM Usuario u");      
        return q.getResultList();
    }
    public void adicionar(Usuario usuario){
        manager.persist(usuario);
    
    }
     public Usuario listarId(Long id){
    
        return manager.find(Usuario.class, id);
    }
    
}
