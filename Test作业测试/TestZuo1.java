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
    public static void main4(String[] args){
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
    public static void main5(String[] args){
        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
            String str = "3 9 6 8 -10 7 -11 19 30 12 23 5";
            String[] s = str.split(" ");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length-1 ; i++) {
                list.add(Integer.parseInt(s[i]));
            }
            int k = Integer.parseInt(s[s.length-1]);
            PriorityQueue<Integer> p = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            for(int i = 0 ;i < list.size();i++){
                if(p.size() < k){
                    p.offer(list.get(i));
                }else {
                    if(list.get(i) < p.peek()){
                        p.poll();
                        p.offer(list.get(i));
                    }
                }
            }
        List<Integer> list2 = new ArrayList<>();
            while (p.size() > 0){
                list2.add(p.poll());
            }
            Collections.reverse(list2);
            for(int x : list2){
                System.out.print(x + " ");
            }

        }
   // }
   public static void main6(String[] args){
       Scanner sc = new Scanner(System.in);
//       while(sc.hasNext()){
           int x = 8;
           List<Integer> list = new ArrayList<>();
           if(x > 1000) x = 1000;
           for(int i = 0 ;i < x  ;i++){
               list.add(i);
           }
            int i = 0;
            while (list.size() > 1) {
                i = (i + 2) % list.size();
                list.remove(i);
            }
           System.out.println(list.get(0));
       }
   //}
   public static void main7(String[] args) {
        int[][] array ={{1,2,5},{3,2,1}};
       System.out.println(maxValue(array));

   }
    public  static int maxValue(int[][] grid) {
        int sum = grid[0][0];
        int i = 0;
        int j = 0;
        while(i < grid.length - 1 && j < grid[i].length-1){
            if(grid[i][j+1] < grid[i+1][j]){
                sum = sum + grid[i+1][j];
                i++;
            }else{
                sum = sum + grid[i][j+1];
                j++;
            }
        }
        if(i == grid.length -1){
            while(j < grid.length -1){
                sum = sum + grid[i][j+1];
                j++;
            }
        }else{
            if(j == grid[i].length -1 ){
                while(i < grid.length -1){
                    sum = sum + grid[i+1][j];
                    i++;
                }
            }
        }
        return sum;

    }
    static int[] array;
    public static  int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < target;i++) {
            int sum = 0;
            for(int j = i; j < target ;j++){
                sum = sum + j;
                if(sum == target ) {
                    array = new int [j-i+1];
                    int index = 0;
                    while(i <= j) {
                        array[index] = i;
                        index++;
                        i++;
                    }
                    break;
                }else {
                    if(sum > target) break;
                }
            }
            if(sum == target) list.add(array);
        }
        return list.toArray(new int[list.size()][]);
    }
    public static void main8 (String[] args){
        int x = 1516000;
        StringBuffer sb = new StringBuffer();
        while (x > 0){
            int c = x % 10;
            sb.append(c);
            x = x /10;
        }
       // System.out.println(sb.toString());
        System.out.println(Feb(500));

    }
    public static long Feb(int x){
        long  sum = 1;
        if(x == 1) return 1;
        while (x > 1){
            sum = sum * x;
            int i = x--;
        }
        return  sum;
    }
    //一组数字中只有两个数字分别分出现了1次，其他的都出现了2次；找到这两个数
        public int[] singleNumbers(int[] nums) {
            int ret = 0;
            for (int n : nums) {
                ret ^= n;
            }
            int div = 1;
            while ((div & ret) == 0) {
                div <<= 1;
            }
            int a = 0, b = 0;
            for (int n : nums) {
                if ((div & n) != 0) {
                    a ^= n;
                } else {
                    b ^= n;
                }
            }
            return new int[]{a, b};
        }

    public static void main9(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            char[] s = str.toCharArray();
            HashMap<Character ,Integer> map = new HashMap<>();
            for(char x : s){
                map.put(x,map.getOrDefault(x,0)+1);
            }
            if(map.containsKey('0')){
                System.out.println(0 + ":" + map.get('0'));
            }
            if(map.containsKey('1')){
                System.out.println(1+ ":" + map.get('1'));
            }
            if(map.containsKey('2')){
                System.out.println(2+ ":" + map.get('2'));
            }
            if(map.containsKey('3')){
                System.out.println(3+ ":" + map.get('3'));
            }
            if(map.containsKey('4')){
                System.out.println(4+ ":" + map.get('4'));
            }
            if(map.containsKey('5')){
                System.out.println(5+ ":" + map.get('5'));
            }
            if(map.containsKey('6')){
                System.out.println(6+ ":" + map.get('6'));
            }
            if(map.containsKey('7')){
                System.out.println(7+ ":" + map.get('7'));
            }
            if(map.containsKey('8')){
                System.out.println(8+ ":" + map.get('8'));
            }
            if(map.containsKey('9')){
                System.out.println(9+ ":" + map.get('9'));
            }

        }
    }
//    public String minNumber(int[] nums) {
//        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
//    }
    //生成格雷码
    public static void main10(String[] args) {
        System.out.println(Arrays.toString(getGray(3)));
    }
//    public static   String[] getGray(int n) {
//        String[] str = {"0","1"};
//        if(n == 1) return str;
//       return helpGetGray(getGray(n-1));
//
//    }
//    public static String[] helpGetGray(String[] str){
//        String[] s = new String[str.length * 2];
//        for(int i = 0 ; i < str.length;i++){
//            s[i] = "0"+str[i];
//            s[s.length-1-i] = "1" + str[i];
//        }
//        return s;
//    }
    public static String[] getGray(int n) {
        String[] str = {"0","1"};
        if(n == 1) return str;
        return helpGetGray(n,getGray(n-1));

    }
    public static String[] helpGetGray(int n ,String[] str){
        if(n == 1) return str;
        int x = str.length;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < x;i++){
            StringBuffer sb = new StringBuffer(str[i]);
            list.add(sb.insert(0,"0").toString());
        }
        for(int i = x-1; i >= 0;i--){
            StringBuffer sb = new StringBuffer(str[i]);
            list.add(sb.insert(0,"1").toString());
        }
        String[] s = new String[list.size()];
        int index = 0;
        for(String c : list){
            s[index] = c;
            index++;
        }
        return s;
    }


    public static int[] countBits(int num) {
        int[] array = new int[num+1];
        for(int i = 0;i <= num;i++){
            int count = 0;
            int z = i;
            while(z > 0){
                if(z % 2 == 1) count++;
                z >>= 1;
            }
            array[i] = count;
        }
        return array;
    }
    public static void main11(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.toString(reconstructQueue(people)));
    }
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int x = (int)(n * 0.05);
        int sum = 0;
        for (int i = x; i < n -x ; i++) {
            sum = sum+(arr[i]);
        }
        return sum /(n * 0.9);

    }
        public static int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (person1, person2) -> {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            });
            List<int[]> ans = new ArrayList<>();
            for (int[] person : people) {
                ans.add(person[1], person);
            }
            return ans.toArray(new int[ans.size()][]);
        }
    public static int minSteps(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        char[] str = s.toCharArray();
        for(char c : str){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        char[] str2 = t.toCharArray();
        for(char c : str2){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        int count = 0;
        for(char c : map.keySet()){
            int x = map.getOrDefault(c,0) - map2.getOrDefault(c,0);
            if(x > 0){
                count = count+ x;
            }
        }
        return count;
    }
    public static void main12(String[] args) {
        Scanner sc = new Scanner(System.in);
            String s1 ="99999999999999999999999999999999999999999999999999";
            String s2 = "1";
            double num = 11.64;
        System.out.println(Math.round(num));
            char[] x = new StringBuffer(s1).reverse().toString().toCharArray();
            char[] c = new StringBuffer(s2).reverse().toString().toCharArray();
            int max = Math.max(x.length,c.length);
            int[] sum = new int[max+1];
            for (int i = 0; i < sum.length; i++) {
                int ret = sum[i];
                if(i < x.length) ret = ret+x[i] - '0';
                if(i < c.length) ret = ret+c[i] - '0';
                if(ret >= 10){
                    ret = ret -10;
                    sum[i+1] = 1;
                }
                sum[i] = ret;
            }
            StringBuilder sb = new StringBuilder();
        for (int i = sum.length-1 ;i >= 0 ; i--) {
            sb.append(sum[i]);
        }
           // System.out.println(sb.toString());
    }
    public static void main13(String[] args) {
            Scanner sc = new Scanner(System.in);
            int x =  sc.nextInt();
            String c = sc.next();
            int z = (int) Math.round(x/2.0);
            for (int i = 0; i < z ;i++){
                for (int j = 0; j < x ;j++){
                    if (i == 0 || i == z-1){
                        System.out.print(c);
                    } else {
                        if (j == 0 || j == x-1){
                            System.out.print(c);
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
    }
    public static void main14(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = x * x * x;
            int z = y / x;
            int m = x/2;
            int[] array = new int[x];
            if(x % 2 == 0){
                int  max = z + 1 +2*(x-m-1);
                int index = x -1;
                while(index >= 0){
                    array[index] = max;
                    index--;
                    max = max -2;
                }
            }else{
                int max = z + 2*(x-m-1);
                int index = x -1;
                while(index >= 0){
                    array[index] = max;
                    index--;
                    max = max -2;
                }
            }
            StringBuffer sb = new StringBuffer();
            for(int num : array) {
                sb.append(num);
                sb.append("+");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main15(String[] args){
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long c = 1000000007;
        int z = 100000;
        long[] find = new long[3];
        find[0] = x;
        find[1] = (4 * find[0] + 3) % c;
        find[2] = (4 * find[1] + 3) % c;
        long tmp = z;
        long cur = 0;
        int count = 0;
        for(int i = 0;i < 3;i++){
            cur = find[i];
            count = i;
            while( cur != 0 && count < tmp){
                cur = ( cur * 8 + 7) % c;
                count++;
            }
            tmp = Math.min(count,tmp);
        }
        if(tmp < z){
            System.out.println(tmp);
        }else{
            System.out.println(-1);
        }
    }
    //实现a+b，不用加号;
    public int addAB(int A, int B) {
        int tmp = A^B;
        int prev = (A & B) << 1;
        int ret = tmp ^ prev;
        if((tmp & prev) != 0){
            ret = addAB(tmp,prev);
        }
        return ret;
    }

    public static int maxProduct(String[] words) {
        int count = 0;
        for(int i = 0;i < words.length-1;i++){
            Set<Character> set = new HashSet<>();
            char[] x = words[i].toCharArray();
            for(char c : x){
                set.add(c);
            }
            int count2 = 0;
            for(int j = i + 1;j <words.length;j++){
                char[] z = words[j].toCharArray();
                for(char c : z){
                    if(set.contains(c)){
                        count2++;
                    }
                }
                if(count2 == 0){
                    int ret = words[i].length() * words[j].length();
                    count = Math.max(count,ret);
                }
            }
        }
        return count;
    }
    public static void main16(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int x = sc.nextInt();
            if(x == 0)break;
            int[] array = new int[x];
            for(int i = 0;i < x ;i++){
                array[i] = sc.nextInt();
            }
            int y = sc.nextInt();
            int count = 0;
            for(int i = 0;i < array.length;i++){
                if(array[i] == y){
                    count++;
                }
            }
            System.out.println(count);
        }

    }
    public static void main17(String[] args){
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        while(z>0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] array = new int[2*n];
            for(int i = 0;i < array.length;i++){
                int ret = i;
                for(int j = 0;j < m;j++){
                    if(ret < n){
                        ret = ret * 2;
                    }else{
                        ret =2*(ret-n)-1;
                    }
                }
                array[ret] = sc.nextInt();
            }
            for(int i = 0; i < array.length;i++){
                if(i != array.length-1){
                    System.out.print(array[i]+" ");
                }else{
                    System.out.print(array[i]);
                }
            }
            System.out.println();
            z--;
        }
    }
    //火车出站；
    static List<String> ret = new ArrayList<>();
    public static void main18(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int[] array = new int[x];
            for(int i = 0; i < x;i++){
                array[i] = sc.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            int[] tmp = new int[2];
            tmp[0] = x;
            tmp[1] = x;
            help(array,tmp,stack);
            Collections.sort(ret);
            for(String cur : ret){
                for(int i = 0 ; i < cur.length()-1;i++){
                    System.out.print(cur.charAt(i)+ " ");
                }
                System.out.print(cur.charAt(cur.length()-1));
                System.out.println();
            }
        }
    }
    public static void help (int[] array,int[] tmp,Stack<Integer> stack){
        if(tmp[0] > 0){
            stack.push(1);
            tmp[0]--;
            help(array,tmp,stack);
            tmp[0]++;
            stack.pop();
        }
        if(tmp[1] > 0 && tmp[1] > tmp[0]){
            stack.push(0);
            tmp[1]--;
            help(array,tmp,stack);
            tmp[1]++;
            stack.pop();
        }
        if(stack.size() == array.length * 2){
            Stack<Integer> s = new Stack<>();
            String str = "";
            int i = 0;
            for(int x : stack){
                if(x == 1){
                    s.push(array[i]);
                    i++;
                }else{
                    str = String.valueOf(s.pop());

                }
                ret.add(str);
            }
        }
    }
    public static void main19(String[] args){
        int x = 100;
        long y = 1;
        x = x * 30;
        int z = 29;
        long ret =1;
        while(z > 0){
            y = y*2;
            ret = ret + y;
            z--;
        }
        System.out.println(x+" " + ret);

    }
    public static String interpret(String command) {
        StringBuffer sb = new StringBuffer();
        char[] s = command.toCharArray();
        for(int i = 0 ; i <s.length;i++){
            if(s[i] == '('){
                if(s[i+1] == ')'){
                    sb.append('o');
                    i++;
                }
            }else{
                if(s[i] != ')') sb.append(s[i]);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int x = 9669;
        System.out.println(maximum69Number(x));
    }
    public static int maximum69Number (int num) {
        StringBuffer sb = new StringBuffer();
        while(num > 0){
            sb.append(num % 10);
            num = num /10;
        }
        sb.reverse();
        for(int i = 0 ;i < sb.length();i++){
            char x = sb.charAt(i);
            if(x == '6'){
                sb.delete(i,i+1);
                sb.insert(i,9);

                break;
            }
        }

        return Integer.parseInt(sb.toString());
    }
    public static String predictPartyVictory(String senate) {
        int x = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for(int i = 0;i < x;i++){
            if(senate.charAt(i) == 'R'){
                r.offer(i);
            }else {
                d.offer(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()){
            int rindex = r.poll();
            int dindex = d.poll();
            if(rindex < dindex){
                r.offer(rindex+x);
            }else {
                d.offer(dindex+x);
            }
        }
        return !r.isEmpty() ? "Radiant" : "Dire";
    }
    //原地反转数组;
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] matrix_new = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix_new[j][n - i - 1] = matrix[i][j];
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = matrix_new[i][j];
                }
            }
        }
    public List<String> commonChars(String[] A) {
        String str = A[0];
        for(int i = 1;i < A.length;i++){
            Map<Character,Integer> map1 = new HashMap<>();
            Map<Character,Integer> map2 = new HashMap<>();
            char[] x = str.toCharArray();
            for(char ch:x){
                map1.put(ch,map1.getOrDefault(ch,0)+1);
            }
            char[] y = A[i].toCharArray();
            for(char ch:y){
                map2.put(ch,map2.getOrDefault(ch,0)+1);
            }
            StringBuffer sb = new StringBuffer();
            for(char n : map1.keySet()){
                int min = Math.min(map1.getOrDefault(n,0),map2.getOrDefault(n,0));
                while(min > 0){
                    sb.append(n);
                    min--;
                }
            }
            str = sb.toString();
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() ; i++) {
            char x = str.charAt(i);
            list.add(String.valueOf(x));
        }
        return list;
    }
    //有序链表变二叉搜索树
    /*public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    */
    /*二叉搜索树转双向链表循环
        Node pre, head;
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }
        void dfs(Node cur) {
            if(cur == null) return;
            dfs(cur.left);
            if(pre != null) pre.right = cur;
            else head = cur;
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }
    }
*/
    public boolean wordPattern(String pattern, String s) {
        char[] sp = pattern.toCharArray();
        String[] ss= s.split(" ");
        Map<Character,String> map = new HashMap<>();
        for(int i = 0;i < sp.length;i++){
            if(map.containsKey(sp[i])){
                if(!map.get(sp[i]).equals(ss[i])){
                    return false;
                }
            }else {
                if(map.containsValue(ss[i])){
                    return false;
                }
                map.put(sp[i],ss[i]);
            }
        }
        return  true;
    }
    //数字的补数
    public int findComplement(int num) {
        String tmp = "";
        String cur = Integer.toBinaryString(num);
        for(int i = 0;i < cur.length();i++){
           int x =  cur.charAt(i) ^ '1';
           tmp = tmp + x;
        }
        return Integer.parseInt(tmp,2);
    }
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = Integer.MIN_VALUE;
        if(set.size() == 1) return nums[0];
        if(set.size() == 2) {
            for (int num : nums) {
                max = Math.max(max,num);
            }
            return max;
        }
        int first = -1;
        int firstNum = 0;
        int second = -1;
        int secondNum = 0;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
                first = i;
                firstNum = max;
            }
        }
         max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if( i ==  first) continue;
            if(nums[i] == firstNum) continue;
            if(nums[i] > max){
                max = nums[i];
                second = i;
                secondNum = max;
            }
        }
         max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(i == first || i == second) continue;
            if(nums[i] == firstNum || nums[i] == secondNum) continue;
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;

    }
    //第二高薪水
    /*select MAX(Salary) as SecondHighestSalary from Employee where
    Salary not in (select max(Salary) from Employee);*/


}
