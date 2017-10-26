package myTest;

import nabd.ReadWriteFileWithEncode;

import java.io.File;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/6/16
 * Time: 18:20
 */
public class SearchFIle {
    static String path = "D:\\workspace\\code\\news-crawler\\crawler-feeler\\crawler-feeler-text\\src\\main\\java\\com\\onemt\\news\\crawler\\feeler\\text\\processor";
    static String encoding = "utf-8";
    public static void main(String[] args) throws Exception{
        File file = new File(path);
        if(file.isDirectory()){
            File[] files = file.listFiles();

            for(File file1:files){
                if(!file1.isDirectory()){
                    String name = file1.getName();
                    String content = ReadWriteFileWithEncode.read(file1.getPath(),encoding);
                    if(content.contains(".setCharset(\"UTF-8\")")){
                        System.out.println("UPDATE crawler_media_category AS p set p.charset = 'UTF-8' WHERE p.processor = "+name.replace(".java",""));
                    }
//                    else {
//                        System.out.println(name+":null");
//                    }
                }
            }

        }
    }
}
