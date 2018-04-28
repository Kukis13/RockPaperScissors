package lukaszja.gig.game.player.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import lukaszja.gig.game.GameChoice;
import lukaszja.gig.game.player.Player;

public class HttpRandomPlayerClient implements Player {

	@Override
	public GameChoice play() {
		try {
			String gameChoiceString = sendRequest();
			return GameChoice.valueOf(gameChoiceString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new IllegalStateException("Something went wrong ...");
	}

	private String sendRequest() throws Exception {
		URL url = new URL("http://localhost:" + HttpRandomPlayerAPI.PORT + HttpRandomPlayerAPI.PATH);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine = in.readLine();
		in.close();
		return inputLine;
	}

}
