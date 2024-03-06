package allFrame;

import allController.Custom_Frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AboutAuthorFrame {
    Custom_Frame mainFrame = new Custom_Frame("关于作者",100,100);
    Custom_JPanel mainPanel = new Custom_JPanel();
    public void init(){
        mainFrame.add(mainPanel);
        mainFrame.setLayout(new GridLayout(1,1));
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.repaint();
    }
    public static void main(String[] args){
        new AboutAuthorFrame().init();
    }

    void Event_init(){

    }
    class Custom_JPanel extends JPanel{
        @Override
        public void paint(Graphics g) {
            try {
                ImageIcon img= new ImageIcon(ImageIO.read(new File("D:\\JAVA\\AutocfgWriter-Remastered\\img\\Authorpng.png")));
                g.drawImage(img.getImage(),-10,-15,960,600,this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
