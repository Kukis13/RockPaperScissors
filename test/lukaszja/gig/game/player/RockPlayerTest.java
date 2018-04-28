package lukaszja.gig.game.player;

import static org.junit.Assert.*;

import org.junit.Test;

import lukaszja.gig.game.GameChoice;
import static lukaszja.gig.game.GameChoice.ROCK;

public class RockPlayerTest {

	@Test
	public void play_returnRock(){
		RockPlayer player = new RockPlayer();
		
		GameChoice choice = player.play();
		
		assertEquals(ROCK, choice);
	}
}
