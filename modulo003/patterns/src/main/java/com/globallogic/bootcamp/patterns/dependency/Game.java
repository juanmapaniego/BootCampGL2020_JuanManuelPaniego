package com.globallogic.bootcamp.patterns.dependency;

public class Game {
	private String title;

	public Game(String game) {
		this.title = game;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return this.title;
	}
	
	
	
}
