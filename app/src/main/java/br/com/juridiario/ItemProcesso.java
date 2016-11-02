package br.com.juridiario;

import java.io.Serializable;

/**
 * Created by PCAC on 19/10/2016.
 */
public class ItemProcesso implements Serializable{

    private String desEdicaoCompleta;
    private String processoTexto;
    private String desAdvogado;
    private String numeroProcesso;
    private String desEdicao;
    private Integer codId;

    public ItemProcesso() {
    }

    public ItemProcesso(String desEdicaoCompleta, String processoTexto, String desAdvogado, String numeroProcesso, String desEdicao, Integer codId) {
        this.desEdicaoCompleta = desEdicaoCompleta;
        this.processoTexto = processoTexto;
        this.desAdvogado = desAdvogado;
        this.numeroProcesso = numeroProcesso;
        this.desEdicao = desEdicao;
        this.codId = codId;
    }

    public ItemProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getDesEdicaoCompleta() {
        return desEdicaoCompleta;
    }

    public void setDesEdicaoCompleta(String desEdicaoCompleta) {
        this.desEdicaoCompleta = desEdicaoCompleta;
    }

    public String getProcessoTexto() {
        return processoTexto;
    }

    public void setProcessoTexto(String processoTexto) {
        this.processoTexto = processoTexto;
    }

    public String getDesAdvogado() {
        return desAdvogado;
    }

    public void setDesAdvogado(String desAdvogado) {
        this.desAdvogado = desAdvogado;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getDesEdicao() {
        return desEdicao;
    }

    public void setDesEdicao(String desEdicao) {
        this.desEdicao = desEdicao;
    }

    public Integer getCodId() {
        return codId;
    }

    public void setCodId(Integer codId) {
        this.codId = codId;
    }
}