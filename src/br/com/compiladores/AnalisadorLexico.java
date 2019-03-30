package br.com.compiladores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalisadorLexico {

	
	public static List<String> leituraLinguagem(String linguagem){
		String linha = "";
		BufferedReader arquivo = null;
		List <String> listaLinguagem = new ArrayList <String>();
		listaLinguagem.add("");
		
		try {
			arquivo = new BufferedReader(new FileReader(linguagem));

			while (arquivo.ready()) {
				linha = arquivo.readLine();
				String[] a = linha.split(" ");

				for (int i = 0; i < a.length; i++) {
					if(listaLinguagem.contains(a[i]) == true)
						continue;
					listaLinguagem.add(a[i]);
				}
			}
		}

		catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		finally {
			try {
				arquivo.close();
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}
		
		return listaLinguagem;
		
	}
	
	
	

}
