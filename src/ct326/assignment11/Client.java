/**
 * @author Luke Potter
 * @studentid 07013418
 * @course 3rd B.Sc. I.T.
 * @date 19/February/2010
 */

package ct326.assignment11;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main (String[] args) throws IOException {
		
		//Declare Variables
		int port = 4444;
		String host = "localhost", filename  = "text.txt";
		Socket sock = null;
		Server server = new Server();
		ObjectOutputStream oos = null;
		
		//Start the Server
		server.start();
		
		//Instantiate the Socket
		try {
			
			sock = new Socket(host, port);
		}
		catch (UnknownHostException e) {
			
			System.out.println("Host Unknown\n");
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			
			//Instantiate the Object Output Stream
			oos = new ObjectOutputStream(sock.getOutputStream());
			
			//Write the Object, Flush it and close the stream
			oos.writeObject(filename);
			oos.flush();
			oos.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
