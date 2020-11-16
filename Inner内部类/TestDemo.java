package Inner内部类;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created with Intellij IFEA
 * Description:
 * 1.实例内部类
 * 2.静态内部类
 * 3.匿名内部类；
 * 4.本地内部类；
 * User : 花朝
 * Date : 2020-11-16
 * Time : 19:13
 */


//实例内部类；
class Outclass {
    public int val = 99;
    private int val2 = 98;
    public static int val3;

    //1.拿到实例内部类对象的方式；Outclass.Innerclass innerClass = outclass. new Innerclass();
    //2.不能再实例内部类中定义一个静态变量；如果非要如此，加一个final， 能在编译时期确定的值；
    //3.实例内部类是否有额外的开销；有的;
    //4.this --> 静态 可以通过外部类名引用 Outclass.this.val
    //5.注意内部类产生的字节码文件 外部类名$内部类命.class;
    class Innerclass {
        public int val = 100;
        public int val4 = 10;
        public static final int val5 = 20;
        public void test() {
            System.out.println(val);//打印的值为100；
            System.out.println(this.val);//打印的值为100；
            System.out.println(Outclass.this.val); //打印的值为99
            System.out.println(val2);
            System.out.println(val3); //这个静态的也可以访问
            System.out.println(val4);
            System.out.println(val5);
        }
    }
}

//静态内部类
class Outclass2 {
    public int val = 99;
    private int val2 = 98;
    public static int val3;

    //1.拿到静态实例内部类对象；Outclass2.InnerClass2  innerClass2 = new Outclass2.InnerClass2();
    //2.静态内部类当中 是不可以访问外部类的非静态数据成员的；非要访问就要构造
    static class InnerClass2 {
        public int val4 = 11;
        private int val5 = 12;
        public static int val6 = 13;
        //这个方法就访问val；
        Outclass2 outclass2;

        public InnerClass2(Outclass2 out) {
            this.outclass2 = out;
        }

        public void test2() {
            System.out.println(val4);
            System.out.println(val5);
            System.out.println(val6);
            System.out.println(outclass2.val);
        }
    }
}
    //匿名内部类；
class Outclass3 {
    public void test() {
        System.out.println("test()");
    }
}
public class TestDemo {
//    public void func() {
//        class A {
//            //本地内部类；定义在方法里面的
//        }
//    }
    public static void main(String[] args) {
        new Outclass3(){
            @Override
            public void test() {
                System.out.println("alalallalala");
            }
        }.test();
    }
    public static void main2(String[] args) {
        Outclass2 out = new Outclass2();
        Outclass2.InnerClass2 innerClass2 = new Outclass2.InnerClass2(out);
        innerClass2.test2();
    }
    public static void main1(String[] args) {
        Outclass outclass = new Outclass();
        Outclass.Innerclass innerClass = outclass. new Innerclass();
        innerClass.test();
    }
}
