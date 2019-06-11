package ufjf.dcc193.tr2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Revisao
 */
@Entity
public class Revisao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int nota;
    private String descricao;
    private int status;

    
    @ManyToOne
    private Avaliador avaliador;

    @ManyToOne
    private Trabalho trabalho;


    public Revisao() {

    }

    public Revisao(Avaliador avaliador, Trabalho trabalho, int nota, String descricao, int status) {
        this.avaliador = avaliador;
        this.trabalho = trabalho;
        this.nota = nota;
        this.descricao = descricao;
        this.status = status;

    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Avaliador getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Avaliador avaliador) {
        this.avaliador = avaliador;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", avaliador='" + getAvaliador().toString() + "'" +
            ", trabalho='" + getTrabalho().toString() + "'" +
            ", nota='" + getNota() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}