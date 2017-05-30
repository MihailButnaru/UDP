
import java.io.*;
import java.net.*;
/*
 * UDPServer Receive the messages from the UDPClient: DISPLAYS THE CLIENT'S IP ADDRESS AND THE CLIENT'S MESSAGE
*  @MIHAIL BUTNARU
*/

class UDPServer
{
   public static void main(String args[]) throws Exception
      {
         DatagramSocket serverSocket = new DatagramSocket(20001);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            System.out.println();
            System.out.println("========================= MIHAIL'S BUTNARU SERVER =================================");
            
            while(true)
               {
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
                  String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  System.out.println("CLIENT'S IP ADDRESS: "  + IPAddress + ":" + port);
                  System.out.println("RECEIVED MESSAGE: " + sentence);
                  System.out.println();
                  receivePacket.setLength(receiveData.length);
                  String capitalizedSentence = sentence.toUpperCase();
                  sendData = capitalizedSentence.getBytes();
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serverSocket.send(sendPacket);
               }
      }
}