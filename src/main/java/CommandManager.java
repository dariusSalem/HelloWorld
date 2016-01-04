import java.util.Stack;

/**
 * Created by Darius on 12/25/2015.
 *
 * A way to improve this would be to make it so that the command manager is
 * the only one capable of creating commands, to ensure we always follow the right steps
 */
public class CommandManager
{
    private Stack<RosterCommandReversable> cmdStack_;

    public CommandManager()
    {
        cmdStack_ = new Stack<>();
    }

    public void executeCommand(RosterCommand cmd)
    {
        cmd.execute();
    }

    public void executeCommand(RosterCommandReversable cmd)
    {
        cmd.execute();
        cmdStack_.push(cmd);
    }

    public void undo()
    {
        cmdStack_.pop().undo();
    }
}
