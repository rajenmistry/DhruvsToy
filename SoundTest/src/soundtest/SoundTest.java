/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundtest;

import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javazoom.jlgui.basicplayer.*;

/**
 * Original single class attempt at this project. This was then split into
 * several classes for improved maintenance and implementation
 *
 * @author rajen
 */
public class SoundTest extends JFrame implements WindowListener {

    /**
     *
     */
    final BasicPlayer raj = new BasicPlayer();
    private JButton buttonClicked;
    JFrame PictureFrame = new JFrame();

    public SoundTest() throws BasicPlayerException, IOException {
        setLayout(new BorderLayout());
        PictureFrame.setLayout(new GridBagLayout());
        PictureFrame.setSize(900, 900);
        PictureFrame.setLocation(500, 100);
        final BufferedImage image = ImageIO.read(new File("image1.jpg"));
        final JLabel picture = new JLabel(new ImageIcon(image));
        raj.addBasicPlayerListener(new BasicPlayerListener() {
            @Override
            public void opened(Object o, Map map) {
            }

            @Override
            public void progress(int i, long l, byte[] bytes, Map map) {
            }

            @Override
            public void stateUpdated(BasicPlayerEvent bpe) {

                if (bpe.getCode() != 3) {

                    PictureFrame.add(picture);

                    PictureFrame.setVisible(true);
                    buttonClicked.setEnabled(false);





                } else {
                    buttonClicked.setEnabled(true);
                    PictureFrame.setVisible(false);
                }
            }

            @Override
            public void setController(BasicController bc) {
            }
        });

        JFrame alpha = new JFrame("Apple");
        alpha.addWindowListener(this);
        alpha.setSize(600, 600);
        alpha.setLocation(300, 300);


        final JButton b1 = new JButton("Sound 1");
        b1.setFont(new Font("arial", Font.ITALIC, 36));

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (raj.getStatus() != 0) {
                    try {
                        buttonClicked = b1;
                        raj.open(new File("bip.ogg"));

                        raj.play();

                    } catch (BasicPlayerException ex) {
                        Logger.getLogger(SoundTest.class.getName()).log(Level.SEVERE, null, ex);
                    }


                }
            }
        });

        final JButton b2 = new JButton("Sound 2");
        b2.setFont(new Font("arial", Font.ITALIC, 36));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (raj.getStatus() != 0) {
                    try {
                        buttonClicked = b2;
                        raj.open(new File("tada.ogg"));
                        raj.play();
                    } catch (BasicPlayerException ex) {
                        Logger.getLogger(SoundTest.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });


        final JButton b3 = new JButton("Sound 3");
        b3.setFont(new Font("arial", Font.ITALIC, 36));
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (raj.getStatus() != 0) {
                    try {
                        buttonClicked = b3;
                        raj.open(new File("ping.ogg"));
                        raj.play();
                    } catch (BasicPlayerException ex) {
                        Logger.getLogger(SoundTest.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }


            }
        });
        alpha.add(b1, BorderLayout.NORTH);
        alpha.add(b2, BorderLayout.CENTER);
        alpha.add(b3, BorderLayout.SOUTH);
        alpha.pack();
        alpha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        alpha.setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BasicPlayerException, IOException {


        SoundTest apple = new SoundTest();

        // TODO code application logic here
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("open");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("bye bye");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        if (raj.getStatus() == 0) {
            try {
                raj.stop();

            } catch (BasicPlayerException ex) {
                Logger.getLogger(SoundTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("was not playing");
        }


    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}