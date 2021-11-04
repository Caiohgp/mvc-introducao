package br.com.caiohenriquedev.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class Usuario {
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;
    @NotBlank
    @Size(min = 3, max = 50)
    private String sobrenome;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "O campo Data de Nascimento é requerido")
    private LocalDate dtNascimento;
    private TipoSexo tipoSexo;

    public Usuario(){

    }

    public Usuario(Long id, String nome, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Usuario(Long id, String nome, String sobrenome, LocalDate dtNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dtNascimento = dtNascimento;
    }

    public Usuario(Long id, String nome, String sobrenome, LocalDate dtNascimento, TipoSexo tipoSexo) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dtNascimento = dtNascimento;
        this.tipoSexo = tipoSexo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public TipoSexo getTipoSexo() {
        return tipoSexo;
    }

    public void setTipoSexo(TipoSexo tipoSexo) {
        this.tipoSexo = tipoSexo;
    }
}
