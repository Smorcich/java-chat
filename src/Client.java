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
<<<<<<< HEAD
        
        while(true) {
            String message = scan.nextLine();
            writer.write(message);
            writer.flush();
            if(message.contentEquals("exit")) {
            	break;
            }
        }
        writer.close();
=======

        String message = scan.nextLine();
        
        writer.write(message);
        writer.flush();
>>>>>>> parent of ec3deb3... 1.4.1
        scan.close();
        client.close();
	}

}
