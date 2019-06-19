package ufjf.dcc193.tr2.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.persistence.Entity;

/**
 * Avaliador
 */
@Entity
public class Avaliador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @NotBlank(message = "Campo obrigatório")
    private String email;
    @NotBlank(message = "Campo obrigatório")
    private String codigoAcesso;

    @ManyToMany
    private List<AreaConhecimento> areaConhecimento;

    public Avaliador() {
    }

    public Avaliador(Long id, String nome, String email, String codigoAcesso, List<AreaConhecimento> areaConhecimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.codigoAcesso = codigoAcesso;
        this.areaConhecimento = areaConhecimento;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoAcesso() {
        return this.codigoAcesso;
    }

    public void setCodigoAcesso(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
    }

    public List<AreaConhecimento> getAreaConhecimento() {
        return this.areaConhecimento;
    }

    public void setAreaConhecimento(List<AreaConhecimento> areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", nome='" + getNome() + "'" + ", email='" + getEmail() + "'"
                + ", codigoAcesso='" + getCodigoAcesso() + "'" + ", areaConhecimento='" + getAreaConhecimento() + "'"
                + "}";
    }
}