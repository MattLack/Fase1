package Principal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Init {

	private static Init instance = null;
	private static String[] Alfabeto = { "a", "b", "c", "ç", "d", "e", "f", "g", "h", "i", "j", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "x", "z", "k", "w", "y", "*" };
	private List<String> palavras = new ArrayList<String>();

	private Init() {
	}

	public static Init getInstance() {
		if (instance == null) {
			instance = new Init();
		}
		return instance;
	}

	private static void replaceAll(StringBuffer builder, String from, String to) {

		/**
		 * Dada uma string (builder), uma segunda string (form) será buscada
		 * dentro da anterior, e substituida por outra string (to)
		 */

		int index = builder.indexOf(from);
		while (index != -1) {
			builder.replace(index, index + from.length(), to);
			index += to.length();
			index = builder.indexOf(from, index);
		}
	}

	private static void replace(StringBuffer Alt1) {

		/**
		 * Subistitue .? sobrando no meio do texto para não atrapalhar na quebra
		 * de sentenças
		 */

		replaceAll(Alt1, ",", "");
		replaceAll(Alt1, ".", "");
		replaceAll(Alt1, ";", "");
		replaceAll(Alt1, ":", "");
		replaceAll(Alt1, "|", "");
		replaceAll(Alt1, "\"", "");
		replaceAll(Alt1, "'", "");
		replaceAll(Alt1, "?", "");
		replaceAll(Alt1, "/", "");
		replaceAll(Alt1, "]", "");
		replaceAll(Alt1, "}", "");
		replaceAll(Alt1, "~", "");
		replaceAll(Alt1, "^", "");
		replaceAll(Alt1, "[", "");
		replaceAll(Alt1, "{", "");
		replaceAll(Alt1, "º", "");
		replaceAll(Alt1, "ª", "");
		replaceAll(Alt1, "´", "");
		replaceAll(Alt1, "`", "");
		replaceAll(Alt1, "=", "");
		replaceAll(Alt1, "+", "");
		replaceAll(Alt1, "§", "");
		replaceAll(Alt1, "_", "");
		replaceAll(Alt1, ")", "");
		replaceAll(Alt1, "(", "");
		replaceAll(Alt1, "*", "");
		replaceAll(Alt1, "&", "");
		replaceAll(Alt1, "¨", "");
		replaceAll(Alt1, "¬", "");
		replaceAll(Alt1, "%", "");
		replaceAll(Alt1, "¢", "");
		replaceAll(Alt1, "$", "");
		replaceAll(Alt1, "£", "");
		replaceAll(Alt1, "#", "");
		replaceAll(Alt1, "@", "");
		replaceAll(Alt1, "!", "");
		replaceAll(Alt1, "°", "");
		replaceAll(Alt1, "1", "");
		replaceAll(Alt1, "2", "");
		replaceAll(Alt1, "3", "");
		replaceAll(Alt1, "4", "");
		replaceAll(Alt1, "5", "");
		replaceAll(Alt1, "6", "");
		replaceAll(Alt1, "7", "");
		replaceAll(Alt1, "8", "");
		replaceAll(Alt1, "9", "");
		replaceAll(Alt1, "0", "");
		replaceAll(Alt1, "¹", "");
		replaceAll(Alt1, "²", "");
		replaceAll(Alt1, "³", "");

	}

	public static void BuscaDicionario(String palavra) {
		String proxLetra = null;
		String proxLetraLida = null;

		palavra = palavra.substring(0, 1).toUpperCase() + palavra.substring(1).toLowerCase();

		String letra1 = palavra.substring(0, 1);
		String letra2 = palavra.substring(1, 2);

		for (int i = 0; i < 26; i++) {
			if (letra2.equals(Alfabeto[i])) {
				proxLetra = Alfabeto[i + 1];
			}
		}
		if (proxLetra.equals("*")) {
			proxLetra = Alfabeto[26];
		}

		BufferedReader leitor = null;
		StringBuffer aux = new StringBuffer();
		aux.append(palavra);
		int key = 0;

		try {

			leitor = new BufferedReader(new FileReader("src/Dicionario/"+letra1 + "saida.txt"));

			String linha = "";

			while (((linha = leitor.readLine()) != null) && !(proxLetra.equals(proxLetraLida)) && (key == 0)) {
				if (linha.length() > 0) {
					if (!(linha.substring(0, 1).equals("(")))
						if (!(linha.substring(1, 2).equals("(")))
							proxLetraLida = linha.substring(1, 2);
					// System.out.println(linha);
					if (linha.contains(aux)) {
						System.out.println(palavra + " está contida no dicionário");
						key = 1;
					}
				}

			}
			if (key == 0) {
				System.out.println(palavra + " não está contida no dicionário");
			}
		} catch (Exception e) {
			System.out.println("arquivo inexistente");
			e.printStackTrace();
		} finally {
			try {
				leitor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void pos(String texto) {

		StringBuffer Alt1 = new StringBuffer();
		String palavraC;
		int count;

		String Alt2[] = texto.split(Pattern.quote(" "));

		for (int i = 0; i < Alt2.length; i++) {
			if (!(Alt2[i].equals(",")) && !(Alt2[i].equals(".")) && !(Alt2[i].equals(";")) && !(Alt2[i].equals(":"))
					&& !(Alt2[i].equals("|")) && !(Alt2[i].equals("\"")) && !(Alt2[i].equals("'"))
					&& !(Alt2[i].equals("?")) && !(Alt2[i].equals("/")) && !(Alt2[i].equals("]"))
					&& !(Alt2[i].equals("}")) && !(Alt2[i].equals("~")) && !(Alt2[i].equals("^"))
					&& !(Alt2[i].equals("[")) && !(Alt2[i].equals("{")) && !(Alt2[i].equals("º"))
					&& !(Alt2[i].equals("ª")) && !(Alt2[i].equals("´")) && !(Alt2[i].equals("`"))
					&& !(Alt2[i].equals("=")) && !(Alt2[i].equals("+")) && !(Alt2[i].equals("§"))
					&& !(Alt2[i].equals("-")) && !(Alt2[i].equals("_")) && !(Alt2[i].equals(")"))
					&& !(Alt2[i].equals("(")) && !(Alt2[i].equals("...")) && !(Alt2[i].equals(".."))
					&& !(Alt2[i].equals("*")) && !(Alt2[i].equals("&")) && !(Alt2[i].equals("¨"))
					&& !(Alt2[i].equals("¬")) && !(Alt2[i].equals("¬¬")) && !(Alt2[i].equals("%"))
					&& !(Alt2[i].equals("¢")) && !(Alt2[i].equals("$")) && !(Alt2[i].equals("£"))
					&& !(Alt2[i].equals("#")) && !(Alt2[i].equals("@")) && !(Alt2[i].equals("!"))
					&& !(Alt2[i].equals("°")) && !(Alt2[i].equals("1")) && !(Alt2[i].equals("2"))
					&& !(Alt2[i].equals("3")) && !(Alt2[i].equals("4")) && !(Alt2[i].equals("5"))
					&& !(Alt2[i].equals("6")) && !(Alt2[i].equals("7")) && !(Alt2[i].equals("8"))
					&& !(Alt2[i].equals("9")) && !(Alt2[i].equals("0")) && !(Alt2[i].equals("¹"))
					&& !(Alt2[i].equals("²")) && !(Alt2[i].equals("³"))) {

				Alt1.append(Alt2[i]);
				replace(Alt1);
				palavraC = new String(Alt1);
				count = Alt1.length();
				Alt1.delete(0, count);
				//System.out.println(palavraC);
				this.palavras.add(palavraC);

			}
		}

	}

	public void Execução(String frase) {

		this.pos(frase);

		for (int i = 0; i < this.palavras.size(); i++) {
			Init.BuscaDicionario(palavras.get(i));
		}

	}

	public static void main(String args[]) {

		// lerArquivo("amor");
		//pos("Apartamento cása porta-luvas 11111vida");
		//BuscaDicionario("amor");

	}

}
