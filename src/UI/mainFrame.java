/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.panel.LeftMainPanel;
import UI.panel.RightMainPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Shang
 */
public class mainFrame extends JFrame implements Runnable {
    private ImageIcon iiconTemp = new ImageIcon("./image/icon.png");
    private Image iicon = iiconTemp.getImage();
    
    private LeftMainPanel leftPanel;
    private RightMainPanel rightPanel;
    
    
    public mainFrame(){
        super("JTalk!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(600,500));
        
        this.setLocation(100, 100);
        setIconImage(iicon);
        initComponents();
        validate();
    }
    
    private void initComponents(){
        leftPanel = new LeftMainPanel();
        this.add(leftPanel,BorderLayout.WEST);
        
        rightPanel = new RightMainPanel();
        this.add(rightPanel,BorderLayout.EAST);
        rightPanel.getInputPanel().getInputField().requestFocusInWindow();//set focus to the inputField
        
        
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
    
}
