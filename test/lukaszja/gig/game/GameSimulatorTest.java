package lukaszja.gig.game;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import lukaszja.gig.game.RockPaperScissorsGame.Result;
import lukaszja.gig.game.setup.GameMode;
import lukaszja.gig.game.setup.GameOptions;

public class GameSimulatorTest {

	@Mock
	private Logger logger;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void start_givenNoGameRounds_gameStatsEmpty(){
		GameOptions gameOptions = new GameOptions(GameMode.FAIR, true);
		GameSimulator simulator = new GameSimulator(gameOptions, 0, logger);
		
		GameStatistics start = simulator.start();
		
		assertEquals(0, start.getResults().size());
	}
	
	@Test
	public void start_given5Rounds_gameStatsContain5Results(){
		GameOptions gameOptions = new GameOptions(GameMode.FAIR, true);
		GameSimulator simulator = new GameSimulator(gameOptions, 5, logger);
		
		GameStatistics start = simulator.start();
		
		assertEquals(5, start.getResults().values().stream().mapToInt(Integer::intValue).sum());
	}
	
	@Test
	public void start_given100Rounds_gameStatsContain100Results(){
		GameOptions gameOptions = new GameOptions(GameMode.FAIR, true);
		GameSimulator simulator = new GameSimulator(gameOptions, 100, logger);
		
		GameStatistics start = simulator.start();
		
		assertEquals(100, start.getResults().values().stream().mapToInt(Integer::intValue).sum());
	}
}
