/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtalk;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author Shang
 */
public class localMachineIP {
    private String ip;
    private String localip = null;// localnetwork IP  
    private String netip = null;// real IP
    
    public localMachineIP(){
        ip = getIp();
    }
    @Override
    public String toString(){
        return ip;
    }

    /** 
     * process multiple IPs 
     * @return 
     */  
    public String getIp() {  
 
        try {  
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();  
            InetAddress ip = null;  
            boolean finded = false;// 是否找到外网IP  
            while (netInterfaces.hasMoreElements() && !finded) {  
                NetworkInterface ni = netInterfaces.nextElement();  
                Enumeration<InetAddress> address = ni.getInetAddresses();  
                while (address.hasMoreElements()) {  
                    ip = address.nextElement();
                    if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()  
                            && ip.getHostAddress().indexOf(":") == -1) {// 外网IP  
                        netip = ip.getHostAddress();  
                        finded = true;  
                        break;  
                    } else if (ip.isSiteLocalAddress()  
                            && !ip.isLoopbackAddress()  
                            && ip.getHostAddress().indexOf(":") == -1) {// 内网IP  
                        localip = ip.getHostAddress();  
                    }  
                }  
            }  
        } catch (SocketException e) {  
            e.printStackTrace();  
        }  
        if (localip != null && !"".equals(localip)) {  
            return localip;  
        } else {  
            return netip;  
        }
    }  

}
