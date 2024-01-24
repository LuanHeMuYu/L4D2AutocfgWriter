import com.sun.tools.javac.Main;

import java.lang.reflect.Field;
import java.util.PrimitiveIterator;

/**
 * 这个类
 * 默认设置为-1
 * 也就是检测到-1就跳过写入
 */
public class cfgClass {
    private Field[] fileds = cfgClass.class.getDeclaredFields();
    //lerp
    public int cl_interp = -1;
    public int cl_interp_radio = -1;
    //准星
    public int cl_crosshair_dynamic = -1;
    public int cl_crosshair_thickness = -1;
    public int[] cl_crosshair_color = {-1,-1,-1};
    public int cl_crosshair_alpha = -1;
    //杂项
    public int cl_viewmodelfovsurvivor = -1;
    public int cc_predisplay_time = -1;
    public int cl_glow_survivor_health_include_buffer = -1;
    public int cl_glow_survivor_health_bleed_pulse = -1;
    public int cl_glow_survivor_health_bleed_pulse_amount = -1;
    public int cl_glow_survivor_health_bleed_pulse_speed = -1;
    //网络
    public int TabShowNetWork = -1;
    public int net_graphheight = -1;
    public int net_graphpos = -1;
    public int net_graphproportionalfont = -1;
    public int net_graphshowinterp = -1;
    //颜色
    //人类看队友
    public int[] cl_glow_survivor = {-1,-1,-1};
    //人类看远处物品
    public int[] cl_glow_item_far = {-1,-1,-1};
    public int[] cl_glow_item = {-1,-1,-1};
    public int[] cl_glow_ability = {-1,-1,-1};
    public int[] cl_glow_survivor_hurt = {-1,-1,-1};
    public int[] cl_glow_survivor_vomit = {-1,-1,-1};
    public int[] cl_glow_infected = {-1,-1,-1};
    public int[] cl_glow_ghost_infected = {-1,-1,-1};
    public int[] cl_glow_survivor_health_high = {-1,-1,-1};
    public int[] cl_glow_survivor_health_med = {-1,-1,-1};
    public int[] cl_glow_survivor_health_low = {-1,-1,-1};
    public int[] cl_glow_survivor_health_crit = {-1,-1,-1};
    public int[] cl_glow_thirdstrike_item = {-1,-1,-1};
    public int[] cl_glow_infected_vomit = {-1,-1,-1};


    //这后面的方法可以用折射实现
    //但是我不会:( 所以只能用笨办法了

    public void Ccl_crosshair_color(int red,int green,int blue){
        cl_crosshair_color[0] = red;
        cl_crosshair_color[1] = green;
        cl_crosshair_color[2] = blue;
        System.out.println(cl_crosshair_color[1]);
    }
    public void Ccl_glow_survivor(int red,int green,int blue){
        cl_glow_survivor[0] = red;
        cl_glow_survivor[1] = green;
        cl_glow_survivor[2] = blue;
        System.out.println(cl_glow_survivor[1]);
    }
    public void Ccl_glow_item_far(int red,int green,int blue){
        cl_glow_item_far[0] = red;
        cl_glow_item_far[1] = green;
        cl_glow_item_far[2] = blue;
        System.out.println(cl_glow_item_far[1]);
    }
    public void Ccl_glow_item(int red,int green,int blue){
        cl_glow_item[0] = red;
        cl_glow_item[1] = green;
        cl_glow_item[2] = blue;
        System.out.println(cl_glow_item[1]);
    }
    public void Ccl_glow_ability(int red,int green,int blue){
        cl_glow_ability[0] = red;
        cl_glow_ability[1] = green;
        cl_glow_ability[2] = blue;
        System.out.println(cl_glow_ability[1]);
    }
    public void Ccl_glow_survivor_hurt(int red,int green,int blue){
        cl_glow_survivor_hurt[0] = red;
        cl_glow_survivor_hurt[1] = green;
        cl_glow_survivor_hurt[2] = blue;
        System.out.println(cl_glow_survivor_hurt[1]);
    }
    public void Ccl_glow_survivor_vomit(int red,int green,int blue){
        cl_glow_survivor_vomit[0] = red;
        cl_glow_survivor_vomit[1] = green;
        cl_glow_survivor_vomit[2] = blue;
        System.out.println(cl_glow_survivor_vomit[1]);
    }
    public void Ccl_glow_infected(int red,int green,int blue){
        cl_glow_infected[0] = red;
        cl_glow_infected[1] = green;
        cl_glow_infected[2] = blue;
        System.out.println(cl_glow_infected[1]);
    }
    public void Ccl_glow_ghost_infected(int red,int green,int blue){
        cl_glow_ghost_infected[0] = red;
        cl_glow_ghost_infected[1] = green;
        cl_glow_ghost_infected[2] = blue;
        System.out.println(cl_glow_ghost_infected[1]);
    }
    public void Ccl_glow_survivor_health_high(int red,int green,int blue){
        cl_glow_survivor_health_high[0] = red;
        cl_glow_survivor_health_high[1] = green;
        cl_glow_survivor_health_high[2] = blue;
        System.out.println(cl_glow_survivor_health_high[1]);
    }
    public void Ccl_glow_survivor_health_med(int red,int green,int blue){
        cl_glow_survivor_health_med[0] = red;
        cl_glow_survivor_health_med[1] = green;
        cl_glow_survivor_health_med[2] = blue;
        System.out.println(cl_glow_survivor_health_med[1]);
    }
    public void Ccl_glow_survivor_health_low(int red,int green,int blue){
        cl_glow_survivor_health_low[0] = red;
        cl_glow_survivor_health_low[1] = green;
        cl_glow_survivor_health_low[2] = blue;
        System.out.println(cl_glow_survivor_health_low[1]);
    }
    public void Ccl_glow_survivor_health_crit(int red,int green,int blue){
        cl_glow_survivor_health_crit[0] = red;
        cl_glow_survivor_health_crit[1] = green;
        cl_glow_survivor_health_crit[2] = blue;
        System.out.println(cl_glow_survivor_health_crit[1]);
    }
    public void Ccl_glow_thirdstrike_item(int red,int green,int blue){
        cl_glow_thirdstrike_item[0] = red;
        cl_glow_thirdstrike_item[1] = green;
        cl_glow_thirdstrike_item[2] = blue;
        System.out.println(cl_glow_thirdstrike_item[1]);
    }
    public void Ccl_glow_infected_vomit(int red,int green,int blue){
        cl_glow_infected_vomit[0] = red;
        cl_glow_infected_vomit[1] = green;
        cl_glow_infected_vomit[2] = blue;
        System.out.println(cl_glow_infected_vomit[1]);
    }

}
