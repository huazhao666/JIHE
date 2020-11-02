import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-02
 * Time : 15:39
 */
//<T> 这是一个占符位，表示当前泛型类；
//可以进行类型的自动检查
//可以进行自动类型转换
//简单类型不能作为泛型类型的参数，必须是包装类；或者其他的类
//泛型类型的参数 不参与类型的组成
// 坑：不能new泛型类型的 需要（T[]）强转
// 泛型怎么编译？ ： 擦除机制（擦除为Object,不是替换为Object）
// 泛型是在编译时期的一个动作，只存在编译时期
class  MyArrayList<T> { //泛型
    public T[] elem;
    public int uesdSize;


    public  MyArrayList() {
        this.elem = (T[])new Object[10];
    }
    public void add (T data) {
        this.elem[this.uesdSize++] = data;
    }
    public T getpos(int pos) {
        return this.elem[pos];
    }

}
class Person1 {

}

public class TestGenirc {
    public static void main (String[] args){
        Person1 person = new Person1();
        System.out.println(person);
        MyArrayList<String> myArrayList = new MyArrayList<>();
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>(); // <>不参与类型组成
        System.out.println(myArrayList);
        System.out.println(myArrayList2);
    }


    public static void main1 (String[] args){
//        MyArrayList myArrayList = new MyArrayList();
//        myArrayList.add(1);
//        myArrayList.add("2");
//        String str = (String) myArrayList.getpos(2);
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("hello");
        myArrayList.add("2");
        String str = myArrayList.getpos(1);
        System.out.println(str);
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        myArrayList2.add(1);
        myArrayList2.add(2);
        myArrayList2.add(3);

    }
}
