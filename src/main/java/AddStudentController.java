/**
 * Created by Darius on 1/2/2016.
 *
 * Seems trivial for it to be its own class right now.
 * However, after the Database integration, there will be more logic here
 */

public class AddStudentController
{
    private Roster roster_;
    private CommandManager cmdMgr_;
    public AddStudentController(Roster roster,
                                CommandManager cmdMgr)
    {
        roster_ =  roster;
        cmdMgr_ = cmdMgr;
    }

    public void addStudent(int id,
                           int age,
                           String firstName,
                           String lastName)
    {
        Student student = new Student(id,age, firstName, lastName );
        cmdMgr_.executeCommand(new AddStudentCommand(roster_, student));
    }
}
