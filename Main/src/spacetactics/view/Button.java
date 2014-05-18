package spacetactics.view;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 1/12/14
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */

public class Button extends UIElement implements Clickable {

    public void onClick()
    {

    }

    public void inView()
    {

    }

    public boolean hitTest(int x, int y)
    {
        return (x >= this.x && x <= this.x + this.width) && (y >= this.y && y <= this.y + this.height);
    }

    @Override
    public void removeFocus() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Button(int x, int y, int width, int height, String imageLocation)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.textureLocation = imageLocation;
    }



}
