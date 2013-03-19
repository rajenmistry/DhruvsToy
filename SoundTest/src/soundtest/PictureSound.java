/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundtest;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *Creates an object that combines a name, picture and a collection of sounds that can accessed 
 * @author rajen
 */
public class PictureSound implements Serializable {

    private BufferedImage image;
    private String[] songs;
    private BasicPlayer[] arrayOfSounds;
    private String pictureName;
    private String location[] = {"/soundtest/pictures/", "/soundtest/sounds/"};
    private int playTrack;

    /**
     * Constructor for PictureSoubnd
     *
     * @param pictureName name of the animal
     * @param songs String array of sound effect names
     * @throws IOException
     * @throws BasicPlayerException
     */
    public PictureSound(String pictureName, String[] songs) throws
            IOException, BasicPlayerException {
        playTrack = 0;
        this.pictureName = captilize(pictureName);
        image = ImageIO.read(getClass().getResource(location[0]
                + pictureName + ".jpg"));
        this.songs = songs;

        arrayOfSounds = new BasicPlayer[songs.length];
        for (int i = 0; i < songs.length; i++) {
            BasicPlayer temp = new BasicPlayer();
            temp.open(getClass().getResource(location[1] + songs[i]));
            arrayOfSounds[i] = temp;
        }


    }

    /**
     * This constructor was written for testing purposes
     *
     * @param pictureName name of the animal
     * @throws IOException
     */
    public PictureSound(String pictureName) throws IOException {
        this.pictureName = captilize(pictureName);
        image = ImageIO.read(this.getClass().getResource(location[0]
                + pictureName + ".jpg"));
    }

    /**
     * Method to return the buffered image
     *
     * @return the image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Method to return the array of sounds
     *
     * @return array of sounds
     */
    public BasicPlayer[] getSound() {
        return arrayOfSounds;
    }

    /**
     * Method to get the name of the picture
     *
     * @return name of the picture
     */
    public String getName() {
        return pictureName;
    }

    /**
     * Method to return a specific track
     *
     * @param i track to return
     * @return BasicPlayer of track i
     */
    public BasicPlayer getSound(int i) {
        return arrayOfSounds[i];
    }

    /**
     * Method to capitalise the initial letter of the label
     *
     * @param picture name of the picture
     * @return capitalised name of picture
     */
    private String captilize(String picture) {
        return Character.toUpperCase(picture.charAt(0)) + picture.substring(1);

    }

    /**
     * Get the track number to be played
     *
     * @return track number
     */
    public int getPlayTrack() {
        return playTrack;
    }

    /**
     * Set new track number
     *
     * @param newTrack new track number
     */
    public void setPlayTrack(int newTrack) {

        int length = this.getSound().length;
        this.playTrack = (newTrack % length);
    }
}
