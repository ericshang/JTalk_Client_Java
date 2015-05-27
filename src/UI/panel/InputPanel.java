/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.panel;

import UdpConn.messageSender;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Shang
 */
public class InputPanel extends JPanel {
    private Box box ;//the main box of panel, verticle
    JTextField inputField;
    JButton buttonSend;
    private DatagramSocket clientSocket;
    
    public InputPanel(){
        super();
        this.setLayout(new BorderLayout());
        //this.setPreferredSize(new Dimension(430,30));
        this.setAlignmentX(0);
        this.setAlignmentY(0);
        box = Box.createHorizontalBox();
        
        //Box hContainerBox = Box.createHorizontalBox();
        //hContainerBox.setPreferredSize(new Dimension(500,30));
        
        inputField = new JTextField();
        inputField.requestFocus();
        inputField.setPreferredSize(new Dimension(500,30));
        box.add(inputField);
        //hContainerBox.add(inputField);
        
        //hContainerBox.add(Box.createHorizontalStrut(1));
        box.add(Box.createHorizontalStrut(1));
        
        buttonSend = new JButton("Send");
        buttonSend.setPreferredSize(new Dimension(110,30));
        
        
        //hContainerBox.add(buttonSend);
        box.add(buttonSend);
        
        //box.add(hContainerBox);
        
        
        this.add(box,BorderLayout.CENTER);
    }
    
    public JTextField getInputField(){
        return inputField;
    }
    public JButton getButtonSend(){
        return buttonSend;
    }
    
}
