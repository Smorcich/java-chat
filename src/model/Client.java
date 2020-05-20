package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Developer;
import model.DeveloperRunner;

public class Client {
	private static SessionFactory sessionFactory;
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Developer developer = new Developer();
		DeveloperRunner developerRunner = new DeveloperRunner();

		Scanner scan = new Scanner(System.in);
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
        String name = scan.nextLine();
        developerRunner.addDeveloper(name, sessionFactory);
        /*
        while(true) {
            String message = scan.nextLine();
            writer.write(message + "\r\n");
            writer.flush();
            if(message.contentEquals("exit")) {
            	break;
            }
        }
        writer.close();
        scan.close();
        client.close();
        */
	}

}