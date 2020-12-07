package manager;

import java.util.ArrayList;

import models.Arquivo;
import manager.CabecalhoManager;

public class ArquivoManager {

    private ArrayList<Arquivo> arquivos;
    private CabecalhoManager cabecalho;

    public ArquivoManager() {
    }
    
    public ArquivoManager(CabecalhoManager cabecalho, ArrayList<Arquivo> arquivos) {
        this.arquivos = arquivos;
        this.cabecalho = cabecalho;
    }
    
    public ArquivoManager(String nome, String caminhoOrigem, String caminhoAtual) {
        this.cabecalho = new CabecalhoManager(0, 0);
        this.arquivos = new ArrayList<Arquivo>();
        this.cabecalho.setNome(nome);
        this.cabecalho.setCaminhoOrigem(caminhoOrigem);
        this.cabecalho.setCaminhoAtual(caminhoAtual);
    }

	public ArrayList<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(ArrayList<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}

	public CabecalhoManager getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(CabecalhoManager cabecalho) {
		this.cabecalho = cabecalho;
	} 
	
	public boolean temEspacoVazioMaior(Arquivo a) {
        for (Arquivo arq : this.arquivos) {
            if (arq.isVazio() && arq.getCabecalho().getTamanhoArquivo() >= a.getCabecalho().getTamanhoArquivo()) return true;
        }
        
        return false;
    }
    
}
