/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiPackage;

import java.io.Serializable;

/**
 *
 * @author Shang
 */
public class Client implements Serializable {
    private String name;
    private String IpAddress;
    private int port;
    
    public Client (String name, String ip, int port){
        setName(name);
        setIpAddress(ip);
        setPort(port);
    }
    //getters
    public String getName(){
        return this.name;
    }
    public String getIpAddress(){
        return this.IpAddress;
    }
    public int getPort(){
        return this.port;
    }
    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setIpAddress(String ip){
        this.IpAddress = ip;
    }
    public void setPort(int port){
        this.port = port<1 ? 1020: port;
    }
    
}
