
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(8000);
		while(true) {
		
			Socket clientSocket = server.accept();

		    Multithread multithread = new Multithread(clientSocket);
		    multithread.start();
		}

	}

}
