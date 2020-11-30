package Test作业测试;
import java.util.*;
/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-25
 * Time : 23:32
 */
public class TestZuo1 {
    static int count = 0;
    static int[] arr;
    static int x;
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
             x = sc.nextInt();
            arr = new int[x+1];
            for(int i = 1; i <= x;i++){
                arr[i] = sc.nextInt();
            }
        }
        help(40,x);
        System.out.println(count);
    }
    public static void help(int s,int x){
        if(s == 0) count++; //s表示背包剩余容量，x表示剩下物品的种类；
        if(s <= 0 || s > 0&& x < 0) return;//容量小于0 或者物品种类没了，就要截止；
        help(s-arr[x],x-1);//从最后一件物品开始装；
        help(s,x-1);//最后一件已经无解的话，尝试倒数第二件；
    }


    public static String compressString(String S) {
        StringBuffer sb = new StringBuffer();
        int count = 1;
        sb.append(S.charAt(0));
        for(int i = 1;i < S.length();i++){
            char x = S.charAt(i);
            char c = S.charAt(i-1);
            if( x == c){
                count++;
            }else{
                sb.append(count);
                count = 1;
                sb.append(x);
            }
        }
        sb.append(count);//到最后那位，也要count；
        String str = sb.toString().trim();

        if(str.length() < S.length()){
            return str;
        }
        return S;
    }
    public static void main2 (String[] args){
        String S = "cba";
        String T = "abcd";
        System.out.println(customSortString(S,T));
    }
    
    public static String customSortString(String S, String T) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < S.length();i++) {
            char x = S.charAt(i);
            set.add(x);
        }
        int count = 0;//用来限制sb2重复添加，因为我只想让他添加一个循环
        for(int i = 0;i < S.length();i++){
            char x = S.charAt(i);
            for(int j = 0 ; j < T.length();j++){
                char c = T.charAt(j);
                if(set.contains(c)){
                    if(x == c){
                        sb.append(c);
                    }
                }else{
                    if(count == 0) sb2.append(c);
                }
            }
            count++;
        }
        sb.append(sb2);
        return sb.toString();
    }
    public  static List<String> findAndReplacePattern(String[] words, String pattern) {
        int n = pattern.length();
        List<String> list = new ArrayList<>();
        for(String word : words){
            if(word.length() == n){
                HashMap<Character,Character> map = new HashMap<>();
                int count = 0;
                for(int i = 0;i < word.length();i++){
                    char x = word.charAt(i);
                    char y = pattern.charAt(i);
                    if(map.containsKey(x)){
                        if(map.get(x) != y){
                            break;
                        }else {
                            map.put(x,y);
                            count++;
                        }
                    }else{
                        if(map.containsValue(y)){
                            break;
                        }else{
                            map.put(x,y);
                            count++;
                        }
                    }
                }
                if(count == n) list.add(word);
            }

        }
        return list;
    }
    public static String reorderSpaces(String text) {
        int count = 0;//空格的个数;
        for(int i = 0;i < text.length();i++){
            char x = text.charAt(i);
            if(x ==' ') count++;
        }
        int tmp = 0; //单词个数;
        String[] str = text.trim().split(" ");
        for(String word : str){
            if(!word.equals("")){
                tmp++;
            }
        }
        int x = count / (tmp-1);
        int y = count % (tmp-1);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length;i++){
            if (!str[i].equals("")) {
                if(i < str.length-1){
                    sb.append(str[i]);
                    while(x > 0){
                        sb.append(" ");
                        x--;
                    }
                    x = count / (tmp-1);
                }else{
                    sb.append(str[i]);
                    while(y > 0){
                        sb.append(" ");
                        y--;
                    }
                }
            }
        }
        return sb.toString();
    }
    public static String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        int left = 0;
        int right = str.length-1;
        while(left < right){
            String tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }
        StringBuffer sb = new StringBuffer();
        for(String word : str){
            if(word.equals("")) continue;
            sb.append(word);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static void main3(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = helpNum(x,y);
            int z = x * y / a;
            System.out.println(z);
        }
    }
    public static int  helpNum(int x, int y){
        if(x < y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        while ( y != 0){
            if(x == y) return x;
            else {
                int k = x % y;
                x = y;
                y = k;
            }
        }
        return x;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[][] array = new int[x][y];
            int count = 0;
            for(int i = 0 ;i < x;i++){
                if(i % 4 == 0 || i % 4 == 1){
                    for (int j = 0; j < y; j++) {
                        if(j % 4 == 0 || j % 4 == 1){
                            array[i][j] = 1;
                            count++;
                        }
                    }
                }else {
                    for (int j = 0; j < y; j++) {
                        if( j % 4 == 2 || j % 4 == 3){
                            array[i][j] = 1;
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
