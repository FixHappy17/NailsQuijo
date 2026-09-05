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
 * Mapeada para a tabela 'cliente'.
 * * @author FixHappy
 */
@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idCliente;
    
    @Column (name = "nome")
    private String nome;
    
    @Column (name = "cpf")
    private String cpf;
    
    @Column (name = "gmail")
    private String gmail;
    
    @Column (name = "telefone")
    private String telefone;
    
    
    
    //IdCliente
    public int getIdCliente (){
        return idCliente;
    }
    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;         
    }
    
    
    // nome
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    // cpf
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    // gmail
    public String getGmail(){
        return gmail;
    }
    public void setGmail(String gmail){
        this.gmail = gmail;
    }
    
    // Telefone
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    
    @Override
    public String toString(){
        return this.nome;
    }
}
