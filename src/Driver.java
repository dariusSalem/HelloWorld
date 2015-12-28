/**
 * Created by Darius on 12/24/2015.
 */
public class Driver
{
    private Menu<RosterCommand> menu_;
    private Roster roster_;

    public static void main(String... args)
    {
        System.out.println("Hello");
        Driver driver = new Driver();
        driver.initMap();
        driver.run();
    }

    public Driver()
    {
        menu_ = new Menu<>();
        roster_ = new Roster();
    }

    /**
     * It would be better for this stuff to be entered via data file. It would
     * be nice to specify the commands and their constructors as well via data file
     */
    private void initMap()
    {
        menu_.addOption("Add Student",            new AddStudentCommand());
        menu_.addOption("Modify Student",         new ModifyStudentCommand());
        menu_.addOption("Remove Student",         new RemoveStudentCommand());
        menu_.addOption("Print to Console",       new PrintRosterCommand() );
        menu_.addOption("Save to File in XML",    new SaveRosterCommand(new SaveRosterXML()) );
        menu_.addOption("Save to File in JSON",   new SaveRosterCommand(new SaveRosterJson()) );
        menu_.addOption("Exit Program",           new ExitCommand() );
    }

    public void run()
    {
        while(true)
        {

            menu_.displayOptions();
            RosterCommand command = menu_.fetchUserCommand();
            if(command == null)
            {
                System.out.println("ITS NULL");
                continue;
            }
            command.execute(roster_);
        }
    }
}
