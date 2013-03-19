/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundtest;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

/**
 * Creates a panel of buttons that can be added to the main window
 *
 * @author rajen
 */
public class PictureSoundButtons extends JPanel implements ActionListener, BasicPlayerListener {
    
    private CollectionOfPictureSounds collection;
    private ArrayList<JButton> buttonArray = new ArrayList<>();
    private JFrame frame = new JFrame();
    private JLabel image = new JLabel();
    private int track;

    /**
     * Class creates the buttons
     *
     * @throws BasicPlayerException
     * @throws IOException
     */
    public PictureSoundButtons() throws BasicPlayerException, IOException {
        HashMap<String, String[]> animals = new MakeData().getStringMap();
        collection = new CollectionOfPictureSounds(animals);

        //layout based on the number of elememts in the hashmap
        this.setLayout(new GridLayout(animals.size(), 1));

        /**
         * A for each loop is used to go through the map and create buttons from
         * the name field of PictureSound
         */
        for (Map.Entry<String, String[]> entry : animals.entrySet()) {
            String string = entry.getKey();
            JButton temp = new JButton(collection.getCollection().get(string).getName());
            temp.setFont(new Font(Font.SERIF, Font.PLAIN, 36));
            temp.addActionListener(this);
            buttonArray.add(temp);
            this.add(temp);
            
        }
        //set frame size and location
        frame.setSize(300, 300);
        frame.setLocation(500, 100);
        //Frame has no buttons
        frame.setUndecorated(true);
    }

    /**
     * Action performed method that responds to buttons being pushed
     *
     * @param ae Action event from button
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String key = ae.getActionCommand().toLowerCase();

        //get image from the hashmap
        BufferedImage icon = collection.getCollection().get(key).getImage();

        //set the icon for the JLabel
        image.setIcon(new ImageIcon(icon));

        /**
         * add, pack and make visible
         */
        frame.add(image);
        frame.pack();
        frame.setVisible(true);
        //when closing the frame, dispose of it. Kills this thread of the GUI
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        try {
            //Get the basicplayer associated with the image and play it
            track = collection.getCollection().get(key).getPlayTrack();
            BasicPlayer ply = collection.getCollection().get(key).getSound(track);
            ply.addBasicPlayerListener(this);
            ply.play();

            //increment track and update the track number
            track++;
            collection.getCollection().get(key).setPlayTrack(track);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(PictureSoundButtons.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void opened(Object o, Map map) {
    }
    
    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {
    }

    /**
     * Check the status of the player
     * http://www.javazoom.net/jlgui/docs/docs2.3/index.html
     *
     * @param bpe BasicPlayerEvent
     */
    @Override
    public void stateUpdated(BasicPlayerEvent bpe) {
        
        switch (bpe.getCode()) {
            //while playing
            case 2:
                frame.setVisible(true);
                toggleButtons(buttonArray, false);
                break;
            //when stopped
            case 3:
                
                frame.dispose();
                toggleButtons(buttonArray, true);
                break;
        }
        
        
    }
    
    @Override
    public void setController(BasicController bc) {
    }

    /**
     * Toggles button status This was changed to an explicit condition. Using
     * jb.setEnabled(!jb.isEnabled) causes the buttons to lock as disabled if
     * they are clicked too quickly
     *
     * @param jbutton array of buttons to toggle
     */
    private void toggleButtons(ArrayList<JButton> jbutton, boolean bool) {
        for (JButton jb : jbutton) {
            jb.setEnabled(bool);
            
        }
        
    }
}
