
import java.io.*;
import java.net.*;

/*
 * UDPClient is a transport layer protocol defined for use with the IP network layer protocol.
 * To Test: Run the UDPClient and Run the UDPServer. Write a message in the client interface / the server will receive it.
 * For Testing Purposes I have created two Clients, both clients sending
 * to the same server.
 * 	@ MIHAIL BUTNARU
 */

class UDPClient
{
   public static void main(String args[]) throws Exception
   {
	  // === First Client
      System.out.println();
      System.out.println("========================= MIHAIL'S BUTNARU CLIENT SIDE ==============================");
	  System.out.println("Client 1:");
      BufferedReader inFromUser =
         new BufferedReader(new InputStreamReader(System.in));
      
      DatagramSocket clientSocket = new DatagramSocket();
      InetAddress IPAddress = InetAddress.getByName("localhost");
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      System.out.print("Enter message to send: ");
      String sentence = inFromUser.readLine();
      sendData = sentence.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 20001);
      clientSocket.send(sendPacket);
      
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      
      String modifiedSentence = new String(receivePacket.getData());
      System.out.println("FROM SERVER:" + modifiedSentence);
      clientSocket.close();
      
      // === Client 2
      System.out.println("Client 2: ");
      BufferedReader inFromUser2 = 
    		  new BufferedReader(new InputStreamReader(System.in));
      DatagramSocket client2Socket = new DatagramSocket();
      InetAddress IPAddress1 = InetAddress.getByName("localhost");
      byte[] sendData2 = new byte[1024];
      byte[] receiveData2 = new byte[1024];
      System.out.print("Enter message to send: ");
      String sentence2 = inFromUser2.readLine();
      sendData2 = sentence2.getBytes();
      DatagramPacket sendPacket1 = new DatagramPacket(sendData2, sendData2.length, IPAddress1, 20001);
      client2Socket.send(sendPacket1);
      
      DatagramPacket receivePacket1 = new DatagramPacket(receiveData2, receiveData2.length);
      client2Socket.receive(receivePacket1);
      
      String modifiedSentence1 = new String(receivePacket1.getData());
      System.out.println("FROM SERVER:" + modifiedSentence1);
      client2Socket.close();
      
      
      }
}
