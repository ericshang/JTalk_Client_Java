/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Shang
 */
public interface RMIClientListInterface extends Remote {
    
     public void addClient(Client c)throws RemoteException;//add client to the list
     public void removeClient(Client c) throws RemoteException;//remove client to the list
     public ArrayList<Client> getClients()throws RemoteException;//get the whole list of clients
     public void removeClientByIp(String ip)throws RemoteException;
     public void addMessageToList(String msg) throws RemoteException;
     public ArrayList<String> getMessages() throws RemoteException;
     
}
