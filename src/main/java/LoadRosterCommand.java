import java.util.Scanner;

/**
 * Created by Darius on 12/28/2015.
 */
public class LoadRosterCommand extends  RosterCommandReversable implements RosterVisitor
{
    private LoadRosterStrategy strat_;
    private String fileName_;
    private Roster roster_, origRoster_;

    public LoadRosterCommand(Roster roster,
                             LoadRosterStrategy strat,
                             String fileName)
    {
        roster_ = roster;
        origRoster_ = new Roster(roster);
        strat_ = strat;
        fileName_ = fileName;
    }

    public void implExecute()
    {
        roster_.accept(this);
    }
    public void implUndo()

    {
        roster_.assign(origRoster_);
    }

    public void visit(Roster roster)
    {
        strat_.load(fileName_,
                    roster);
    }
}
