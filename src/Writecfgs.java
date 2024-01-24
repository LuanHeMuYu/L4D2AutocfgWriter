import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DecimalFormat;

public class Writecfgs {
    public void Entertrance(cfgClass res, String cfgPath) {
        Field[] field = res.getClass().getFields();
        File file = new File(cfgPath + "\\Azazel.cfg");
        try {
            if(!file.exists())file.createNewFile();
            FileWriter fw = new FileWriter(file);
            for (Field i : field) {
                //判断整型和数组的逻辑
                if(i.getType().toString().equals("int")){
                    if ((int) i.get(res) == -1) {
                        continue;
                    } else {
                        String cfgName = i.getName();
                        int cfgVal = (int)i.get(res);
                        fw.write(cfgName+" "+cfgVal+"\n");
                    }
                }
                else{
                    //数组
                    String[] str = {"_r","_g","_b"};
                    int[] nums = (int[]) i.get(res);
                    if(nums[0] != -1){
                        //不等于-1则录入数据
                        for (int j = 0;j < 3;j++) {
                            String cfgName = i.getName() + str[j];
                            double ans = nums[j]/(double)255;
                            DecimalFormat answer = new DecimalFormat("#.##");
                            String a = answer.format(ans);
                            System.out.println(a);
                            fw.write(cfgName + " " +a + "\n");
                        }
                    }
                }
            }
            fw.close();
        } catch (IllegalAccessException | IOException e){
            throw new RuntimeException(e);
        }
    }
}
