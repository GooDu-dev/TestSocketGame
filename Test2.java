import java.util.ArrayList;

public class Test2 {
    public static ArrayList<Test> testList;
    Test2(Test t){
        testList.add(t);
    }
    public static void main(String[] args) {
        System.out.println(Test.testList);
    }
}
