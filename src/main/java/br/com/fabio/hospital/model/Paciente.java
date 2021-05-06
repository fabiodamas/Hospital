package br.com.fabio.hospital.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String nome;

    @Embedded
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @NotNull
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paciente that = (Paciente) o;

        if (!id.equals(that.id)) return false;
        return nome != null ? nome.equals(that.nome) : that.nome == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }

}
