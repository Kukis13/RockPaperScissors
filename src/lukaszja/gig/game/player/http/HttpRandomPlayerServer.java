package lukaszja.gig.game.player.http;



import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import lukaszja.gig.game.player.RandomPlayer;

//TODO: Don't use com.sun.* packages with java 8 + anymore. Find something better.
@SuppressWarnings("restriction")
public class HttpRandomPlayerServer implements HttpHandler {

	private HttpServer server;

	public HttpRandomPlayerServer() {
		try {
			startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void startServer() throws IOException {
		server = HttpServer.create(new InetSocketAddress(HttpRandomPlayerAPI.PORT), 0);
		server.createContext(HttpRandomPlayerAPI.PATH, this);
		server.setExecutor(null);
		server.start();
	}

	@Override
	public void handle(HttpExchange args) throws IOException {
        String response = new RandomPlayer().play().toString();
        args.sendResponseHeaders(200, response.length());
        OutputStream os = args.getResponseBody();
        os.write(response.getBytes());
        os.close();
	}

	public void stop() {
		server.stop(0);
	}

}
