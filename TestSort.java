import java.util.Arrays;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-12
 * Time : 9:12
 */
//在比较的过程中，交换的时候不发生跳跃交换，就是稳定
//稳定可以变成不稳定，但是不稳定不能变成稳定


public class TestSort {
    public static void main(String[] args) {
        int[] array = {45, 23, 35, 6, 723, 223, 43};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    //直接插入排序  稳定， 空间复杂度是O(1)；时间复杂度是O(n^2);
    //特点： 数据越有序，速度越快；
    public static void insort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (tmp < array[j]) { //array[j] 是tmp前面的数值；
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    //希尔排序；不稳定，时间复杂度0(n^1.5) - 0(n^1.3) ,空间复杂度；O(1)
    public static void shellSort(int[] array) {
        int[] drr = {5, 3, 1};
        for (int i = 0; i < drr.length; i++) {
            shell(array, drr[i]);
        }
    }

    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (tmp < array[j]) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

    //选择排序;  不稳定；时间复杂度O(n^2),空间复杂度O(1);
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    //堆排序  不稳定；时间复杂度 O(n ^ log n ) 空间复杂度为O(1):
    public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array, 0, end);
            end--;
        }
    }

    public static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i++) {
            adjustDown(array, i, array.length);
        }
    }

    public static void adjustDown(int[] array, int parent, int len) {
        int child = parent * 2 + 1;
        while (child < len) {
            if (child + 1 < len && array[child] < array[child + 1]) {
                child++;
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }
    }

    // 冒泡排序 时间复杂度，n^2 空间复杂度 1；
    public static void bubbleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = false;
                }
            }
            if(flag) break;
        }
    }

    //快排    不稳定 时间复杂度 n*log n 空间复杂度 log n；
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    public static void quick(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int par = partion(array, low, high);
        quick(array, low, par - 1);
        quick(array, par + 1, high);
    }

    public static int partion(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while (start < end && array[end] >= tmp) {
                end--;
            }
            if (start >= end) {
                break;
            } else {
                array[start] = array[end];
            }
            while (start < end && array[start] <= tmp) {
                start++;
            }
            if (start >= end) {
                break;
            } else {
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }
}
