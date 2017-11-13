package MyTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/6/16
 * Time: 18:20
 */
public class SearchFIle {
    static String path = "D:\\workspace\\code\\news-crawler\\crawler-feeler\\crawler-feeler-text\\src\\main\\java\\com\\onemt\\news\\crawler\\feeler\\text\\processor";
    static String encoding = "utf-8";
    static String logPath = "C:\\Users\\Administrator\\Desktop\\临时\\default (7)";

    public static void main(String[] args) throws Exception {
        File file = new File(logPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), encoding));
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.contains("Download file success:"))
                System.out.println("\""+line.split("Download file success:")[1]+"\"");
        }
        reader.close();
//            File[] files = file.listFiles();

//            for(File file1:files){
//                if(!file1.isDirectory()){
//                    String name = file1.getName();
//                    String content = ReadWriteFileWithEncode.read(file1.getPath(),encoding);
//                    if(content.contains(".setCharset(\"UTF-8\")")){
//                        System.out.println("UPDATE crawler_media_category AS p set p.charset = 'UTF-8' WHERE p.processor = "+name.replace(".java",""));
//                    }
////                    else {
////                        System.out.println(name+":null");
////                    }
//                }
//            }

    }
}
