#AutocfgWriter

AutocfgWriter是一个求生之路2(Left 4 Dead 2)的cfg自动书写器

![L4D2](../img/Left4Dead2.png)

[作者b站:@滦河暮鱼](https://space.bilibili.com/204828664?spm_id_from=333.1007.0.0)

> 使用方法:
>
> 下载一个Java 这个使用Java1.8书写
>
> 然后运行.jar 
> 
> 源文件的话就build

---

**文档书写规则:**

*有两个主要的Frame，bindFrame和cfgWriterFrame,这两个Frame实现方法不一样*

---

***对于:cfgWriterFrame***

我们通过实例化"Data_Sturct"

在Data_Sturct中实现Writer read

注解是用来检测类型的 我们有 **颜色** **准心** **普通数据**

对应注解 **@MyColor** **@CrossHairColor** **@Data**

对于自身写入文件时

使用反射实现

---

所以 ***添加方法如下***

在Data_Sturct中添加指令名 颜色类型不需要添加_r或_red

只需要加注解以说明

---

<font color = "#1034a6">**对于描述**</font>

在文件data.txt中 我添加了描述

一个指令 一个描述 *在所有颜色选项前 添加Color*

使用datatxtReader封装

```String datatxtReader(String Text) {
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
                    System.out.printf(str.replace("Color ", ""));
                }
                str = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Can't Find";
    }
```

这个方法实现了在data.txt中寻找Choice(也就是那个选择器)里面的值

---

**对于bindFrame(待重做)**

在文件头的位置有个cfgData的变量 这个变量储存了所有我们将要写入的数据

**待重做内容**

    1.toggle的添加
    2.+,-的添加
    3.对于指令的索引
    4....