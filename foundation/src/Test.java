import java.io.*;

public class Test {

    private int m;

    public int test01() {
        return  m + 1;
    }

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(""))));
            //BufferedInputStream bufferedInputStream = new BufferedInputStream(new File(""));
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(""));
            FileInputStream fileInputStream = new FileInputStream("");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
