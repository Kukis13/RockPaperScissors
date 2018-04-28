package lukaszja.gig.game;

import java.util.HashMap;
import java.util.Map;

import lukaszja.gig.game.RockPaperScissorsGame.Result;

public class GameStatistics {

	private Map<Result, Integer> results = new HashMap<>();
	
	public void addGameResult(GameRoundResult result) {
		results.merge(result.getResult(), 1, (oldValue, one) -> oldValue + one);
	}

	public Map<Result, Integer> getResults() {
		return results;
	}
	
	@Override
	public String toString(){
		String string = "";

		string += "Player 1 won: " + results.get(Result.PLAYER_1_WON) + " ";
		string += "Player 2 won: " + results.get(Result.PLAYER_2_WON) + " ";
		string += "Draw: " + results.get(Result.DRAW);
		
		return string;
	}
}
