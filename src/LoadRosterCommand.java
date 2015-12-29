/**
 * Created by Darius on 12/28/2015.
 */
public class LoadRosterCommand extends  RosterCommand
{
    private LoadRosterStrategy strat_;

    public LoadRosterCommand(Roster roster,
                             LoadRosterStrategy strat)
    {
        super(roster);
        strat_ = strat;
    }

    public void execute()
    {
        String fileName = "";

        //use input parser to get it
        getRoster().load(fileName,
                         strat_);
    }
}
