import javax.swing.*;

public class FilePathReader {
    String init(){
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = fc.showDialog(null,"确认");
        if(res == JFileChooser.APPROVE_OPTION){
            //选择了文件 就返回路径
            return fc.getSelectedFile().toString();
        }
        return null;
    }
    public static void main(String[] args){
        new FilePathReader().init();
    }
}
