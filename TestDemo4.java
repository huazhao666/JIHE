/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-04
 * Time : 9:24
 */

import  java.util.*;
public class TestDemo4 {
    //括号匹配问题；
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //只要再以下过程当中 发现不匹配  直接return
        for (int i = 0; i < s.length(); i++) {
            //1、左括号进行入栈
            char tmp = s.charAt(i);
            if(tmp == '(' || tmp == '[' || tmp == '{') {
                stack.push(tmp);
            }else {
                //2、判断栈是否为空
                if(stack.isEmpty()){
                    return false;
                }else{
                    //3、判断栈顶元素的字符左括号和当前的字符 右括号是否匹配
                    char cur = s.charAt(i);
                    if(stack.peek()=='(' && cur == ')'|| stack.peek() == '[' && cur == ']'||stack.peek() =='{'&&cur  == '}') {
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        //4、判断栈是否为空
        if( !stack.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}
//用队列实现栈；
class MyStack3 {

    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    private int usedSize;

    /** Initialize your data structure here. */
    public MyStack3() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        //1、谁不为空  入到哪个队列就好了
        //2、两个都为空   放到第一个qu1当中
        if( !qu1.isEmpty()){
            qu1.offer(x);
        }else if( !qu2.isEmpty()){
            qu2.offer(x);
        }else {
            qu1.offer(x);
        }
        usedSize++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) {
            return -1;
        }
        int size = usedSize;
            if (!qu1.isEmpty()) {
                while (size > 1) {
                    qu2.offer(qu1.poll());
                    size--;
                }
                usedSize--;
                return qu1.poll();
            } else {
                while (size > 1) {
                    qu1.offer(qu2.poll());
                    size--;
                }
                usedSize--;
                return qu2.poll();
            }

    }

    /** Get the top element. */
    public int top() {
        if (empty()) {
            return -1;
        }
        int tmp = -1;
        int size = usedSize;
        if (!qu1.isEmpty()) {
            while (size > 1) {
               tmp = qu1.poll();
                qu2.offer(tmp);
                size--;
            }
        } else {
            while (size > 1) {
               tmp = qu2.poll();
                qu1.offer(tmp);
                size--;
            }
        }
        return tmp;
    }


    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (qu1.isEmpty() && qu2.isEmpty()){
            return true;
        }
        return false;
    }
}
//用栈实现队列；
class MyQueue3 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue3() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    public  void push(int x ){ //加入元素
        s1.push(x);
    }
    public  int pop() { //弹出元素
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        if (!s2.empty()) {
            return s2.pop();
        }
        return -1;
    }
    public int peek() { //显示队头元素；
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        if (!s2.empty()) {
            return s2.peek();
        }
        return -1;
    }
    public boolean empty() { //判断队是否是空；
        if(s1.empty() && s2.empty()){
            return true;
        }
        return false;
    }
}
