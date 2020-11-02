/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-02
 * Time : 16:14
 */

import java.util.ArrayList;
import java.util.List;

/**
        * 装箱（装包）： 简单类型 —— 包装类类型
        * 1.自动装箱；
        * 2.显示装箱；
        * 拆箱（拆包）：包装类型—— 简单类型
        * 1.自动拆箱
        * 2.显示拆箱
        *
        *
        */
public class TestDemo2 {
    public static void main (String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        List<Integer> ret = list.subList(0,2);//左闭右开,截取一部分
        System.out.println(ret);
        ret.set(0,44); // 将list中的0号也改变了
        System.out.println(ret);//(44,2)
        System.out.println(list);//(44,2,3,4)
        list.clear();

//        list.add(3,90);
//        System.out.println(list);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(1);
//        list2.addAll(list);
//        System.out.println(list2);
//        System.out.println("list2:" + list2.size());
//        System.out.println(list2.remove(2)); // 移除2号
//        System.out.println(list2); //打印移除后的list；
//        System.out.println("list2:" + list2.size());
//        Integer ret = list2.get(0);
//        System.out.println(list2.remove(ret));
//        System.out.println(list2);
//        System.out.println("list2:" + list2.size());
//        Integer a = 10;
//        int b = a ;//隐式拆箱
//        double d = a.doubleValue();//显示拆箱


//        Integer i = 100 ;//自动装箱；//valueOf方法
//        Integer i3 = 200;
//       Integer ii = new Integer(10); // 显示装箱
//       Integer ii2 = Integer.valueOf(10); // 显示装箱
//        Integer i2 = 100;
//        Integer i4 = 200;
//        System.out.println(i == i2); // true (-128 到127 之间就是true)
//        System.out.println(i3 == i4); // false



    }
}
