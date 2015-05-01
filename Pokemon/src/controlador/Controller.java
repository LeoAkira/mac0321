package controlador;

import java.util.Scanner;
import controlador.Batalha;


public class Controller {
	public void run(Treinador primeiro, Treinador segundo) {
		Event e;
		boolean continua = true;

		while (continua) {
			int resposta1;
			int resposta2;

			System.out.println("What will " + primeiro.name + " do?");
			System.out.println("1: Fight");
			System.out.println("2: Bag");
			System.out.println("3: Pokemon");
			System.out.println("4: Run");

			Scanner scanIn = new Scanner(System.in);
			resposta1 = scanIn.nextInt();
			scanIn.close();

			System.out.println("What will " + segundo.name + " do?");
			System.out.println("1: Fight");
			System.out.println("2: Bag");
			System.out.println("3: Pokemon");
			System.out.println("4: Run");

			Scanner scanIn2 = new Scanner(System.in);
			resposta2 = scanIn2.nextInt();
			scanIn2.close();
			
			

		}
	}
}
