import javax.swing.*;
import java.awt.*;

public class AboutAuthor {
    JFrame Athor = new JFrame("关于作者");
    MyCanvas myCanvas = new MyCanvas();
    JPanel Message = new JPanel(new GridLayout(2,1));
    JLabel Label1 = new JLabel();
    JLabel Label2 = new JLabel();
    Font LabelFont = new Font("新方圆",Font.PLAIN,16);
    void init(){

        Label1.setBackground(Color.ORANGE);
        Label2.setBackground(Color.ORANGE);
        Label1.setText("BiliBili@--滦河暮鱼--");
        //Label2.setText("Steam(URL)->/Azazelkawaii/");
        Label1.setFont(LabelFont);
        Label2.setFont(LabelFont);
        Message.add(Label1);
        Message.add(Label2);
        Message.setBounds(0,100,300,60);
        Athor.add(Message);
        myCanvas.setSize(200,200);
        myCanvas.setLocation(50,0);
        Athor.add(myCanvas);
        Athor.setLayout(null);
        Athor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Athor.setVisible(true);
        Athor.setBounds(100, 100, 300, 280);
    }

    class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.setColor(new Color(142, 111, 240));
            g.setFont(new Font("新方圆",Font.BOLD,64));
            g.drawString("Azazel",0,50);
        }
    }
}
