package manager;

import models.Cabecalho;

public class CabecalhoManager extends Cabecalho {
	
	private int qtdArquivos;
    private int tamArquivo;
    private String caminhoAtual;
    
    public CabecalhoManager() {
    }
	
	public CabecalhoManager(int qtdArquivos, int tamArquivo) {
		this.qtdArquivos = qtdArquivos;
		this.tamArquivo = tamArquivo;
	}

	public int getQtdArquivos() {
		return qtdArquivos;
	}

	public void setQtdArquivos(int qtdArquivos) {
		this.qtdArquivos = qtdArquivos;
	}

	public int getTamArquivo() {
		return tamArquivo;
	}

	public void setTamArquivo(int tamArquivo) {
		this.tamArquivo = tamArquivo;
	}

	public String getCaminhoAtual() {
		return caminhoAtual;
	}

	public void setCaminhoAtual(String caminhoAtual) {
		this.caminhoAtual = caminhoAtual;
	}

}
