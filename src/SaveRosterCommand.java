/**
 * Created by Darius on 12/26/2015.
 */
public class SaveRosterCommand extends RosterCommand
{
    /**
     * If this were to go live, we woulnd't want our own serialzer class,
     * and we would just use a library, but I want to
     */
    private SaveRosterStrategy saver_;

    public SaveRosterCommand(Roster roster,
                             SaveRosterStrategy saver)
    {
        super(roster);
        saver_ = saver;
    }

    @Override
    public void execute()
    {
        String fileName = "";

        //use input parser to get it
        getRoster().save(fileName,
                    saver_);
    }
}
