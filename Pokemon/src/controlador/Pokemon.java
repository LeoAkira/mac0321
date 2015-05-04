package controlador;


public class Pokemon {
	String nickname;
	String name;
	int maxHp;
	int Hp;
	boolean ativo = false;
	Move[] moves;
	boolean vivo = true;
	public Pokemon(String name, int hp, Move[] moves) {
		this.nickname = name;
		this.name = name;
		this.maxHp = hp;
		this.Hp = hp;
		this.moves = moves;
	}
	
}
