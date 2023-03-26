import java.util.ArrayList;

public class Test {
    private static int a = 0;
    protected static ArrayList<Test> testList = new ArrayList<Test>();
    Test(){
        a += 5;
        testList.add(this);
    }
    public static void main(String[] args) {
        Test t1 = new Test();
        System.out.println(Test.a);
        Test t2 = new Test();
        System.out.println(Test.a);
        System.out.println(Test.testList);
    }
}
