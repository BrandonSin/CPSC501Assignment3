package Reflection1Serializable;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.io.ObjectInputStream;

import org.jdom.Document;
import org.jdom.output.XMLOutputter;

public class Client {


  public void send(Document doc, String z) throws IOException {
	  String serverAddress = "localhost";
	  int serverPort = 88;
	  File f = new File(z);
	  System.out.println("Connecting to Server");
	  try {
		  Socket socket = new Socket("10.0.0.246", 4321);
		  System.out.println("Connected to Server");
		  DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
		  outputStream.writeBytes(z);
		  outputStream.flush();
		  socket.close();
		  System.out.println("Sent --- Program Closing");
	  }
	  catch(IOException e) {
		  e.printStackTrace();
	  }
   
  }
}