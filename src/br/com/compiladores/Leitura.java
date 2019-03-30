package br.com.compiladores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitura {

	public static void main(String[] args) {
		String alfabeto = "alfabeto.txt";
		String programa = "programa.txt";
		String linha = "";
		Integer numeroLinha = 1;
		int flagErro = 0; 
		BufferedReader arquivo = null;
		List <String> listaAlfabeto = AnalisadorLexico.leituraAlfabeto(alfabeto);
		
		
		try {
			arquivo = new BufferedReader(new FileReader(programa));

			while (arquivo.ready()) {
				linha = arquivo.readLine();
				String[] a = linha.split(" ");
                
				for (int i = 0; i < a.length; i++) {
					
					if(listaAlfabeto.contains(a[i]) == false){						
					System.out.println("Erro na linha: "+numeroLinha+"   Coluna : "+(i+1)+"\n"+"Termo: "+a[i]);
					flagErro=1;
					}
				}
				
				numeroLinha++;
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
		if(flagErro !=1)
			System.out.println("Progama Lido com sucesso!");

	}
}
