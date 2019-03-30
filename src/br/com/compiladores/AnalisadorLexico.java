package br.com.compiladores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalisadorLexico {

	
	public static List<String> leituraAlfabeto(String alfabeto){
		String linha = "";
		BufferedReader arquivo = null;
		List <String> listaAlfabeto = new ArrayList <String>();
		listaAlfabeto.add("");
		
		try {
			arquivo = new BufferedReader(new FileReader(alfabeto));

			while (arquivo.ready()) {
				linha = arquivo.readLine();
				String[] a = linha.split(" ");

				for (int i = 0; i < a.length; i++) {
					if(listaAlfabeto.contains(a[i]) == true)
						continue;
					listaAlfabeto.add(a[i]);
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
		
		return listaAlfabeto;
		
	}
	
	
	

}
