import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Darius on 1/1/2016.
 */
public class RosterTest
{
    private Roster roster_;

    @Before
    public void init()
    {
        roster_ = new Roster();
    }

    @Test
    public void emptyCtorTest()
    {
        Assert.assertNotNull(roster_);
    }

    @Test
    public void injectionCtorTest()
    {
        Roster temp = new Roster(addStudents());
        Assert.assertNotNull(temp);
    }

    @Test
    public void copyCtorTest()
    {
        roster_.addStudent(addStudent());
        Roster temp = new Roster(roster_);
        Assert.assertTrue(roster_ != temp);
        Assert.assertTrue(roster_.equals(temp));
        roster_.removeStudent(1);
        Assert.assertFalse(roster_.equals(temp));
    }

    @Test
    public void initTest()
    {
        Assert.assertTrue(roster_.getSize() == 0);
    }

    @Test
    public void addStudentTest()
    {
        roster_.addStudent(addStudent());
        Assert.assertTrue(roster_.getSize() == 1);
    }

    @Test
    public void removeStudentTest()
    {
        roster_.addStudent((addStudent()));
        roster_.removeStudent(1);
        Assert.assertTrue(roster_.getSize() == 0);
    }

    public List<Student>  addStudents()
    {
        ArrayList<Student> temp = new ArrayList<>();
        temp.add(new Student(1, 10, "John", "Doe"));
        temp.add(new Student(2, 15, "Jane", "Doe"));
        temp.add(new Student(3, 20, "Bob", "Doe"));
        return temp;
    }

    public Student addStudent()
    {
        return new Student(1, 10, "John", "Doe");
    }


}