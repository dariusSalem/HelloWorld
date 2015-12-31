/**
 * Created by Darius on 12/27/2015.
 *  I really hate the way I did the edit commands...So many classes
 *  A map of functors would be the way I would do this in C++,
 *  however when i tried using method references in Java, I got an error
 *  about how my type could not be converted to T
 */

public class ModifyStudentCommand extends RosterCommand
{
    private Menu<EditCommand> menu_;

    public ModifyStudentCommand(Roster roster)
    {
        super(roster);

        menu_ = new Menu<>();
        menu_.addOption("Modify ID",
                new EditId());
        menu_.addOption("Modify Age",
                new EditAge() );
        menu_.addOption("Modify First Name",
                new EditFirstName() );
        menu_.addOption("Modify Last Name",
                new EditLastName() );
    }

    @Override
    public void execute()
    {
        Integer id = StudentInfoCapture.askId();
        Student student = getRoster().getStudent(id);

        if(student == null)
        {
            InputParser.throwError();
            return;
        }

        menu_.displayOptions();
        EditCommand command = menu_.fetchUserCommand();
        command.execute(student);
    }

    private interface EditCommand
    {
        void execute(Student student);
    }

    private class EditId implements EditCommand
    {
        @Override
        public void execute(Student student)
        {
            student.setId(StudentInfoCapture.askId());
        }
    }

    private class EditAge implements EditCommand
    {
        @Override
        public void execute(Student student)
        {
            student.setAge(StudentInfoCapture.askAge());
        }
    }

    private class EditFirstName implements EditCommand
    {
        @Override
        public void execute(Student student)
        {
            student.setFirstName(StudentInfoCapture.askFirstName());
        }
    }

    private class EditLastName implements EditCommand
    {
        @Override
        public void execute(Student student)
        {
            student.setLastName(StudentInfoCapture.askLastName());
        }
    }
}
