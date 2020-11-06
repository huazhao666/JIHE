/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-04
 * Time : 11:44
 */
import java.util.*;
public class TestDemo5 {
    public static void main (String[] args){
       Lala lala = new Lala();
        int[] array = {2,1,5};
       int[] ret = lala.nextLargerNodes(array);
       //System.out.println(Arrays.toString(ret));
        Solution1 solution = new Solution1();
        int[] nums1  = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};
        int[] ret2 = solution.nextGreaterElement2(nums1,nums2);
        System.out.println(Arrays.toString(ret2));
    }
}
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();//入
        minStack = new Stack<>();//出
    }

    public void push(int x) {
        //1、stack是一定需要放元素的
        //2、最小栈当中 是否存放数据   x<= 最小栈的栈顶元素
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else if(x <= minStack.peek()){
                minStack.push(x);
        }
    }

    public void pop() {
        //1、stack是一定需要弹出元素的
        //2、最小栈当中 是否弹出数据    x  ==  最小栈的栈顶元素
        int x = stack.pop();
        if(x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        //跟最小栈没有关系
        return stack.peek();

    }

    public int getMin() {
        //每次返回最小栈的栈顶元素
        return minStack.peek();
    }
}
class Lala {
    public    int[] nextLargerNodes(int[] array) {
        int[] arr = new int[3];
        Stack<Integer> stack = new Stack();
        for(int i = 0; i<array.length;i++){
            while(!stack.isEmpty() && array[i] > array[stack.peek()]){
                int index = stack.pop();
                arr[index] = array[i];
            }
            stack.push(i);

        }
        return arr;
    }
}
//
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length];
        for(int i = 0 ;i < nums1.length;i++){
            for(int j = 0;j < nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    int x = nums2[j];
                    int n = j+1;
                    for(;n <= nums2.length -1;n++){
                        if(x < nums2[n]){
                            array[i] = nums2[n];
                            break;
                        }
                    }
                    if(n > nums2.length - 1){
                        array[i] = -1;
                    }
                    break;
                }
            }
        }
        return array;
    }
}

//
class Solution1 {
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length];
        for(int i = 0 ;i < nums1.length;i++){
            Stack<Integer> stack = new Stack();
            for(int j = nums2.length-1;j >= 0;j--){
                stack.push(nums2[j]);
            }
            while (!stack.isEmpty()) {
                if (nums1[i] == stack.pop()) {
                    while (!stack.isEmpty()) {
                        if (nums1[i] < stack.peek()) {
                            array[i] = stack.peek();
                            break;
                        }
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        array[i] = -1;
                    }
                }
            }
        }
        return array;
    }
}

