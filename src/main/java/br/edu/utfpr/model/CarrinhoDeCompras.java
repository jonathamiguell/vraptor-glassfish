/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import br.edu.utfpr.model.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Joao Henrique
 */
@SessionScoped
public class CarrinhoDeCompras implements Serializable {

    private List<Produto> itens = new ArrayList<Produto>();
    private String total;

    public CarrinhoDeCompras() {
    }

    public void adicionaItem(Produto item) {
        if (!itens.contains(item)) {
            itens.add(item);
        }
    }

    public void removeItem(Long id) {
        for (Produto p : itens) {
            if(p.getId().equals(id)) {
                itens.remove(p);
                break;
            }
        }
    }

    public void encerraCarrinho() {
        itens.clear();
    }

    public String getTotal() {
        Double t = 0.0;
        for (Produto p : itens) {
            t += p.getPreco().doubleValue();
        }
        return t + "";
    }

    public List<Produto> getTodosOsItens() {
        return itens;
    }
}
