import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Darius on 12/31/2015.
 */

public class StudentTest
{
    private Student student_;

    @Test
    public void ctorTest()
    {
        Assert.assertTrue(student_ != null);
    }

    @Test
    public void copyCtorTest()
    {
        Student studentCopy = new Student(student_);
        Assert.assertEquals(studentCopy,student_);
    }

    @Before
    public void initTest()
    {
        student_ = new Student(1,10, "Firstname", "Lastname");
    }

    @After
    public void dtor()
    {
        student_ = null;
    }

}
