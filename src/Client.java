
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket client = new Socket("127.0.0.1", 8000);

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        client.getOutputStream()
                )
        );
        
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        client.getInputStream()
                )
        );
        
        writer.write("q server");
        writer.flush();
        
        client.close();
	}

}
