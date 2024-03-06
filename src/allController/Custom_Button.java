package allController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 有需求的话可以写UI美化
 */
public class Custom_Button extends JButton {
    //3.0开始画UI
    private int Width;
    private int Heigth;
    public Custom_Button(String title, Font font) {
        super(title);
        this.setFont(font);
        //repaint();
    }

    public Custom_Button(String title, Font font,int Width,int Height) {
        super(title);
        this.setFont(font);
        this.setBounds(0,0,Width,Height);
        //repaint();
    }

    @Override
    public void paint(Graphics g) {
        try {
            ImageIcon img = new ImageIcon(ImageIO.read(new File("D:\\JAVA\\AutocfgWriter-Remastered\\img\\Button.png")));
            g.drawImage(img.getImage(),0,0,309,140,this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
