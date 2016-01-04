/**
 * Created by Darius on 12/26/2015.
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AddStudentCommand extends RosterCommandReversable
{
    Student student_;
    Roster roster_;
    public AddStudentCommand(Roster roster,
                             Student student)
    {
        roster_ = roster;
        student_ = student;
    }

    @Override
    public void implExecute()
    {
        roster_.addStudent(student_);
    }

    public void implUndo()
    {
        roster_.removeStudent(student_);
    }
}
