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
    public static mainFrame UI;
    public static final String clientIP = new localMachineIP().toString();
    public static String currentClientName="";
    
    
    public static void main(String[] args) throws  InterruptedException {
        ///try to get local ip
        System.out.println("the ip for localhost is: "+clientIP);
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                UI = new mainFrame();
                UI.setMainTopLabelText("Your Ip is: "+clientIP );
            }
        });
        
    }
    
}
