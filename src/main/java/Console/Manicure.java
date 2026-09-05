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
 * Mapeada para a tabela 'manicure'.
 * * @author FixHappy
 */
@Entity
@Table(name = "manicure")
public class Manicure {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_manicure")
    private int idManicure;
    
    @Column (name = "nome")
    private String nome;
    
    @Column (name = "data_nascimento")
    private String data_nascimento;
    
    @Column (name = "cpf")
    private String cpf;
    
    @Column (name = "gmail")
    private String gmail;
    
    @Column (name = "salao_idSalao")
    private Integer Salao_id;
    
    @Column (name = "telefone")
    private String telefone;
    
    
    
    // ID
    public int getIdManicure(){
        return idManicure;
    }
    public void setIdManicure(int idManicure){
        this.idManicure = idManicure;
    }
    
    // NOME
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    // DATA_NASCIMENTO
    public String getData_Nascimento(){
        return data_nascimento;
    }
    public void setData_Nascimento(String data_nascimento){
        this.data_nascimento = data_nascimento;
    }
    
    // CPF
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    // GMAIL
    public String getGmail(){
        return gmail;
    }
    public void setGmail(String gmail){
        this.gmail = gmail;
    }
    
    // SALAO_ID
    public Integer getSalao_id(){
        return Salao_id;
    }
    public void setSalao_id(Integer Salao_id){
        this.Salao_id = Salao_id;
    }
    
    // TELEFONE
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
