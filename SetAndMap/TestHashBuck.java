package SetAndMap;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-19
 * Time : 10:44
 */
class HashBuck {
    static class Node {
        public int data;
        public int value;
        public Node next;

        public Node(int data,int value) {
            this.data = data;
            this.value = value;
        }
    }
    public Node[] array;
    public int usedSize; //总长度；
    public HashBuck() {
        this.array = new Node[10];
        this.usedSize = 0;
    }
    public void put(int key,int value){
        //找到位置
        int index = key % this.array.length;
        //遍历这个位置下的链表；看看是否存在这个key；
        for (Node cur = array[index];cur != null;cur = cur.next) {
            if(cur.data == key){
                cur.value = value;
                return;
            }
        }
        //该链表没有和当前key值一样的元素；jdk1.8使用尾插，这里使用头插法；
        Node node = new Node(key,value);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        if(loadFactor() > 0.75){ //
            resize();
        }
    }
    public float loadFactor(){ //计算负载因子；
        return this.usedSize * 1.0f / this.array.length;
    }
    public void resize() { //扩容，然后重新哈希；
        Node[] newArray = new Node[this.array.length *2];
        for (int i = 0; i < this.array.length ; i++) {
            Node curNext = null;
            for (Node cur = array[i]; cur != null; cur = curNext) {
                 curNext = cur.next;
                //array[i]是一个链表；cur为头节点;
                int index = cur.data % newArray.length;
                cur.next = newArray[index]; //
                newArray[index] = cur;
            }
        }
        this.array = newArray;
    }
    public int getValue(int key) {
        int index = key % this.array.length;
        Node cur = this.array[index];
        for(; cur!= null; cur = cur.next) {
            if(cur.data == key) return cur.value;
        }
        return -1;
    }


}
public class TestHashBuck {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,1);
        hashBuck.put(21,2);
        hashBuck.put(31,3);
        hashBuck.put(4,4);
        hashBuck.put(5,5);
        hashBuck.put(6,6);
        hashBuck.put(7,7);
        hashBuck.put(8,8);
        System.out.println();
    }

}
