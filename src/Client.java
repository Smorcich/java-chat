
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket client = new Socket("127.0.0.1", 8000);
		Scanner scan = new Scanner(System.in);
		
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


            String message = scan.nextLine();
            writer.write(message);
            writer.flush();

        scan.close();
        client.close();
	}

}
