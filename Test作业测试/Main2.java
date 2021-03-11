package Test作业测试;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-03-10
 * Time : 20:02
 */
public class Main2 {
    public static void mainllll(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            boolean flag = true;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length() ; i++) {
                StringBuffer sb = new StringBuffer(s);
                String string = sb.deleteCharAt(i).toString();
                flag = help(string);
                if(flag){
                   list.add(string);
                }
            }
            if(list.size() == 0){
                System.out.println(false);
            }else {
                System.out.println(list.get(0));
            }
        }
    }
    public static boolean help(String s){
        StringBuffer sb = new StringBuffer(s);
        String string = sb.reverse().toString();
        if(string.equals(s)){
            return true;
        }else {
            return false;
        }

    }



}

