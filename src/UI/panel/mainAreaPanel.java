/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Shang
 */
public class mainAreaPanel extends JPanel {
    
    private Box box ;//the main box of panel, verticle
    JLabel mainTxtLabel;
    
    public mainAreaPanel(){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(255,255,255));//white
        
        box = Box.createVerticalBox();
        Border borderIn = BorderFactory.createEmptyBorder(5, 2, 2, 2);
        Border borderOut = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        Border borderGroup = BorderFactory.createCompoundBorder(borderOut,
                        borderIn);
        box.setBorder(borderGroup);
        
        Box hContainerBox = Box.createVerticalBox();
        hContainerBox.setPreferredSize(new Dimension(430,400));
        mainTxtLabel = new JLabel();
        mainTxtLabel.setText("This where messages appears");
        hContainerBox.add(mainTxtLabel);        
        box.add(hContainerBox);
        
        this.add(box,BorderLayout.CENTER);
    }
    
    public JLabel getMainTxtLabel(){
        return mainTxtLabel;
    }

    protected void paintComponent(Graphics g) {  
        ImageIcon icon = new ImageIcon("./image/bg.png"); 
        Image bgImage = icon.getImage();  
        g.drawImage(bgImage, 110, 110, (int) (this.getWidth()*0.7), (int)(this.getHeight()*0.7),   
                         0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
    }
}
