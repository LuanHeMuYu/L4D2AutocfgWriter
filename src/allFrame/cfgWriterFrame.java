package allFrame;

import Music.MusicPlayer;
import allController.Custom_Button;
import allController.Custom_Frame;
import allController.Custom_JPanel;
import allController.Custom_MenuItem;
import data_srtruct.cfgWriter.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.Random;

/**
 * 这个类 主要是创建了一个Data_Sturct的实例 然后用这个实例去写入cfg文件
 */
public class cfgWriterFrame {
    //常量
    Data_Sturct dataSturct = new Data_Sturct();
    Lerp Data_lerp = new Lerp();
    Net Data_Net = new Net();
    Other Data_Other = new Other();
    data_srtruct.cfgWriter.Color Data_Color = new data_srtruct.cfgWriter.Color();
    Crosshair Data_CrossHair = new Crosshair();
    public final Font mainFont_16 = new Font("新方圆", Font.PLAIN, 16);
    public final Font mainFont_32 = new Font("新方圆", Font.PLAIN, 32);
    //变量
    private boolean isPlay = false;//音乐是否正在播放
    private int CommonVal = -1;
    public int Position_X = 100;//实现切换窗口后在相同位置出现
    public int Position_Y = 100;
    MusicPlayer mp3;//音乐
    String Cur_Music = "";
    //UI
    ///主要控件
    /**
     * 左边主要Panel
     */
    JPanel LeftPanel = new JPanel();
    //左Panel上的控件
    Custom_Button Btu_Lerp = new Custom_Button("Lerp", mainFont_16);
    Custom_Button Btu_Net = new Custom_Button("网络", mainFont_16);
    Custom_Button Btu_Other = new Custom_Button("杂项", mainFont_16);
    Custom_Button Btu_Color = new Custom_Button("颜色", mainFont_16);
    Custom_Button Btu_CrossHair = new Custom_Button("准星", mainFont_16);
    /**
     * 中间Panel
     */
    JPanel CenterPanel = new JPanel();
    JPanel Panel_Choose = new JPanel();
    Choice Choice_Function = new Choice();//左边按钮控制显示信息
    JTextArea TextArea_Preview = new JTextArea("描述");
    /**
     * 右边Panel
     */
    RightPanel_Cus RightPanel = new RightPanel_Cus();
    Custom_Button Btu_Setting = new Custom_Button("设置", mainFont_16);
    JTextArea TextArea_MusicInfo = new JTextArea();

    ///菜单栏
    JMenuBar mainMenu = new JMenuBar();
    JMenu Menu_Save = new JMenu("文件");
    JMenu Menu_PlayMusic = new JMenu("放首音乐");
    Custom_MenuItem MenuItem_Save = new Custom_MenuItem("保存", mainFont_16);
    Custom_MenuItem MenuItem_Append = new Custom_MenuItem("写入别的cfg后", mainFont_16);
    Custom_MenuItem MenuItem_AboutAuthor = new Custom_MenuItem("关于作者", mainFont_16);
    Custom_MenuItem MenuItem_PlayRandomSAGASound = new Custom_MenuItem("随机音乐", mainFont_16);
    Custom_MenuItem MenuItem_GoToBind = new Custom_MenuItem("绑定键位", mainFont_16);
    //主界面
    Custom_Frame mainFrame;
    Timer Flash;//刷新器
    //方法

    String datatxtReader(String Text) {
        try {
            FileReader fr = new FileReader(new File("D:\\JAVA\\AutocfgWriter-Remastered\\src\\data_srtruct\\cfgWriter\\data.txt"));
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            while (str != null) {
                //非颜色情况
                if (str.equals(Text)) {
                    //如果是同一字符串 那么就返回下一个字符串
                    str = br.readLine();
                    br.close();
                    fr.close();
                    return str;
                }
                //颜色情况
                if (str.contains("Color")) {
                    //如果是Color描述 则去掉这个Color
                    if (str.replace("Color ", "").equals(Text)) {
                        str = br.readLine();
                        br.close();
                        fr.close();
                        return str;
                    }
                    //System.out.printf(str.replace("Color ", ""));
                }
                str = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Can't Find";
    }

    /**
     * 这个方法和datatxtReader相同 只是返回值改变
     */
    boolean isColor(String Text) {
        try {
            FileReader fr = new FileReader(new File("D:\\JAVA\\AutocfgWriter-Remastered\\src\\data_srtruct\\cfgWriter\\data.txt"));
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            int LineCount = 1;
            while (str != null) {
                //非颜色情况
                if (str.equals(Text)) {
                    //如果是同一字符串 那么就返回下一个字符串
                    str = br.readLine();
                    br.close();
                    fr.close();
                    return false;
                }
                //颜色情况
                if (str.contains(Text)) {
                    //如果是同一字符串 那么就返回下一个字符串
                    str = br.readLine();
                    br.close();
                    fr.close();
                    return true;
                }
                str = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public cfgWriterFrame() {
        mainFrame = new Custom_Frame("cfg书写器", Position_X, Position_Y);
    }

    public cfgWriterFrame(int Position_x, int Position_y) {
        Position_X = Position_x;
        Position_Y = Position_y;
        mainFrame = new Custom_Frame("cfg书写器", Position_X, Position_Y);
    }

    //主入口
    public static void main(String[] args) {
        new cfgWriterFrame().init();
    }

    //初始化
    public void init() {
        Panel_init();
        Choice_Function.addItem(" ");

        Menu_init();
        Event_init();

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Flash.stop();
                System.exit(0);
            }
        });

        Flash = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = datatxtReader(Choice_Function.getSelectedItem());
                TextArea_Preview.setText(str);
            }
        });
        Flash.start();
    }

    private void Panel_init() {
        //左Panel
        mainFrame.add(LeftPanel);
        LeftPanel.setBounds(0, 0, 160, 540);
        LeftPanel.setLayout(new GridLayout(5, 1));

        LeftPanel.add(Btu_Lerp);
        LeftPanel.add(Btu_Net);
        LeftPanel.add(Btu_CrossHair);
        LeftPanel.add(Btu_Color);
        LeftPanel.add(Btu_Other);
        //中Panel
        mainFrame.add(CenterPanel);
        CenterPanel.setBounds(160, 0, 500, 537);
        CenterPanel.setLayout(null);

        Panel_Choose.setBounds(0, 0, 500, 300);//剩237给Preview
        //Panel_Choose.setBackground(new Color(152, 120, 24));
        Panel_Choose.setFont(mainFont_32);
        CenterPanel.add(Panel_Choose);

        Panel_Choose.add(Choice_Function);
        Panel_Choose.setLayout(null);
        Choice_Function.setBounds(0, 0, 500, 100);

        TextArea_Preview.setBounds(0, 300, 500, 237);
        TextArea_Preview.setFont(mainFont_32);
        TextArea_Preview.setLineWrap(true);
        TextArea_Preview.setEditable(false);
        //TextArea_Preview.setBackground(new Color(52, 124, 5));//这行记得删
        CenterPanel.add(TextArea_Preview);

        //右Panel
        mainFrame.add(RightPanel);
        RightPanel.setBounds(660, 0, 300, 537);
        //RightPanel.setBackground(Color.ORANGE);//这行记得删
        RightPanel.setLayout(null);

        RightPanel.add(Btu_Setting);
        RightPanel.add(TextArea_MusicInfo);
        TextArea_MusicInfo.setEditable(false);
        TextArea_MusicInfo.setBounds(0, 0, 300, 350);
        TextArea_MusicInfo.setBackground(Color.ORANGE);
        TextArea_MusicInfo.setLineWrap(true);
        TextArea_MusicInfo.setFont(mainFont_32);
        Btu_Setting.setBounds(0, 350, 300, 187);

    }
    
    private void Menu_init() {
        //菜单栏
        mainFrame.setJMenuBar(mainMenu);
        mainMenu.add(Menu_Save);
        Menu_Save.add(MenuItem_Save);
        Menu_Save.add(MenuItem_Append);
        mainMenu.add(MenuItem_GoToBind);
        mainMenu.add(MenuItem_AboutAuthor);
        mainMenu.add(Menu_PlayMusic);
        Menu_PlayMusic.add(MenuItem_PlayRandomSAGASound);
    }

    void Event_init() {
        //菜单栏事件
        MenuItem_GoToBind.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new bindFrame(mainFrame.getX(), mainFrame.getY()).init();
                Flash.stop();
                mainFrame.dispose();
            }
        });
        MenuItem_AboutAuthor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new AboutAuthorFrame().init();
            }
        });
        MenuItem_Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                jFileChooser.showOpenDialog(null);
                String Path = jFileChooser.getSelectedFile().toString() + "/Customcfg.cfg";
                System.out.println(Path);
                dataSturct.WriteOut(Path);
            }
        });
        MenuItem_Append.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(null);
                String Path = jFileChooser.getSelectedFile().toString();
                System.out.println(Path);
                dataSturct.Appendcfg(Path);
            }
        });
        MenuItem_PlayRandomSAGASound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Flash.stop();//这个是Debug内容 只在Debug时使用
                if (isPlay) {
                    mp3.Stop();
                    isPlay = false;
                }
                if (!isPlay) {
                    isPlay = true;

                    FileReader fr = null;


                    if (!Cur_Music.isEmpty()) {
                        try {
                            fr = new FileReader(new File("D:\\JAVA\\AutocfgWriter-Remastered\\src\\Music\\MusicData.txt"));
                            BufferedReader br = new BufferedReader(fr);

                            String str = br.readLine();
                            while (!str.equals(Cur_Music)) {
                                str = br.readLine();
                                if (str == null) {
                                    System.out.printf("音乐目录到结尾了");
                                    break;
                                }
                            }
                            str = br.readLine();
                            if (str == null) {
                                str = "激昂サバイブ-FranChouChou.wav";
                            }
                            Cur_Music = str;

                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {
                        MenuItem_PlayRandomSAGASound.setText("下一首");
                        Cur_Music = "激昂サバイブ-FranChouChou.wav";
                    }

                    TextArea_MusicInfo.setText("当前播放:\n" + Cur_Music);
                    mp3 = new MusicPlayer("D:\\JAVA\\AutocfgWriter-Remastered\\music\\" + Cur_Music);
                    mp3.Start();
                }
            }
        });
        //左侧按钮事件
        Btu_Lerp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Choice_Function.removeAll();
                Field[] fields = Data_lerp.getClass().getFields();
                for (Field field : fields) {
                    Choice_Function.addItem(field.getName());
                }
            }
        });
        Btu_Color.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Choice_Function.removeAll();
                Field[] fields = Data_Color.getClass().getFields();
                for (Field field : fields) {
                    Choice_Function.addItem(field.getName());
                }
            }
        });
        Btu_Net.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Choice_Function.removeAll();
                Field[] fields = Data_Net.getClass().getFields();
                for (Field field : fields) {
                    Choice_Function.addItem(field.getName());
                }
            }
        });
        Btu_Other.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Choice_Function.removeAll();
                Field[] fields = Data_Other.getClass().getFields();
                for (Field field : fields) {
                    Choice_Function.addItem(field.getName());
                }
            }
        });
        Btu_CrossHair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Choice_Function.removeAll();
                Field[] fields = Data_CrossHair.getClass().getFields();
                for (Field field : fields) {
                    Choice_Function.addItem(field.getName());
                }
            }
        });
        //上面那个选择器的事件
        Choice_Function.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //System.out.println(e.getItem());
                TextArea_Preview.setText(datatxtReader((String) e.getItem()));
            }
        });
        //左下角按钮的事件
        Btu_Setting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //先判断现在选择器里面的东西是谁和属性
                //System.out.println(Choice_Function.getSelectedItem());
                if (isColor(Choice_Function.getSelectedItem())) {
                    System.out.println("颜色选项");
                    Color SelectColor = new colorChooser().init();
                    if (Choice_Function.getSelectedItem().equals("cl_crosshair")) {
                        if (SelectColor != null) {
                            try {
                                dataSturct.Instance_Writer_CrossColor(Choice_Function.getSelectedItem(), SelectColor.getRed(), SelectColor.getGreen(), SelectColor.getBlue());
                            } catch (IllegalAccessException | NoSuchFieldException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    } else {
                        if (SelectColor != null) {
                            try {
                                dataSturct.Instance_Writer_color(Choice_Function.getSelectedItem(), SelectColor.getRed(), SelectColor.getGreen(), SelectColor.getBlue());
                            } catch (IllegalAccessException | NoSuchFieldException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                    System.out.println(SelectColor);
                } else {
                    //非颜色选项
                    EnterValFrame enterValFrame = new EnterValFrame(Choice_Function.getSelectedItem());
                    enterValFrame.init();
                    System.out.println(enterValFrame.Val);
                }
                return;
            }
        });
    }

    class RightPanel_Cus extends JPanel {
    }

    class colorChooser extends JColorChooser {

        public Color init() {
            JColorChooser cc = new JColorChooser();
            return cc.showDialog(mainFrame, "颜色选择器", Color.WHITE);
        }
    }

    class EnterValFrame {
        JFrame EnterValFrame_instance = new JFrame();
        String FieldName;
        public int Val;
        TextField textField = new TextField();

        EnterValFrame(String Fieldname) {
            FieldName = Fieldname;
        }

        public void init() {
            EnterValFrame_instance.add(textField);
            textField.setFont(mainFont_32);
            EnterValFrame_instance.setVisible(true);
            EnterValFrame_instance.setBounds(100, 100, 400, 150);
            EnterValFrame_instance.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    if (textField.getText().isEmpty() || textField.getText().equals(" ")) {
                        System.out.println("数据为空");
                        return;
                    }
                    Val = Integer.parseInt(textField.getText());
                    CommonVal = Val;//冗余的一步 实现不了并发的无奈啊
                    dataSturct.Instance_Writer_uncolor(FieldName, Val);
                }
            });
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    String key = "0123456789";
                    if (key.indexOf(e.getKeyChar()) < 0) {
                        e.consume();
                    }
                }
            });
        }
    }
}
