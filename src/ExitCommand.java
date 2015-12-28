/**
 * Created by Darius on 12/26/2015.
 */
public class ExitCommand implements RosterCommand
{
    @Override
    public void execute(Roster roster)
    {
        System.out.println("Exiting");
        System.exit(1);
    }
}
