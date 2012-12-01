/**
 * @author Luke Potter
 * @studentid 07013418
 * @course 3rd B.Sc. I.T.
 * @date 19/February/2010
 */

package ct326.assignment11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class Server extends Thread {

	//Declare Variables
	int port;
	ServerSocket ss;
	Socket sock;
	ObjectInputStream ois;
	
	//Constructor
	public Server() {}
	
	@SuppressWarnings("deprecation")
	@Override
	//Run Method
	public void run() {
		
		//Instantiate the Server Socket
		try {
			
			port = 4444;
			ss = new ServerSocket(port);
		}
		catch (IOException e) {
			
			System.out.println("Could not listen in port:" + port);
			e.printStackTrace();
			System.exit(0);
		}
		
		//Instantiate the socket
    	try {
    		
    		sock = null;
    		
    		//The Socket will block here until it gets a connection
    		sock = ss.accept();
    		System.out.println("Connected with Client");
    	}
    	catch (IOException e) {
    		
    		System.out.println("Unable to connect with Client");
    		e.printStackTrace();
    		System.exit(1);
    	}
    	
		//Instantiate the Object Input Stream
		try {
			
			ois = new ObjectInputStream (sock.getInputStream());
			System.out.println("Revieved Data");
		}
		catch (IOException e) {
			
			System.out.println("Unable to recieve Data");
			e.printStackTrace();
			System.exit(0);
		}
		
		//Stop the Server
		System.out.println("Server Stopped");
		this.stop();
		
	}
}
