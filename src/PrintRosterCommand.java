/**
 * Created by Darius on 12/25/2015.
 */
public class PrintRosterCommand implements RosterCommand
{
    @Override
    public void execute(Roster roster)
    {
        System.out.println(roster);
    }
}
