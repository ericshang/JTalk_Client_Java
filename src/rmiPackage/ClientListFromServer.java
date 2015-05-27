/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiPackage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiPackage.Client;
import rmiPackage.RMIClientListInterface;

/**
 *
 * @author Shang
 */
public class ClientListFromServer implements Runnable {
    public static final String REGISTRY_URL = "localhost";
    private RMIClientListInterface stub;
    private Registry registry;
    private ArrayList<Client> clients;
    
    public ClientListFromServer(){
        /*System.out.println("load security policy");
        System.setProperty("java.security.policy","rmi.policy");
        if(System.getSecurityManager() == null){
            System.setSecurityManager( new  SecurityManager());
        }*/
        try{
            System.out.println("start registry");
            registry = LocateRegistry.getRegistry(REGISTRY_URL);
            System.out.println("looking for stubbed object from server");
            stub = (RMIClientListInterface)registry.lookup("ClientList");//get the stubbed remote object
            
            clients = stub.getClients();

        }catch(RemoteException e){
            System.out.println(e);
        }catch(NotBoundException ex){
            System.out.println(ex);
        } catch (Exception ex) {
            Logger.getLogger(ClientListFromServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {

    }
    
    public ArrayList<Client> getClients(){
        return this.clients;
    }
    public void addClient(Client c) throws RemoteException{
        stub.addClient(c);
    }
    public void removeClient(Client c)throws RemoteException{
        stub.removeClient(c);
    }
}
