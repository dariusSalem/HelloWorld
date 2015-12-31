/**
 * Created by Darius on 12/26/2015.
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AddStudentCommand extends RosterCommand
{
    public AddStudentCommand(Roster roster)
    {
        super((roster));
    }

    @Override
    public void execute()
    {
        Integer id = StudentInfoCapture.askId();
        Integer age = StudentInfoCapture.askAge();
        String firstName = StudentInfoCapture.askFirstName();
        String lastName = StudentInfoCapture.askLastName();
        getRoster().addStudent(new Student(id,
                                      age,
                                      firstName,
                                      lastName));
    }
}
