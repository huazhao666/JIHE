package Test作业测试;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-24
 * Time : 21:13
 */
public class TestZuo3 {
    static int n, m, max = 0;
    static int[][] array;
    static boolean flag = false;
    static String path = "";
    static LinkedList<String> list = new LinkedList<>();

    public static void mainppppp(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int p = sc.nextInt();
        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        helpArray(0, 0, p);
        if (!flag)
            System.out.println("Can not escape!");
        else
            System.out.println(path);

    }

    public static synchronized void helpArray(int x, int y, int energy) {
        if (energy < 0 || x<0 || y<0 || x >= n || y>= m || array[x][y] != 1) {
            return;
        }else {
            list.add("[" + x + "," + y + "]");
            array[x][y] = 0;
            if (x == 0 && y == m - 1) {
                if (energy >= max) {
                    max = energy;
                    helpPath();
                }
                array[x][y] = 1;
                list.removeLast();
                flag = true;
                return;
            }
            helpArray(x, y+1, energy-1); // 右移
            helpArray(x+1, y, energy); // 下移
            helpArray(x-1, y, energy-3);//上移
            helpArray(x, y-1, energy-1);//左移
            array[x][y] = 1;
            list.removeLast();
        }
    }

    public static void helpPath() {
        StringBuilder sb = new StringBuilder();
        for(String res : list){
            sb.append(res);
            sb.append(",");
        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        path = sb.toString();
    }
    static int[][] help = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int count = 0;
    static boolean[][] visited;
    public static void mainllllllllllljjh(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int a = -1,b = -1;
            char[][] ch= new char[m][n];
            for(int i = 0;i < m;i++){
                String str = sc.next();
                for(int j = 0;j < n;j++){
                    ch[i][j] = str.charAt(j);
                    if(ch[i][j] == '@'){
                        a = i;
                        b = j;
                    }
                }
            }
            helpBR(a,b,ch);
            System.out.println(count);
        }
    }

    public static void helpBR(int a ,int b, char[][] s){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a,b});
        visited[a][b] = true;
        while (!q.isEmpty()){
            int[] aT = q.poll();
            for(int i = 0 ;i < 4;i++){
                int[] aH = new int[]{aT[0] + help[i][0],aT[1] + help[i][1]};
                if(aH[0] >= 0 && aH[0] < s.length && aH[1] >= 0 && aH[1] < s[0].length
                    && (!(s[aH[0]][aH[1]] == '#')) && (!visited[aH[0]][aH[1]]) ){
                        count++;
                        q.offer(aH);
                        visited[aH[0]][aH[1]] = true;
                }
            }
        }
    }
    private static double solve(int n, int m, int[][] xy) {

        double[][] map = new double[n + 1][m + 1];
        for (int[] a : xy) {
            map[a[0]][a[1]] = -1;
        }
        map[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != -1) {
                    if (map[i - 1][j] != -1)
                        map[i][j] += j == m ? map[i - 1][j] : map[i - 1][j] / 2;
                    if (map[i][j - 1] != -1)
                        map[i][j] += i == n ? map[i][j - 1] : map[i][j - 1] / 2;
                }
            }
        }
        return map[n][m];
    }
    public static void ma(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] x = new int[n];
            for(int i = 0; i < n; i++){
                x[i] = sc.nextInt();
            }
            long max = Integer.MIN_VALUE;

        }
    }

    public static void mainllllllllllllswq (String[] args){
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));

    }
    public static String[] findRestaurant(String[] list1, String[] list2) {
        int index = 0;
        PriorityQueue<String[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> Integer.parseInt(o[1])));
        for(int i = 0;i < list1.length;i++){
            for(int j = 0;j < list2.length;j++){
                if(list1[i].equals(list2[j])){
                    index = i+j;
                    q.offer(new String[]{list1[i],String.valueOf(index)});
                    continue;
                }
            }
        }
        List<String[]> list = new ArrayList<>();
        while (!q.isEmpty()){
            list.add(q.poll());
        }
        List<String> ret = new ArrayList<>();
        ret.add(list.get(0)[0]);
        int x = Integer.parseInt(list.get(0)[1]);
        for (int i = 1; i < list.size(); i++) {
            int y = Integer.parseInt(list.get(i)[1]);
                if(y == x){
                    ret.add(list.get(i)[0]);
                }else {
                    break;
                }
        }
        int perv = 0;
        String[] s = new String[ret.size()];
        for(String str : ret){
            s[perv] = str;
            perv++;
        }
        return s;
    }
    public static void maingyfhfthfh(String[] args){
        Scanner sc = new Scanner(System.in);
            String s = "abcd12345ed125ss123456789";
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            int start = 0;
            int end = 0;
            for(int i = 0;i < s.length();i++){
                char x = s.charAt(i);
                if(x < 65){
                    stack.push(i);
                }else {
                    if(!stack.isEmpty()){
                        int a = stack.peek();
                        while (stack.size() > 1){
                            stack.pop();
                        }
                        int b = stack.pop();
                        if(max < a-b+1){
                            max = a-b+1;
                            end = a;
                            start = b;
                        }
                    }
                }
            }
            if(!stack.isEmpty()){
                int a = stack.peek();
                while (stack.size() > 1){
                    stack.pop();
                }
                int b = stack.pop();
                if(max < a-b+1){
                    end = a;
                    start = b;
                }
            }

            String str = s.substring(start,end+1);
            System.out.println(str);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] x = new int[n];
            for(int i = 0;i < n;i++){
                x[i] = sc.nextInt();
            }
            Arrays.sort(x);
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
            for(int i = 0;i < m;i++){
                int anInt = sc.nextInt();
                int bInt = sc.nextInt();
                if(anInt <= x[n-1]){
                    queue.offer(new int[]{anInt,bInt});
                }
            }
            int money = 0;
            int use = 0;
            boolean[] desk = new boolean[n];
            while (!queue.isEmpty()){
                int[] a = queue.poll();
                for (int i = 0; i < n; i ++) {
                    if(a[0] <= x[i] && ! desk[i]) {
                        money = money + a[1] ;
                        desk[i] = true;
                        use ++;
                        break;
                    }
                }
                if(use == n){
                    break;
                }
            }
            System.out.println(money);
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k <= 0 || k > input.length){
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i = 0;i < input.length;i++){
            if(queue.size() <= k){
                queue.offer(input[i]);
            }else {
                queue.poll();
            }
        }
        while (queue.size() > k){
            queue.poll();
        }
        while (!queue.isEmpty()){
            list.add(queue.poll());
        }
        Collections.reverse(list);
        return list;
    }



}
