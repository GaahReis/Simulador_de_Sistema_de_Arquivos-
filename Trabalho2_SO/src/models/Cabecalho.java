package models;

import java.util.Date;

public class Cabecalho {
	
	private String nome;
    private String caminhoOrigem;
    private Date dataCriacao;
    private int tamanhoArquivo;
	
    public Cabecalho() {
    }

    public Cabecalho(String nome, String caminhoOrigem, Date dataCriacao, int tamanhoArquivo) {
        this.nome = nome;
        this.caminhoOrigem = caminhoOrigem;
        this.dataCriacao = dataCriacao;
        this.tamanhoArquivo = tamanhoArquivo;
    }
    
    public String getNome() {        
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCaminhoOrigem() {
        return caminhoOrigem;
    }

    public void setCaminhoOrigem(String caminhoOrigem) {
        this.caminhoOrigem = caminhoOrigem;
    }

    
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public int getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(int tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
    
	public int getPosicaoExtensao() {
        int i = 0;
        for (i = this.getNome().length() - 1; this.getNome().charAt(i) != '.'; i--) {  }
        return i;
    }
    
    public String getExtensao(boolean vazio) {
        
        if (vazio) {
            return "";
        }
        
        int i = 0;
        
        for (i = this.getNome().length() - 1; this.getNome().charAt(i) != '.'; i--) {  }
        
        String extensao = this.getNome().substring(i);
        
        return extensao;
    }	
    
}
