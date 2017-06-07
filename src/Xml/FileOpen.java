package Xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileOpen {

	private static FileOpen instance = null;
	private BufferedWriter escritor = null;

	private FileOpen() {
	}

	public static FileOpen getInstance() {
		if (instance == null) {
			instance = new FileOpen();
		}
		return instance;
	}

	public String lerArquivo() {

		String texto = null;
		BufferedReader leitor = null;

		try {

			leitor = new BufferedReader(new FileReader("src/input.txt"));

			texto = "";

			while ((texto = leitor.readLine()) != null) {
				if (texto.length() > 0)
					texto.concat(texto);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				leitor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(texto);
		return texto;
	}

}
