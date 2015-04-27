package controlador;

public abstract class Event {
	
	abstract public void action(Treinador atual, Treinador enemy);
	abstract public String description();
}
