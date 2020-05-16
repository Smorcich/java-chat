import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class Multithread extends Thread {
	
	public Socket clientSocket = new Socket();
	
	public Multithread(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	@Override
	public void run(){
		try {
			serverWork();
		}
		catch (IOException e) {}
	}
	
	public void serverWork() throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        clientSocket.getOutputStream()
                )
        );
        
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()
                )
        );
        String clientRequest = reader.readLine();
        /*while((clientRequest) != null ) {
        	if (clientRequest.equals("exit")) {
        		break;
        	}
        }
        */
        System.out.println(clientRequest);
	}
}
