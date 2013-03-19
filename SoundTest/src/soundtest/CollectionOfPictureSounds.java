/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundtest;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 * Creates a HashMap of <String,PictureSound>
 *
 * @author rajen
 */
public class CollectionOfPictureSounds {

    private HashMap<String, PictureSound> collection;
    // private List<PictureSound> list;

    public HashMap<String, PictureSound> getCollection() {
        return collection;
    }

    /**
     * Takes an array of Strings and creates a hashmap of Strings and images
     *
     * @param name array of Strings containing the animal names
     * @throws BasicPlayerException
     * @throws IOException
     */
    public CollectionOfPictureSounds(String[] name) throws BasicPlayerException, IOException {
        collection = new HashMap<>();
        //   list = new LinkedList<>(); //was considering lists
        for (String string : name) {
            //     list.add(new PictureSound(string));
            collection.put(string, new PictureSound(string));

        }
    }

    /**
     * Takes a hashmap of Strings and String[] and creates a hashmap of String
     * and PictureSound, where the PictureSound has a picture and an array of
     * sounds
     *
     * @param map of String and PictureSound
     * @throws IOException
     * @throws BasicPlayerException
     */
    public CollectionOfPictureSounds(HashMap<String, String[]> map) throws IOException, BasicPlayerException {
        collection = new HashMap<>();
        //list = new LinkedList<>();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] sounds = entry.getValue();
            collection.put(key, new PictureSound(key, sounds));
            //  list.add(new PictureSound(key, sounds));

        }


    }
}
