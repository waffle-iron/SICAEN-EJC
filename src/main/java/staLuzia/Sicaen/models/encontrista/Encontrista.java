package staLuzia.Sicaen.models.encontrista;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by Henrique on 06/05/2016.
 */
@Entity
@Table(name="encontrista")
public class Encontrista implements Serializable{

    private static final long serialVersionUID = 6159794101653074086L;

    @Id
    @GeneratedValue
    private Integer id;
    private Boolean pgtInscricao;
    private String nome;
    private String apelido;
    private String relacionamento;
    private String dataNascimento;
    private String celular;
    private String whatsapp;
    private String nomeResponsavel1;
    private String telefoneResponsavel1;
    private String nomeResponsavel2;
    private String telefoneResponsavel2;
    private String email;
    private String tamanhoCamisa;

    private String problemaSaude;
    private String problemaAlimentar;

    private String endereco;
    private String complemento;
    private String cep;
    private String bairro;
    private String referencia;

    private String religiao;
    private String paroquia;
    private String sacramento;

    private String imagemPerfil;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPgtInscricao() {
        return pgtInscricao;
    }

    public void setPgtInscricao(Boolean pgtInscricao) {
        this.pgtInscricao = pgtInscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(String relacionamento) {
        this.relacionamento = relacionamento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getNomeResponsavel1() {
        return nomeResponsavel1;
    }

    public void setNomeResponsavel1(String nomeResponsavel1) {
        this.nomeResponsavel1 = nomeResponsavel1;
    }

    public String getTelefoneResponsavel1() {
        return telefoneResponsavel1;
    }

    public void setTelefoneResponsavel1(String telefoneResponsavel1) {
        this.telefoneResponsavel1 = telefoneResponsavel1;
    }

    public String getNomeResponsavel2() {
        return nomeResponsavel2;
    }

    public void setNomeResponsavel2(String nomeResponsavel2) {
        this.nomeResponsavel2 = nomeResponsavel2;
    }

    public String getTelefoneResponsavel2() {
        return telefoneResponsavel2;
    }

    public void setTelefoneResponsavel2(String telefoneResponsavel2) {
        this.telefoneResponsavel2 = telefoneResponsavel2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTamanhoCamisa() {
        return tamanhoCamisa;
    }

    public void setTamanhoCamisa(String tamanhoCamisa) {
        this.tamanhoCamisa = tamanhoCamisa;
    }

    public String getProblemaSaude() {
        return problemaSaude;
    }

    public void setProblemaSaude(String problemaSaude) {
        this.problemaSaude = problemaSaude;
    }

    public String getProblemaAlimentar() {
        return problemaAlimentar;
    }

    public void setProblemaAlimentar(String problemaAlimentar) {
        this.problemaAlimentar = problemaAlimentar;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getReligiao() {
        return religiao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public String getParoquia() {
        return paroquia;
    }

    public void setParoquia(String paroquia) {
        this.paroquia = paroquia;
    }

    public String getSacramento() {
        return sacramento;
    }

    public void setSacramento(String sacramento) {
        this.sacramento = sacramento;
    }

    public String getImagemPerfil() {
        return imagemPerfil;
    }

    public void setImagemPerfil(String imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }


    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Encontrista that = (Encontrista) o;

        if (!id.equals(that.id)) return false;
        if (!pgtInscricao.equals(that.pgtInscricao)) return false;
        if (!nome.equals(that.nome)) return false;
        if (!apelido.equals(that.apelido)) return false;
        if (!relacionamento.equals(that.relacionamento)) return false;
        if (!dataNascimento.equals(that.dataNascimento)) return false;
        if (!celular.equals(that.celular)) return false;
        if (!whatsapp.equals(that.whatsapp)) return false;
        if (!nomeResponsavel1.equals(that.nomeResponsavel1)) return false;
        if (!telefoneResponsavel1.equals(that.telefoneResponsavel1)) return false;
        if (!nomeResponsavel2.equals(that.nomeResponsavel2)) return false;
        if (!telefoneResponsavel2.equals(that.telefoneResponsavel2)) return false;
        if (!email.equals(that.email)) return false;
        if (!tamanhoCamisa.equals(that.tamanhoCamisa)) return false;
        if (!problemaSaude.equals(that.problemaSaude)) return false;
        if (!problemaAlimentar.equals(that.problemaAlimentar)) return false;
        if (!endereco.equals(that.endereco)) return false;
        if (!complemento.equals(that.complemento)) return false;
        if (!cep.equals(that.cep)) return false;
        if (!bairro.equals(that.bairro)) return false;
        if (!referencia.equals(that.referencia)) return false;
        if (!religiao.equals(that.religiao)) return false;
        if (!paroquia.equals(that.paroquia)) return false;
        if (!sacramento.equals(that.sacramento)) return false;
        return imagemPerfil.equals(that.imagemPerfil);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + pgtInscricao.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + apelido.hashCode();
        result = 31 * result + relacionamento.hashCode();
        result = 31 * result + dataNascimento.hashCode();
        result = 31 * result + celular.hashCode();
        result = 31 * result + whatsapp.hashCode();
        result = 31 * result + nomeResponsavel1.hashCode();
        result = 31 * result + telefoneResponsavel1.hashCode();
        result = 31 * result + nomeResponsavel2.hashCode();
        result = 31 * result + telefoneResponsavel2.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + tamanhoCamisa.hashCode();
        result = 31 * result + problemaSaude.hashCode();
        result = 31 * result + problemaAlimentar.hashCode();
        result = 31 * result + endereco.hashCode();
        result = 31 * result + complemento.hashCode();
        result = 31 * result + cep.hashCode();
        result = 31 * result + bairro.hashCode();
        result = 31 * result + referencia.hashCode();
        result = 31 * result + religiao.hashCode();
        result = 31 * result + paroquia.hashCode();
        result = 31 * result + sacramento.hashCode();
        result = 31 * result + imagemPerfil.hashCode();
        return result;
    }
}