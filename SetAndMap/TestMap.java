package SetAndMap;

import java.util.*;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-17
 * Time : 10:19
 */
//key - value 关系；
public class TestMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("玄策","电耗子"); //将key(玄策),以及对应的value(电耗子)放入map;
        map.put("裴勤虎","老虎");
        map.put("云中君","走地鸡");
        map.put("瑶妹","永远的神");
        map.put("孙悟空","吉吉国王");
        System.out.println(map.get("玄策")); //得到 电耗子；
        System.out.println(map.getOrDefault("瑶妹","混子")); //得到永远的神；因为存在瑶妹
        System.out.println(map.getOrDefault("李信","高地保安"));//得到高低保安，因为不存在李信，返回默认值；
        map.remove("孙悟空");//将孙悟空对应的隐射关系都删掉了；
        map.put("李信","高地保安");
        map.remove("李信","高地保安"); //将其全部删掉；
        System.out.println(map.containsValue("吉吉国王"));
        System.out.println(map.containsKey("孙悟空"));
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + "--->" + entry.getValue()); //将map中的key 和value 一一对应打印出来；
        }


    }


}
