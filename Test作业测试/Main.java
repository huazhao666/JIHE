package Test作业测试;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-03-10
 * Time : 15:52
 */

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            int index = 0;
            List<String> list = new ArrayList<>();
            for(int i = 0; i< s.length();i++){
                char x = s.charAt(i);
                if(x == '\n'){
                    list.add(s.substring(index,i+1));
                    index = i+1;
                }
            }
        for (int i = 0; i <list.size() ; i++) {
            StringBuffer sb = new StringBuffer();
            String s1 = list.get(i).trim();
            int num = s1.indexOf('\t');
            String s2 = s1.substring(0,num);
            String s3 =s1.substring(num+1);
            if(s3.startsWith("0x")){
                int num1 = 0;
                int count = 0;
                for (int j = s3.length()-1; j > 1 ; j--) {
                    char x = s3.charAt(j);
                    int num2 = 0;
                    if(x >= 'A'){
                       num2 = x - 7;
                    }else {
                        num2 = Integer.parseInt(String.valueOf(x));
                    }
                    int num3 = count;
                    while (num3 > 0){
                        num2 = num2 * 16;
                        num3--;
                    }
                    num1 = num1 + num2;
                    count++;
                }
                s2 = s2 +"," + num1;
            }else if(s3.startsWith("x")) {
                sb = null;
                break;
            }else {
                s2 = s2+"," + s3;
            }
            sb.append(s2);
            System.out.println(sb.toString());
        }
        }

    }
    String s1 = "晨光AFPM0801\n0x2\t斑马小楷,40\n";
    String string = "晨光AFPM0801,2" +
                    "斑马小楷,40";
}
