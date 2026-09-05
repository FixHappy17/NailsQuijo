package Console;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda")
    private int idAgenda;

    @Temporal(TemporalType.DATE)
    @Column(name = "agendamento")
    private Date agendamento;

    @Column(name = "horario")
    private Time horario;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "manicure_id")
    private Manicure manicure;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servicos servico;
    
    
    @Column(name = "realizado")
    private String realizado;

    
    
    
    public Agenda() {
    }

    // Getters e Setters

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Date getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Date agendamento) {
        this.agendamento = agendamento;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Manicure getManicure() {
        return manicure;
    }

    public void setManicure(Manicure manicure) {
        this.manicure = manicure;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }
    
    
    public String getRealizado(){
        return realizado;
    }
    public void setRealizado(String realizado){
        this.realizado = realizado;
    }
}