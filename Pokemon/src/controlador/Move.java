package controlador;

public class Move {
	String name;
	int damage;
	int prioridade;
	
	void attack(Pokemon atacado){
		atacado.Hp -= damage;
	}
}
