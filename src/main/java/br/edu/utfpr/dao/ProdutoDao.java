/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.model.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author Joao Henrique
 */
@Stateless
public class ProdutoDao {
    
    @PersistenceContext
    private EntityManager manager;
    
    
    public ProdutoDao(){
    }
    
    
    public List<Produto> listaTodos(){
        Query q = manager.createQuery("SELECT p FROM Produto p");      
        return q.getResultList();
//        return null;
    }
    public Produto listarId(Long id){
    
        return manager.find(Produto.class, id);
    }
    public void adicionar(Produto p){
        if (p.getId()==null){
            manager.persist(p);
        }else{
            manager.merge(p);
        }
    
    }
    public Produto busca(Produto p){
        return manager.find(Produto.class, p.getId());
    }
    public void editar(Produto p){
        manager.merge(p);
        
    
    }
    public void remover(Long id){
        manager.remove(id);
    
    }
    
}
