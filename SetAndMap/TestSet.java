package SetAndMap;

import java.util.*;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-17
 * Time : 10:25
 */
public class TestSet {
    public static void main(String[] args) { //打印每个数字出现了多少次；
        List<Integer> list = new ArrayList<>();
        Random ra = new Random();
        for(int i = 0;i <= 100000;i++){
            int n = ra.nextInt(100000);
            list.add(n);
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(Integer key : list){
            //hashMap.put(key,hashMap.getOrDefault(key,0)+1);
            if(hashMap.get(key) == null){
                hashMap.put(key,1);
            }else {
                int val = hashMap.get(key); //这个val就是key对应的value ，也就是对应的出现次数；
                hashMap.put(key,val+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            System.out.println(entry.getKey() + "次数为" + entry.getValue());
        }

    }
    public static void main3(String[] args) { //去重；
        List<Integer> list = new ArrayList<>();
        Random ra = new Random();
        for(int i = 0;i <= 100000;i++){
            int n = ra.nextInt(100000);
            list.add(n);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < list.size();i++){
               set.add(list.get(i));
        }
        System.out.println(set);
    }
    public static void main2(String[] args) { //第一个重复的数据；
        List<Integer> list = new ArrayList<>();
        Random ra = new Random();
        for(int i = 0;i <= 100000;i++){
            int n = ra.nextInt(100000);
            list.add(n);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < list.size();i++){
            if( !set.contains(list.get(i))){
                set.add(list.get(i));
            }else {
                System.out.println(list.get(i));
                return;
            }
        }
    }
    //set的值不能修改，只能先删除再添加；
    public static void main1(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("野王");
        set.add("混子");//添加；
        System.out.println(set);
        set.clear();//清空集合；
        set.add("法王");
        set.remove("法王");//删除集合的某个元素；
       Iterator<String> it =  set.iterator();//迭代器；
        while (it.hasNext()){
            System.out.println(it.next());
        }
        set.contains("ahhh");//是否包含某个元素；
        set.isEmpty();//是否为空；
        set.size();//长度；
        set.toArray();//转换为数组输出;
    }
}
