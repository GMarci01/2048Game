
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;


public class teszt_keyIN {
    public static void main(String[] args) {
        Robot robot;

        try {
            robot=new Robot();
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }
    }
}
