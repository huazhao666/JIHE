/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-03
 * Time : 9:47
 */
class MyStack {
    public int[] elem;
    public int usedSize;//top

    public MyStack() {
        this.elem = new int[5];
    }
    public void push(int item) {
        if( isFull()){
            System.out.println("栈是满的");
            return;
        }else {
            this.usedSize++;
            elem[this.usedSize-1] = item;
        }
    }
    public int pop() {
        if(this.usedSize == 0){
            return -1;
        }
        int ret = elem[this.usedSize-1];
        this.usedSize--;
        return  ret;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("栈是空的");
            return -1;
        }
        return (elem[this.usedSize-1]);
    }
    public boolean isEmpty() {
        if (this.usedSize == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
    public  void display(){
        for (int i = 0; i < usedSize ; i++) {
            System.out.print(elem[i]);
        }
        System.out.println();
    }
}


public class TestStack {
    public static void main (String[] args){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(4);
        myStack.display();
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        myStack.push(5);
        myStack.display();
    }
}
