package Ex2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		// Cria arquivos de nome e sobrenome
		try (BufferedWriter bwNome = new BufferedWriter(new FileWriter(new File("nome.txt")));
				BufferedWriter bwSobrenome = new BufferedWriter(new FileWriter(new File("sobrenome.txt")));) {
					bwNome.append("Bruna");
					bwSobrenome.append("Rodrigues de Oliveira");
				} catch (IOException e) {
					e.printStackTrace();
				}

				
		// Le e imprimi arquivos de nome e sobrenome
			try (Scanner scanNome = new Scanner(new File("nome.txt"));
					Scanner scanSobrenome = new Scanner(new File("sobrenome.txt"))) {
						while (scanNome.hasNext()) {
							System.out.print(scanNome.next() + " ");
						}

						while (scanSobrenome.hasNext()) {
							System.out.print(scanSobrenome.next() + " ");
						}	
					} catch (Exception e) {
						e.printStackTrace();
					   }

			}
}
