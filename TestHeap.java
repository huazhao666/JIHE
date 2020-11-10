import java.util.Arrays;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-10
 * Time : 10:57
 */
public class TestHeap {
    public  int[] elem;
    public  int useSize;

    public  TestHeap(){

        this.elem = new int[10];
    }
    public  void initHeap(int[] array){
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.useSize++;
        }
        for (int i = (this.useSize-1-1) / 2 ; i >= 0 ; i--) {
            adjustDown(i,this.useSize);
        }
        System.out.println("==========");
    }
    //向下整形；-- >
    public void  adjustDown(int parent ,int len ){
        int child =  2 * parent +1;
        while (child < len){
            if( child + 1 < len &&elem[child] < elem[child+1] ){
                child++;
            }
            if(elem[child] > elem[parent] ){
                int tmp= elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = parent *2 + 1;
            }else {
                break;
            }
        }
    }

    //向上整形；
    public  void adjustUp(int child){
        int parent = (child - 1) /2;
        while (child > 0){
            if(elem [child] > elem[parent]){
                int tmp= elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child  - 1)/2;
            }else {
                break;
            }
        }
    }

    //增加元素；插入
    public  void  push(int val){
        if(ifFull()){
            this.elem = Arrays.copyOf(elem, elem.length * 2);
        }
        this.elem[useSize] = val;
        this.useSize++ ;
        adjustUp(this.useSize-1);
    }

    //判断是否满了；
    public  boolean ifFull(){
        return this.useSize == this.elem.length;
    }
    //删除元素，pop；
    public  void pop(){
        if(isEmpty()) return;
        int tmp = this.elem[0];
        this.elem[0] = this.elem[useSize-1];
        this.elem[useSize-1] = tmp;
        this.useSize--;
        adjustDown(0,useSize);
        System.out.println("===========");
    }
    //判断空；
    public  boolean isEmpty(){
        return this.useSize == 0;
    }
    //堆排序；
    public void  Headsort(int[] array){
        initHeap(array);
        int count = this.useSize;
        for(int i = count - 1; i > 0;i--){
            int tmp = this.elem[0];
            this.elem[0] = this.elem[i];
            this.elem[i] = tmp;
            count--;
            adjustDown(0,count);
        }
        System.out.println("==========");
    }
}
