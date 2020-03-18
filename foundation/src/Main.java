import com.xue.foundation.InterfaceAndAbstract.ClassA;
import com.xue.foundation.InterfaceAndAbstract.impl.ClassAImpl;

public class Main {

    public static void main(String[] args) {
        ClassA a = new ClassAImpl();
        a.testOne();
        a.testTwo();
    }
}
