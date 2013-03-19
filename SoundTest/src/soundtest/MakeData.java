/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundtest;

import java.util.HashMap;

/**
 *Make the data structures to pass to the PictureSound constructor
 * @author rajen
 */
public class MakeData {

    public MakeData() {
    }
/**
 * Creates an array of Strings
 * @return array of strings containing the animals
 */
    public String[] getStringArray() {
        return new String[]{"cheetah", "elephant", "dog", "monkey", "zebra"};
    }
/**
 * Creates a HashMap of String as a key and String[] as object
 * @return HashMap<String,String[]> of animal name and sound effect names.
 */
    public HashMap getStringMap() {

        HashMap<String, String[]> t = new HashMap<>();
        t.put("dog", new String[]{"dog.mp3", "woof.mp3"});
        t.put("elephant", new String[]{"elephant.mp3", "elephantTrumpet.mp3"});
        t.put("monkey", new String[]{"monkey.mp3", "monkeySound.mp3"});
        t.put("zebra", new String[]{"zebra.mp3", "horses.mp3"});
        t.put("snake", new String[]{"snake.mp3"});
        return t;


    }
}