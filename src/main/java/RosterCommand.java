/**
 * Created by Darius on 12/24/2015.
 */
public abstract class RosterCommand
{
    private Roster roster_;
    private Roster originalRoster_;

    public RosterCommand(Roster roster)
    {
        roster_ = roster;
        originalRoster_ = new Roster(roster);
    }

    /**
     * Why make roster private and create a protected getter?
     * Forces users to use this method, which can be easily searched for to see
     * where in the interface/parent chain the variable roster comes from.
     * @return
     */
    protected Roster getRoster()
    {
        return roster_;
    }

    public abstract void execute();

    public Roster undo()
    {
        return originalRoster_;
    }

    public interface RosterCommandCtr
    {
        RosterCommand get(Roster roster);
    }

}
