import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnterValue {
    JFrame main = new JFrame("请输入值");
    JTextField EnterBox = new JTextField();
    private int Res = -1;
    public int init(){
        EnterBox.setBounds(0,0,300,50);
        main.setBounds(0,0,300,80);
        main.add(EnterBox);
        main.setLayout(null);
        main.setVisible(true);
        EnterBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String key = "0123456789";
                if(key.indexOf(e.getKeyChar())<0){
                    e.consume();
                }
            }
        });
        main.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(EnterBox.getText() == ""){
                    System.exit(0);
                }
                int res = Integer.parseInt((EnterBox.getText().toString()));
                Res = res;
            }
        });
        return Res;
    }

    public static void main(String[] args){
        new EnterValue().init();
    }
}
