package Xml;

import java.util.ArrayList;
import java.util.regex.Pattern;

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
		
		/*
		
		String palavrinha = Init.getInstance().NERwiki();
		String Alt[] = palavrinha.split(Pattern.quote(">"));
		StringBuffer aux = new StringBuffer();
		aux.append("<link rel=\"canonical\"");
		String tag = "";
		for(int i=0;i<Alt.length;i++){
			if(Alt[i].contains(aux)){
				tag = Alt[i];
			}
		}
		System.out.println(tag);
		*/
		/*
		String stringURL = "https://pt.wikipedia.org/w/index.php?search=";
		stringURL = stringURL.concat("okok");
		System.out.println(stringURL);
		*/
		
		//Init.getInstance().NERwiki("mateus");
		
		//System.out.println(result);
		
		Init.getInstance().MAINxml("Olá Mateus matrata está erro fazendo algo.");
		System.out.println("Palavras no DIc: "+ Init.getInstance().toStringPalavrasDIC());
		System.out.println("Palavras ner: "+ Init.getInstance().toStringNERList());
		System.out.println("Palavras fora do dic: "+Init.getInstance().toStringPalavrasForaDIC());
	}

}
