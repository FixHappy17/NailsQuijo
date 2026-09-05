/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Console;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe que representa a entidade Manicure no banco de dados.
 * Mapeada para a tabela 'produto'.
 * * @author FixHappy
 */
@Entity
@Table(name = "produtos")
public class Produtos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private int idProdutos;
    
    @Column (name = "categoria")
    private String categoria;
    
    @Column (name = "nome")
    private String nome;
    
    @Column (name = "quantidade")
    private Integer quantidade;
    
    @Column (name = "marca")
    private String marca;
    
    
    
    
    // ID
    public int getIdProdutos(){
        return idProdutos;
    }
    public void setIdProdutos(int idProdutos){
        this.idProdutos = idProdutos;
    }
    
    // CATEGORIA
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    // NOME
     public String getNome(){
         return nome;
     }
     public void setNome(String nome){
         this.nome = nome;
     }
     
     // QUANTIDADE
     public Integer getQuantidade(){
         return quantidade;
     }
     public void setQuantidade(Integer quantidade){
         this.quantidade = quantidade;
     }
     
     // MARCA
     public String getMarca(){
         return marca;
     }
     public void setMarca(String marca){
         this.marca = marca;
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
