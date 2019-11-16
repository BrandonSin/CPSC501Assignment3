package Reflection1Serializable;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.jdom.Document;
import org.jdom.output.XMLOutputter;

public class Client {


  public void send(Document doc, XMLOutputter xmlout) throws IOException {
	  String serverAddress = "localhost";
	  int serverPort = 88;
	  try {
		  System.out.println("starting");
		  ServerSocket ss = new ServerSocket(serverPort);
		  Socket socket = ss.accept();
		  System.out.println("accepted");
		  ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
		  Serializer serial = new Serializer();
		  outputStream.writeObject(serial.doc);
		  outputStream.flush();
		  socket.close();
	  }
	  catch(IOException e) {
		  e.printStackTrace();
	  }
   
  }
}