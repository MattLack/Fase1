package Xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

	public ArrayList<String> lerArquivo() {

		ArrayList<String> instrucoes = new ArrayList<String>();
		BufferedReader leitor = null;

		try {

			leitor = new BufferedReader(new FileReader("input.txt"));

			String linha = "";

			while ((linha = leitor.readLine()) != null) {
				if (linha.length() > 0)
					instrucoes.add(linha);
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
		return instrucoes;

	}
	
	public void arquivoSaida(String texto) {

		try {
			if (new File("output.txt").exists() == false) {

				new File("output.txt").createNewFile();

			}
			escritor = new BufferedWriter(new FileWriter("output.txt"));

			escritor.append("\r\n" + texto + "\r\n");
			escritor.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
