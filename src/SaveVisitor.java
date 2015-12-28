/**
 * Created by Darius on 12/26/2015
 * This visitor isn't used for double dispatch
 * but to keep the Roster Class stupid
 */

/*
public class SaveVisitor implements RosterVisitor
{
    SaveRosterStrategy strat_;
    String fileName_;
    SaveVisitor(SaveRosterStrategy strat,
                String fileName)
    {
        strat_ = strat;
        fileName_ = fileName;
    }

    @Override
    public void visit(Roster roster)
    {
        strat_.save(fileName_,
                    roster);
    }


}
*/