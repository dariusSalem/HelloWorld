import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Darius on 1/3/2016.
 */
public class ModifyStudentControllerTest
{
    private Roster roster_;
    private ModifyStudentController controller_;
    private CommandManager cmdMgr_;
    private Student student_;
    @Before
    public void init()
    {
        roster_ = new Roster();
        cmdMgr_ = new CommandManager();
        controller_ = new ModifyStudentController(roster_, cmdMgr_);
        student_ = new Student(1, 20, "First", "Name");
        roster_.addStudent(student_);

    }

    @Test
    public void modifyAgeTest()
    {
        controller_.modifyAge(student_.getId(), 30);
        Assert.assertTrue(roster_.getStudent(1).getAge() == 30);
        cmdMgr_.undo();
        Assert.assertTrue(roster_.getStudent(1).getAge() == 20);
    }

    @Test
    public void modifyFirstNameTest()
    {
        controller_.modifyFirstName(student_.getId(), "NewName");
        Assert.assertTrue(roster_.getStudent(1).getFirstName().equals("NewName"));
        cmdMgr_.undo();
        Assert.assertTrue(roster_.getStudent(1).getFirstName().equals("First"));
    }

    @Test
    public void modifyLastNameTest()
    {
        controller_.modifyLastName(student_.getId(), "NewName");
        Assert.assertTrue(roster_.getStudent(1).getLastName().equals("NewName"));
        cmdMgr_.undo();
        Assert.assertTrue(roster_.getStudent(1).getLastName().equals("Name"));
    }

}
