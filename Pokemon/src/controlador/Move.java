package controlador;

public class Move {
	String name;
	int damage;
	int prioridade;
	
	public Move(String name, int damage, int prioridade) {
		this.name = name;
		this.damage = damage;
		this.prioridade = prioridade;
	}
	void attack(Pokemon atacado){
		if (damage >= atacado.Hp){
			atacado.Hp = 0;
			atacado.vivo = false;
		} else
		atacado.Hp -= damage;
	}
}
