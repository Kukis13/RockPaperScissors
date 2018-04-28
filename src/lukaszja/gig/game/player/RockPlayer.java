package lukaszja.gig.game.player;

import lukaszja.gig.game.GameChoice;

public class RockPlayer implements Player {
	
	@Override
	public GameChoice play() {
		return GameChoice.ROCK;
	}

}
