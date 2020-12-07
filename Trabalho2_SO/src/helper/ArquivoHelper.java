package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import helper.ArquivoHelper;
import manager.ArquivoManager;
import models.Arquivo;
import models.Cabecalho;

public class ArquivoHelper {
	 public static ArquivoManager lerDeArquivoMestre(String pathArquivo) {
         
		 	ArquivoManager arqM = new ArquivoManager();
	        
	        try {
	        
	            FileInputStream arq = new FileInputStream(pathArquivo);
	            ObjectInputStream lerArq = new ObjectInputStream(arq);
	            
	            arqM = (ArquivoManager) lerArq.readObject();    
	            
	        } catch (FileNotFoundException ex) {
	            
	            System.out.println("Arquivo nao encontrado.");
	            
	        } catch (IOException ex) {
	            System.out.println("Fim do arquivo");
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(ArquivoHelper.class.getName()).log(Level.SEVERE, null, ex);
	        } 
	    
	        return arqM;
	        
	    }
	    
	    public static void gravarEmArquivo(ArquivoManager arqM) {

	        try {
	            
	            FileOutputStream arq = new FileOutputStream(arqM.getCabecalho().getCaminhoAtual().toString());
	            ObjectOutputStream gravarArq = new ObjectOutputStream(arq);
	            
	            gravarArq.writeObject(arqM);
	            
	        } catch (FileNotFoundException ex) {
	            
	            Logger.getLogger(ArquivoHelper.class.getName()).log(Level.SEVERE, null, ex);
	            
	        } catch (IOException ex) {
	            Logger.getLogger(ArquivoHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	    }
	    
	    public static ArquivoManager criarArquivoMestre(String nomeArquivo, String path) {
	        File arqM = new File(path + "/" + nomeArquivo);
	        
	        ArquivoManager arqMestre = new ArquivoManager(nomeArquivo, arqM.getAbsolutePath(), arqM.getAbsolutePath());
	        try {
	            arqM.createNewFile();
	        } catch (IOException ex) {
	            Logger.getLogger(ArquivoHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return arqMestre;
	    }
	    
	    public static Arquivo fileToArquivo(File f) {
	        
	        BasicFileAttributes attr = null;
	        Arquivo arq = new Arquivo();
	        
	        try {
	            attr = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
	            
	            arq.setConteudo(Files.readAllBytes(f.toPath()));
	            arq.setVazio(false);            
	             
	            Cabecalho cab = new Cabecalho();

	            cab.setNome(f.getName());
	            cab.setCaminhoOrigem(f.getAbsolutePath());
	            cab.setDataCriacao(new Date(attr.creationTime().toMillis()));
	            cab.setTamanhoArquivo(arq.getConteudo().length);
	            
	            arq.setCabecalho(cab);
	            
	            
	            
	        } catch (IOException ex) {
	            Logger.getLogger(ArquivoHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        return arq;
	    }
	    
	    public static void gravarEmArquivoSimples(Arquivo arqS, String path) {

	        try {

	            Files.write(Paths.get(path), arqS.getConteudo());
	            
	        } catch (IOException ex) {
	            Logger.getLogger(ArquivoHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	    }
}
