package fish;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void QINQIN() {
        String s = "h";
        s.toString();
        // String s = new String("h");
        System.out.println(s == "h");
        if ("h" == s) {
            System.out.println("A");
        }
        if (s.equals("h")) {
            System.out.println('B');
        }
    }

    @Test
    public void testScanner() {
        Scanner sc = new Scanner(System.in);
        sc.next();
        sc.close();
    }
}
