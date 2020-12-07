package models;

public class Arquivo {
	

    private boolean vazio;
    private Cabecalho cabecalho;   
    private byte[] conteudo;
    
    public Arquivo() {
    }
    
	public Arquivo(boolean vazio, byte[] conteudo) {
		this.vazio = vazio;
		this.conteudo = conteudo;
		this.cabecalho = new Cabecalho("<vazio>", "", null, this.conteudo.length);
	}

	public boolean isVazio() {
		return vazio;
	}

	public void setVazio(boolean vazio) {
		this.vazio = vazio;
	}

	public Cabecalho getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(Cabecalho cabecalho) {
		this.cabecalho = cabecalho;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}
 
}
