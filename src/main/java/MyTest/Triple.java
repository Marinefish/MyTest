package MyTest;

/**
 * Author: fangxueshun
 * Description: 最大子序列求和
 * Date: 2017/4/9
 * Time: 16:41
 */
public class Triple {
    private static  Triple triple0;
    private static  Triple triple1;
    private static  Triple triple2;
    private Triple(){}
    public static Triple getInstance(int id){
        Triple targetTriple = null;
        switch (id){
            case 0:
                if(null == triple0)
                    triple0 = new Triple();
                targetTriple = triple0;
                break;
            case 1:
                if(null == triple1)
                    triple1 = new Triple();
                targetTriple = triple1;
                break;
            case 2:
                if(null == triple2)
                    triple2 = new Triple();
                targetTriple = triple2;
                break;

        }
        return targetTriple;
    }

    public static String toString(Triple triple){
        return String.valueOf(triple.hashCode());
    }
}
