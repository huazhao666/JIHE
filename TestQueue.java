/**
 * Created with Intellij IFEA
 * Description: 单链表
 * User : 花朝
 * Date : 2020-11-03
 * Time : 10:49
 */
class  Node {
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
class Myqueue {
    public  Node head;
    public  Node tail;



    //尾插法
    public void offer(int val) {
        Node  node = new Node(val);
        if(isEmpty()){
            this.head = node ;
            this.tail = node ;
        }else{
            this.tail.next = node ;
            this.tail = node ;
        }
    }
    //头删
    public int poll() {
        if(isEmpty()){
            System.out.println("队列为空");
            return -1;
        }
        int data = this.head.val;
        if(this.head.next == null){
            this.head = null;
            this.tail = null;
        }else {
            this.head= this.head.next;
        }
       return data;
    }

    public int peek() {
        if(isEmpty()){
            return -1;
        }else{
            return  this.head.val;
        }
    }
    public boolean isEmpty() {
        if(this.head == null){
            return  true;
        }
        return  false;
    }


}
public class TestQueue {
    public static void main (String[] args){
        Myqueue myqueue = new Myqueue();
        myqueue.offer(3);
        myqueue.offer(5);
        myqueue.offer(6);
        System.out.println(myqueue.poll());
    }
}
