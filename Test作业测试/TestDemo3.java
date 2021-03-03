package Test作业测试;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

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
public class TestDemo3 {
    public static void main3(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        List<Integer> ret = list.subList(0, 2);//左闭右开,截取一部分
        System.out.println(ret);
        ret.set(0, 44); // 将list中的0号也改变了
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
    public static void main2 (String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("憨憨","阿春");
        map.put("辣鸡","迪总");
        map.put("辣鸡","狗子"); // k值相同的话，会把v值更新为最后的v值；
        map.put(null,"坤坤");//k值和v值都可以为null；
        map.put(null,null);
        System.out.println(map.get(null));
        System.out.println(map.get("辣鸡"));//通过k值拿到v值；
        System.out.println(map.getOrDefault("玄奘","唐僧"));//如果有k值，就找到k对应的v值，如果没有k值，返回“唐僧”
        System.out.println(map);
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for (Map.Entry<String,String>entry:entrySet ) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }



    }
    public static void main1 (String[] args){
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        System.out.println(collection);
        System.out.println(collection.isEmpty());
        System.out.println(collection.remove(3));
        System.out.println(collection);
        // Collection<Integer> collection1 = new LinkedList<>();
        Collection<String> collection2 = new ArrayList<>();
        collection2.add("shabi");//尾插法；
    }

    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        String str  = decimalFormat.format((5.0 / 5) * 1.0);
        System.out.println(str);
    }
}