/**
 * Created by Darius on 12/30/2015.
 * Job is to facillitate communication with the display.
 * A display could be any kind of display we choose(gui, console, web page, etc)
 */
public class DisplayManager
{
    private Display display_;

    public DisplayManager(Display display)
    {
        display_ = display;
    }

    public void showDisplay()
    {
        display_.showDisplay();
    }
}
