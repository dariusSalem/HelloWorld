/**
 * Created by Darius on 12/25/2015.
 */
public class PrintRosterCommand extends RosterCommand
{
    public PrintRosterCommand(Roster roster)
    {
        super(roster);
    }

    @Override
    public void execute()
    {
        System.out.println(getRoster());
    }
}
