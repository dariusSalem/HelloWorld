import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Darius on 12/24/2015.
 */
public class Student
{
    private int id_;
    private int age_;
    private String firstName_;
    private String lastName_;

    public static final int FIRST_NAME_MAX_LENGTH = 26,
                             FIRST_NAME_MIN_LENGTH = 1,
                             LAST_NAME_MAX_LENGTH = 40,
                             LAST_NAME_MIN_LENGTH = 1;

    public Student(int id,
                   int age,
                   String firstName,
                   String lastName)
    {
        id_ = id;
        age_ = age;
        firstName_ = firstName;
        lastName_ = lastName;
    }

    public Student(Student student)
    {
        id_ = student.getId();
        age_ = student.getAge();
        firstName_ = student.getFirstName();
        lastName_ = student.getLastName();
    }

    public void setId(int id)
    {
        id_= id;
    }

    public void setAge(int age)
    {
        age_ = age;
    }

    public void setFirstName(String firstName)
    {
        firstName_ = firstName;
    }

    public void setLastName(String lastName)
    {
        lastName_ = lastName;
    }

    public int getId(){ return id_ ; }

    public int getAge(){ return age_; }

    public String getFirstName(){ return firstName_; }

    public String getLastName(){ return lastName_; }

    @Override
    public String toString()
    {
        String ret = "Student: \n";
        ret += "\t id        = " + id_        + "\n";
        ret += "\t age       = " + age_       + "\n";
        ret += "\t firstName = " + firstName_ + "\n";
        ret += "\t lastName  = " + lastName_  + "\n";
        return ret;
    }


}
