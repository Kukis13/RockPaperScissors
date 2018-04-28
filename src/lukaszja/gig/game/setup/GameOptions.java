package lukaszja.gig.game.setup;

import lukaszja.gig.game.player.Player;
import lukaszja.gig.game.player.RandomPlayer;
import lukaszja.gig.game.player.RockPlayer;
import lukaszja.gig.game.player.http.HttpRandomPlayerClient;

/**
 * This class is immutable by design
 */
public class GameOptions {
	
	public static final int NUMBER_OF_ITERATIONS = 100;
	
	private GameMode mode;
	private boolean fileLogging;
	
	public GameOptions(GameMode mode, boolean fileLogging) {
		this.mode = mode;
		this.fileLogging = fileLogging;
	}

	public GameMode getMode() {
		return mode;
	}

	public boolean isFileLogging() {
		return fileLogging;
	}
	
	public Player getPlayerOne(){
		return new RandomPlayer();
	}
	
	public Player getPlayerTwo(){
		switch(mode){
			case FAIR: return new RandomPlayer();
			case UNFAIR: return new RockPlayer();
			case REMOTE: return new HttpRandomPlayerClient();
			default: throw new IllegalArgumentException();
		}
	}

}
