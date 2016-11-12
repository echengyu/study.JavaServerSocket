package study.JavaServerSocket;

import java.util.Scanner;

public class Main {
	
	private static Scanner mScanner;
	private static String startSocketIP = "192.168.123.1";
	private static int SocketPort = 2000;
	
	
    public static void main(String[] args) {
        mScanner = new Scanner(System.in);
        
        System.out.printf("Initialization IP(df: %s): ", startSocketIP);
        startSocketIP = mScanner.nextLine();
        System.out.printf("Initialization Port(df: %d): ", SocketPort);
        SocketPort = mScanner.nextInt();
        
        
        System.out.println("-- Data entered --");
        System.out.printf("Initialization IP: %s\n", startSocketIP);
        System.out.printf("Initialization Port: %d\n", SocketPort);
    }
}
