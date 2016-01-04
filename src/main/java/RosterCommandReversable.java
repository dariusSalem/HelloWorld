/**
 * Created by Darius on 1/3/2016.
 */
public abstract class RosterCommandReversable implements RosterCommand
{
    private boolean executed_ = true;

    /**
     * Why make roster private and create a protected getter?
     * Forces users to use this method, which can be easily searched for to see
     * where in the interface/parent chain the variable roster comes from.
     * @return
     */

    public void execute()
    {
        implExecute();
        executed_ = true;
    }

    public abstract void implExecute();
    public abstract void implUndo();

    public void undo()
    {
        if(! executed_)
        {
            return;
        }
        implUndo();
    }
}
