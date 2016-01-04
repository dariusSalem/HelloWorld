import java.util.Scanner;

/**
 * Created by Darius on 12/26/2015.
 */
public class SaveRosterCommand implements RosterCommand, RosterVisitor
{
    private SaveRosterStrategy saver_;
    private String fileName_;
    private Roster roster_;

    public SaveRosterCommand(Roster roster,
                             SaveRosterStrategy saver,
                             String fileName)
    {
        roster_ = roster;
        saver_ = saver;
        fileName_ = fileName;
    }

    @Override
    public void execute()
    {
        roster_.accept(this);
    }

    public void visit(Roster roster)
    {
        //use input parser to get it
        saver_.save(fileName_,
                    roster);
    }
}
