package spacetactics.view;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/17/13
 * Time: 12:51 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Clickable {
    public void inView();
    public void onClick();
    public boolean hitTest(int x, int y);
    public void removeFocus();
}


