import java.util.Stack;

/**
 * Created by Darius on 12/24/2015.
 */
public class Driver
{

    private DisplayManager display_;

    public static void main(String... args)
    {
        System.out.println("Hello");
        Driver driver = new Driver(new DisplayManager(new ConsoleDisplay()));
    }

    public Driver(DisplayManager display)
    {
        display_ = display;
        display_.showDisplay();
    }
}
