/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Joao Henrique
 */
@Stateless
public class CategoriaDao {
    @PersistenceContext
    private EntityManager manager;

    public CategoriaDao() { }
    
    
    public List<Categoria> listaTodos(){
        Query q = manager.createQuery("SELECT c FROM Categoria c");      
        return q.getResultList();
    }
    public void adicionar(Categoria c){
          if (c.getId()==null){
            manager.persist(c);
        }else{
            manager.merge(c);
        }
    
    }
     public Categoria listarId(Long id){
    
        return manager.find(Categoria.class, id);
    }
    
}
