/**
 * Created by Darius on 1/2/2016.
 */
public class ModifyStudentController
{
    private Roster roster_;
    private CommandManager cmdMgr_;

    public ModifyStudentController(Roster roster,
                                   CommandManager cmdMgr)
    {
        roster_ =  roster;
        cmdMgr_ = cmdMgr;
    }

    public void modifyId(int originalId,
                         int newId)
    {
        Student student = roster_.getStudent(originalId);
        if(student == null)
        {
            return;
        }
        Student newStudent = new Student(student);
        newStudent.setId(newId);
        cmdMgr_.executeCommand(new ModifyStudentCommand(roster_, student, newStudent));
    }

    public void modifyAge(int originalId,
                         int newAge)
    {
        Student student = roster_.getStudent(originalId);
        if(student == null)
        {
            return;
        }
        Student newStudent = new Student(student);
        newStudent.setAge(newAge);
        cmdMgr_.executeCommand(new ModifyStudentCommand(roster_, student, newStudent));
    }

    public void modifyFirstName(int originalId,
                                String newName)
    {
        Student student = roster_.getStudent(originalId);
        if(student == null)
        {

            return;
        }
        Student newStudent = new Student(student);
        newStudent.setFirstName(newName);
        cmdMgr_.executeCommand(new ModifyStudentCommand(roster_, student, newStudent));
    }

    public void modifyLastName(int originalId,
                               String newName)
    {
        Student student = roster_.getStudent(originalId);
        if(student == null)
        {
            return;
        }
        Student newStudent = new Student(student);
        newStudent.setLastName(newName);
        cmdMgr_.executeCommand(new ModifyStudentCommand(roster_, student, newStudent));
    }
}
