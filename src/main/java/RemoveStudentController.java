/**
 * Created by Darius on 1/2/2016.
 */
public class RemoveStudentController
{
    private Roster roster_;
    private CommandManager cmdMgr_;

    public RemoveStudentController(Roster roster,
                                   CommandManager cmdMgr)
    {
        roster_ =  roster;
        cmdMgr_ = cmdMgr;
    }

    public void removeStudent(int id)
    {
        //Student student = new Student(id,age, firstName, lastName );
        Student student = roster_.getStudent(id);
        if(student == null)
        {
            return;
        }

        cmdMgr_.executeCommand(new RemoveStudentCommand(roster_, student));
    }
}
