import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Darius on 12/26/2015.
 */
public class StudentInfoCapture
{
    public static Integer askId()
    {
        Integer id = new Integer(0);

        System.out.println("Enter Student Id");
        Scanner sc = new Scanner(System.in);
        /*
        InputParser.InputChecker<Integer> idChecker =  (val) -> {
            return  (val % 99999 == 0) ? true : false ;
        };

        if(! InputParser.getInput(id,
                idChecker))
        {
            InputParser.throwError();
            id = askId();
        }
        */
        String pattern = "\\d{1,5}";
        if(!sc.hasNext(pattern))
        {
            InputParser.throwError();
            id = askId();
        }
        else
        {
            id = Integer.valueOf(sc.next(pattern));
        }

        return id;
    }

    public  static String askFirstName()
    {
        String firstName = "";
        System.out.println("Enter Student First Name");

        /*
        if(! InputParser.getInput(firstName,
                new NameChecker(Student.FIRST_NAME_MIN_LENGTH,
                                Student.FIRST_NAME_MAX_LENGTH)))
        {
            InputParser.throwError();
            firstName = askFirstName();
        }
        */
        String pattern =
                "\\w{" +Student.FIRST_NAME_MIN_LENGTH + "," +  Student.FIRST_NAME_MAX_LENGTH + "}";
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNext(pattern))
        {
            InputParser.throwError();
            firstName = askFirstName();
        }
        else
        {
            firstName = sc.next(pattern);
        }

        return firstName;
    }

    public static String askLastName()
    {
        String lastName = "";
        System.out.println("Enter Student Last Name");

        String pattern =
                "\\w{" +Student.LAST_NAME_MIN_LENGTH + "," +  Student.LAST_NAME_MAX_LENGTH + "}";
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNext(pattern))
        {
            InputParser.throwError();
            lastName= askLastName();
        }
        else
        {
            lastName = sc.next(pattern);
        }

        return lastName;

    }

    public static Integer askAge()
    {
        System.out.println("Enter Student Age");
        Integer age = new Integer(0);
        String pattern = "[1-9]{2}";
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNext(pattern))
        {
            InputParser.throwError();
            age = askAge();
        }
        else
        {
            age = Integer.parseInt(sc.next(pattern));
        }

        return age;
    }

    private class NameChecker implements InputParser.InputChecker<String>
    {
        private int minLength_,
                    maxLength_;

        NameChecker(int minLength,
                    int maxLength)
        {
            minLength_ = minLength;
            maxLength_ = maxLength;
        }

        @Override
        public boolean check(String input)
        {
            Pattern pattern = Pattern.compile("\\w{" + minLength_ + "," +  maxLength_ + "}");
            Matcher matcher = pattern.matcher(input);
            return matcher.matches();
        }
    }

}