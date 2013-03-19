/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * 
 * Images are from http://openphoto.net/
 */
package soundtest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jlgui.basicplayer.*;
import java.util.Set;
/**
 *Test class for aspects of pictureSound
 * @author rajen
 */
public class PictureSoundTest {
    
    public static void main(String[] args) throws IOException, BasicPlayerException, JavaLayerException {

HashMap<String, String[]> map = new MakeData().getStringMap();
        Set keys = map.keySet();
        for (Iterator it = keys.iterator(); it.hasNext();) {
          
            
            it.next();
        }
    }
}

