import java.util.Scanner;

/**
 * Created by Darius on 12/25/2015.
 */
public class InputParser
{

    static boolean getInput(String retVal,
                            InputChecker<String> checker)
    {
        retVal = "";
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNext())
        {
            return false;
        }
        retVal = new String(sc.next());
        return true;
    }

    static boolean getInput(Integer retVal,
                            InputChecker<Integer> checker)
    {
        retVal = 0;
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt())
        {
            return false;
        }
        retVal = new Integer(sc.nextInt());
        return true;
    }

    static boolean checkBounds(int lowBound,
                           int highBound,
                           int value)
    {
        return (lowBound <= value && value <= highBound) ? true : false ;
    }


    static void throwError()
    {
        System.out.println("ERROR. Incorrect Input. Please try again");
    }

    public interface InputChecker<T>
    {
        public boolean check(T input);
    }

}
