package Test作业测试;

import java.text.DecimalFormat;
import java.util.*;
import java.util.Map;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-11
 * Time : 19:24
 */
public class TestZuo2 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<String, Integer> map = new HashMap<>();
            int x = sc.nextInt();
            for (int i = 0; i < x; i++) {
                map.put(sc.next(), 0);
            }
            int y = sc.nextInt();
            int count = 0;
            for (int i = 0; i < y; i++) {
                String str = sc.next();
                if (map.get(str) == null) {
                    count++;
                } else {
                    map.put(str, map.get(str) + 1);
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
            for (String c : map.keySet()) {
                System.out.println(c + " : " + map.get(c));
            }
            String strc = "Invalid";
            System.out.println(strc + " : " + count);

        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<String, Integer> map = new HashMap<>();
            int x = sc.nextInt();
            String[] s = new String[x];
            for (int i = 0; i < x; i++) {
                s[i] = sc.next();
            }
            int y = sc.nextInt();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < y; i++) {
                String str = sc.next();
                map.put(str, map.getOrDefault(str, 0) + 1);
                set.add(str);
            }
            for (String c : s) {
                if (map.get(c) != null) {
                    int x1 = map.get(c);
                    System.out.println(c + " : " + x1);
                }

                String strc = "Invalid : ";
                System.out.print(strc + (set.size() - x));
            }

        }
    }

    /*  167773121
              10.3.3.193
  */
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        //while(sc.hasNext()){
        String s = "10.0.3.193";
        String str = "167969729";
        helps(s);
        helpStr(str);
        // }
    }

    public static void helps(String s) {
        String[] s1 = s.split("\\.");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String s2 = Integer.toBinaryString(Integer.parseInt(s1[i]));
            if (s2.length() < 8) {
                int count = 8 - s2.length();
                StringBuffer sb1 = new StringBuffer();
                while (count > 0) {
                    sb1.append("0");
                    count--;
                }
                s2 = sb1.toString() + s2;
            }
            sb.append(s2);
        }
        long ret = Long.parseLong(sb.toString(), 2);
        System.out.println(ret);
    }

    public static void helpStr(String str) {
        String s = Long.toBinaryString(Long.parseLong(str));
        StringBuffer sb = new StringBuffer();
        if (s.length() < 32) {
            int count = 32 - s.length();
            while (count > 0) {
                sb.append("0");
                count--;
            }
        }
        s = sb.toString() + s;
        String[] x = new String[4];
        x[0] = s.substring(0, 8);
        x[1] = s.substring(8, 16);
        x[2] = s.substring(16, 24);
        x[3] = s.substring(24, 32);
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            sb1.append(Integer.parseInt(x[i], 2));
            sb1.append(".");
        }
        sb1.deleteCharAt(sb1.length() - 1);
        System.out.println(sb1.toString());
    }

    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        // while(sc.hasNext()){
        String s = "021ABC9000";
        if (s.length() > 8 && helpCon(s) >= 3 && helpCf(s)) {
            System.out.println("OK");
        } else {
            System.out.println("NG");
        }
        // }
    }

    public static int helpCon(String s) {
        int count = 0;
        if (s.length() - s.replaceAll("[A-Z]", "").length() > 0) {
            count++;
        }
        if (s.length() - s.replaceAll("[a-z]", "").length() > 0) {
            count++;
        }
        if (s.length() - s.replaceAll("[0-9]", "").length() > 0) {
            count++;
        }
        if (s.length() - s.replaceAll("[A-Z，0-9，a-z]", "").length() > 0) {
            count++;
        }
        return count;
    }

    public static boolean helpCf(String s) {
        for (int i = 0; i < s.length() - 3; i++) {
            String s1 = s.substring(i, i + 3);
            String s2 = s.substring(i + 3, s.length() - 1);
            if (s2.contains(s1)) {
                return false;
            }
        }
        return true;
    }


    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);
        //while(sc.hasNext()){
        int x = 3;
        String[] s = new String[x];
        s[0] = "7896907855090142755874787068316593097162662301276";
        s[1] = "85270007029524889956117967733369122761943429379586";
        s[2] = "56016023782220685786174974897740638058306366772004";
        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j < s.length - 1; j++) {
                if (s[j].length() > s[j + 1].length()) {
                    String tmp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = tmp;
                }
                if (s[j].length() == s[j + 1].length()) {
                    for (int k = 0; k < s[j].length(); k++) {
                        if (s[j].charAt(k) > s[j + 1].charAt(k)) {
                            String tmp = s[j];
                            s[j] = s[j + 1];
                            s[j + 1] = tmp;
                            break;
                        } else {
                            if (s[j].charAt(k) < s[j + 1].charAt(k)) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (String s1 : s) {
            System.out.println(s1);
        }
    }

    public static void main6(String[] args) {
        String m = Integer.toBinaryString('z');
        System.out.println((int) 'a');
        System.out.println((int) 'A');
        System.out.println((int) '0');
        System.out.println(m);
    }

    public static void main7(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int left = 0;
            int right = s.length - 1;
            while (left < right) {
                String tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }
            StringBuffer sb = new StringBuffer();
            for (String x : s) {
                sb.append(x);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }

    public static void main8(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNext()) {
            String path = sc.next();
            int index = path.lastIndexOf("\\");
            String file = index == -1 ? path : path.substring(index + 1); //默认是到最后一位；
            int row = sc.nextInt();
            String s = file + " " + row;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int count = 0;
        for (Map.Entry<String, Integer> map1 : list) {
            if (count >= 8) break;
            String[] s1 = map1.getKey().split(" ");
            String fileName = s1[0];
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }
            String s2 = s1[1];
            Integer num = map1.getValue();
            System.out.printf("%s %s %d%n", fileName, s2, num);
            count++;
        }
    }

    public static void main9(String[] args) {
//        int x = 20,y = 5;
//        System.out.println(x+y + "" + (x+y)+y);
        // helpNum(1234);
        int i = 7, count = 0;
        do {
            System.out.println(--i);
            --i;
            count++;
        } while (i != 0);
        System.out.println(count);
    }

    public static void helpNum(int x) {
        System.out.println(x % 10);
        if ((x / 10) != 0) {
            helpNum(x / 10);
        }
        System.out.println(x % 10);
    }

    public void rotate(int[] nums, int k) {
        int[] num = new int[nums.length];
        for (int i = 0; i < num.length; i++) {
            int index = (i + k) % num.length;
            num[index] = nums[i];
        }
        for (int i = 0; i < num.length; i++) {
            nums[i] = num[i];
        }
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        for (char x : magazine.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : ransomNote.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }
        for (char x : ransomNote.toCharArray()) {
            if (map1.getOrDefault(x, 0) > map.getOrDefault(x, 0)) {
                return false;
            }
        }
        return true;

    }

    String str = new String("hello");
    char[] ch = {'a', 'b'};
    private float f = 1.0f;
    int m = 12;
    static int n = 1;

    public static int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            while (left < right && A[left] % 2 == 0) {
                left++;
            }
            while (left < right && A[right] % 2 == 1) {
                right--;
            }
            if (left > right) break;
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
            left++;
            right--;
        }
        return A;
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'c';
        StringBuffer sb = new StringBuffer();

    }

    public static void mains(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            String[] s1 = s[0].split("\\.");
            String[] s2 = s[1].split("\\.");
            StringBuffer sb = new StringBuffer();
            int[] a1 = new int[s1.length];
            int[] a2 = new int[s2.length];
            for (int i = 0; i < s1.length; i++) {
                a1[i] = Integer.parseInt(s1[i]);
                a2[i] = Integer.parseInt(s2[i]);
            }
            boolean flag = false;
            if (a1[0] > a2[0]) {
                swap(a1, a2);
                flag = true;
            } else {
                if (a1[0] == a2[0]) {
                    if (a1[1] > a2[1]) {
                        swap(a1, a2);
                        flag = true;
                    } else {
                        if (a1[1] == a2[1]) {
                            if (a1[2] > a2[2]) {
                                swap(a1, a2);
                                flag = true;
                            }
                        }
                    }
                }
            }
            if (a2[2] < a1[2]) {
                sb.append(a2[2] + 29 - a1[2]);
                a2[1]--;
            } else {
                sb.append(a2[2] - a1[2]);
            }
            sb.insert(0, ".");
            if (a2[1] < a1[1]) {
                sb.insert(0, a2[1] + 17 - a1[1]);
                a2[0]--;
            } else {
                sb.insert(0, a2[1] - a1[1]);
            }
            sb.insert(0, ".");
            sb.insert(0, a2[0] - a1[0]);
            if (flag) {
                sb.insert(0, "-");
            }
            System.out.println(sb.toString());
        }
    }

    public static void swap(int[] a1, int[] a2) {
        for (int i = 0; i < 3; i++) {
            int tmp = a1[i];
            a1[i] = a2[i];
            a2[i] = tmp;
        }
    }

    public static int countNumberOf2s(int n) { //
        int count = 0;
        int fac = 1;
        int low = 0;
        int num = 0;
        int high = 0;
        while (n / fac != 0) {
            low = n - (n / fac) * fac;
            num = (n / fac) % 10;
            high = n / (fac * 10);
            switch (num) {
                case 0:
                    count += high * fac;
                    break;
                case 1:
                    count += high * fac;
                    break;
                case 2:
                    count += high * fac + low + 1;
                    break;
                default:
                    count += (high + 1) * fac;
                    break;
            }
            fac *= 10;
        }
        return count;
    }

    public static void mainrr(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int j = 0;
            int y = 0;
            Map<Character, Integer> mapA = new TreeMap<>();
            Map<Character, Integer> mapB = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                char a = sc.next().charAt(0);
                char b = sc.next().charAt(0);
                int re = match(a, b);
                if (re == 1) {
                    j++;
                    mapA.put(a, mapA.getOrDefault(a, 0) + 1);
                } else if (re == -1) {
                    y++;
                    mapB.put(b, mapB.getOrDefault(b, 0) + 1);
                }
            }
            int x = n - j - y;
            System.out.println(j + " " + x + " " + y);
            System.out.println(y + " " + x + " " + j);
            int max = 0;
            for (Map.Entry<Character, Integer> m : mapA.entrySet()) {
                if (m.getValue() > max) {
                    max = m.getValue();
                }
            }
            if (max == 0) {
                System.out.print("B");
            } else {
                for (Map.Entry<Character, Integer> m : mapA.entrySet()) {
                    if (m.getValue() == max) {
                        System.out.print(m.getKey());
                        break;
                    }
                }
            }
            max = 0;
            System.out.print(" ");
            for (Map.Entry<Character, Integer> m : mapB.entrySet()) {
                if (m.getValue() > max) {
                    max = m.getValue();
                }
            }
            if (max == 0) {
                System.out.print("B");
            } else {
                for (Map.Entry<Character, Integer> m : mapB.entrySet()) {
                    if (m.getValue() == max) {
                        System.out.print(m.getKey());
                        break;
                    }
                }
            }
        }
    }

    public static int match(char a, char b) {
        if (a == b) {
            return 0;
        } else if ((a == 'C' && b == 'J') || (a == 'J' && b == 'B') || (a == 'B' && b == 'C')) {
            return 1;
        } else {
            return -1;
        }
    }


    public static int countWays(int n) {
        if (n <= 2) return n;
        if (n == 3) return 4;
        long a1 = 1;
        long a2 = 2;
        long a3 = 4;
        long b = 0;
        while (n > 3) {
            b = (a1 + a2 + a3) % 10000_00007;
            a1 = a2 % 10000_00007;
            a2 = a3 % 10000_00007;
            a3 = b % 10000_00007;
            n--;
        }
        return (int) b;
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] array = {-1, -1};
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    array[0] = i;
                    array[1] = j;
                }
            }
        }
        return array;
    }

    public static int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                left = i + 1;
                break;
            }
        }
        if (left == 0) return 0;
        int a1 = left - 1;
        while (a1 >= 0 && nums[left] < nums[a1]) {
            a1--;
        }
        a1++;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                right = i - 1;
                break;
            }
        }
        int a2 = right + 1;
        while (a2 <= nums.length - 1 && nums[right] > nums[a2]) {
            a2++;
        }
        a2--;
        return a2 - a1 + 1;
    }

    public static int compress(char[] chars) {
        int n = chars.length;
        StringBuffer sb = new StringBuffer();
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int i = 0;
        for (i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                s.push(i);
            } else {
                int start = 0, end = 0;
                if (s.size() > 1) {
                    end = s.pop();
                    while (s.size() > 1) {
                        s.pop();
                    }
                    start = s.pop();
                } else {
                    s.pop();
                }
                sb.append(chars[i - 1]);
                if (end - start > 0) {
                    sb.append(end - start + 1);
                }
                s.push(i);
            }
        }
        if (!s.isEmpty()) {
            sb.append(chars[s.peek()]);
            if (s.size() > 1) {
                sb.append(s.size());
            }
        }
        for (int j = 0; j < sb.length(); j++) {
            chars[j] = sb.charAt(j);
        }
        return sb.length();
    }

    public static void mainyyy(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < s2.length(); i++) {
                char x = s2.charAt(i);
                set.add(String.valueOf(x).toUpperCase());
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s1.length(); i++) {
                char x = s1.charAt(i);
                String s = String.valueOf(x).toUpperCase();
                if (set.add(s)) {
                    sb.append(s);
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void main3435(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int z1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int z2 = sc.nextInt();
            int x = Math.abs(x1 - x2);
            int y = Math.abs(y1 - y2);
            int z = Math.abs(z1 - z2);
            double r = Math.sqrt(x * x + y * y + z * z);
            DecimalFormat format = new DecimalFormat("#.000");
            String r1 = format.format(r);
            double v = Math.PI * r * r * r * 4 / 3;
            //Math.PI --------- Π  --- 3.141592653589793的那个；
            String v1 = format.format(v);
            StringBuffer sb = new StringBuffer();
            sb.append(r1);
            sb.append(" ");
            sb.append(v1);
            System.out.println(sb.toString());
        }
    }

    public static void mainlllllllllll(String[] args) {
        Scanner sc = new Scanner(System.in);
        long xr = 1;
        int day = 29;
        long sum = 1;
        int xp = 0;
        xp = 30 * 10;
        while (day > 0) {
            sum = sum * 2;
            xr = xr + sum;
            day--;
        }
        System.out.println(xr);
        System.out.println(xp);

    }

    public static int calculateMax(int[] prices) {
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int maxp = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            if (maxp < prices[i] - min) {
                maxp = prices[i] - min;
            }
            left[i] = maxp;
        }
        maxp = 0;
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (max < prices[i]) {
                max = prices[i];
            }
            if (maxp < max - prices[i]) {
                maxp = max - prices[i];
            }
            right[i] = maxp;
        }
        maxp = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] + right[i] > maxp) {
                maxp = left[i] + right[i];
            }
        }
        return maxp;
    }

    //十六进制转换为十进制；
    public static int exchanges(String str) {
        char[] s = str.toCharArray();
        int x = 0;
        for (int i = 2; i < s.length; i++) {
            x = x * 16;
            if (s[i] >= 'A' && s[i] <= 'F') {
                s[i] = (char) (s[i] - 'A' + 10);
            } else if (s[i] >= 'a' && s[i] <= 'f') {
                s[i] = (char) (s[i] - 'a' + 10);
            } else {
                s[i] = (char) (s[i] - '0');
            }
            x = x + (int) s[i];
        }
        return x;
    }

    public static void maindf(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }
            helpArray1(a, b);
        }
    }

    public static void helpArray1(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                list.add(b[i]);
            } else {
                list.remove(new Integer(b[i]));
            }
            if (helpArray2(list)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean helpArray2(List<Integer> list) {
        if (list.size() < 3) {
            return false;
        }
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int tmp = list.remove(i);
            int sum = 0;
            for (int j = 0; j < len - 1; j++) {
                sum = sum + list.get(j);
            }
            if (sum <= tmp) {
                list.add(i, tmp);
                return false;
            }
            list.add(i, tmp);
        }
        return true;
    }

    static boolean[][] visited;
    static int count;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void mainlllll(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int x = in.nextInt();
            int y = in.nextInt();
            int a = -1, b = -1;
            char[][] ch = new char[x][y];
            count = 1;
            visited = new boolean[x][y];
            for (int i = 0; i < x; i++) {
                String str = in.next();
                for (int j = 0; j < y; j++) {
                    ch[i][j] = str.charAt(j);
                    if (ch[i][j] == '@') {
                        a = i;
                        b = j;
                    }
                }
            }
            BFS(a, b, ch);
            System.out.println(count);
        }
    }

    public static void BFS(int x, int y, char[][] ch) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();// 拿出队头
            for (int i = 0; i < 4; i++) {
                Node next = new Node(cur.x + direction[i][0], cur.y + direction[i][1]);
                if (next.x >= 0 && next.x < ch.length && next.y >= 0 && next.y < ch[0].length
                        && ch[next.x][next.y] != '#' && !visited[next.x][next.y]) {
                    count++;
                    queue.add(next);
                    visited[next.x][next.y] = true;
                }
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static void mainlllllllllllllllllllll(String[] args) {
            Scanner sc = new Scanner(System.in);
            //while(sc.hasNext()){
               /* int n = sc.nextInt();
                int m = sc.nextInt();
                int k = sc.nextInt();
                int[][] array = new int[k][2];
                for(int i = 0;i < k;i++){
                    array[i][0] = sc.nextInt();
                    array[i][1] = sc.nextInt();
                }*/
            int[][] array = {{2, 1}};
            double x = helpMG(2, 2, array);
            DecimalFormat df = new DecimalFormat("#.00");
            String s = df.format(x);
            StringBuffer sb = new StringBuffer(s);

            if (sb.charAt(0) == '.') {
                sb.insert(0, 0);
            }
            System.out.println(sb.toString());
            // }
        }

        public static double helpMG(int n, int m, int[][] array) {
            double[][] gL = new double[n + 1][m + 1];
            for (int[] a : array) {
                int x = a[0];
                int y = a[1];
                gL[x][y] = -1;
            }
            gL[1][1] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (gL[i][j] != -1) {
                        if (gL[i - 1][j] != -1) {
                            gL[i][j] += j == m ? gL[i - 1][j] : gL[i - 1][j] / 2;
                        }
                        if (gL[i][j - 1] != -1) {
                            gL[i][j] += i == n ? gL[i][j - 1] : gL[i][j - 1] / 2;
                        }
                    }
                }
            }
            return gL[n][m];
        }
    }

    public static void main1233(String[] args) {
        Scanner sc = new Scanner(System.in);
        //while(sc.hasNext()){
        String s = "coco";
        char[] s1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        boolean flag = false;
        for (int i = 0; i <= s.length(); i++) {
            StringBuffer sb = new StringBuffer(s);
            for (int j = 0; j < s1.length; j++) {
                String s2 = sb.insert(i, s1[j]).toString();
                if (helpH(s2)) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        //}
    }

    public static boolean helpH(String s) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        if (s.equals(sb.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static void mainllkjuhu(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int n = 4;
        System.out.println(Arrays.toString(arrayPrint(a, n)));
    }

    public static int[] arrayPrint(int[][] arr, int n) {
        int[] x = new int[n * n];
        Stack<int[]> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(new int[]{i, 0});
        }
        for (int i = 1; i < n; i++) {
            stack.push(new int[]{0, i});
        }

        int index = 0;
        while (!stack.isEmpty()) {
            int[] x1 = stack.pop();
            int a = x1[0], b = x1[1];
            while (a < n && b < n) {
                x[index] = arr[a][b];
                a++;
                b++;
                index++;
            }
        }
        return x;
    }

    public static String jiami(String str) {     //加密
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z')     //若字符为小写字母
                arr[i] = (char) ((str.charAt(i) - 32 + 1 - 'A') % 26 + 'A');
            else if (arr[i] >= 'A' && arr[i] <= 'Z') {    //若字符为大写字母
                arr[i] = (char) ((arr[i] + 32 + 1 - 'a') % 26 + 'a');
            } else if (arr[i] >= '0' && arr[i] <= '9') {
                //若为数字
                arr[i] = (char) ((arr[i] + 1 - '0') % 10 + '0');
            }
        }
        String s = "";
        for (char x : arr) s += x;
        return s;
    }

    public static String jiemi(String str) {     //解密
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z')   //若字符为小写字母
                arr[i] = (char) ((str.charAt(i) - 32 - 1 - 'A' + 26) % 26 + 'A');
            else if (arr[i] >= 'A' && arr[i] <= 'Z') {  //若字符为大写字母
                arr[i] = (char) ((str.charAt(i) + 32 - 1 - 'a' + 26) % 26 + 'a');
            } else if (arr[i] >= '0' && arr[i] <= '9') { //若为数字
                arr[i] = (char) ((arr[i] - 1 - '0' + 10) % 10 + '0');
            }
        }
        String s = "";
        for (char x : arr) s += x;
        return s;
    }

    static int[] a = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
    static int[] b = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public static void mainlll(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();
            int sum = 0;
            if (runN(y)) {
                sum = a[m] + d;
            } else {
                sum = b[m] + d;
            }
            if (m < 1 || m > 12) {
                System.out.println(-1);
            } else if (d < 0 || d > 31) {
                System.out.println(-1);
            } else if (runN(y) && m == 2 && d != 29) {
                System.out.println(-1);
            } else if ((!runN(y)) && m == 2 && d != 28) {
                System.out.println(-1);
            } else {
                System.out.println(sum);
            }
        }
    }

    public static boolean runN(int y) {
        if (y % 4 == 0 && y % 100 != 0) {
            return true;
        } else if (y % 100 == 0 && y % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> ret = new ArrayList<>();

    public static void main99999999(String[] args) {
        dfs(1, 6, 6);
        for (List<Integer> res : list) {
            for (int i = 0; i < res.size() - 1; i++) {
                System.out.println(res.get(i) + " ");
            }
            System.out.println(res.get(res.size() - 1));
        }
    }

    public static void dfs(int index, int n, int m) {
        if (m == 0) {
            list.add(new ArrayList<>(ret));
        } else {
            for (int i = index; i <= m && i <= n; i++) {
                ret.add(i);
                dfs(i + 1, n, m - i);
                ret.remove(ret.size() - 1);
            }
        }
    }

    public static void mainllllllll(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String[] s = str.split("_");
            StringBuffer sb = new StringBuffer();
            sb.append(s[0]);
            for (int i = 1; i < s.length; i++) {
                String s1 = s[i].substring(0, 1);
                String s2 = s[i].substring(1);
                sb.append(s1.toUpperCase());
                sb.append(s2);
            }
            System.out.println(sb.toString());
        }
    }

    public static void mainlllllllllllllllllllllll(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = sc.next();
            }
            String word = sc.next();
            int m = sc.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int count = 0;
                if (!s[i].equals(word) && s[i].length() == word.length()) {
                    char[] x1 = word.toCharArray();
                    char[] x2 = s[i].toCharArray();
                    for (char c : x2) {
                        for (int k = 0; k < x1.length; k++) {
                            if (x1[k] == c) {
                                x1[k] = '@';
                                count++;
                                break;
                            }
                        }
                    }
                    if (count == x1.length) {
                        list.add(s[i]);
                    }
                }
            }
            System.out.println(list.size());
            if (m > 0 && m <= list.size()) {
                System.out.println(list.get(m - 1));
            }
        }
    }
    public static void mainlkjh(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();//LinkedHashMap而不是hashmap！！！！！
        while(sc.hasNext()){
            String path = sc.next();
            int id = path.lastIndexOf('\\');
            String name = id<0 ? path : path.substring(id+1);
            int m = sc.nextInt();
            String key = name+" "+m;
            map.put(key, map.getOrDefault(key,0)+1);
        }
        Set<String> set = map.keySet();
        int count = 0;
        for (String tmp : set) {
            count++;
            if (count > (set.size() - 8)) {   //输出的是后8条记录
                String[] s = tmp.split(" ");  //按空格分割key
                String s1 = s[0];  //取得净文件名
                int len = s1.length();
                if (len > 16) {  //如果净文件名长度大于16，只取后16位
                    s1 = s1.substring(len - 16);
                }
                int line = Integer.parseInt(s[1]);   //取得行号
                int number = map.get(tmp);  //取得此错误记录的条数
                System.out.println(s1 + " " + line + " " + number);
            }
        }
    }
    public static void main22(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for(int i = 1;i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        //创建最大值和最小值两个辅助数组，long数组存放数值，范围更大
        long[][] f = new long[n + 1][k + 1];
        long[][] g = new long[n + 1][k + 1];
        //初始化两个数组，即K=1的情况
        for(int i = 1; i <= n; i++) {
            f[i][1] = arr[i];
            g[i][1] = arr[i];
        }
        //从k = 2开始填充（遍历每一行）
        for(int i = 2; i <= k; i++) {
            for(int j = i; j <= n; j++) {  //遍历每一列
                long max = Long.MIN_VALUE;         //临时最大、最小值变量
                long min = Long.MAX_VALUE;
                //根据left的两个边界条件进行遍历
                for(int left = Math.max(i - 1, j - d); left <= j - 1; left++){
                    //根据所得的递推公式更新最小值 最大值
                    if(max < Math.max(f[left][i - 1] * arr[j], g[left][i - 1] * arr[j])) {
                        max = Math.max(f[left][i - 1] * arr[j], g[left][i - 1] * arr[j]);
                    }

                    if(min > Math.min(f[left][i - 1] * arr[j], g[left][i - 1] * arr[j])) {
                        min = Math.min(f[left][i - 1] * arr[j], g[left][i - 1] * arr[j]);
                    }
                }
                //更新最大值
                f[j][i] = max;
                //更新最小值
                g[j][i] = min;
            }
        }
        //确定了K值，要得到最大值，则遍历第K列，
        long max = Long.MIN_VALUE;
        for(int i = k; i <= n; i++) {
            if(f[i][k] > max)
                max = f[i][k];
        }
        System.out.println(max);
    }
    //数组中元素左边比自己小的第一个元素和右边比自己小的第一个元素
    public static void mainlllllllllllllllllllllllllllllllllllll(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] x = new int[n];
            for(int i = 0;i < n;i++){
                x[i] = sc.nextInt();
            }
            int[][] array = new int[n][2];
            Stack<Integer> s  = new Stack<>();
            for(int i = 0;i < n;i++){
                while (!s.isEmpty() && x[i] < x[s.peek()]){
                    int a = s.pop();
                    int b = s.isEmpty() ? -1 : s.peek();
                    array[a][0] = b;
                    array[a][1] = i;
                }
                s.push(i);
            }
            while (!s.isEmpty()){
                int a = s.pop();
                int b = s.isEmpty() ? -1 : s.peek();
                array[a][0] = b;
                array[a][1] = -1;
            }
            for(int i = 0;i < array.length;i++){
                System.out.println(array[i][0] + " " + array[i][1]);
            }
        }
    }

    public static int findMaxGap(int[] A, int n) {
        int m = n-1;
        int max = 0;
        for(int i = 1;i <= m;i++){
            int x =help(A,i,n) ;
            max = Math.max(max,x);
        }
        return max;
    }
    public static int help(int[] A,int i,int n){
        int max1 = 0;
        int max2 = 0;
        for(int j = 0;j < i;j++){
            max1 = Math.max(max1,A[j]);
        }
        for(int j = i;j < n;j++){
            max2 = Math.max(max2,A[j]);
        }
        int ret = Math.abs(max1-max2);
        return ret;
    }
    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        int[] x = new int[n * m];
        int index = 0;
        int left = 0,right = n-1;
        int top = 0,down = m - 1;
        while(left < right && top < down){
            for(int i = left;i < right;i++){
                x[index] = mat[top][i];
                index++;
            }
            for(int i = top;i < down;i++){
                x[index] = mat[i][right];
                index++;
            }
            for(int i = right;i > left;i--){
                x[index] = mat[down][i];
                index++;
            }
            for(int i = down;i > top;i--){
                x[index] = mat[i][left];
                index++;
            }
            left++;
            right--;
            top++;
            down--;
        }
        if(left == right){
            for(int i = top;i <= down;i++){
                x[index] = mat[i][right];
                index++;
            }
        }else{
            if(top == down){
                for(int i = left;i <= right;i++){
                    x[index] = mat[top][i];
                    index++;
                }
            }
        }
        return x;
    }
    public static void main (String[] args){
        String s = "98";
        String s1 = "9";
        System.out.println(addStrings(s,s1));
    }
    public static String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int n1 = num1.length();
        int n2 = num2.length();
        int m = Math.abs(n1-n2);
        if(n1 < n2){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
            int tmp1 = n1;
            n1 = n2;
            n2 = tmp1;
        }
        int ret = 0;
        for(int i = n2-1;i >= 0;i--){
            int a1 = num1.charAt(i+m) - '0';
            int a2 = num2.charAt(i) - '0';
            int sum = a1 + a2 + ret;
            ret = sum / 10;
            sum = sum % 10;
            sb.insert(0,sum);
        }
        for(int i = m -1;i >= 0;i--){
            int a1 = num1.charAt(i) - '0';
            int sum = ret + a1;
            ret = sum / 10;
            sum = sum % 10;
            sb.insert(0,sum);
        }
        if(ret != 0){
            sb.insert(0,ret);
        }
        return sb.toString();
    }



















}
