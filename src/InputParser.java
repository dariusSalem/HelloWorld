import java.util.Scanner;

/**
 * Created by Darius on 12/25/2015.
 */
public class InputParser
{

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

}
