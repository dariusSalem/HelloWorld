/**
 * Created by Darius on 12/28/2015.
 */
public class LoadRosterCommand extends  RosterCommand implements RosterVisitor
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
        getRoster().accept(this);
    }

    public void visit(Roster roster)
    {
        String fileName = "";
        //use input parser to get it
        strat_.load(fileName,
                    roster);
    }
}
