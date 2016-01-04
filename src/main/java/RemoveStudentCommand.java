/**
 * Created by Darius on 12/27/2015.
 */
public class RemoveStudentCommand extends RosterCommandReversable
{
    private Student student_;
    private Roster roster_;
    public RemoveStudentCommand(Roster roster,
                                Student student)
    {
        roster_ = roster;
        student_ = student;
    }

    @Override
    public void implExecute()
    {
        boolean success = roster_.removeStudent(student_);
        /*
        if(!success)
        {
            InputParser.throwError();
        }
        */
    }

    @Override
    public void implUndo()
    {
        roster_.addStudent(student_);
    }
}
