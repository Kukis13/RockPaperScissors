package lukaszja.gig.game.init;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import lukaszja.gig.game.GameSimulator;
import lukaszja.gig.game.player.RockPlayer;
import lukaszja.gig.game.player.http.HttpRandomPlayerServer;
import lukaszja.gig.game.setup.GameMode;
import lukaszja.gig.game.setup.GameOptions;
import lukaszja.gig.game.setup.GameOptionsReader;

public class Start {

	private static Logger logger = Logger.getLogger("GameLogger");

	public static void main(String[] args) throws SecurityException, IOException {
		GameOptions gameOptions = new GameOptionsReader().readGameOptions();
		if (gameOptions.isFileLogging()) {
			logger.addHandler(new FileHandler("GameLogger.log"));
			logger.setUseParentHandlers(false);
		}

		HttpRandomPlayerServer httpRandomPlayerServer = null;
		if (gameOptions.getMode() == GameMode.REMOTE) {
			httpRandomPlayerServer = new HttpRandomPlayerServer();
		}
		
		GameSimulator game = new GameSimulator(gameOptions, GameOptions.NUMBER_OF_ITERATIONS, logger);
		game.start();
		if(httpRandomPlayerServer != null){
			httpRandomPlayerServer.stop();	
		}
	}

}
