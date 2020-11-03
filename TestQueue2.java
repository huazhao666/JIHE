/**
 * Created with Intellij IFEA
 * Description:循环队列
 * User : 花朝
 * Date : 2020-11-03
 * Time : 11:28
 */
 class Myqueue2 {
    public  int[] elem;
    public  int front;
    public int rear;

    public  Myqueue2(int k ){
        this.elem = new int[k+1];
    }

   public  boolean enQueue(int val){
       if(isFull()){
           return false;
       }
           this.elem[rear] = val;
           this.rear = (rear + 1) % this.elem.length;
           return true;
   }
   public  boolean deQueue(){
       if(isEmpty()){
           return false;
       }
       this.front = (this.front+1) % this.elem.length;
       return true;
   }
   public  boolean isFull(){
       if( (this.rear+1) % this.elem.length == front){
           return true;
       }
       return false;
   }
   public boolean isEmpty(){
       if(rear == front){
           return true;
       }
       return false;
   }
   public int Front(){
       if(isFull()){
           return -1;
       }
       return this.elem[this.front];
   }
   public int rear(){
       if(isEmpty()){
           return -1;
       }
       int index = this.rear == 0 ? this.elem.length -1 : this.rear;
       return index;
   }
}
