package br.com.fabio.hospital.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="internacao")
public class Internacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String justificativa;

    @Column(name="data_internacao")
    private LocalDate dataInternacao;

    @Column(name="data_alta")
    private LocalDate dataAlta;

    private BigDecimal valor;

    private String observacao;

    @Enumerated(EnumType.STRING)
    private TipoInternacao tipo_internacao;

    @ManyToOne
    @JoinColumn(name="id_especialidade")
    private Especialidade especialidade;

    @ManyToOne
    @JoinColumn(name="id_paciente")
    private Paciente paciente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public LocalDate getDataInternacao() {
        return dataInternacao;
    }

    public void setDataInternacao(LocalDate dataInternacao) {
        this.dataInternacao = dataInternacao;
    }

    public LocalDate getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDate dataAlta) {
        this.dataAlta = dataAlta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoInternacao getTipo() {
        return tipo_internacao;
    }

    public void setTipo(TipoInternacao tipo) {
        this.tipo_internacao = tipo;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Internacao that = (Internacao) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (justificativa != null ? !justificativa.equals(that.justificativa) : that.justificativa != null)
            return false;
        if (dataInternacao != null ? !dataInternacao.equals(that.dataInternacao) : that.dataInternacao != null)
            return false;
        if (dataAlta != null ? !dataAlta.equals(that.dataAlta) : that.dataAlta != null) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;
        if (observacao != null ? !observacao.equals(that.observacao) : that.observacao != null) return false;
        if (tipo_internacao != that.tipo_internacao) return false;
        if (especialidade != null ? !especialidade.equals(that.especialidade) : that.especialidade != null)
            return false;
        return paciente != null ? paciente.equals(that.paciente) : that.paciente == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (justificativa != null ? justificativa.hashCode() : 0);
        result = 31 * result + (dataInternacao != null ? dataInternacao.hashCode() : 0);
        result = 31 * result + (dataAlta != null ? dataAlta.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (observacao != null ? observacao.hashCode() : 0);
        result = 31 * result + (tipo_internacao != null ? tipo_internacao.hashCode() : 0);
        result = 31 * result + (especialidade != null ? especialidade.hashCode() : 0);
        result = 31 * result + (paciente != null ? paciente.hashCode() : 0);
        return result;
    }
}
