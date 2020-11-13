package Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-12
 * Time : 17:37
 */
public class TestSort {
    public static void main (String[] args){
        int[] array = {3,75,43,42,5,34,36,66,54,1};
       mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
    //直接插入 N^2, 空间1；
    public static void inSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (;j >=0;j--) {
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    //希尔 时间复杂度 n^1.5 - n^1.3 ,空间1；
    public static void  shellSort(int[] array){
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }
    public static void shell(int[] array ,int gap){
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (;j>= 0 ; j-= gap) {
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    //选择排序 时间为n^2,空间为1；
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]){
                    int tmp = array[i];
                    array[i] =array[j];
                    array[j] = tmp;
                }
            }
        }
    }
    //堆排序;时间 n*log n；空间1；
    public static void heapSort(int[] array){
        createHeap(array);
        int count = array.length -1;
        while (count > 0){
            int tmp= array[0];
            array[0] = array[count];
            array[count]= tmp;
            adjust(array,0,count);
            count--;
        }
    }
    public static void createHeap(int[] array){
        adjust(array,0,array.length);
    }
    public static void adjust(int[] array,int parent,int len){
        int child = parent * 2 + 1;
        while (child < len){
            if(child+1 < len && array[child] < array[child+1]){
                child++;
            }
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = parent * 2+ 1;
            }else {
                break;
            }
        }
    }
    //冒泡排序 时间 n^2,空间 1；
    public static void subbleSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length-i; j++) {
                if(array[j+1] < array[j]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
    //快排 时间复杂度 n*log n 最坏的情况是 n^2；空间 log n；
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }
    public static void quick(int[] array,int low,int high){
        if(low >= high) return;
        if(high -low + 1 <= 100){
           inSort2(array,low,high);
           return;
        }
        int par = partion(array,low,high);
        quick(array,low,par-1);
        quick(array,par+1,high);
    }
    public static int partion(int[] array,int start,int end){
        int tmp = array[start];
        while (start < end){
            while (start < end && array[end] >= tmp) {
                end--;
            }
            if(start >= end){
                break;
            }else {
                array[start] = array[end];
            }
            while (start< end && array[start] <= tmp){
                start++;
            }
            if(start >= end){
                break;
            }else {
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return  start;
    }
    public static void inSort2(int[] array,int low,int high){
        for (int i = 1; i <= high; i++) {
            int tmp = array[i];
            int j = i-1;
            for (;j >=low;j--) {
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void medianOfThree(int[] array,int low,int high) {
        int mid = (low+high)/2;
       if(array[mid] >= array[low]){
           swap(array,mid,low);
       }
       if(array[low] >= array[high]){
           swap(array,low,high);
       }
       if(array[mid] >= array[high]){
           swap(array,mid,high);
       }

    }
    public static void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    //快排非递归；
    public static void quickSort1(int[] array){

        quickNor(array,0,array.length-1);
    }
    public static void quickNor(int[] array,int low ,int high){

        Stack<Integer> stack = new Stack<>();
        int par = partion(array,low,high) ;
            if (par > low + 1) {
            stack.push(low);
            stack.push(par - 1);
        }
        if(par < high-1){
            stack.push(par+1);
            stack.push(high);
        }
        while (!stack.empty()){
            int end = stack.pop();
            int start = stack.pop();
            par =partion(array,start,end);
            if(par > start+1){
                stack.push(start);
                stack.push(par -1);
            }
            if(par < end-1){
                stack.push(par +1);
                stack.push(end);
            }
        }
    }

    //归并排序; 稳定；时间复杂度 n*log n；空间复杂度 n;
    public static void mergeSort(int[] array){
        mergeSortHelp(array,0,array.length-1);
    }

    public static void mergeSortHelp(int[] array,int low,int high){
        if(low >= high) return;
        int mid = (low + high) / 2;
        mergeSortHelp(array,low,mid);
        mergeSortHelp(array,mid+1,high);
        merge(array,low, high,mid);//重新合并起来；
    }
    public static void merge(int[] array,int low,int high,int mid){
        int s1 = low;
        int s2 = mid+1;
        int[] tmp = new int[high - low +1 ];
        int k = 0 ;//数组tmp的下表;
        while (s1 <= mid && s2 <= high) { //这里是个区段的上限边界
            if(array[s1] <= array[s2]){
                tmp[k] = array[s1];
                k++;
                s1++;
            }else {
                tmp[k] = array[s2];
                k++;
                s2++;
            }
        }
        while (s1 <= mid){ //这里是担心s2结束了，s1还有数据
            tmp[k] = array[s1];
            k++;
            s1++;
        }
        while (s2 <= high){ // 同上，s2还有数据
            tmp[k] = array[s2];
            k++;
            s2++;
        }
        for (int i = 0; i < tmp.length; i++) {
            array[i+low] = tmp[i];//因为这里的low可能在右边区段，所有要考虑；
        }
    }


}
