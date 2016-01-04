/**
 * Created by Darius on 12/25/2015.
 */
public class PrintRosterCommand implements RosterCommand
{
    private Roster roster_;

    public PrintRosterCommand(Roster roster)
    {
        roster_ = roster;
    }

    @Override
    public void execute()
    {
        System.out.println(roster_);
    }
}
