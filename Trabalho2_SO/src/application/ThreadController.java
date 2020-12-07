package application;

import java.util.ArrayList;
import java.util.List;

import helper.ArquivoHelper;
import manager.ArquivoManager;
import models.Arquivo;

public class ThreadController {
	public static void desfragmentar(ArquivoManager arqM) {
        
        List<Integer> posArquivosVazios = new ArrayList<>();
        int i = 0;
        
        for (Arquivo arq : arqM.getArquivos()) {
            if (arq.isVazio()) {
                posArquivosVazios.add(i);
            }
            i++;
        }
        
        for (i = posArquivosVazios.size() - 1; i >= 0; i--) {
            int pos = posArquivosVazios.get(i);
            arqM.getArquivos().remove(pos);
        }
        
        ArquivoHelper.gravarEmArquivo(arqM);
        
    }
    
    public static void limpar(ArquivoManager arqM) {
        
        arqM.setArquivos(new ArrayList<Arquivo>());
        
        ArquivoHelper.gravarEmArquivo(arqM);
        
    }
}
