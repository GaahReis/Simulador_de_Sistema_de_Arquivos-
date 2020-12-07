package application;

import helper.ArquivoHelper;
import manager.ArquivoManager;
import models.Arquivo;

public class ArquivoController {
	
    public ArquivoController() { }

    public static void insereArquivo(ArquivoManager arqM, Arquivo a) {
        
        if (arqM.temEspacoVazioMaior(a)) {
            
            int i;
            
            for (i = 0; i < arqM.getArquivos().size(); i++) {
                if (arqM.getArquivos().get(i).isVazio() && arqM.getArquivos().get(i).getCabecalho().getTamanhoArquivo() >= a.getCabecalho().getTamanhoArquivo()) {
                    break;
                }
            }
            
            int diffTamanho = arqM.getArquivos().get(i).getCabecalho().getTamanhoArquivo() - a.getCabecalho().getTamanhoArquivo();
            int posicaoInserir = i;
            int aux;
            
            for (i = posicaoInserir; i < arqM.getArquivos().size(); i++) {
            	
                if (arqM.getArquivos().get(i).isVazio() && arqM.getArquivos().get(i).getCabecalho().getTamanhoArquivo() >= a.getCabecalho().getTamanhoArquivo()) {
                    aux = arqM.getArquivos().get(i).getCabecalho().getTamanhoArquivo() - a.getCabecalho().getTamanhoArquivo();
                    if (aux < diffTamanho) {
                        diffTamanho = aux;
                        posicaoInserir = i;
                    }
                }
            }
            
            if (diffTamanho == 0) {
                arqM.getArquivos().remove(posicaoInserir);
            } else {
                arqM.getArquivos().get(posicaoInserir).getCabecalho().setTamanhoArquivo(diffTamanho);
            }
            
            arqM.getArquivos().add(posicaoInserir, a);
            
        } else {
            arqM.getArquivos().add(a);
        }
        
        ArquivoHelper.gravarEmArquivo(arqM);
    }
    
    public static void removeArquivoByPos(ArquivoManager arqM, int posicao) {
       
        Arquivo arqRemovido = arqM.getArquivos().get(posicao);
        
        arqM.getArquivos().set(posicao, new Arquivo(true, arqRemovido.getConteudo()));
        
        ArquivoHelper.gravarEmArquivo(arqM);
    }
}
