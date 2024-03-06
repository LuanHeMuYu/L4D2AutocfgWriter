package allFrame;

import allController.Custom_Frame;
import allController.Custom_JPanel;
import allController.Custom_MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * 这个JFrame实现的方式
 * 以变量的方式储存
 */
public class bindFrame {
    //常量
    private int Position_X;
    private int Position_Y;

    Custom_Frame mainFrame;

    /**
     * cfg变量
     */
    private String cfgData = "";
    public final Font mainFont_16 = new Font("新方圆", Font.PLAIN, 16);
    public final Font mainFont_32 = new Font("新方圆", Font.PLAIN, 32);
    //UI
    /*左Panel*/
    Custom_JPanel LeftPanel = new Custom_JPanel();

    //控件
    JTextField TextField_bind = new JTextField("bind");
    JTextField TextField_alias = new JTextField("alias");

    /*中Panel*/
    Custom_JPanel CenterPanel = new Custom_JPanel();

    JLabel Title_KeyOrVal = new JLabel("键位名或者变量名");
    JLabel Title_cmdOrVal = new JLabel("指令名变量名或指令串");

    //控件
    JTextField TextField_KeyName = new JTextField();
    JTextField TextField_ValName = new JTextField();
    JTextField TextField_cmdOrVal = new JTextField();
    JTextField TextField_cmds = new JTextField();

    //MessageTextField
    JTextArea TextArea_Message = new JTextArea();

    /*右Panel*/
    Custom_JPanel RightPanel = new Custom_JPanel();

    Custom_btu Confirm_bind = new Custom_btu("添加", mainFont_32);
    Custom_btu Confirm_alias = new Custom_btu("添加", mainFont_32);
    Custom_btu Btu_Preview = new Custom_btu("预览", mainFont_32);

    ///菜单栏
    JMenuBar mainMenu = new JMenuBar();
    JMenu Menu_Save = new JMenu("文件");
    Custom_MenuItem MenuItem_Save = new Custom_MenuItem("保存", mainFont_16);
    Custom_MenuItem MenuItem_Append = new Custom_MenuItem("写入别的cfg后", mainFont_16);
    Custom_MenuItem MenuItem_AboutAuthor = new Custom_MenuItem("关于作者", mainFont_16);
    Custom_MenuItem MenuItem_GoTocfgWriter = new Custom_MenuItem("cfg书写器", mainFont_16);

    //变量

    //构造函数
    public bindFrame() {
        this.Position_X = 100;
        this.Position_Y = 100;
    }

    public bindFrame(int Position_X, int Position_Y) {
        this.Position_X = Position_X;
        this.Position_Y = Position_Y;
    }

    //主入口
    public static void main(String[] args) {
        new bindFrame().init();
    }

    //初始化
    public void init() {
        //在初始化时 创建临时文件temp.txt 在关闭时删除这个文件 仅仅作为创建 不操作
        if (!cfgData.isEmpty()) {
            System.out.print("这个cfg不为空");
            cfgData = "";
        }

        System.out.print("Log:初始化...\n");
        UI_init();
        System.out.print("Log:UI初始化完成...\n");
        Menu_init();
        System.out.print("Log:菜单栏初始化完成...\n");
        Event_init();
        System.out.print("Log:事件初始化完成...\n");
    }

    private void UI_init() {
        mainFrame = new Custom_Frame("bindFrame", Position_X, Position_Y);

        /*LeftPanel*/
        mainFrame.add(LeftPanel);
        LeftPanel.setBounds(0, 0, 200, 540);
        LeftPanel.setLayout(null);

        //TextField_bind
        LeftPanel.add(TextField_bind);
        TextField_bind.setEditable(false);
        TextField_bind.setBounds(0, 100, 200, 100);
        TextField_bind.setFont(mainFont_32);

        //TextField_alias
        LeftPanel.add(TextField_alias);
        TextField_alias.setEditable(false);
        TextField_alias.setBounds(0, 250, 200, 100);
        TextField_alias.setFont(mainFont_32);

        /*CenterPanel*/
        mainFrame.add(CenterPanel);
        CenterPanel.setBounds(200, 0, 550, 540);
        CenterPanel.setLayout(null);

        //Title_KeyOrVal <-记得添加置中
        CenterPanel.add(Title_KeyOrVal);
        Title_KeyOrVal.setFont(new Font("新方圆", Font.PLAIN, 25));
        Title_KeyOrVal.setBounds(10, 0, 300, 100);

        //TextField_KeyName
        CenterPanel.add(TextField_KeyName);
        TextField_KeyName.setFont(mainFont_32);
        TextField_KeyName.setBounds(10, 100, 250, 100);

        //TextField_ValName
        CenterPanel.add(TextField_ValName);
        TextField_ValName.setFont(mainFont_32);
        TextField_ValName.setBounds(10, 250, 250, 100);

        //Title_cmdOrVal<-记得添加置中
        CenterPanel.add(Title_cmdOrVal);
        Title_cmdOrVal.setFont(new Font("新方圆", Font.PLAIN, 25));
        Title_cmdOrVal.setBounds(280, 0, 300, 100);

        //TextField_cmdOrVal
        CenterPanel.add(TextField_cmdOrVal);
        TextField_cmdOrVal.setFont(mainFont_32);
        TextField_cmdOrVal.setBounds(285, 100, 250, 100);

        //TextField_cmds
        CenterPanel.add(TextField_cmds);
        TextField_cmds.setBounds(285, 250, 250, 100);
        TextField_cmds.setFont(mainFont_32);

        //Message
        CenterPanel.add(TextArea_Message);
        TextArea_Message.setFont(mainFont_32);
        TextArea_Message.setBounds(0, 350, 550, 190);
        TextArea_Message.setLineWrap(true);
        TextArea_Message.setEditable(false);
        TextArea_Message.setText("如果有错误信息会显示在这里");

        /*RightPanel*/
        mainFrame.add(RightPanel);
        RightPanel.setBounds(750, 0, 210, 540);
        RightPanel.setLayout(null);

        //Confirm_bind
        RightPanel.add(Confirm_bind);
        Confirm_bind.setBounds(0, 100, 250, 100);

        //Confirm_alias
        RightPanel.add(Confirm_alias);
        Confirm_alias.setBounds(0, 250, 250, 100);

        //Btu_Preview
        RightPanel.add(Btu_Preview);
        Btu_Preview.setBounds(0, 400, 250, 100);
    }

    private void Menu_init() {
        //菜单栏
        mainFrame.setJMenuBar(mainMenu);
        mainMenu.add(Menu_Save);
        Menu_Save.add(MenuItem_Save);
        Menu_Save.add(MenuItem_Append);
        mainMenu.add(MenuItem_GoTocfgWriter);
        mainMenu.add(MenuItem_AboutAuthor);
    }

    void Event_init() {

        //Frame事件
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.printf(cfgData);
                System.exit(0);
            }
        });

        //这是菜单栏 文件保存的事件
        MenuItem_Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                jFileChooser.showOpenDialog(null);
                String Path = jFileChooser.getSelectedFile().toString() + "/Customcfg.cfg";
                //选好路径就开始输出咯
                try {
                    FileWriter fw = new FileWriter(new File(Path));
                    fw.write(cfgData);
                    System.out.print("Log:成功输出");
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //这是菜单栏 添加到别的cfg后面
        MenuItem_Append.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(null);
                File Path = jFileChooser.getSelectedFile();

                String TempLine = "";
                try {
                    FileReader reader = new FileReader(Path);
                    BufferedReader br = new BufferedReader(reader);
                    String str = br.readLine();
                    while (str != null) {
                        TempLine += "\n" + str;
                        str = br.readLine();
                    }
                    TempLine += "\n";
                    System.out.print("读取文件数据并且写入TempLine成功\n");
                    System.out.printf(TempLine);

                    br.close();
                    reader.close();
                    //读取完后创建写入流
                    FileWriter fw = new FileWriter(Path);
                    fw.write(TempLine + cfgData);
                    fw.close();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        //这是菜单栏 关于作者的事件
        MenuItem_AboutAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutAuthorFrame().init();
            }
        });

        //这是菜单栏 前往cfgWriter的事件
        MenuItem_GoTocfgWriter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new cfgWriterFrame(mainFrame.getX(), mainFrame.getY()).init();
                mainFrame.dispose();
            }
        });

        //bind后面的添加按钮的事件
        Confirm_bind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //当按下这个按钮时 我们就获取前面的两个Value 如果有空或者异常 那么将Message"抛出"错误
                String KeyName = TextField_KeyName.getText();
                String cmdOrVal = TextField_cmdOrVal.getText();
                if (KeyName.isEmpty()) {
                    TextArea_Message.setText("键位名字不能为空");
                    return;
                }
                if (cmdOrVal.isEmpty()) {
                    TextArea_Message.setText("指令或者变量名字不能为空");
                    return;
                }
                TextArea_Message.setText("如果有错误信息会显示在这里");
                String output = "bind " + KeyName + " " + "\"" + cmdOrVal + "\"\n";
                /*文本示例: <bind v "Show"> */
                //cfgData += "\n";
                cfgData += output;
                System.out.printf(cfgData);

                TextField_KeyName.setText("");
                TextField_cmdOrVal.setText("");
            }
        });

        //alias后面的添加按钮的事件
        Confirm_alias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //当按下这个按钮时 我们就获取前面的两个Value 如果有空或者异常 那么将Message"抛出"错误
                String ValName = TextField_ValName.getText();
                String cmds = TextField_cmds.getText();
                if (ValName.isEmpty()) {
                    TextArea_Message.setText("变量名字不能为空");
                    return;
                }
                if (cmds.isEmpty()) {
                    TextArea_Message.setText("指令串不能为空");
                    return;
                }
                TextArea_Message.setText("如果有错误信息会显示在这里");

                String output = "alias " + "\"" + ValName + "\"" + " " + "\"" + cmds + "\"\n";
                /*文本示例: <alias "-k" "say_team Hurry!"> */
                //cfgData += "\n";
                cfgData += output;
                System.out.printf(cfgData);

                TextField_ValName.setText("");
                TextField_cmds.setText("");
            }
        });

        //Preview按钮事件
        Btu_Preview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PreviewFrame(cfgData, mainFrame.getX(), mainFrame.getY()).init();
            }
        });
    }

    static class Custom_btu extends JButton {
        public Custom_btu(String Text, Font font) {
            this.setText(Text);
            this.setFont(font);
        }
    }

    class PreviewFrame extends Custom_Frame {
        JTextArea Preview = new JTextArea();
        String text = "";

        public PreviewFrame(String Preview, int Position_X, int Position_Y) {
            super("预览", Position_X + 100, Position_Y + 100);
            text = Preview;
        }

        public void init() {
            this.setLayout(new GridLayout(1, 1));
            this.add(Preview);
            Preview.setText(text);
            Preview.setFont(mainFont_32);
            Preview.setBackground(new Color(123, 123, 123));
            Preview.setEditable(false);
        }
    }
}
