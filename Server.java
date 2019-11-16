import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

  public final static int SOCKET_PORT = 13267;  

  public final static String
       FILE_TO_RECEIVED = "CPSC501 Ass3/files.xml";

  public final static int FILE_SIZE = 6022386; 
                                            

  public static void main (String [] args ) throws IOException {
	 
	  try {
		  int port = 88;
		  Socket socket = new Socket("localhost", port);
		  ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
		  Object doc = inputStream.readObject();
		  socket.close();
		  
	  }
	  catch(IOException | ClassNotFoundException e) {
		  e.printStackTrace();
	  }
	 
	  
	  
	  
	  
  }

}