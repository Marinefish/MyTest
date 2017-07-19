package CssSelectorRule;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/3/13
 * Time: 10:02
 */
public enum ContentType {
    LINKS("link"),
    IMAGE("image"),
    IMAGES("images"),
    VIDEO("video"),
    ARTICLE("article");


    private String key;
    private ContentType(String key){
        this.key=key;
    }
    private String getKey(){
        return this.key;
    }

    /**
     * 是否包含该枚举类型key值
     * @param key
     * */
    public static boolean contains(String key){
        boolean contains = false;
        for(ContentType contentType:ContentType.values()){
            if(contentType.key.equalsIgnoreCase(key)){
                contains=true;
                break;
            }
        }
        return contains;
    }
}
