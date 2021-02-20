package Test作业测试;


import java.text.DecimalFormat;
import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-04
 * Time : 23:20
 */
//链表＋1；
/*
public class TestNode {
    static class Node{
        int val;
        Node next;
       public Node(int val){
            this.val = val;
        }
    }
    public  Node head;
    public Node add(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        return head;
    }
    public Node addLast(int val,Node head){
        if(head == null){
            add(val);
        }else {
            Node cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(val);
        }
        return head;
    }
    public void display(Node head){
        Node cur = head;
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public Node reserve(Node head) {
        Node cur = head;
        Node prev= null;
        Node newHead = null;
        while (cur != null){
            Node curNext = cur.next;
            if(curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    public void addOne(Node head) {
        Node newHead = reserve(head);
        Node cur = newHead;
        while (cur != null){
            if(cur.val + 1 == 10){
                cur.val = 0;
            }else {
                cur.val = cur.val+1;
                break;
            }
            cur = cur.next;
        }
        if(cur == null){
            addLast(1,newHead);
        }
        Node prev = reserve(newHead);
        display(prev);
    }
    public static void main(String[] args) {
        TestNode ts = new TestNode();
        ts.add(8);
        ts.add(8);
        ts.add(8);
        ts.add(8);
        ts.display(ts.head);
        System.out.println("-----------");
        ts.addOne(ts.head);
    }
}
*/
 class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
/*class Person{
    String name;
    int score;
    public Person(String name,int score){
        this.score = score;
        this.name = name ;
    }
}*/

public class TestNode {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    public static void main0(String[] args) {
        int[] array = {12, 4, 52, 3, 43, 5, 23};
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }
        int[] a = {1, 2, 2, 4, 18, 8};
        System.out.println(largestPerimeter(a));
          /*for (Integer integer : set) {
              System.out.println(integer);
          }*/
        //String s = "Test1ng-Leet=code-Q!";
        //System.out.println(reverseOnlyLetters(s));
    }

    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }

        }
        return 0;
    }

    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        for (char x : S.toCharArray()) {
            if (Character.isLetter(x)) {
                stack.push(x);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (char s : S.toCharArray()) {
            if (Character.isLetter(s)) {
                sb.append(stack.pop());
            } else {
                sb.append(s);
            }
        }

        return sb.toString();

    }

    public String removeDuplicateLetters(String s) {
        Deque<Character> deque = new LinkedList<>();
        boolean[] blag = new boolean[26];
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (!blag[x - 'a']) {
                while (!deque.isEmpty() && deque.getLast() > x && count[deque.getLast() - 'a'] > 0) {
                    blag[deque.getLast() - 'a'] = false;
                    deque.removeLast();
                }
                deque.add(x);
                blag[x - 'a'] = true;
            }
            count[x - 'a']--;
        }
        StringBuffer sb = new StringBuffer();
        for (char x : deque) {
            sb.append(x);
        }
        return sb.toString();

    }

    public String toGoatLatin(String S) {
        StringBuffer sb = new StringBuffer();
        String x = "ma";
        String[] s = S.split(" ");
        int i = 0;
        for (String str : s) {
            StringBuffer sb1 = new StringBuffer(str);
            if (sb1.charAt(0) == 'a' || sb1.charAt(0) == 'e' ||
                    sb1.charAt(0) == 'i' || sb1.charAt(0) == 'o' || sb1.charAt(0) == 'u' || sb1.charAt(0) == 'A' || sb1.charAt(0) == 'E' ||
                    sb1.charAt(0) == 'I' || sb1.charAt(0) == 'O' || sb1.charAt(0) == 'U') {
                sb1.append(x);
            } else {
                sb1.append(sb1.charAt(0));
                sb1.deleteCharAt(0);
            }
            i++;
            int z = i;
            while (z > 0) {
                sb1.append('a');
                z--;
            }
            sb.append(sb1);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public int minCostClimbingStairs(int[] cost) {
        int x = cost.length;
        int a = 0;
        int b = 0;
        for (int i = 2; i <= x; i++) {
            int c = Math.min(a + cost[i - 1], b + cost[i - 2]);
            b = a;
            a = c;
        }
        return a;
    }


    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] < popped[index]) {
                stack.push(pushed[i]);
            }
            if (pushed[i] == popped[index]) {
                index++;
                i--;
                int x = i;
                while (!stack.isEmpty()) {
                    if (pushed[i] == popped[index]) {
                        x--;
                        index++;
                    } else {
                        break;
                    }
                }
            }
        }
        if (index != popped.length || !stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main2(String[] args) {
        int[][] array = {{2, 1, 5}, {3, 3, 7}};
        System.out.println(carPooling(array, 4));
    }

    public static int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int tmp = start;
                    start = nums[start];
                    count++;
                    nums[tmp] = Integer.MAX_VALUE;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public String thousandSeparator(int n) {
        if (n <= 999) return String.valueOf(n);
        StringBuffer sb = new StringBuffer();
        int count = 0;
        while (n > 0) {

            sb.append(n % 10);
            count++;
            if (count % 3 == 0) {
                sb.append(".");
            }
            n = n / 10;
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] capacityChanges = new int[10];
        for (int i = 0; i < trips.length; i++) {
            capacityChanges[trips[i][1]] -= trips[i][0];
            capacityChanges[trips[i][2]] += trips[i][0];
        }

        for (int i = 0; i < capacityChanges.length; i++) {
            capacity += capacityChanges[i];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public int[] arrayRankTransform(int[] arr) {
        int[] array = Arrays.copyOf(arr, arr.length);
        Arrays.sort(array);
        Map<Integer, Integer> map = new HashMap<>();
        int k = 1;
        for (int i : array) {
            if (!map.containsKey(i)) {
                map.put(i, k);
                k++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    /*int n = ratings.length;
    int[] left =  new int[n];
    int[] right = new int[n];
       Arrays.fill(left,1);
       Arrays.fill(right,1);
       for(int i = 1;i < n;i++){
        if(ratings[i] > ratings[i-1]){
            left[i] = left[i-1]+1;
        }
    }
    int count = ratings[left.length-1] ;//第一轮最后一个人的糖果；
       for(int i = n-2;i >= 0;i--){
        if(ratings[i] > ratings[i+1]){
            right[i] = right[i+1]+1;
            count = count +Math.max(left[i],right[i]);
        }
    }
       return count;*/
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, (a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b));
        return Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
    }


    public static int countSegments(String s) {
        for (char x : s.toCharArray()) {
            if (!Character.isLetter(x)) {
                s = s.replace(x + "", ",");
            }
        }

        String[] strings = s.split(",");
        int count = 0;
        for (String c : strings) {
            if (!c.equals("")) {
                count++;
            }
        }
        return count;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int count = 1;
        int max = 0;
        for (String word : words) {
            char[] s = word.toCharArray();
            Arrays.sort(s);
            for (int i = 1; i < s.length; i++) {
                if (s[i] == s[i - 1]) {
                    count++;
                } else {
                    break;
                }
            }
            max = Math.max(max, count);
            count = 1;
        }
        List<Integer> list = new ArrayList<>();
        for (String word : queries) {
            char[] s = word.toCharArray();
            Arrays.sort(s);
            for (int i = 1; i < s.length; i++) {
                if (s[i] == s[i - 1]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count < max) {
                list.add(count);
            }
            count = 1;
        }
        int[] array = new int[list.size()];
        int index = 0;
        for (int z : list) {
            array[index] = z;
            index++;
        }
        return array;
    }

    public static void main11(String[] args) {
        String s = "aabaa";
        //String[] strings = {"ten","two","better","talk","suddenly","stand","protect","collection","about","southern"};
        int[] nums = {1, 2, 3, 4, 1};
        System.out.println(minCost(s, nums));
        // System.out.println(Arrays.toString(nextGreaterElements(nums)));
        // System.out.println(3^1);
        // System.out.println(shortestCompletingWord(s,strings));
    }

    public static int minCost(String s, int[] cost) {
        int count = 0;
        int left = 0;
        int n = cost.length;
        while (left < n) {
            char x = s.charAt(left);
            int max = 0;
            int sum = 0;
            while (left < n && s.charAt(left) == x) {
                max = Math.max(max, cost[left]);
                sum = sum + cost[left];
                left++;
            }
            count = count + (sum - max);
        }
        return count;
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] array = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = (i + 1) % nums.length;
            int count = nums.length - 1;
            while (count >= 0) {
                if (nums[i] < nums[j]) {
                    break;
                } else {
                    j = (j + 1) % nums.length;
                    count--;
                }
            }
            if (count < 0) {
                array[index] = -1;
            } else {
                array[index] = nums[j];
            }
            index++;
        }
        return array;
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        String s = licensePlate.toLowerCase();
        char[] x = s.toCharArray();
        for (char c : x) {
            if (Character.isLetter(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        int count = -1; //可能是0号元素，所以这里为-1；
        int z = 0;
        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> map2 = new HashMap<>();
            char[] c = words[i].toLowerCase().toCharArray();
            for (char ch : c) {
                map2.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            boolean flag = true;
            for (char ch : x) {
                if (!Character.isLetter(ch)) continue;
                if (map.get(ch) > map2.getOrDefault(ch, 0)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (count == -1) { //第一个符合条件的单词

                    count = i;
                    z = words[i].length();
                } else {
                    if (words[i].length() < z) {
                        count = i;
                        z = words[i].length();
                    }
                }
            }
        }
        return words[count];
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        ;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int[] x = new int[n];
        Arrays.fill(x, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    x[i] = Math.max(x[i], x[j] + 1);
                }
            }
        }
        return n - Arrays.stream(x).max().getAsInt();
    }

    public static void main3(String[] args) {
        int start = 7;
        int[] distance = {7, 10, 1, 12, 11, 14, 5, 0};
        int des = 2;
        //System.out.println(tribonacci(des));
        String text = "aacaba";
        System.out.println(numSplits(text));
        // System.out.println(Arrays.toString(dicesProbability(des)));
    }

    public boolean halvesAreAlike(String s) {
        int x = s.length() / 2;
        String s1 = s.substring(0, x);
        String s2 = s.substring(x, s.length());
        int count1 = 0, count2 = 0;
        for (char c : s1.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count1++;
            }
        }
        for (char c : s2.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count2++;
            }
        }
        return count1 == count2;
    }

    public static int numSplits(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, s.length());
            char[] x1 = s1.toCharArray();
            char[] x2 = s2.toCharArray();
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for (char c : x1) {
                set1.add(c);
            }
            for (char c : x2) {
                set2.add(c);
            }
            if (set1.size() == set2.size()) {
                count++;
            }
        }
        return count;
    }

    public static String arrangeWords(String text) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        String[] s = text.split(" ");
        for (int i = 0; i < s.length; i++) {
            q.offer(new int[]{s[i].length(), i});
        }
        StringBuffer sb = new StringBuffer();
        while (!q.isEmpty()) {
            sb.append(s[q.poll()[1]].toLowerCase());
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        char x = sb.charAt(0);
        sb.delete(0, 1);
        String c = (x + "").toUpperCase();
        sb.insert(0, c);
        return sb.toString();
    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) { //一天只有1440分钟；
            return 0;
        }
        int[] array = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            array[i] = Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3, 5));
        }
        Arrays.sort(array);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i] - array[i - 1]);
            if (min == 0) return 0;
        }
        min = Math.min(min, 1440 - array[array.length - 1] + array[0]);
        return min;
    }

    public static double[] dicesProbability(int n) {
        double[] tmp = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d}; //
        for (int i = 2; i <= n; i++) {
            double[] pre = new double[5 * i + 1];
            for (int j = 0; j < tmp.length; j++) {
                for (int x = 0; x < 6; x++) {
                    pre[j + x] = pre[j + x] + tmp[j] * (1 / 6d);
                }
            }
            tmp = pre;
        }
        return tmp;
    }

    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int a = 0;
        int b = 1;
        int c = 1;
        while (n > 2) {
            int sum = a + b + c;
            a = b;
            b = c;
            c = sum;
            n--;
        }
        return c;
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) return 0;
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        int sumZ = 0;
        int sumF = 0;
        for (int i = destination; i > start; i--) {
            sumZ = sumZ + distance[i - 1];
        }
        for (int i = destination; i < distance.length; i++) {
            sumF = sumF + distance[i];
        }
        for (int i = 0; i < start; i++) {
            sumF = sumF + distance[i];
        }
        return Math.min(sumZ, sumF);
    }

     /*public static void main4(String[] args){
         Scanner sc = new Scanner(System.in);
         while(sc.hasNextLine()) {
             int n = sc.nextInt();
             int z = sc.nextInt();
             List<Person> list = new ArrayList<>();
             for(int i =0 ;i < n ;i++){
                 SetAndMap.Person person = new SetAndMap.Person(sc.nextLine(),sc.nextInt());
                 list.add(person);
             }
             if(z == 0){
                 Collections.sort(list,(o1,o2) ->o2.score - o1.score);
             }else{
                 Collections.sort(list,(o1,o2)-> o1.score - o2.score);
             }
             for(SetAndMap.Person p : list){
                 System.out.println(p.name + " " + p.score);
             }
         }
     }*/

    public static void main5(String[] args) {
        int[] array = {1, 2, 2, 3, 2};
        int n = 5;
        System.out.println(getValue(array, n));
    }

    public static int getValue(int[] gifts, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : gifts) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) > (n / 2)) {
                return x;
            }
        }
        return 0;
    }

    public static void main10(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            StringBuffer sb = new StringBuffer();
            int[] array = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                char x = s.charAt(i);
                if (!Character.isLetter(x)) {
                    array[i] = -1;
                } else {
                    array[i] = x;
                }
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] == -1) {
                    sb.append(" ");
                } else {
                    int x = array[i] + 21;
                    if (x > 90) {
                        x = x - 26;
                    }
                    char z = (char) x;
                    sb.append(z);
                }
            }
            System.out.println(sb.toString());
        }
    }


    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        if (s == null) return list;
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (count >= 3) {
                    list.add(Arrays.asList(i - count + 1, i));
                }
            } else {
                count++;
            }
        }
        return list;
    }

    public static int[] smallestK(int[] arr, int k) {
        if (arr.length == 0) return arr;
        int[] array = new int[k];
        if (k == 0) return array;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int x : arr) {
            if (q.size() < k) {
                q.offer(x);
            } else {
                if (x < q.peek()) {
                    q.poll();
                    q.offer(x);
                }
            }
        }
        int index = 0;
        while (!q.isEmpty()) {
            array[index] = q.poll();
            index++;
        }
        return array;
    }

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        //return fib(n-1)+fib(n-2);
        int a = 0;
        int b = 1;
        int c = 0;
        while (n >= 2) {
            c = b + a;
            b = c;
            a = b;
            n--;
        }
        return c;
    }

    public static int maxScore(String s) {
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, s.length());
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == '0') {
                    count1++;
                }
            }
            for (int j = 0; j < s2.length(); j++) {
                if (s2.charAt(j) == '1') {
                    count2++;
                }
            }
            max = Math.max(max, count1 + count2);
        }
        return max;
    }

    public static int removeStones(int[][] stones) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            int[] array = stones[i];
            for (int j = i + 1; j < stones.length; j++) {
                int[] array1 = stones[j];
                if (array[0] == array1[0] || array[1] == array1[1]) {
                    count++;
                    stones[i] = new int[]{-1, -1};
                    break;
                }
            }
        }
        return count;
    }

    public ListNode plusAB(ListNode a, ListNode b) {
        if (a == null && b == null) return null;
        if (a == null) return b;
        if (b == null) return a;
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        ListNode headA = a;
        ListNode headB = b;
        int tmp = 0;
        while (headA != null && headB != null) {
            int sum = headA.val + headB.val + tmp;
            sum = sum - 10;
            cur.next = new ListNode(sum);
            headA = headA.next;
            headB = headB.next;
            cur = cur.next;
        }
        if (headA != null) {
            while (headA != null) {
                int sum = headA.val + tmp;
                tmp = sum >= 10 ? 1 : 0;
                sum = sum - 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                headA = headA.next;
            }
        }
        if (headB != null) {
            while (headB != null) {
                int sum = headB.val + tmp;
                tmp = sum >= 10 ? 1 : 0;
                sum = sum - 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                headB = headB.next;
            }
        }
        if (tmp == 1) {
            cur.next = new ListNode(1);
            cur = cur.next;
        }
        cur.next = null;
        return newHead.next;
    }

    public static void main6(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.next();
            String s2 = sc.next();
            int count = 0;
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for (char x : s1.toCharArray()) {
                map1.put(x, map1.getOrDefault(x, 0) + 1);
            }
            for (char x : s2.toCharArray()) {
                map2.put(x, map2.getOrDefault(x, 0) + 1);
            }
            for (char x : map2.keySet()) {
                int c1 = map1.getOrDefault(x, 0);
                int c2 = map2.getOrDefault(x, 0);
                if (c1 < c2) count = count + (c2 - c1);
            }
            if (count == 0) {
                System.out.println("YES" + " " + (s1.length() - s2.length()));
            } else {
                System.out.println("NO" + " " + count);
            }
        }
    }

    //下一个main8；
    public int minDifference(int[] nums) {
        if (nums.length <= 3) return 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(nums[i], min);
        }
        int max = nums[0];
        int m = 0;
        //第一次修改；
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                m = i;
            }
        }
        nums[m] = min;
        //第二次；
        max = nums[0];
        m = 0;
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                m = i;
            }
        }
        nums[m] = min;
        //第三次；
        max = nums[0];
        m = 0;
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                m = i;
            }
        }
        nums[m] = min;
        //找到最大值；
        max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);

        }
        return max - min;
    }

    public static void main8(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            int[] x = new int[n];
            int A1 = 0, A2 = 0, A3 = 0, A5 = 0;
            double A4 = 0.0;
            int count = 0;
            int tmp = 1;
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
                if (x[i] % 5 == 0) {
                    if (x[i] % 2 == 0) {
                        A1 = A1 + x[i];
                    }
                }
                if (x[i] % 5 == 1) {
                    A2 = A2 + x[i] * tmp;
                    tmp = tmp * -1;
                }
                if (x[i] % 5 == 2) {
                    A3++;
                }
                if (x[i] % 5 == 3) {
                    A4 = A4 + x[i];
                    count++;
                }
                if (x[i] % 5 == 4) {
                    if (x[i] > A5) {
                        A5 = x[i];
                    }
                }

            }
            if (A1 != 0) {
                System.out.println(A1 + " ");
            } else {
                System.out.println("N" + " ");
            }
            if (A2 != 0) {
                System.out.println(A2 + " ");
            } else {
                System.out.println("N" + " ");
            }
            if (A3 != 0) {
                System.out.println(A3 + " ");
            } else {
                System.out.println("N" + " ");
            }
            if (A4 != 0) {
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                String str = decimalFormat.format(A4 / count * 1.0);
                System.out.println(str + " ");
            } else {
                System.out.println("N" + " ");
            }
            if (A5 != 0) {
                System.out.println(A5);
            } else {
                System.out.println("N");
            }
        }
    }
   /* 5 7
    1 2 3 4 5
    Q 1 5
    U 3 6
    Q 3 4
    Q 4 5
    U 4 5
    U 2 9
    Q 1 5*/

    public static void main9(String[] args) {
        Scanner sc = new Scanner(System.in);
        // while(sc.hasNext()){
        int n = 5;
        int m = 7;
        int[] x = {1, 2, 3, 4, 5};
           /* for(int i = 0 ;i < n;i++){
                x[i]= sc.nextInt();
            }*/
        String[] s = {"Q", "U", "Q", "Q", "U", "U", "Q"};
        int[] a = {1, 3, 3, 4, 4, 2, 1};
        int[] b = {5, 6, 4, 5, 5, 9, 5};
            /*for(int i = 0 ;i < m;i++){
                s[i]= sc.next();
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }*/
        String q = "Q", u = "U";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (s[i].equals(q)) {
                list.add(maxNumber(x, a[i], b[i]));
            } else {
                x[a[i] - 1] = b[i];
            }
        }
        for (int num : list) {
            System.out.println(num);
        }
        //}

    }

    public static int maxNumber(int[] array, int a, int b) {
        int max = array[a - 1];
        for (int i = a; i <= b - 1; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }



    public static void main7(String[] args) {
        Scanner sc = new Scanner(System.in);
        //while (sc.hasNext()) {
            int x = 5;
            int[] m = {4 ,3 ,4 ,2, 3};
            int[] z = {91 ,88, 72 ,69 ,56};
            double sum = 0.0;
            double sum1 = 0.0;
            for (int i = 0; i < x; i++) {
                //m[i] = sc.nextInt();
                sum = sum + m[i];
            }
            for (int i = 0; i < x; i++) {
               // z[i] = sc.nextInt();
                double n = (help1(z[i]) * (m[i]*1.0));
                sum1 = sum1 + n;
            }

//            DecimalFormat decimalFormat = new DecimalFormat("#.00");
//            String str = decimalFormat.format(d);
            System.out.printf("%.2f",(sum1 / sum));
        }
    //}

    public static double help1(int x) {
        double p = 0.0;
        if (x >= 90 && x <= 100) p =  4.0;
        if (x >= 85 && x <= 89) p =  3.7;
        if (x >= 82 && x <= 84) p =  3.3;
        if (x >= 78 && x <= 81) p = 3.0;
        if (x >= 75 && x <= 77) p = 2.7;
        if (x >= 72 && x <= 74) p =  2.3;
        if (x >= 68 && x <= 71) p =  2.0;
        if (x >= 64 && x <= 67) p = 1.5;
        if (x >= 60 && x <= 63) p =  1.0;
        if(x < 60) p = 0.0;
        return p;
    }
    private final static char[] NUM = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖', '拾',
            '佰', '仟', '万', '亿'};

    public static void mainc(String[] args) {
        Scanner sc= new Scanner(System.in);

        while (sc.hasNext()) {
            double d = sc.nextDouble();
            System.out.println(convert(d));
        }
    }

    private static String convert(double d) {
        long n = (long) d;

        StringBuilder builder = new StringBuilder("人民币");

        // 处理整数部分，前提是整数部分大于0
        if (n > 0) {
            convert(n, builder);
            builder.append('元');
        }
        // 加上0.0001是为了防止d*100发生失真
        int v = (int) (d * 100 - n * 100 + 0.0001);
//        System.out.println((d) + " " + (d * 100) + "-" + (n * 100) + "=" + v);

        int i = v / 10;
        int j = v % 10;

        if (i == 0 && j == 0) {
            builder.append('整');

            return builder.toString();
        }

        if (i != 0) {
            builder.append(NUM[i]).append('角');
        }

        if (j != 0) {
            builder.append(NUM[j]).append('分');
        }


        return builder.toString();
    }
    private static void convert(long n, StringBuilder builder) {
        // 大于一亿
        if (n >= 1_0000_0000) {
            long q = n / 1_0000_0000;
            long r = n % 1_0000_0000;
            convert(q, builder);
            builder.append('亿');
            // 是亿的整数倍
            if (r != 0) {
                convert(r, builder);
            }
        }
        // 大于一万
        else if (n >= 1_0000) {
            long q = n / 1_0000;
            long r = n % 1_0000;

            convert(q, builder);
            builder.append('万');

            // 是亿的整数倍
            if (r != 0) {
                if (r < 100) {
                    builder.append('零');
                }
                convert(r, builder);
            }
        }
        // 大于一千
        else if (n >= 1000) {
            long q = n / 1000;
            long r = n % 1000;

            convert(q, builder);
            builder.append('仟');

            // 是亿的整数倍
            if (r != 0) {

                if (r < 100) {
                    builder.append('零');
                }

                convert(r, builder);
            }
        }
        // 大于一百
        else if (n >= 100) {
            long q = n / 100;
            long r = n % 100;

            convert(q, builder);
            builder.append('佰');

            // 是亿的整数倍
            if (r != 0) {

                if (r < 10) {
                    builder.append('零');
                }

                convert(r, builder);
            }
        }
        // 大于十
        else if (n >= 10) {
            long q = n / 10;
            long r = n % 10;

            if (q > 1) {
                convert(q, builder);
            }
            builder.append('拾');

            // 是亿的整数倍
            if (r != 0) {
                convert(r, builder);
            }
        } else {
            builder.append(NUM[(int) n]);
        }
    }

}




