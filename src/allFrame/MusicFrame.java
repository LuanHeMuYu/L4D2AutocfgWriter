package allFrame;

import allController.Custom_Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;

public class MusicFrame {
    Font mainFont = new Font("新方圆",Font.PLAIN,16);

    Custom_Frame mainFrame = new Custom_Frame("音乐播放器",100,100);
    JPanel MainPanel = new JPanel();
    List<JButton> Btus;//按钮集合

    public static void main(String[] args){
        new MusicFrame().init();
    }

    /**初始化*/
    public void init(){
        UI_init();
        Btu_init();
    }

    void UI_init(){
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        mainFrame.setLayout(null);

        mainFrame.add(MainPanel);
        MainPanel.setLayout(new GridLayout(10,1));
        MainPanel.setBounds(0,0,600,600);

        //MusicChoice.setFont(new Font("新方圆",Font.PLAIN,16));
    }

    void Btu_init(){
        String Path = "D:\\JAVA\\AutocfgWriter-Remastered\\music";
        File Folder = new File(Path);
        Path = Path + "\\";
        File[] files = Folder.listFiles();
        if (files != null) {
            for (int i = 0;i < files.length;i++){
                Btus.add(new JButton(String.valueOf(files[i])));
                MainPanel.add(Btus.get(i));
                Btus.get(i).setFont(mainFont);
            }

        }
    }
}
