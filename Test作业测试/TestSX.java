package Test作业测试;

import java.util.Scanner;
import java.util.Stack;

public class TestSX {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() ->{
            for(int i= 0;i < 10;i++){
                try {
                    data.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() ->{
            for(int i= 0;i < 10;i++){
                try {
                    data.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }

}

class Data{
    private  int a = 0;
    public synchronized void add() throws InterruptedException {
        while (a != 0){
            this.wait();
        }
        a++;
        System.out.println("生产者");
        this.notify();
    }
    public synchronized void sub() throws InterruptedException {
        while (a == 0){
            this.wait();
        }
        a--;
        System.out.println("消费者");
        this.notify();
    }
}
