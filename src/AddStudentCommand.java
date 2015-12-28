/**
 * Created by Darius on 12/26/2015.
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AddStudentCommand implements RosterCommand
{
    @Override
    public void execute(Roster roster)
    {
        Integer id = StudentInfoCapture.askId();
        Integer age = StudentInfoCapture.askAge();
        String firstName = StudentInfoCapture.askFirstName();
        String lastName = StudentInfoCapture.askLastName();
        roster.addStudent(new Student(id,
                                      age,
                                      firstName,
                                      lastName));
    }


}
