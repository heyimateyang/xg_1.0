package org.heyimtaeyang.until;  
   
import java.io.File;
import java.util.UUID;

  
/** 
 * @author Heyimateyang
 *  
 */  
public class My_UID {  
	//获得全球唯一性的id  
    public static String getId(){  
        String id=UUID.randomUUID().toString();//生成的id942cd30b-16c8-449e-8dc5-028f38495bb5中间含有横杠，<span style="color: rgb(75, 75, 75); font-family: Verdana, Arial, Helvetica, sans-serif; line-height: 20.7999992370605px;">用来生成数据库的主键id是很实用的。</span>  
        id=id.replace("-", "");//替换掉中间的那个斜杠  
        return id;  
    }  
    
    
    /**
     * 修改文件的名称
     * @param file
     * @param toFile
     */
    
    public void renameFile(String file, String toFile) {

        File toBeRenamed = new File(file);
        //检查要重命名的文件是否存在，是否是文件
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {

            System.out.println("File does not exist: " + file);
            return;
        }

        File newFile = new File(toFile);

        //修改文件名
        if (toBeRenamed.renameTo(newFile)) {
            System.out.println("File has been renamed.");
        } else {
            System.out.println("Error renmaing file");
        }

    }
}  