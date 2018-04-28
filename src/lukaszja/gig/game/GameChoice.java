package lukaszja.gig.game;

public enum GameChoice {
	SCISSORS(2), PAPER(1), ROCK(0);
	
	private int value;
	
	GameChoice(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
