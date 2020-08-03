package com.globallogic.bootcamp.patterns.dependency;

public class Playstation {
	private Game videogame;
	
	public Playstation(Game game) {
		this.videogame = game;
	}

	public Game getGame() {
		return videogame;
	}

	public void setGame(Game game) {
		this.videogame = game;
	}
	
	public String askMyGame() {
		if( videogame != null )
			return "El videojuego que estoy corriendo es: " + this.videogame;
		return "¡Estoy Vacio!";
	} 
	
	public static void main(String[] args) {
		Playstation playstation = new Playstation(new Game("Resident Evil"));
		System.out.println(playstation.askMyGame());
		
		playstation.setGame(new Game("Brawlhalla"));
		System.out.println(playstation.askMyGame());
		
		playstation.setGame(null);
		System.out.println(playstation.askMyGame());
	}
	
}
