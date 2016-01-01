import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by Darius on 12/31/2015.
 */
public class TestRunner
{
    public static void main(String... args)
    {

        Result result = JUnitCore.runClasses(StudentTest.class);
        for(Failure failure : result.getFailures())
        {
            System.out.println(failure);
        }

    }
}