import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.jdom.*;
import org.jdom.input.SAXBuilder;



public class Server {


  public final static int FILE_SIZE = 6022386; 
  static Object obj = null;
                                            

  public static void main (String [] args ) throws IOException, JDOMException {
	  InetAddress addr = InetAddress.getLocalHost();
	  System.out.println("Waiting...");
	  ServerSocket serverSocket = new ServerSocket(4321);
	  Socket socket = serverSocket.accept();
	  System.out.println("Connected");
	  DataInputStream inputStream = new DataInputStream(socket.getInputStream());
	  SAXBuilder builder = new SAXBuilder();
	  Document doc = builder.build(inputStream);
	  
	  socket.close();
	  Deserializer deserial = new Deserializer();
	  try {
		deserial.deserialize(doc);
	} catch (ClassNotFoundException e) {
		 e.printStackTrace();
	}
	  
	  
	  }
	 
	  
	  
	  
	  
  

}