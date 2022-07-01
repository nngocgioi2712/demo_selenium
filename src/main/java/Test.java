import java.io.FileInputStream;
import java.io.IOException;

public class Test {
    public static void main(String args[]) throws IOException {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("D:\\0.GIOINN\\AUTO_selenium\\demo_selenium\\data-test.xlsx");
            int i = fin.read();
            System.out.print((char) i);

            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            fin.close();
        }
    }
}
