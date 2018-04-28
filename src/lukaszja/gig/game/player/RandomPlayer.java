package lukaszja.gig.game.player;

import java.util.Random;

import lukaszja.gig.game.GameChoice;

public class RandomPlayer implements Player {
	
	@Override
	public GameChoice play() {
		int randomNumber = new Random().nextInt(GameChoice.values().length);
	    return GameChoice.values()[randomNumber];
	}
}
