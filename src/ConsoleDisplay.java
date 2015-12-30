import java.util.Stack;

/**
 * Created by Darius on 12/30/2015.
 */
public class ConsoleDisplay implements Display
{
    /**
     * SupplierCommandCtr is a functional interface that returns a
     * RosterCommand. I can satisfy the interface by using
     * constructors references of my command classes and lambda expresssions.
     * Basically storing constructor functors!
     */
    private Menu<RosterCommand.RosterCommandCtr> menu_;
    private Roster roster_;
    private Stack<RosterCommand> cmdStack_;


    public ConsoleDisplay()
    {
        menu_ = new Menu<>();
        roster_ = new Roster();
        cmdStack_ = new Stack<>();
        initMap();
    }

    /**
     * It would be better for this stuff to be entered via data file. It would
     * be nice to specify the commands and their constructors as well via data file
     */
    private void initMap()
    {

        menu_.addOption("Add Student",            AddStudentCommand::new);
        menu_.addOption("Modify Student",         ModifyStudentCommand::new);
        menu_.addOption("Remove Student",         RemoveStudentCommand::new);
        menu_.addOption("Print to Console",       PrintRosterCommand::new );
        menu_.addOption("Load Roster XML File",   (roster)->{return new LoadRosterCommand(roster, new LoadRosterXML());});
        menu_.addOption("Load Roster JSON File",  (roster)->{return new LoadRosterCommand(roster, new LoadRosterJson());});
        menu_.addOption("Save to File in XML",    (roster)->{return new SaveRosterCommand(roster, new SaveRosterXML());});
        menu_.addOption("Save to File in JSON",   (roster)->{return new SaveRosterCommand(roster, new SaveRosterJson());});
        menu_.addOption("Undo Previous Command",  null);
        menu_.addOption("Exit Program",           ExitCommand::new );

    }

    @Override
    public void show()
    {
        while(true)
        {
            menu_.displayOptions();
            RosterCommand.RosterCommandCtr ctor = menu_.fetchUserCommand();

            /** this is such a hack... */
            if(ctor == null)
            {

                roster_ = cmdStack_.pop().undo();
                continue;
            }
            RosterCommand command = ctor.get(roster_);
            command.execute();
            cmdStack_.push(command);
        }
    }
}
