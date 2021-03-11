package Test作业测试;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-03-10
 * Time : 18:27
 */
public class Main1 {
    /*public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = sc.nextInt();
            int a= sc.nextInt();
            String str = sc.nextLine();
            str = a + str;
            String[] s = str.split(" ");
            System.out.println(Arrays.toString(s));
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            int count = 0;
            for (String s1 : s) {
                if(!s1 .equals("") ){
                    if(count < n){
                        list1.add(Integer.parseInt(s1));
                        count++;
                    }else {
                        list.add(Integer.parseInt(s1));
                    }
                }
            }
            //System.out.println(list1);
            Collections.reverse(list1);
            list.addAll(list1);
            System.out.println(list1);
            StringBuffer sb = new StringBuffer();
            for (int x : list) {
               sb.append(x);
               sb.append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }*/
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n % 100 == 0){
                num = n / 100;
            }else {
                int x = n / 100;
                int count = n % 100;
                if(count % 20 == 0){
                    num = x + count / 20;
                }else {
                    int x1 = count / 20;
                    int count1 = x1 % 20;
                    if(count1 % 5 == 0){
                        num = num + count / 20 + count1 % 5;
                    }else {
                        int x2 = count1 /5;
                        int count2 = count1 % 5;
                        num = num + count / 20 + count1 / 5 + count2 ;
                    }
                }
            }
            System.out.println(num);
        }
    }
}
