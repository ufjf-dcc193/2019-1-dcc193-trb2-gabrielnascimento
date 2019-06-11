package ufjf.dcc193.tr2.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * AreaConhecimento
 */
@Entity
public class AreaConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String descricao;

    public AreaConhecimento() {
    }

    public AreaConhecimento(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public AreaConhecimento id(Long id) {
        this.id = id;
        return this;
    }

    public AreaConhecimento descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public String toString() {
        return "{id='" + getId() + "'" + ", descricao='" + getDescricao() + "'}";
    }
}