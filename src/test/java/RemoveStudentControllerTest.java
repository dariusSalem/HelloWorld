import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Darius on 1/3/2016.
 */
public class RemoveStudentControllerTest
{

    private Roster roster_;
    private RemoveStudentController controller_;
    private CommandManager cmdMgr_;

    @Before
    public void init()
    {
        roster_ = new Roster();
        cmdMgr_ = new CommandManager();
        controller_ = new RemoveStudentController(roster_, cmdMgr_);
    }

    @Test
    public void removeStudentTest()
    {
        Student student = new Student(1, 20, "First", "Name");
        roster_.addStudent(student);
        Assert.assertTrue(roster_.getSize() == 1);

        controller_.removeStudent(student.getId());
        Assert.assertTrue(roster_.getSize() == 0);

        cmdMgr_.undo();
        Assert.assertTrue(roster_.getSize() == 1);
    }
}
