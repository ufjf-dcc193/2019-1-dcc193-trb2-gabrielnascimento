package ufjf.dcc193.tr2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Trabalho
 */
@Entity
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;

    @OneToOne
    private AreaConhecimento areaConhecimento;
    
    public Trabalho() {

    }

    public Trabalho(Long id, String titulo, String descricao, String url, AreaConhecimento areaConhecimento) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.areaConhecimento = areaConhecimento;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AreaConhecimento getAreaConhecimento() {
        return this.areaConhecimento;
    }

    public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    @Override
    public String toString() {
        return "{id='" + getId() + "'" +", titulo='" + getTitulo() + "'" +
            ", descricao='" + getDescricao() + "', url='" + getUrl() + "'" +
            ", areaConhecimento='" + getAreaConhecimento() + "'}";
    }
}