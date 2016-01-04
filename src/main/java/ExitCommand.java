/**
 * Created by Darius on 12/26/2015.
 */
public class ExitCommand implements RosterCommand
{
    public ExitCommand(Roster roster){};


    @Override
    public void execute()
    {
        System.out.println("Exiting");
        System.exit(1);
    }
}
