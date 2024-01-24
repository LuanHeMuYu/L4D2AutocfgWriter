import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.lang.reflect.Field;

public class MainFrame {
    public static String CurCFGS = "";
    public static String Showtext = "选择指令以查看";
    public static boolean isUseColorChooser = false;
    cfgClass res = new cfgClass();
    private int output = -1;
    FilePathReader fileWriter = new FilePathReader();
    Font NormalFont = new Font("新方圆", Font.PLAIN, 16);
    /**
     * 主界面的实例
     */
    public JFrame mainFrame = new JFrame("Auto Write cfg<-Made By Azazel");
    /**
     * 菜单栏
     */
    JMenuBar menuBar = new JMenuBar();
    JMenu File = new JMenu("文件");
    JMenu Author = new JMenu("关于作者");
    JMenuItem aboutAuthor = new JMenuItem("关于作者");
    JMenuItem Save = new JMenuItem("保存");
    JMenuItem OtherSave = new JMenuItem("另存为");
    //主界面上的东西
    /**
     * 左边主Panel 主要放选择按钮
     */
    JPanel LeftPanel = new JPanel(new GridLayout(1, 5));
    //小控件
    JButton CLerp = new JButton("Lerp");
    JButton CCrossHair = new JButton("准心");
    JButton COther = new JButton("杂类");
    JButton CNetwork = new JButton("网络");
    JButton CColor = new JButton("颜色");
    //细选项
    JPanel MoreChoose = new JPanel();

    /**
     * 右边主Panel 主要放按钮描述和确认 配置
     */
    JPanel RightPanel = new JPanel(new GridLayout(2, 1));
    JLabel Description = new JLabel(Showtext);
    JPanel BtuArea = new JPanel(null);
    JButton Confirm = new JButton("确认");
    JButton Setting = new JButton("设置");
    JTextField EnterBox = new JTextField();


    /**
     * 入口
     */
    public void init() {
        ActionListener DescriptionChange = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Description.setText(Showtext);
            }
        };
        new Timer(500, DescriptionChange).start();
        AllEventInit();
        UIInit();
    }

    /**
     * UI初始化
     */
    private void UIInit() {
        //主界面
        //Left
        LeftPanel.setBounds(0, 0, 400, 50);
        //LeftPanel.setBackground(new Color(100,110,100));
        //morechoose
        //MoreChoose.setBackground(new Color(247, 228, 150));
        MoreChoose.setBounds(0, 50, 400, 350);
        //add
        LeftPanel.add(CLerp);
        LeftPanel.add(CNetwork);
        LeftPanel.add(COther);
        LeftPanel.add(CCrossHair);
        LeftPanel.add(CColor);
        //Right
        RightPanel.setBounds(400, 0, 400, 400);
        //RightPanel.setBackground(new Color(65, 112, 169));
        //add
        Description.setFont(NormalFont);
        RightPanel.add(Description);
        RightPanel.add(BtuArea);

        BtuArea.setBounds(0, 100, 400, 200);
        //BtuArea.setBackground(new Color(197, 112, 238));

        EnterBox.setBounds(0, 0, 200, 50);
        Confirm.setBounds(0, 50, 100, 50);
        Setting.setBounds(100, 50, 100, 50);

        BtuArea.add(EnterBox);
        BtuArea.add(Confirm);
        BtuArea.add(Setting);
        //菜单栏
        Author.add(aboutAuthor);
        File.add(Save);
        File.add(OtherSave);
        menuBar.add(File);
        menuBar.add(Author);
        //主界面添加控件
        mainFrame.add(LeftPanel);
        mainFrame.add(RightPanel);
        mainFrame.setJMenuBar(menuBar);
        mainFrame.add(MoreChoose);
        //这后面是主Frame的设置
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setBounds(100, 100, 800, 400);
    }

    /**
     * 所有事件初始化
     */
    void AllEventInit() {
        OtherSave.addActionListener(e -> {
            //文件另存为
            String cfgPath = new FilePathReader().init();
            System.out.println(cfgPath);
        });
        Save.addActionListener(e -> {
            //文件保存
            String cfgPath = new FilePathReader().init();
            new Writecfgs().Entertrance(res,cfgPath);
        });
        aboutAuthor.addActionListener(e -> {
            //关于作者
            new AboutAuthor().init();
        });
        CLerp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MoreChoose.removeAll();
                MoreChoose.setLayout(new GridLayout(10, 10));
                ArrayList<Button> res = new AllCanChanges.Lerp().init();
                for (Button btu : res) {
                    MoreChoose.add(btu);
                }
                MoreChoose.updateUI();
            }
        });
        CCrossHair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MoreChoose.removeAll();
                MoreChoose.setLayout(new GridLayout(10, 10));
                ArrayList<Button> res = new AllCanChanges.CrossHair().init();
                for (Button btu : res) {
                    MoreChoose.add(btu);
                }
                MoreChoose.updateUI();
            }
        });
        COther.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MoreChoose.removeAll();
                MoreChoose.setLayout(new GridLayout(10, 10));
                ArrayList<Button> res = new AllCanChanges.Other().init();
                for (Button btu : res) {
                    MoreChoose.add(btu);
                }
                MoreChoose.updateUI();
            }
        });
        CNetwork.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MoreChoose.removeAll();
                MoreChoose.setLayout(new GridLayout(10, 10));
                ArrayList<Button> res = new AllCanChanges.Network().init();
                for (Button btu : res) {
                    MoreChoose.add(btu);
                }
                MoreChoose.updateUI();
            }
        });
        CColor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MoreChoose.removeAll();
                MoreChoose.setLayout(new GridLayout(10, 10));
                ArrayList<Button> res = new AllCanChanges.Color().init();
                for (Button btu : res) {
                    MoreChoose.add(btu);
                }
                MoreChoose.updateUI();
            }
        });
        Setting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isUseColorChooser) {
                    Color color = new ColorChooser().init();
                    try {
                        Method method = res.getClass().getMethod("C"+CurCFGS,int.class,int.class,int.class);
                        method.invoke(res,color.getRed(),color.getGreen(),color.getBlue());
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    if (EnterBox.getText().equals("")) {
                        Showtext = "内容不能为空";
                    } else {
                        //设置
                        try {
                            Field field = res.getClass().getDeclaredField(CurCFGS);
                            field.set(res,Integer.parseInt(EnterBox.getText()));
                            System.out.println(field.getType().toString());
                        } catch (NoSuchFieldException | IllegalAccessException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                }
            }
        });
        Confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Showtext = "这个按钮好像没什么作用";
            }
        });
        EnterBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String key = "0123456789";
                if (key.indexOf(e.getKeyChar()) < 0) {
                    e.consume();
                }
            }
        });
    }

    public static void main(String[] args) {
        new MainFrame().init();
    }

    public static void ChangeShowtext(String text) {
        Showtext = text;
    }

    public static void ChangeCurCfgs(String text) {
        CurCFGS = text;
    }
    public static String GetCurCfgs(){
        return CurCFGS;
    }

    public static void ChangeisUseColorChooser(boolean Going) {
        if (Going) {
            isUseColorChooser = true;
        } else {
            isUseColorChooser = false;
        }
    }

    class ColorChooser {
        public Color init() {
            JColorChooser cc = new JColorChooser();
            return cc.showDialog(mainFrame, "颜色选择器", Color.WHITE);
        }
    }

}