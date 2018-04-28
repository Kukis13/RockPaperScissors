package lukaszja.gig.game;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.CORBA.PolicyListHelper;

import lukaszja.gig.game.RockPaperScissorsGame.Result;

import static lukaszja.gig.game.GameChoice.*;
import static lukaszja.gig.game.RockPaperScissorsGame.Result.*;

public class RockPaperScissorsGameTest {

	@Test
	public void getResult_rockDrawsRock(){
		Result result = RockPaperScissorsGame.getResult(ROCK, ROCK);
		
		assertEquals(DRAW, result);
	}
	
	@Test
	public void getResult_rockBeatsScissors(){
		Result result = RockPaperScissorsGame.getResult(ROCK, SCISSORS);
		
		assertEquals(PLAYER_1_WON, result);
	}
	
	@Test
	public void getResult_rockLosesToPaper(){
		Result result = RockPaperScissorsGame.getResult(ROCK, PAPER);
		
		assertEquals(PLAYER_2_WON, result);
	}
	
	@Test
	public void getResult_paperDrawsPaper(){
		Result result = RockPaperScissorsGame.getResult(PAPER, PAPER);
		
		assertEquals(DRAW, result);
	}
	
	@Test
	public void getResult_paperBeatsRock(){
		Result result = RockPaperScissorsGame.getResult(PAPER, ROCK);
		
		assertEquals(PLAYER_1_WON, result);
	}
	
	@Test
	public void getResult_paperLosesToScissors(){
		Result result = RockPaperScissorsGame.getResult(PAPER, SCISSORS);
		
		assertEquals(PLAYER_2_WON, result);
	}
	
	@Test
	public void getResult_scissorsDrawsScissors(){
		Result result = RockPaperScissorsGame.getResult(SCISSORS, SCISSORS);
		
		assertEquals(DRAW, result);
	}
	
	@Test
	public void getResult_scissorsBeatsPaper(){
		Result result = RockPaperScissorsGame.getResult(SCISSORS, PAPER);
		
		assertEquals(PLAYER_1_WON, result);
	}
	
	@Test
	public void getResult_scissorsLosesToRock(){
		Result result = RockPaperScissorsGame.getResult(SCISSORS, ROCK);
		
		assertEquals(PLAYER_2_WON, result);
	}
}
