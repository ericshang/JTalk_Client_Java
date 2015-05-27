/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.panel.LeftMainPanel;
import UI.panel.RightMainPanel;
import UdpConn.messageSender;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.*;
import static jtalk.JTalk.clientIP;
import static jtalk.JTalk.currentClientName;
import rmiPackage.Client;
import rmiPackage.ClientListFromServer;

/**
 *
 * @author Shang
 */
public class mainFrame extends JFrame implements Runnable {
    private ClientListFromServer clientList;
    private ArrayList<Client> clients;
    
    private ImageIcon iiconTemp = new ImageIcon("./image/icon.png");
    private Image iicon = iiconTemp.getImage();
    
    private LeftMainPanel leftPanel;
    private RightMainPanel rightPanel;
    private JButton buttonSend;
    private JTextField inputField;
    private JLabel mainTxtLabel;
    private JLabel mainTopLable;
    ArrayList<String> messageList = new ArrayList<String>(15);//used to store messgaes 
    private JButton buttonQuit;
    private JLabel leftUserListLabel;
    
    
    
    
    public mainFrame(){
        super("JTalk!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(600,500));
        
        this.setLocation(100, 100);
        setIconImage(iicon);
        initComponents();
        
        //when window closing, must unregister 
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        validate();
    }
    
    private void initComponents(){
        leftPanel = new LeftMainPanel();
        this.add(leftPanel,BorderLayout.WEST);
        buttonQuit = leftPanel.getButtonQuit();
        
        buttonQuit.addActionListener(new ActionListener() {//quit program
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        
        rightPanel = new RightMainPanel();
        this.add(rightPanel,BorderLayout.EAST);
        rightPanel.getInputPanel().getInputField().requestFocusInWindow();//set focus to the inputField
        
        buttonSend = rightPanel.getInputPanel().getButtonSend();
        buttonSend.addActionListener(new ActionListener() {//send msg
            @Override
            public void actionPerformed(ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });
        inputField = rightPanel.getInputPanel().getInputField();
        inputField.addKeyListener(new KeyListener(){//send message
            @Override
            public void keyTyped(KeyEvent ke) {
            }
            @Override
            public void keyPressed(KeyEvent ke) {   
            }
            @Override
            public void keyReleased(KeyEvent ke) {
                inputFieldKeyReleasedPerformed(ke);
            }
        });
        mainTxtLabel = rightPanel.getMainArea().getMainTxtLabel();
        mainTopLable = rightPanel.getMainTxtLabel();
        
        
        updateUserList();//get user list using RMI
        //all clients from Server
        printUserList();
        setVisible(true);
        pack();
    }
    public void restart(){
        this.remove(leftPanel);
        this.remove(rightPanel);
        
        //.......Left part of the window........
        leftPanel = new LeftMainPanel();
        this.add(leftPanel,BorderLayout.WEST);
        //.......Right part of the window........
        rightPanel = new RightMainPanel();
        this.add(rightPanel,BorderLayout.EAST);
        
        rightPanel.getInputPanel().getInputField().requestFocusInWindow();//set focus to the inputField
        
        updateUserList();//get user list using RMI
        //all clients from Server
        printUserList();
        pack();
        validate();
    }
    
    @Override
    public void run() {
    
    }
    
    public LeftMainPanel getLeftPanel(){
        return leftPanel;
    }
    
    public RightMainPanel getRightPanel(){
        return rightPanel;
    }
    
    
    //actions
    public void sendBtnActionPerformed(ActionEvent evt){
            String msg = inputField.getText();        
            messageSender sender = new messageSender();
            Thread senderThread = new Thread(sender);
            senderThread.start();
            
            sender.sendMessage(msg);
            
            if(messageList.size()>=15){
                messageList.remove(0);
            }
            //print out msges
            if(msg != null && msg.length()>0){
                messageList.add(msg);
            }
            
            mainTxtLabel.setText(printMessages(messageList));
            inputField.setText(null);
            
            repaint();
    }
    
    public void inputFieldKeyReleasedPerformed(KeyEvent ke){
        if(ke.getKeyCode() == Event.ENTER){
            String msg = inputField.getText();        
            messageSender sender = new messageSender();
            Thread senderThread = new Thread(sender);
            senderThread.start();
            
            sender.sendMessage(msg);
            
            if(messageList.size()>=15){
                messageList.remove(0);
            }
            //print out msges
            if(msg != null && msg.length()>0){
                messageList.add(msg);
            }
            
            mainTxtLabel.setText(printMessages(messageList));
            inputField.setText(null);
            repaint();
        }
    }
    
    private String printMessages(ArrayList<String> msgs){
        
        String result ="<html>";
        for(String msg : msgs){
            if(msg == null || msg.length()<1)
                continue;
            result +=" <p>"+msg+"</p> ";
            
        }
        result += "</html>";
        return result;
    }
    public void setMainTopLabelText(String str){
        mainTopLable.setText(str);
    }
    
    //get user list from server using RMI
    public void updateUserList(){
        try{
            clientList = new ClientListFromServer();
            Thread getClientThread = new Thread(clientList);//new thread!!!
            getClientThread.start();
            currentClientName = currentClientName.equals("") ? 
                                    "Unknown"                   :
                                currentClientName ;
            
            //put current client into sever
            Client client = new Client(currentClientName, clientIP, 0);
            clientList.addClient(client);//register client to server
            clients = clientList.getClients();
        }catch(RemoteException e){
            System.out.println(e);
        }
    }
    
    private void printUserList(){
        if(clients!=null){
            leftUserListLabel = leftPanel.getLeftUserListLabel();//the container to display all users
            String clientsStr ="<html>";
            for(Client client : clients){
                clientsStr += "<p>Name: "+ client.getName() +
                                "<br />IP:"+ client.getIpAddress()+
                              "</p>";
            }
            clientsStr +="</html>";
            leftUserListLabel.setText(clientsStr);
        }else{
            leftUserListLabel.setText(clients.toString());
        }
    }
    
    public void clearingCliengFromServer(){
    }
    
    
    
}
