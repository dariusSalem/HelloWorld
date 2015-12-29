import java.util.Scanner;

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
        String fileName = askFileName();

        strat_.load(fileName,
                    roster);
    }

    /**
     *
     * This code is duplicated(BAD). Perhaps create a filecommand class that
     * has these methods. This class would inherit from it or just make this a
     * method in RosterCommand
     */
    public  static String askFileName()
    {
        String fileName = "";

        final int MIN_LENGTH = 1,
                  MAX_LENGTH = 40;
        System.out.println("Enter Filename, no extension ");

        String pattern =
                "\\w{" + MIN_LENGTH + "," + MAX_LENGTH + "}";
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNext(pattern))
        {
            InputParser.throwError();
            fileName = askFileName();
        }
        else
        {
            fileName = sc.next(pattern);
        }

        return fileName;
    }
}
