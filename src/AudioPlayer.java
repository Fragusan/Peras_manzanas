import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    private Clip clip;

    public void playSound(String
                                  ruta, boolean repite) {
        try {
            File soundFile = new File(ruta);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);


            clip = AudioSystem.getClip();
            clip.open(audioStream);

            if (repite) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.loop(0);
            }

            clip.start();
        } catch (UnsupportedAudioFileException
                 | IOException | LineUnavailableException e) {
            e.printStackTrace();
            System.out.println("error reproduciendo el audio");
        }
    }

    public void stopSound() {
        if (clip != null
                && clip.isRunning()) {
            clip.stop();
        }
    }
}