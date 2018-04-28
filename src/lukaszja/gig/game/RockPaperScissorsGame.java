package lukaszja.gig.game;

public class RockPaperScissorsGame {

	public enum Result {
		PLAYER_1_WON, PLAYER_2_WON, DRAW
	}
	
	public static Result getResult(GameChoice choice1, GameChoice choice2) {
		if(choice1.getValue() == choice2.getValue()){
			return Result.DRAW;
		} else if(choice1.getValue() == 0 && choice2.getValue() == Result.values().length - 1){
			return Result.PLAYER_1_WON;
		} else if(choice2.getValue() == 0 && choice1.getValue() == Result.values().length -1){
			return Result.PLAYER_2_WON;
		} else if(choice1.getValue() > choice2.getValue()){
			return Result.PLAYER_1_WON;
		}
		return Result.PLAYER_2_WON;
	}

}
