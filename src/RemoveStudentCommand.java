/**
 * Created by Darius on 12/27/2015.
 */
public class RemoveStudentCommand implements RosterCommand
{
    @Override
    public void execute(Roster roster)
    {
        boolean success = roster.removeStudent(StudentInfoCapture.askId());
        if(!success)
        {
            InputParser.throwError();
        }
    }
}
