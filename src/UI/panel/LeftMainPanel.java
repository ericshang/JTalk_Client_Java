/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Shang
 */
public class LeftMainPanel extends JPanel{
    private Box box ;//the main box of panel, verticle
    private JButton buttonQuit;
    private JLabel leftTopLabel;
    private JLabel leftUserListLabel;
    
    public LeftMainPanel(){
        super();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(100,400));
        this.setBackground(new Color(255,255,255));//white
        box = Box.createVerticalBox();
        Border borderIn = BorderFactory.createEmptyBorder(5, 10, 10, 10);
        Border borderOut = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        Border borderGroup = BorderFactory.createCompoundBorder(borderOut,
                        borderIn);
        
        box.setBorder(borderGroup);
        
        
        Box hContainerBox3 = Box.createHorizontalBox();
        buttonQuit = new JButton("Quit");
        hContainerBox3.add(buttonQuit);
        box.add(hContainerBox3);
        box.add(Box.createVerticalStrut(10));//add space in between
        
        leftTopLabel = new JLabel ("Users Online");  
        Box hContainerBox = Box.createHorizontalBox();
        hContainerBox.add(leftTopLabel);
        box.add(hContainerBox);
        box.add(Box.createVerticalStrut(10));//add space in between
        
        leftUserListLabel = new JLabel("<html> <p>Tom</p> <p>John</p></html>");
        Box hContainerBox2 = Box.createHorizontalBox();
        hContainerBox2.add(leftUserListLabel);
        hContainerBox2.setPreferredSize(new Dimension(100,300));
        box.add(hContainerBox2);
        box.add(Box.createVerticalStrut(50));//add space in between
        
        
        
        
        this.add(box,BorderLayout.CENTER);
    }

    public JButton getButtonQuit(){
        return buttonQuit;
    }
    public JLabel getLeftUserListLabel(){
        return leftUserListLabel;
    }
}
