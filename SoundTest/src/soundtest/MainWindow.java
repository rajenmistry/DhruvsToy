/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundtest;

import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JFrame;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *Creates the Main window on to which buttons are added
 * @author rajen
 */
public class MainWindow extends JFrame implements WindowListener {
    
    public MainWindow() throws BasicPlayerException, IOException {
        /**
         * Draw the main window
         */
        setLayout(new GridBagLayout());
        this.setSize(300, 300);
        this.setLocation(100, 100);
        this.addWindowListener(this);
        
//Dispose on close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    @Override
    public void windowOpened(WindowEvent we) {
        System.out.println("window open");
    }
    
    @Override
    public void windowClosing(WindowEvent we) {
        System.out.println("windowclosing");
    }
    
    @Override
    public void windowClosed(WindowEvent we) {
        System.out.println("window closed");
    }
    
    @Override
    public void windowIconified(WindowEvent we) {
    }
    
    @Override
    public void windowDeiconified(WindowEvent we) {
    }
    
    @Override
    public void windowActivated(WindowEvent we) {
    }
    
    @Override
    public void windowDeactivated(WindowEvent we) {
    }
}
