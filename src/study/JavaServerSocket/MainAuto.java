package study.JavaServerSocket;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MainAuto {
	
	private static int connectQuantity = 15;
	private static ConnectThread mConnectThread;
	
    public static void main(String[] args) {
        
        /* TODO
        System.out.printf("Initialization IP(df: %s): ", startSocketIP);
        startSocketIP = mScanner.nextLine();
        System.out.printf("Initialization Port(df: %d): ", SocketPort);
        SocketPort = mScanner.nextInt();
        
        
        System.out.println("-- Data entered --");
        System.out.printf("Initialization IP: %s\n", startSocketIP);
        System.out.printf("Initialization Port: %d\n", SocketPort);
        */

    	for(int i=0; i<connectQuantity; i++){
    		String settingIpTmp = "192.168.123." + (100 + i);
    		
    		mConnectThread = new ConnectThread();
    		mConnectThread.setThreadName("ConnectThread: " + settingIpTmp);
            mConnectThread.setSocket(settingIpTmp, 2000);
            mConnectThread.start();
    	}
    }
}

class ConnectThread extends Thread {
	
	private String socketIp = "";
	private int socketPort = 0;
	private ServerSocket servSock;			
	private Socket clntSock;
	private InetAddress serverAddr;
	
	public void setThreadName(String name) {
		this.setName(name);
	}
	
	public String getThreadName() {
		return this.getName();
	}
	
	public void setSocket(String ip, int port) {
		this.socketIp = ip;
		this.socketPort = port;
	}
	
	public String getSocketIp() {
		return this.socketIp;
	}
	
	public int getSocketPort() {
		return this.socketPort;
	}
	
	public void stopThread() {
		this.interrupt();
		System.out.println("stopThread");
	}
	
	public void run() {
		try {

			System.out.println(socketIp + " > " + "Waitting to connect...");

			char value0[] = {0x45,0x36,0x48,0x7E,0x0D,0x0A};
			char value1[] = {0x45,0x36,0x47,0x7D,0x0D,0x0A};
			char value2[] = {0x45,0x36,0x44,0x7A,0x0D,0x0A};
			char value3[] = {0x45,0x36,0x41,0x77,0x0D,0x0A};
			char value4[] = {0x45,0x36,0x40,0x76,0x0D,0x0A};
			char value5[] = {0x45,0x36,0x38,0x74,0x0D,0x0A};

			
			serverAddr = InetAddress.getByName(socketIp);
			servSock = new ServerSocket(socketPort, 14, serverAddr);
			clntSock = servSock.accept();
			
			System.out.println(socketIp + " > " + "Connected!");
			
			int j[] = new int[1];

			while(true) {
				try {
					PrintWriter out1 = new PrintWriter(
					    new BufferedWriter(new OutputStreamWriter(clntSock.getOutputStream())), true);
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

									Thread.sleep(200);
									out1.println(value5);
								}
							}
						}
					}
				} catch (Exception e) {
//					// TODO: handle exception
//					if (clntSock != null) {
//						try {
//							clntSock.close();
//							for(int y = 0; y<1; y++) {
//								serverAddr = InetAddress.getByName("192.168.31.239");
//								servSock = new ServerSocket(2000,14,serverAddr);
//								clntSock = servSock.accept();
//							}
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}
				}
			}
		} catch (Exception e) {
			System.out.println(socketIp + " > " + "Error: " + e.getMessage());
		}
	}
}

