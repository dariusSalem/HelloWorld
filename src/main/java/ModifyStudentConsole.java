/**
 * Created by Darius on 1/3/2016.
 */
public class ModifyStudentConsole
{
    private Menu<EditOption> menu_;
    private Integer origId_;
    private Roster roster_;
    private CommandManager cmdMgr_;

    ModifyStudentConsole(Roster roster,
                         CommandManager cmdMgr)
    {
        roster_ = roster;
        menu_ = new Menu<>();
        menu_.addOption("Modify ID",
                this::editId);
        menu_.addOption("Modify Age",
                this::editAge );
        menu_.addOption("Modify First Name",
                this::editFirstName );
        menu_.addOption("Modify Last Name",
                this::editLastName );
        origId_ = StudentInfoCapture.askId();
        menu_.displayOptions();
        menu_.fetchUserCommand().edit();
    }

    private interface EditOption
    {
        void edit();
    }

    public void editId()
    {
        new ModifyStudentController(roster_, cmdMgr_).modifyId(origId_, StudentInfoCapture.askId());
    }

    public void editAge()
    {
        new ModifyStudentController(roster_, cmdMgr_).modifyAge(origId_, StudentInfoCapture.askAge());
    }

    public void editFirstName()
    {
        new ModifyStudentController(roster_, cmdMgr_).modifyFirstName(origId_, StudentInfoCapture.askFirstName());
    }

    public void editLastName()
    {
        new ModifyStudentController(roster_, cmdMgr_).modifyLastName(origId_, StudentInfoCapture.askLastName());
    }
}