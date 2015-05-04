package controlador;

import java.util.Scanner;

public abstract class Event {
	boolean continua;
	Scanner scanIn;
	abstract public boolean action(Treinador atual, Treinador enemy);
	public Event(Treinador atual, Treinador enemy, Scanner scanIn) {
		this.continua = true;
		this.scanIn = scanIn;
	}
}
