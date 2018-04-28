package lukaszja.gig.game.setup;

import java.util.Scanner;

public class GameOptionsReader {

	/**
	 * Waits for user input and reads game options from the console.
	 * TODO: think, how do we want to handle invalid input
	 */
	public GameOptions readGameOptions() {
		System.out.println("Choose game mode: [0] - fair, [1] - unfair, [2] - remote. Press Enter to confirm your choice.");
		GameMode mode = GameMode.valueOf(readNumber());
		System.out.println("Now choose the logging method: [0] - file, [1] - console.");
		boolean useFileLogging = readNumber() == 0 ? true : false;
		return new GameOptions(mode, useFileLogging);
	}

	private int readNumber() {
		Scanner in = new Scanner(System.in);
		try{
			int number = in.nextInt();
			return number;
		} catch(Exception e){
			System.out.println("Wrong option choosen. I will use default one [0]");
			return 0;
		}
	}

	
}
