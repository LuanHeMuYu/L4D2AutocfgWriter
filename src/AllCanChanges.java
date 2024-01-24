import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AllCanChanges {
    public static final class Lerp {
        ArrayList<Button> init() {
            Button lerp = new Button("cl_interp");
            Button lerp_radio = new Button("cl_interp_radio");
            ArrayList<Button> res = new ArrayList<Button>();
            res.add(lerp);
            res.add(lerp_radio);

            lerp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("更改Lerp值");
                    new MainFrame().ChangeCurCfgs("cl_interp");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            lerp_radio.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("更改Lerp_radio值");
                    new MainFrame().ChangeCurCfgs("cl_interp_radio");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });

            return res;
        }
    }

    public static class CrossHair {
        ArrayList<Button> init() {
            Button dynamic = new Button("dynamic");
            Button thickness = new Button("thickness");
            Button crosshair = new Button("crosshair");
            Button alpha = new Button("alpha");
            ArrayList<Button> res = new ArrayList<Button>();
            res.add(dynamic);
            res.add(thickness);
            res.add(crosshair);
            res.add(alpha);
            dynamic.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("准星是否动态(1动 0静)");
                    new MainFrame().ChangeCurCfgs("cl_crosshair_dynamic");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            thickness.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MainFrame().ChangeShowtext("准星粗细(1-5)");
                    new MainFrame().ChangeCurCfgs("cl_crosshair_thickness");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            crosshair.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MainFrame().ChangeShowtext("准星颜色");
                    new MainFrame().ChangeCurCfgs("cl_crosshair_color");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            alpha.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MainFrame().ChangeShowtext("准星透明度(0-255)");
                    new MainFrame().ChangeCurCfgs("cl_crosshair_alpha");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });

            return res;
        }
    }

    public static class Other {
        ArrayList<Button> init() {
            Button HandLength = new Button("viewmodelfovsurvivor");
            Button CCpredisplay = new Button("CCpredisplay");
            Button buffer = new Button("buffer ");
            Button bleed_pulse = new Button("bleed_pulse");
            Button bleed_pulse_amount = new Button("bleed_pulse_amount");
            Button bleed_pulse_speed = new Button("bleed_pulse_speed");
            ArrayList<Button> res = new ArrayList<Button>();
            res.add(HandLength);
            res.add(CCpredisplay);
            res.add(buffer);
            res.add(bleed_pulse);
            res.add(bleed_pulse_amount);
            res.add(bleed_pulse_speed);
            HandLength.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("手臂长度");
                    new MainFrame().ChangeCurCfgs("cl_viewmodelfovsurvivor");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            CCpredisplay.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("字幕延后时间");
                    new MainFrame().ChangeCurCfgs("cc_predisplay_time");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            buffer.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("人类全部是虚血之后特感看人类的颜色等于特感看生还者倒地颜色是否一样 0：不一样 1：一样  ");
                    new MainFrame().ChangeCurCfgs("cl_glow_survivor_health_include_buffer");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            bleed_pulse.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("虚血闪光是否开启   1=开启  0=关闭");
                    new MainFrame().ChangeCurCfgs("cl_glow_survivor_health_bleed_pulse");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            bleed_pulse_amount.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("脉冲是否很现眼 1~0  只要身上有虚血就闪");
                    new MainFrame().ChangeCurCfgs("cl_glow_survivor_health_bleed_pulse_amount");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            bleed_pulse_speed.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("0~100  脉冲频率");
                    new MainFrame().ChangeCurCfgs("cl_glow_survivor_health_bleed_pulse_speed");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            return res;
        }
    }

    public static class Network {
        ArrayList<Button> init() {
            Button TabShowNetWork = new Button("TabShowNetWork");
            Button net_graphheight = new Button("net_graphheight");
            Button net_graphpos = new Button("net_graphpos ");
            Button net_graphshowinterp = new Button("net_graphshowinterp");
            Button net_graphproportionalfont = new Button("net_graphproportionalfont ");
            ArrayList<Button> res = new ArrayList<Button>();
            res.add(TabShowNetWork);
            res.add(net_graphheight);
            res.add(net_graphpos);
            res.add(net_graphshowinterp);
            res.add(net_graphproportionalfont);
            TabShowNetWork.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("组合指令 摁Tab显示网络等信息 松开Tab关闭信息");
                    new MainFrame().ChangeCurCfgs("TabSwitchNetWork");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            net_graphheight.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("这个信息显示距离下屏幕的距离");
                    new MainFrame().ChangeCurCfgs("net_graphheight");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            net_graphpos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("信息显示距离左屏幕的距离");
                    new MainFrame().ChangeCurCfgs("net_graphpos");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            net_graphproportionalfont.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("字体大小(0-1)");
                    new MainFrame().ChangeCurCfgs("net_graphproportionalfont");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            net_graphshowinterp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("减少信息底部线条");
                    new MainFrame().ChangeCurCfgs("net_graphshowinterp");
                    MainFrame.ChangeisUseColorChooser(false);
                }
            });
            return res;
        }
    }

    public static class Color {
        ArrayList<Button> init() {
            Button cl_glow_survivor = new Button("cl_glow_survivor");
            Button cl_glow_item_far = new Button("cl_glow_item_far");
            Button cl_glow_item = new Button("cl_glow_item ");
            Button cl_glow_ability = new Button("cl_glow_ability");
            Button cl_glow_survivor_hurt = new Button("cl_glow_survivor_hurt ");
            Button cl_glow_survivor_vomit = new Button("cl_glow_survivor_vomit ");
            Button cl_glow_infected = new Button("cl_glow_infected ");
            Button cl_glow_ghost_infected = new Button("cl_glow_ghost_infected ");
            Button cl_glow_survivor_health_high = new Button("cl_glow_survivor_health_high ");
            Button cl_glow_survivor_health_med = new Button("cl_glow_survivor_health_med ");
            Button cl_glow_survivor_health_low = new Button("cl_glow_survivor_health_low ");
            Button cl_glow_survivor_health_crit = new Button("cl_glow_survivor_health_crit ");
            Button cl_glow_thirdstrike_item = new Button("cl_glow_thirdstrike_item ");
            Button cl_glow_infected_vomit = new Button("cl_glow_infected_vomit ");
            ArrayList<Button> res = new ArrayList<Button>();
            res.add(cl_glow_survivor);
            res.add(cl_glow_item_far);
            res.add(cl_glow_item);
            res.add(cl_glow_ability);
            res.add(cl_glow_survivor_hurt);
            res.add(cl_glow_survivor_vomit);
            res.add(cl_glow_infected);
            res.add(cl_glow_ghost_infected);
            res.add(cl_glow_survivor_health_high);
            res.add(cl_glow_survivor_health_med);
            res.add(cl_glow_survivor_health_low);
            res.add(cl_glow_survivor_health_crit);
            res.add(cl_glow_thirdstrike_item);
            res.add(cl_glow_infected_vomit);
            cl_glow_survivor.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("人类视角看队友轮廓");
                    new MainFrame().ChangeCurCfgs("cl_glow_survivor");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_item_far.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("远距离看物品边框包括机关");
                    new MainFrame().ChangeCurCfgs("cl_glow_item_far");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("近距离看物品边框包括机关");
                    new MainFrame().ChangeCurCfgs("cl_glow_item");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_ability.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("人类视角看队友被控的特感边框");
                    new MainFrame().ChangeCurCfgs("cl_glow_ability");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_survivor_hurt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("生还者 被控 倒地 挂边");
                    new MainFrame().ChangeCurCfgs("cl_glow_survivor_hurt");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_survivor_vomit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("生还者视角看队友被吐");
                    new MainFrame().ChangeCurCfgs("cl_glow_survivor_vomit");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_infected.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("感染者视角看感染者轮廓颜色(已重生)");
                    new MainFrame().ChangeCurCfgs("cl_glow_infected");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_ghost_infected.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("感染者视角看感染者轮廓颜色(未重生)");
                    new MainFrame().ChangeCurCfgs("cl_glow_ghost_infected");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_survivor_health_high.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("特感看生还 100HP-40HP");
                    new MainFrame().ChangeCurCfgs("cl_glow_survivor_health_high");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_survivor_health_med.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("特感看生还 39HP-25HP");
                    new MainFrame().ChangeCurCfgs("cl_glow_survivor_health_med");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_survivor_health_low.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("特感看生还 24HP-1HP");
                    new MainFrame().ChangeCurCfgs("cl_glow_survivor_health_low");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_survivor_health_crit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("特感视角看生还者倒地和倒地之后只有1血的生还者 包括挂边");
                    new MainFrame().ChangeCurCfgs("cl_glow_survivor_health_crit");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_thirdstrike_item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("坦克打箱子汽车和黑白状态下的物品边框颜色");
                    new MainFrame().ChangeCurCfgs("cl_glow_thirdstrike_item");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            cl_glow_infected_vomit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().ChangeShowtext("生还者看感染者胆汁击中颜色和特感视角看生还者被胖子吐中");
                    new MainFrame().ChangeCurCfgs("cl_glow_infected_vomit");
                    MainFrame.ChangeisUseColorChooser(true);
                }
            });
            return res;
        }
    }
}