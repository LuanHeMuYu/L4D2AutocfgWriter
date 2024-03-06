package Music;

import com.sun.jndi.toolkit.url.Uri;

import javax.sound.sampled.*;
import javax.swing.plaf.multi.MultiScrollBarUI;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
/**只是一个单纯的音乐播放类 构造函数传入path即可实例化*/
public class MusicPlayer {
    private InputStream aio;
    private Clip bgm;

    public MusicPlayer() {
    }

    /**
     * &#064;Path  音频文件路径
     */
    public MusicPlayer(String Path) {
        try {
            this.bgm = AudioSystem.getClip();
            this.aio = AudioSystem.getAudioInputStream(new File(Path));

            bgm.open((AudioInputStream) aio);
            //FloatControl gainContral = (FloatControl) bgm.getControl(FloatControl.Type.MASTER_GAIN);

        } catch (Exception e) {
            System.out.printf("初始化错误");
            System.out.printf(e.toString());
        }
    }

    public void Start() {
        bgm.start();
    }

    public void Stop() {
        bgm.stop();
    }

    public int GetMusicLength(){
        return bgm.getFrameLength();
    }

    public static void main(String[] args) throws InterruptedException {
        MusicPlayer mp = new MusicPlayer("D:\\JAVA\\AutocfgWriter-Remastered\\music\\激昂サバイブ-FranChouChou.wav");
        while (true) {
            mp.Start();
            Thread.sleep(100000);
            mp.Stop();
        }
    }
}
