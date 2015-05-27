/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtalk;

import UI.mainFrame;
import rmiPackage.ClientListFromServer;
import java.rmi.RemoteException;
import javax.swing.SwingUtilities;
import rmiPackage.Client;

/**
 *
 * @author Shang
 */
public class JTalk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws  InterruptedException {
        ///try to get local ip
        String clientIP = new localMachineIP().toString();
        System.out.println("the ip for localhost is: "+clientIP);
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                mainFrame UI = new mainFrame();
            }
        });
        
        try{
            ClientListFromServer clientList = new ClientListFromServer();
            Thread getClientThread = new Thread(clientList);
            getClientThread.start();
            
            Client client = new Client("Eric", clientIP,0);
            clientList.addClient(client);
            
        }catch(RemoteException e){
            System.out.println(e);
        }
        
    }
    
}
