package PriorityQueue优先级队列;

import java.util.*;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-16
 * Time : 10:44
 */
public class TestPriority {
        public static void topK(int[] array, int k) {
            //取前5个最小的元素
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {

                    return o2-o1;
                }
            });
            for (int i = 0; i < array.length; i++) {
                if(maxHeap.size() < k ){
                    maxHeap.offer(array[i]);
                }else {
                    if(maxHeap.size() == k){
                        if(maxHeap.peek() > array[i]){
                            maxHeap.poll();
                            maxHeap.offer(array[i]);
                        }
                    }
                }
            }
        }
        public static void main1(String[] args) {
            int[] array = {12,45,2,7,10,8,19,56,32};
            topK(array,5);
            String version1 = "7.01";
            String version2 = "7.001.003";
            System.out.println(compareVersion(version1,version2));
        }
        public  static  int compareVersion(String version1, String version2) {
            String[] nums1 = version1.split("\\.");
            String[] nums2 = version2.split("\\.");
            int n1 = nums1.length, n2 = nums2.length;

            // compare versions
            int i1, i2;
            for (int i = 0; i < Math.max(n1, n2); ++i) {
                i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
                i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
                if (i1 != i2) {
                    return i1 > i2 ? 1 : -1;
                }
            }
            return 0;
        }
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> list = new ArrayList<>();
            k = Math.min(k,nums1.length*nums2.length);//因为k可能会的数字可能会超过所有的组合个数；
            if(k == 0) return list;
            PriorityQueue< int[] > q = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {

                    return (o2[0]+o2[1]) - (o1[0]+o1[1]);
                }
            });
            for(int e1:nums1){
                for(int e2: nums2){
                    if(q.size()< k){
                        q.offer(new int[]{e1,e2});
                    }else{
                        if(e1+e2 <= q.peek()[0]+q.peek()[1]){
                            q.poll();
                            q.offer(new int[]{e1,e2});
                        }
                    }
                }
            }
            while(k >0 ){
                int[] arr = q.poll();
                list.add(0, Arrays.asList(arr[0],arr[1]));
                k--;
            }
            return list;
        }
        PriorityQueue< int[] > q = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0]+o2[1]) - (o1[0]+o1[1]);
            }
        });
}
