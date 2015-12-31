import java.util.*;
import java.util.Collection;

/**
 * Created by Darius on 12/24/2015.
 */
public class Menu<T>
{
    private List<MenuOption<T>> options_;

    public Menu()
    {
        options_ = new ArrayList<>();
    }

    public void addOption(String optionText, T action)
    {
        options_.add(new MenuOption<T>(optionText, action));
    }

    public void displayOptions()
    {

        for(int i = 0; i < options_.size(); ++i)
        {
            String display = "" + (i+1) + ". " + options_.get(i).getText();
            System.out.println(display);
        }
    }

    public T fetchUserCommand()
    {
        System.out.println("Enter the Number of the command");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int lowBound = 1;
        int highBound = options_.size();
        if( ! InputParser.checkBounds(lowBound,
                                highBound,
                                input))
        {
            InputParser.throwError();
            fetchUserCommand();
        }

        return options_.get(input-1).getAction();
    }

    public class MenuOption<T>
    {
        private String text_;
        private T action_;

        MenuOption(String text,
                   T action)
        {
            text_ = text;
            action_ = action;
        }

        String getText()
        {
            return text_;
        }

        T getAction()
        {
            return action_;
        }
    }
}
