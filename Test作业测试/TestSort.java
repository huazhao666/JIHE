package Test作业测试;

import java.util.Arrays;


public class TestSort {
    public static void main (String[] args) {
        int[] x = {13, 43, 54, 35, 14, 23, 5,22, 32};
        mergeSort(x);
        for (int i = 0; i < x.length -1; i++) {
            if (x[i] > x[i + 1]) {
                System.out.println(false);
            }
        }
        System.out.println(Arrays.toString(x));
    }
    //直接排序
    public static void inSort(int[] array){
        for (int i = 1; i <array.length; i++) {
            int tmp = array[i];
            int j = i -1;
            for (; j >= 0; j--) {
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    //希尔排序
    public static void shellSort(int[] array){
        int[] x = {5,3,1};
        for (int i = 0; i < x.length; i++) {
            shellHelp(i,array);
        }
    }
    public static void shellHelp(int gap ,int[] array){
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-gap;
            for (;j >= 0;j -=gap){
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length ; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[i]){
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }
    //冒泡排序
    public static void subSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j <array.length-i ; j++) {
                if(array[j] > array[j+1]){
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
    //堆排
    public static void heapSort(int[] array){
        createHeap(array);
        int len = array.length-1;
        while (len > 0){
            int tmp = array[0];
            array[0] = array[len];
            array[len] = tmp;
            adjust(0,array,len);
            len--;
        }
    }
    public static void createHeap(int[] array){
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjust(i,array,array.length);
        }
    }
    public static void adjust(int parent,int[] array,int len){
        int child = parent * 2 + 1;
        while (child < len){
            if(child + 1 < len && array[child] < array[child+1]) {
                child++;
            }
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent= child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }
    //快排;
    public static void quickSort(int[] array){
        quickHelp(array,0,array.length-1);
    }
    public static void quickHelp(int[] array,int low,int high){
        if(low >= high){
            return;
        }
        int par = par(array,low,high);
        quickHelp(array,low,par-1);
        quickHelp(array,par+1,high);
    }
    public static int par(int[] array,int start,int end){
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
        return start;
    }
    //归并排序
    public static void mergeSort(int[] array){
        mergerSortHelp(array,0,array.length-1);
    }
    public static void mergerSortHelp(int[] array,int low,int high){
        if(low >= high) return;
        int mid = (low+high) / 2;
        mergerSortHelp(array,low,mid);
        mergerSortHelp(array,mid+1,high);
        merger(array,low,high,mid);
    }
    public static void merger(int[] array,int low,int high,int mid){
        int a = low;
        int b = mid+1;
        int[] tmp = new int[high-low+1];
        int index = 0;
        while (a <= mid && b <= high){
            if(array[a] < array[b]){
                tmp[index] = array[a];
                a++;
                index++;
            }else {
                tmp[index] = array[b];
                index++;
                b++;
            }
        }
        while (a <= mid){
            tmp[index] = array[a];
            a++;
            index++;
        }
        while (b <= high){
            tmp[index] = array[b];
            b++;
            index++;
        }
        for (int i = 0; i <tmp.length; i++) {
            array[low+i] = tmp[i];
        }
    }

}
