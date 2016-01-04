/**
 * Created by Darius on 12/27/2015.
 */

public class ModifyStudentCommand extends RosterCommandReversable {
    private Student origStudent_;
    private Student newStudent_;
    private Roster roster_;

    public ModifyStudentCommand(Roster roster,
                                Student origStudent,
                                Student newStudent) {
        origStudent_ = origStudent;
        newStudent_ = newStudent;
        roster_ = roster;
    }

    @Override
    public void implExecute()
    {
        roster_.removeStudent(origStudent_.getId());
        roster_.addStudent(newStudent_);
    }

    @Override
    public void implUndo()
    {
        roster_.removeStudent((newStudent_));
        roster_.addStudent(origStudent_);
    }
}
