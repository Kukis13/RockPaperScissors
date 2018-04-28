package lukaszja.gig.game;

import java.util.logging.Level;
import java.util.logging.Logger;

import lukaszja.gig.game.RockPaperScissorsGame.Result;
import lukaszja.gig.game.player.Player;
import lukaszja.gig.game.setup.GameOptions;

public class GameSimulator {

	private final GameStatistics gameStatistics;
	private final Player player1;
	private final Player player2;
	private final Logger logger;
	private int iterations;
	
	public GameSimulator(GameOptions gameOptions, int iterations, Logger logger) {
		this.iterations = iterations;
		this.player1 = gameOptions.getPlayerOne();
		this.player2 = gameOptions.getPlayerTwo();
		this.gameStatistics = new GameStatistics();
		this.logger = logger;
	}

	public GameStatistics start() {
		for(int round = 0; round < iterations; round ++){
			GameRoundResult result = playGameRound();
			log(result);
			gameStatistics.addGameResult(result);
		}
		log(gameStatistics);
		return gameStatistics;
	}

	private void log(Object object) {
		logger.log(Level.INFO, object.toString());
	}

	private GameRoundResult playGameRound() {
		GameChoice choice1 = player1.play();
		GameChoice choice2 = player2.play();
		Result result = RockPaperScissorsGame.getResult(choice1, choice2);
		return new GameRoundResult(choice1, choice2, result);
	}
	
	

	
}
