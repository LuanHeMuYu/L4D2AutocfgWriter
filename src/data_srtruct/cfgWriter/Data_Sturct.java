package data_srtruct.cfgWriter;

import java.io.*;
import java.lang.reflect.Field;
import java.text.DecimalFormat;

public class Data_Sturct {
    @Data
    public int cl_interp = -1;
    @Data
    public int cl_interp_radio = -1;
    @Data
    public int net_graphheight = -1;
    @Data
    public int net_graphpos = -1;
    @Data
    public int net_graphproportionalfont = -1;
    @Data
    public int net_graphshowinterp = -1;
    @Data
    public int cl_viewmodelfovsurvivor = -1;
    @Data
    public int cc_predisplay_time = -1;
    @Data
    public int cl_glow_survivor_health_include_buffer = -1;
    @Data
    public int cl_glow_survivor_health_bleed_pulse = -1;
    @Data
    public int cl_glow_survivor_health_bleed_pulse_amount = -1;
    @Data
    public int cl_glow_survivor_health_bleed_pulse_speed = -1;
    @Data
    public int cl_crosshair_dynamic = -1;
    @Data
    public int cl_crosshair_thickness = -1;
    @CrossHairColor
    public int cl_crosshair_red = -1;
    @CrossHairColor
    public int cl_crosshair_green = -1;
    @CrossHairColor
    public int cl_crosshair_blue = -1;
    @Data
    public int cl_crosshair_alpha = -1;
    @MyColor
    public int cl_glow_survivor_r = -1;
    @MyColor
    public int cl_glow_survivor_g = -1;
    @MyColor
    public int cl_glow_survivor_b = -1;
    //人类看远处物品
    @MyColor
    public int cl_glow_item_far_r = -1;
    @MyColor
    public int cl_glow_item_far_g = -1;
    @MyColor
    public int cl_glow_item_far_b = -1;
    @MyColor
    public int cl_glow_item_r = -1;
    @MyColor
    public int cl_glow_item_g = -1;
    @MyColor
    public int cl_glow_item_b = -1;
    @MyColor
    public int cl_glow_ability_r = -1;
    @MyColor
    public int cl_glow_ability_g = -1;
    @MyColor
    public int cl_glow_ability_b = -1;
    @MyColor
    public int cl_glow_survivor_hurt_r = -1;
    @MyColor
    public int cl_glow_survivor_hurt_g = -1;
    @MyColor
    public int cl_glow_survivor_hurt_b = -1;
    @MyColor
    public int cl_glow_survivor_vomit_r = -1;
    @MyColor
    public int cl_glow_survivor_vomit_g = -1;
    @MyColor
    public int cl_glow_survivor_vomit_b = -1;
    @MyColor
    public int cl_glow_infected_r = -1;
    @MyColor
    public int cl_glow_infected_g = -1;
    @MyColor
    public int cl_glow_infected_b = -1;
    @MyColor
    public int cl_glow_ghost_infected_r = -1;
    @MyColor
    public int cl_glow_ghost_infected_g = -1;
    @MyColor
    public int cl_glow_ghost_infected_b = -1;
    @MyColor
    public int cl_glow_survivor_health_high_r = -1;
    @MyColor
    public int cl_glow_survivor_health_high_g = -1;
    @MyColor
    public int cl_glow_survivor_health_high_b = -1;
    @MyColor
    public int cl_glow_survivor_health_med_r = -1;
    @MyColor
    public int cl_glow_survivor_health_med_g = -1;
    @MyColor
    public int cl_glow_survivor_health_med_b = -1;
    @MyColor
    public int cl_glow_survivor_health_low_r = -1;
    @MyColor
    public int cl_glow_survivor_health_low_g = -1;
    @MyColor
    public int cl_glow_survivor_health_low_b = -1;
    @MyColor
    public int cl_glow_survivor_health_crit_r = -1;
    @MyColor
    public int cl_glow_survivor_health_crit_g = -1;
    @MyColor
    public int cl_glow_survivor_health_crit_b = -1;
    @MyColor
    public int cl_glow_thirdstrike_item_r = -1;
    @MyColor
    public int cl_glow_thirdstrike_item_g = -1;
    @MyColor
    public int cl_glow_thirdstrike_item_b = -1;
    @MyColor
    public int cl_glow_infected_vomit_r = -1;
    @MyColor
    public int cl_glow_infected_vomit_g = -1;
    @MyColor
    public int cl_glow_infected_vomit_b = -1;

    /**
     * 这个方法为字段赋值
     */
    public void Instance_Writer_uncolor(String Field_Name, int Val) {
        Field field = null;
        try {
            field = this.getClass().getField(Field_Name);
            //如果有这个数据 则写入这个实例本身
            field.set(this, Val);
            System.out.printf(String.valueOf(field.getInt(this)));
        } catch (NoSuchFieldException e) {
            System.out.println("没有这个字段");
        } catch (IllegalAccessException e) {
            System.out.println("写入出错");
        }
    }

    /**
     * 这个方法为颜色字段赋值 但需要在外面区分开
     * 因为这个是写注解为MyColor的
     */
    public void Instance_Writer_color(String Field_Name, int r, int g, int b) throws IllegalAccessException, NoSuchFieldException {
        Field R = this.getClass().getField(Field_Name + "_r");
        Field G = this.getClass().getField(Field_Name + "_g");
        Field B = this.getClass().getField(Field_Name + "_b");
        R.set(this, r);
        G.set(this, g);
        B.set(this, b);
    }

    /**
     * 这个方法为颜色字段赋值 但需要在外面区分开
     * 因为这个是写注解为CrossHairColor的
     */
    public void Instance_Writer_CrossColor(String Field_Name, int r, int g, int b) throws IllegalAccessException, NoSuchFieldException {
        Field R = this.getClass().getField(Field_Name + "_red");
        Field G = this.getClass().getField(Field_Name + "_green");
        Field B = this.getClass().getField(Field_Name + "_blue");
        R.set(this, r);
        G.set(this, g);
        B.set(this, b);
    }

    /**
     * 这个方法提供了将这个实例的数据写入一个新的cfg
     *
     * @param Path 路径 Path 导出cfg的位置
     */
    public void WriteOut(String Path) {

        //这个位置出问题了 记得检查

        Field[] fields = this.getClass().getFields();
        File file = new File(Path);

        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.printf("Log:文件不存在 已经创建文件");
            }

            FileWriter fw = new FileWriter(file);

            for (Field field : fields) {
                System.out.printf("当前的名字为:" + field.getName());
                if (field.getAnnotation(MyColor.class) != null) {
                    //注解为MyColor
                    if ((int) field.get(this) != -1) {
                        //不为-1即输出数据
                        System.out.println("Log:赋值成功(MyColor):" + field.getInt(this) + "\n");
                        String cfgName = field.getName();
                        double ans = field.getInt(this) / (double) 255;
                        DecimalFormat answer = new DecimalFormat("#.##");
                        String a = answer.format(ans);
                        System.out.println(a);
                        fw.write(cfgName + " " + a + "\n");
                        continue;
                    }
                    System.out.println("Log:这个值为-1 并未赋值:" + field.getInt(this) + "\n");
                } else if (field.getAnnotation(CrossHairColor.class) != null) {
                    //注解为准星的Color
                    if ((int) field.get(this) != -1) {
                        //不为-1即输出数据
                        System.out.println("Log:赋值成功(CrossHair):" + field.getInt(this) + "\n");
                        String str = field.getName() + " " + field.getInt(this) + "\n";
                        fw.write(str);
                        continue;
                    }
                    System.out.println("Log:这个值为-1 并未赋值(MyColor):" + field.getInt(this) + "\n");
                } else {
                    //非颜色
                    if ((int) field.get(this) != -1) {
                        //不为-1即输出数据
                        System.out.println("Log:赋值成功(Data):" + field.getInt(this) + "\n");
                        String str = field.getName() + " " + field.getInt(this) + "\n";
                        fw.write(str);
                        continue;
                    }
                    System.out.println("Log:这个值为-1 并未赋值(Data):" + field.getInt(this) + "\n");
                }
            }


//            for (Field i : field) {
//                //判断整型和数组的逻辑<OLD>
//                if (i.getType().toString().equals("int")) {
//                    System.out.println("int");
//                    if (!((int) i.get(this) == -1)) {
//                        //当数据被录入过 也就是不为-1
//                        String cfgName = i.getName();
//                        int cfgVal = (int) i.get(this);
//                        fw.write(cfgName + " " + cfgVal + "\n");
//                    }
//                } else {
//                    //数组
//                    System.out.printf("写入模式改变 已将所有更为非数组类型");
//                    //写入模式改变 已将所有更为非数组类型
//
//                    System.out.println("Array");
//                    String[] str = {"_r", "_g", "_b"};
//                    int[] nums = (int[]) i.get(this);
//                    if (nums[0] != -1) {
//                        //不等于-1则录入数据
//                        for (int j = 0; j < 3; j++) {
//                            String cfgName = i.getName() + str[j];
//                            double ans = nums[j] / (double) 255;
//                            DecimalFormat answer = new DecimalFormat("#.##");
//                            String a = answer.format(ans);
//                            System.out.println(a);
//                            fw.write(cfgName + " " + a + "\n");
//                        }
//                    }
//                }
//            }
            fw.close();
        } catch (IOException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 这个方法提供了将这个实例的数据写入一个cfg的后面
     * 这个方法 在最开始调用Appendcfg方法
     * 将cfg内容读取到内存
     * 而本身使用write方法
     * 将全部数据重写
     * 虽然这个方法不好
     * 但是cfg体量比较小
     *
     * @param Path 路径 Path 选择想要添加的cfg后面
     */
    public void Appendcfg(String Path) {
        try {
            String cfgData = cfgReader(Path) + "\n";
            System.out.printf(cfgData);

            Field[] fields = this.getClass().getFields();
            File file = new File(Path);
            System.out.println(file.toString());//Debug语句

            if (!file.exists()) file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.write(cfgData);//写入原本的数据
            for (Field field : fields) {
                System.out.printf("当前的名字为:" + field.getName());
                if (field.getAnnotation(MyColor.class) != null) {
                    //注解为MyColor
                    if ((int) field.get(this) != -1) {
                        //不为-1即输出数据
                        System.out.println("Log:赋值成功(MyColor):" + field.getInt(this));
                        String cfgName = field.getName();
                        double ans = field.getInt(this) / (double) 255;
                        DecimalFormat answer = new DecimalFormat("#.##");
                        String a = answer.format(ans);
                        System.out.println(a);
                        fw.write(cfgName + " " + a + "\n");
                        continue;
                    }
                    System.out.println("Log:这个值为-1 并未赋值(MyColor):" + field.getInt(this));
                } else if (field.getAnnotation(CrossHairColor.class) != null) {
                    //注解为准星的Color
                    if ((int) field.get(this) != -1) {
                        //不为-1即输出数据
                        System.out.println("Log:赋值成功(CrossHair):" + field.getInt(this));
                        String str = field.getName() + " " + field.getInt(this) + "\n";
                        fw.write(str);
                        continue;
                    }
                    System.out.println("Log:这个值为-1 并未赋值(CrossHair):" + field.getInt(this));
                } else {
                    //非颜色
                    if ((int) field.get(this) != -1) {
                        //不为-1即输出数据
                        System.out.println("Log:赋值成功(Data):" + field.getInt(this));
                        String str = field.getName() + " " + field.getInt(this) + "\n";
                        fw.write(str);
                        continue;
                    }
                    System.out.println("Log:这个值为-1 并未赋值(Data):" + field.getInt(this));
                }
            }
            fw.close();
        } catch (IOException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 这个方法
     * 在Appendcfg中使用
     * 返回这个cfg的内容
     * 然后在Appendcfg最开始的时候添加
     *
     * @param Path 路径 Path 选择想要添加的cfg后面
     */
    private String cfgReader(String Path) throws IOException {
        System.out.printf("路径" + Path);
        File file = new File(Path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String res = "";
        String str = br.readLine();
        while (str != null) {
            res += str;
            res += "\n";
            System.out.printf("Log" + str);
            str = br.readLine();
        }

        br.close();
        fr.close();
        System.out.printf("原本的文件内容:" + res);
        return res;
    }

    public void Console_Data_Val() {
        Field[] fields = this.getClass().getFields();
        for (Field field : fields) {
            try {
                System.out.println(field.getName() + field.get(this));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 这个方法检测了字段是否为Color
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
}
