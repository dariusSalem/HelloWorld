/**
 * Created by Darius on 12/27/2015.
 */
public class RemoveStudentCommand extends RosterCommand
{
    public RemoveStudentCommand(Roster roster)
    {
        super(roster);
    }

    @Override
    public void execute()
    {
        boolean success = getRoster().removeStudent(StudentInfoCapture.askId());
        if(!success)
        {
            InputParser.throwError();
        }
    }
}
