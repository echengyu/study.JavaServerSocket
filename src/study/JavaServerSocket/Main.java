package study.JavaServerSocket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
	
	private static Scanner mScanner;
	private static String startSocketIP = "192.168.123.1";
	private static int SocketPort = 2000;
	
	
    public static void main(String[] args) {
        mScanner = new Scanner(System.in);
        
        /* TODO
        System.out.printf("Initialization IP(df: %s): ", startSocketIP);
        startSocketIP = mScanner.nextLine();
        System.out.printf("Initialization Port(df: %d): ", SocketPort);
        SocketPort = mScanner.nextInt();
        
        
        System.out.println("-- Data entered --");
        System.out.printf("Initialization IP: %s\n", startSocketIP);
        System.out.printf("Initialization Port: %d\n", SocketPort);
        */
        
        Thread t = new thread();
		t.start();
    }
}

class thread extends Thread {
	public void run() {
		try {

			ServerSocket[] servSock;
			servSock = new ServerSocket[1];

			InetAddress[] serverAddr;
			serverAddr = new InetAddress[1];

			Socket[] clntSock;
			clntSock = new Socket[15];

			System.out.println("Waitting to connect......");

			char value0[] = {0x45,0x36,0x48,0x7E,0x0D,0x0A};
			char value1[] = {0x45,0x36,0x47,0x7D,0x0D,0x0A};
			char value2[] = {0x45,0x36,0x44,0x7A,0x0D,0x0A};
			char value3[] = {0x45,0x36,0x41,0x77,0x0D,0x0A};
			char value4[] = {0x45,0x36,0x40,0x76,0x0D,0x0A};
			char value5[] = {0x45,0x36,0x38,0x74,0x0D,0x0A};

//			char value0[] = {0x4E,0x00,0x00,0x53,0x00,0x00,0x00,0x70,0x53,0x0D,0x0A};
//			char value1[] = {0x4E,0x00,0x00,0x55,0x00,0x00,0x00,0x75,0x55,0x0D,0x0A};
//			char value2[] = {0x4E,0x00,0x00,0x57,0x00,0x00,0x00,0x77,0x57,0x0D,0x0A};
//			char value3[] = {0x4E,0x00,0x00,0x59,0x00,0x00,0x00,0x79,0x59,0x0D,0x0A};
//			char value4[] = {0x4E,0x00,0x00,0x51,0x00,0x00,0x00,0x78,0x51,0x0D,0x0A};
//			char value5[] = {0x4E,0x00,0x00,0x53,0x00,0x00,0x00,0x7E,0x53,0x0D,0x0A};

//			char value0[] = {0x52,0x01,0x13,0x15,0x01,0x2A,0x0D,0x0A};
//			char value1[] = {0x52,0x01,0x15,0x17,0x01,0x2E,0x0D,0x0A};
//			char value2[] = {0x52,0x01,0x17,0x19,0x01,0x32,0x0D,0x0A};
//			char value3[] = {0x52,0x01,0x19,0x21,0x01,0x36,0x0D,0x0A};
//			char value4[] = {0x52,0x01,0x21,0x23,0x01,0x46,0x0D,0x0A};
//			char value5[] = {0x52,0x01,0x23,0x13,0x01,0x38,0x0D,0x0A};

//			char value0[] = {0x50,0x00,0x00,0x00,0x13,0x80,0x13,0x0D,0x0A};
//			char value1[] = {0x50,0x00,0x00,0x00,0x15,0x81,0x15,0x0D,0x0A};
//			char value2[] = {0x50,0x00,0x00,0x00,0x17,0x82,0x17,0x0D,0x0A};
//			char value3[] = {0x50,0x00,0x00,0x00,0x19,0x83,0x19,0x0D,0x0A};
//			char value4[] = {0x50,0x00,0x00,0x00,0x21,0x84,0x21,0x0D,0x0A};
//			char value5[] = {0x50,0x00,0x00,0x00,0x23,0x85,0x23,0x0D,0x0A};
			
			// TODO
			// 要記得電腦網路要設定
			// 控制台 > 網路和網際網路 > 網路連線 > "使用裝置" > 內容 > 網際網路...IP/v4)
			// 內容 > 進階 > IP 設定 > IP 位置 > 新增 > IP 位置 "192.168.實際.實際" > 確定
			for(int i = 0; i<1; i++) {
				serverAddr[i] = InetAddress.getByName("192.168.123.106");
				servSock[i] = new ServerSocket(2000,14,serverAddr[i]);
				clntSock[i] = servSock[i].accept();
			}

			System.out.println("Connected!!");
			String str = "java server string";
			System.out.println("(Server端)傳送的字串:" + str);

			int j[] = new int[1];

			while (true) {
				for(int i = 0; i<1; i++) {
					if (!clntSock[i].equals(null)) {
						j[i]=i;
					}
				}

				while(true) {
					for(int i = 0; i <= 1; i++) {
						try {
							if(j[i]==i) {
								PrintWriter out1 = new PrintWriter(
								    new BufferedWriter(new OutputStreamWriter(clntSock[i].getOutputStream())), true);
								if(!out1.equals(null)) {
									synchronized (this) { // 同步
										for (int v = 0; v < 6 ; v++) {
											if (v == 0) {

												Thread.sleep(10);
												out1.println(value0);
											} else if (v == 1) {

												Thread.sleep(10);
												out1.println(value1);
											} else if (v == 2) {

												Thread.sleep(10);
												out1.println(value2);
											} else if (v == 3) {

												Thread.sleep(10);
												out1.println(value3);
											} else if (v == 4) {

												Thread.sleep(10);
												out1.println(value4);
											} else if (v == 5) {

												Thread.sleep(100);
												out1.println(value5);
											}
										}
									}
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
							if (clntSock[i] != null) {
								try {
									clntSock[i].close();
									for(int y = 0; y<1; y++) {
										serverAddr[y] = InetAddress.getByName("192.168.31.239");
										servSock[y] = new ServerSocket(2000,14,serverAddr[y]);
										clntSock[y] = servSock[i].accept();
									}
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}

