/**
 * Created by Darius on 12/26/2015.
 */
import java.io.File;

public interface SaveRosterStrategy
{
    public void save(String fileName,
                     Roster roster);
}
