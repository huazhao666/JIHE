package Sort排序;
import java.util.Arrays;

public class TestSort2 {
    public static void main(String[] args) {
        int[] array = {2,43,65,42,34,25,44,32,3,53};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
    //直接插入排序，时间复杂度为O(n^2)；空间复杂度为O(1);稳定的
    public static void inSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (;j >= 0;j--) {
                if (array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void shellSort(int[] array){
        int[] arr = {5,3,1};
        for (int i = 0; i < arr.length; i++) {
            int gap = arr[i];
            shellSortChild(array,gap);
        }
    }
    // 希尔排序；时间复杂度为O(n^1.5)到O(n^1.3) 空间复杂度为O(1)；不稳定；
    public static void shellSortChild(int[] array,int gap){
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (;j >= 0 ; j -=gap) {
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    //选择排序；时间复杂度为O(n^2);空间复杂度为O(1);
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
    //冒泡排序法，时间复杂度为O(N^2)；空间复杂度为O(1);
    public static void subbleSort(int[] array){
        for (int i = 1; i < array.length ; i++) {
            boolean flag = true;
            for (int j = 0; j <array.length-i; j++) {
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }
    //堆排序;时间复杂度为O(N*log N);空间复杂度为O(1)；
    public static void heapSort(int[] array){
        createHeap(array);
        int end = array.length-1;
        while (end > 0){
            int tmp= array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }
    public static void createHeap(int[] array){
        for (int i = (array.length-1-1)/2;i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
    }
    public static void adjustDown(int[] array,int parent,int len){
        int child = parent * 2 + 1 ;
        while (child < len){
            if (child + 1 < len && array[child] < array[child+1]){
                child++;
            }
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = parent * 2 +1;
            }else {
                break;
            }
        }
    }
    //快排,时间复杂度为O(N * log N);空间复杂度为log N；
    public static void quickSort(int[] array){

        quick(array,0,array.length-1);
    }
    public static void quick(int[] array,int low,int high){
        if(low >= high) return;
        int par = partiton(array,low,high);
        quick(array,low,par-1);
        quick(array,par+1,high);
    }
    public static int partiton(int[] array,int start,int end){
        int tmp = array[start];
        while (start < end){
            while (start < end && array[end] >= tmp){
                end--;
            }
            if(start >= end){
                break;
            }else {
                array[start] = array[end];
            }
            while (start < end && array[start] <= tmp){
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
    //归并 时间复杂度为 O(N * log N)；空间复杂度为O(N);
    public static void mergeSort(int[] array){

        mergeSortChild(array,0,array.length-1);
    }
    public static void mergeSortChild(int[] array,int low,int high){
        if(low >= high) return;
        int mid = (low + high )/2;
        mergeSortChild(array,low,mid);
        mergeSortChild(array,mid+1,high);
        merge(array,low,high,mid);
    }
    public static void merge(int[] array,int low ,int high ,int mid){
        int s1 = low;
        int s2 = mid + 1 ;
        int[] arr = new int[high-low+1];
        int index = 0;
        while (s1 <= mid && s2 <= high ){
            if(array[s1] <= array[s2]){
                arr[index] = array[s1];
                index++;
                s1++;
            }else {
                arr[index] = array[s2];
                index++;
                s2++;
            }
        }
        while (s1 <= mid){
            arr[index] = array[s1];
            index++;
            s1++;
        }
        while (s2 <= high){
            arr[index] = array[s2];
            index++;
            s2++;
        }
        for (int i = 0; i < arr.length; i++) {
            array[low+i] = arr[i];
        }
    }
}
