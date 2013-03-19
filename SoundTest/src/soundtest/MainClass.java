/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundtest;

import java.io.IOException;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *Entry point into the program
 * @author rajen
 */
public class MainClass{
    
    public static void main(String[] args) throws BasicPlayerException, IOException {
        
        
        MainWindow maine = new MainWindow();
        maine.setTitle("Dhruv's Toy");   
PictureSoundButtons buttons = new PictureSoundButtons();

        maine.add(buttons);
              maine.pack();
        maine.setVisible(true);
    }

  

    
   
}
