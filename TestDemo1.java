import java.util.*;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-02
 * Time : 15:03
 */
public class TestDemo1 {
    public static void main (String[] args){
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
        Collection<Integer> collection1 = new LinkedList<>();
        Collection<String> collection2 = new ArrayList<>();
        collection2.add("shabi");//尾插法；
    }
}
