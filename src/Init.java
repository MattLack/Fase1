import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Init {

	private static Init instance = null;
	private static String[] Alfabeto = { "a", "b", "c", "ç", "d", "e", "f", "g", "h", "i", "j", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "x", "z", "k", "w", "y", "*" };

	private Init() {
	}

	public static Init getInstance() {
		if (instance == null) {
			instance = new Init();
		}
		return instance;
	}

	public static void lerArquivo(String palavra) {
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

			leitor = new BufferedReader(new FileReader(letra1 + "saida.txt"));

			String linha = "";

			while (((linha = leitor.readLine()) != null) && !(proxLetra.equals(proxLetraLida)) && (key == 0)) {
				if (linha.length() > 0) {
					if (!(linha.substring(0, 1).equals("(")))
						if (!(linha.substring(1, 2).equals("(")))
							proxLetraLida = linha.substring(1, 2);
					//System.out.println(linha);
					if (linha.contains(aux)) {
						System.out.println("Contém no dicionário");
						key = 1;
					}
				}

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

	public static void main(String args[]) {

		lerArquivo("amor");

	}

}
