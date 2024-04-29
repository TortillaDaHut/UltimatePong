package gameObjects;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    
    File[] sounds = new File[30]; // array of all sounds
    
    // Sound constructor
    public Sound() {
        sounds[0] = new File("ballBounce.wav");
        sounds[1] = new File("pause.wav");
        sounds[2] = new File("unpause.wav");
        sounds[3] = new File("pressButton.wav");
        // add other sounds in sounds[n] = new File("filename");
    }
        
    public void playSound(int soundIndex) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sounds[soundIndex]));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
    
    
}
    

