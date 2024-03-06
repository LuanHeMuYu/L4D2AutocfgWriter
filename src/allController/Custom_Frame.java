package allController;

import javax.swing.*;

public class Custom_Frame extends JFrame {
    public Custom_Frame(String title,int Position_X,int Position_Y){
        super(title);
        this.setLayout(null);
        this.setVisible(true);
        this.setBounds(Position_X,Position_Y,960,600);
    }
    public Custom_Frame(String Title,int Width,int Height,int Position_X,int Position_Y){
        super(Title);
        this.setLayout(null);
        this.setVisible(true);
        this.setBounds(Position_X,Position_Y,Width,Height);
    }
}
