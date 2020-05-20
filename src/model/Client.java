package model;
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
        
        while(true) {
            String message = scan.nextLine();
            String name = scan.nextLine();
            writer.write(message + "\r\n");
            writer.flush();
            if(message.contentEquals("exit")) {
            	break;
            }
        }
        writer.close();
        scan.close();
        client.close();
	}

}