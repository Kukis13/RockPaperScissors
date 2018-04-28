package lukaszja.gig.game;

import lukaszja.gig.game.RockPaperScissorsGame.Result;
import lukaszja.gig.game.player.Player;

public class GameRoundResult {
	
	private GameChoice player1Choice;
	private GameChoice player2Choice;
	private Result result;
	
	public GameRoundResult(GameChoice player1Choice, GameChoice player2Choice, Result result) {
		this.player1Choice = player1Choice;
		this.player2Choice = player2Choice;
		this.result = result;
	}
	
	public GameChoice getPlayer2Choice() {
		return player2Choice;
	}
	
	public GameChoice getPlayer1Choice() {
		return player1Choice;
	}

	public Result getResult() {
		return result;
	}

	@Override
	public String toString(){
		String string = "";

		string += "Player 1 choice: " + player1Choice + " ";
		string += "Player 2 choice: " + player2Choice + " ";
		string += "Result: " + result;
		
		return string;
	}
}
