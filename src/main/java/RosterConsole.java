import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Darius on 12/30/2015.
 */
public class RosterConsole implements Display
{
    /**
     * SupplierCommandCtr is a functional interface that returns a
     * class method. I can satisfy the interface by using
     * method references.
     */
    private Menu<HandleOption> menu_;
    private CommandManager cmdMgr_;
    private Roster roster_;



    public RosterConsole()
    {
        menu_ = new Menu<>();
        roster_ = new Roster();
        cmdMgr_ = new CommandManager();
        initMap();
    }


    private void initMap()
    {
        menu_.addOption("Add Student",            this::handleAddStudent);
        menu_.addOption("Modify Student",         this::handleModifyStudent);
        menu_.addOption("Remove Student",         this::handleRemoveStudent);
        menu_.addOption("Print to Console",       this::handlePrint );
        menu_.addOption("Load Roster XML File",   this::handleLoadXml);
        menu_.addOption("Load Roster JSON File",  this::handleLoadJson);
        menu_.addOption("Save to File in XML",    this::handleSaveXml);
        menu_.addOption("Save to File in JSON",   this::handleSaveJson);
        menu_.addOption("Undo Previous Command",  this::handleUndo);
        menu_.addOption("Exit Program",           this::handleExit );
    }

    @Override
    public void showDisplay()
    {
        while(true)
        {
            menu_.displayOptions();
            menu_.fetchUserCommand().handle();
        }
    }

    public void handleAddStudent()
    {
        Integer id = StudentInfoCapture.askId();
        Integer age = StudentInfoCapture.askAge();
        String firstName = StudentInfoCapture.askFirstName();
        String lastName = StudentInfoCapture.askLastName();
        new AddStudentController(roster_, cmdMgr_).addStudent(id,age,firstName,lastName);
    }

    public void handleRemoveStudent()
    {
        Integer id = StudentInfoCapture.askId();
        new RemoveStudentController(roster_, cmdMgr_).removeStudent(id);
    }

    public void handleModifyStudent()
    {

       new ModifyStudentConsole(roster_, cmdMgr_);

    }

    public void handleSaveXml()
    {
        String fileName = askFileName();
        new SaveRosterController(roster_, cmdMgr_).saveXmlRoster(fileName);
    }

    public void handleSaveJson()
    {
        String fileName = askFileName();
        new SaveRosterController(roster_, cmdMgr_).saveJsonRoster(fileName);
    }

    public void handleLoadXml()
    {
        String fileName = askFileName();
        new LoadRosterController(roster_, cmdMgr_).loadXmlRoster(fileName);
    }

    public void handleLoadJson()
    {
        String fileName = askFileName();
        new LoadRosterController(roster_, cmdMgr_).loadJsonRoster(fileName);
    }

    public void handlePrint()
    {
        //GUI shouldn't know business logic
        //but its so trivial...
        new PrintRosterCommand(roster_).execute();
    }

    public void handleExit()
    {
        //GUI shouldn't know business logic
        //but it's so trivial...
        new ExitCommand(roster_).execute();
    }

    public void handleUndo()
    {
        cmdMgr_.undo();
    }

    private  static String askFileName()
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

    private interface HandleOption
    {
        void handle();
    }
}
