/**
 * Created by Darius on 12/24/2015.
 */
public interface RosterCommand
{

    void execute();

    interface RosterCommandCtr
    {
        RosterCommand get(Roster roster);
    }

}
