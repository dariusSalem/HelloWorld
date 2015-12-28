/**
 * Created by Darius on 12/26/2015.
 */
public class SaveRosterCommand implements RosterCommand
{
    /**
     * If this were to go live, we woulnd't want our own serialzer class,
     * and we would just use a library, but I want to
     */
    private SaveRosterStrategy saver_;

    public SaveRosterCommand(SaveRosterStrategy saver)
    {
        saver_ = saver;
    }

    @Override
    public void execute(Roster roster)
    {
        String fileName = "";

        //use input parser to get it
        roster.save(fileName,
                    saver_);
    }
}
