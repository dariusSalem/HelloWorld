/**
 * Created by Darius on 1/2/2016.
 */
public class LoadRosterController
{
    private Roster roster_;
    private CommandManager cmdMgr_;

    public LoadRosterController(Roster roster,
                                CommandManager cmdMgr)
    {
        roster_ =  roster;
        cmdMgr_ = cmdMgr;
    }

    public void loadXmlRoster(String fileName)
    {
        RosterCommand cmd = new LoadRosterCommand(roster_,  new LoadRosterXML(), fileName);
        cmdMgr_.executeCommand(cmd);
    }

    public void loadJsonRoster(String fileName)
    {
        RosterCommand cmd = new LoadRosterCommand(roster_,  new LoadRosterJson(), fileName);
        cmdMgr_.executeCommand(cmd);
    }
}