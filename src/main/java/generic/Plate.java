package generic;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/5/31
 * Time: 10:23
 */
public class Plate<T> {
    private T item;

    public Plate(T t){
        this.item = t;
    }

    public void set(T t){this.item = t;}

    public T get(){return this.item;}

    public static void main(String[] args) {
        Plate<Fruit> fruitPlate = new Plate<>(new Apple());
        fruitPlate.set(new Lemon());
        System.out.println(fruitPlate.get().taste());
    }
}
