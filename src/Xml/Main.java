package Xml;

import Principal.Init;

public class Main {
	
	public static void main(String[]args){
	
		FileOpen Arquivo = FileOpen.getInstance();
		String frase = Arquivo.lerArquivo();
		
		Init.getInstance().ExecucaoXML("Amanhã é novo dia");
	
	}

}
