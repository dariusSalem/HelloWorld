import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Darius on 1/3/2016.
 */
public class AddStudentControllerTest
{
    private Roster roster_;
    private AddStudentController controller_;
    private CommandManager cmdMgr_;

    @Before
    public void init()
    {
        roster_ = new Roster();
        cmdMgr_ = new CommandManager();
        controller_ = new AddStudentController(roster_, cmdMgr_);
    }

    @Test
    public void addStudentTest()
    {
        Student student = new Student(1, 20, "First", "Name");
        controller_.addStudent(student.getId(),
                               student.getAge(),
                               student.getFirstName(),
                               student.getLastName());
        Assert.assertTrue(roster_.getSize() == 1);
        Assert.assertTrue(roster_.getStudent(1).equals(student));
        cmdMgr_.undo();
        Assert.assertTrue(roster_.getSize() == 0);
    }
}
