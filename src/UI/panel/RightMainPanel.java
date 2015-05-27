/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Shang
 */
public class RightMainPanel extends JPanel {
    private Box box ;//the main box of panel, verticle
    private JLabel mainTxtLabel ;
    private InputPanel inputPanel;
    private mainAreaPanel mainArea;
    
    public RightMainPanel(){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(240,240,255));//white
        this.setPreferredSize(new Dimension(500,400));
        
        
        box = Box.createVerticalBox();
        
        Border borderIn = BorderFactory.createEmptyBorder(5, 10, 10, 10);
        Border borderOut = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        Border borderGroup = BorderFactory.createCompoundBorder(borderOut,
                        borderIn);
        box.setBorder(borderGroup);
        
        mainTxtLabel = new JLabel();
        mainTxtLabel.setText("This is a very good moment and we all need to remember");
        
        box.add(mainTxtLabel, BorderLayout.NORTH);
        
        //adding the main area panel, used to show all messages
        mainArea = new mainAreaPanel();
        box.add(mainArea,BorderLayout.CENTER);
        box.add(Box.createVerticalStrut(2));
        
        JLabel messageLabel = mainArea.getMainTxtLabel();
        messageLabel.setText("<html><p>Tom says: hello </p> <p> Frank says: world!</p></html>");
        
        //adding the input panel in the right bottom
        inputPanel = new InputPanel();
        inputPanel.getInputField().requestFocus(true);
        box.add(inputPanel, BorderLayout.CENTER);
        
        this.add(box,BorderLayout.CENTER);
    }
    
    public JLabel getMainTxtLabel(){
        return mainTxtLabel;
    }
    public InputPanel getInputPanel(){
        return inputPanel;
    }
    public mainAreaPanel getMainArea(){
        return mainArea;
    }
}
