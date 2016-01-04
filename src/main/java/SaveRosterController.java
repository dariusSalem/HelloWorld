/**
 * Created by Darius on 1/2/2016.
 */
public class SaveRosterController
{
    private Roster roster_;
    private CommandManager cmdMgr_;

    public SaveRosterController(Roster roster,
                                CommandManager cmdMgr)
    {
        roster_ =  roster;
        cmdMgr_ = cmdMgr;
    }

    public void saveXmlRoster(String fileName)
    {
        RosterCommand saveCmd = new SaveRosterCommand(roster_, new SaveRosterXML(), fileName);
        cmdMgr_.executeCommand(saveCmd);
    }

    public void saveJsonRoster(String fileName)
    {
        RosterCommand saveCmd = new SaveRosterCommand(roster_, new SaveRosterJson(), fileName);
        cmdMgr_.executeCommand(saveCmd);
    }
}
