import java.util.Scanner;

/**
 * Created by Darius on 12/26/2015.
 */
public class SaveRosterCommand extends RosterCommand implements RosterVisitor
{
    private SaveRosterStrategy saver_;

    public SaveRosterCommand(Roster roster,
                             SaveRosterStrategy saver)
    {
        super(roster);
        saver_ = saver;
    }

    @Override
    public void execute()
    {
        getRoster().accept(this);
    }

    public void visit(Roster roster)
    {
        String fileName = askFileName();

        //use input parser to get it
        saver_.save(fileName,
                    roster);
    }

    /**
     *
     * This code is duplicated(BAD). Perhaps create a filecommand class that
     * has these methods
     */
    public  static String askFileName()
    {
        String fileName = "";

        final int MIN_LENGTH = 1,
                MAX_LENGTH = 40;
        System.out.println("Enter Filename, without extension.");

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
