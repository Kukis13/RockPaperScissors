package lukaszja.gig.game.setup;

import java.util.HashMap;
import java.util.Map;

public enum GameMode {
	FAIR(0), UNFAIR(1), REMOTE(2);
	
	private static Map<Integer, GameMode> map = new HashMap<>();
	private int id;
    
	private GameMode(int id){
		this.id = id;
	}
	
    static {
        for (GameMode pageType : GameMode.values()) {
            map.put(pageType.id, pageType);
        }
    }

    public static GameMode valueOf(int pageType) {
        return map.get(pageType);
    }
}
