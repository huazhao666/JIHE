
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-02
 * Time : 11:12
 */
class  Student {
    private  String name ;
    private  String grade;
    private  double score;

    public Student(String name, String grade, double score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", score=" + score +
                '}';
    }
}
public class  TestDemo {
    public static void main2 (String[] args){
        ArrayList<Integer> list =  new ArrayList<>();
        list.add(22);
        list.add(25);
        list.add(52);
        Collections.sort(list);
        System.out.println(list);
    }


    public static void main1 (String[] args){
        ArrayList<Student> list =  new ArrayList<>();
        Student student1  =  new Student("女帝","1班",89.5);
        Student student2 =  new Student("坤坤","2班",90.5);
        Student student3  =  new Student("哟西","3班",79.5);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        for (Student student : list) {
            System.out.println(student);
        }
    }
    public static void main3 (String[] args) {
        String str = "welcome to bit";
        String str1 = "come";
        List<String> ret = fun(str,str1);
        for (String s: ret) {
            System.out.print(s);
        }
    }
    public static List<String> fun(String str,String str1) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0;i < str.length();i++){
            char n = str.charAt(i);
            if(!str1.contains(n +"")){
                list.add(n + "");
            }
        }
        return  list ;
    }
    //杨辉三角
    public List<List<Integer>> generate(int numRoms) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRoms == 0){
            return ret;
        }
        //第一行
        List<Integer> one = new ArrayList<>();
        one.add(1);
        ret.add(one);
        //第二行
        for (int i = 1; i < numRoms; i++) {
            // 每一行都需要一个list ；
            List<Integer> list = new ArrayList<>();
            list.add(1);
            //前一行
            List<Integer> prelist = ret.get(i-1);
            //从当前行的第一列开始
            for (int j = 1; j < i; j++) {
                int tmp = prelist.get(j) + prelist.get(j-1);
                list.add(tmp);
            }
            list.add(1);
            //当前行添加结束
            ret.add(list);
        }
        return ret;
    }


}