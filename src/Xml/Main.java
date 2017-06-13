package Xml;

import java.util.ArrayList;

import Principal.Init;

public class Main {
	
	public static void main(String[]args){
	
	/*
		ArrayList<String> frase = FileOpen.getInstance().lerArquivo();
		
		String textoConcatenado = "";
		for(byte x=0;x<frase.size();x++){
			if(x==0)
				textoConcatenado.concat(frase.get(x));
			else
				textoConcatenado.concat(" "+frase.get(x));
		}
		
		
		// teste de busca no xml
		Init.getInstance().ExecucaoXML("abacaxi bloco");
	*/
		
		Init.getInstance().NERwiki();
	}

}
