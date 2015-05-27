/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UdpConn;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Shang
 */
public class messageSender implements Runnable {
    private DatagramSocket clientSocket;
    
    //constructor
    public messageSender(){
    }
    
    @Override
    public void run() {
    
    }
    
    public void sendMessage(String msg){
        try{
            clientSocket = new DatagramSocket();
            //InetAddress IPAddress = InetAddress.getByName("localhost");
            InetAddress IPAddress = InetAddress.getByName("192.168.1.3");
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            String sentence = msg;
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            /*clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println("FROM SERVER:" + modifiedSentence);
            */
        }catch(Exception e){
              System.out.println("Error of creating socket or datagram packet: " + e);
        }
        clientSocket.close();
    }
    
}
