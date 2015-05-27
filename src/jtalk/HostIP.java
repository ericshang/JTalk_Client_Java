/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtalk;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Shang
 */
public class HostIP {
    private String localIpAddress;
    
    public HostIP(){
        localIpAddress = "";
        getIP();
    }
    
    private void getIP(){
        try{
            InetAddress address = InetAddress.getByName("localhost");  
            byte ip[] = address.getAddress();
            byte ipSegment ;
            for (int i=0; i<ip.length; i++)  
            {
                ipSegment = ip[i];
                String dot = (i==ip.length-1) ?"" :".";
                int newIPSegment = (ipSegment < 0) ? 256 + ipSegment : ipSegment; 
                localIpAddress += newIPSegment + dot;  
            }
        }catch(UnknownHostException e){
            System.out.println(e);
        }
    }
    
    @Override
    public String toString(){
        return this.localIpAddress;
    }
}
