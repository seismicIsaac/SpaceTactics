package spacetactics.view;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 1/12/14
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */

public class Button implements Clickable {

    public int xPosition;
    public int yPosition;
    public int buttonWidth;
    public int buttonHeight;

    public String imageLocation;

    public void onClick()
    {

    }

    public void inView()
    {

    }

    public boolean hitTest(int x, int y)
    {
        return (x >= this.xPosition && x <= this.xPosition + this.buttonWidth ) && (y >= this.yPosition && y <= this.yPosition + this.buttonHeight);
    }

    @Override
    public void removeFocus() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Button(int x, int y, int width, int height, String imageLocation)
    {
        this.xPosition = x;
        this.yPosition = y;
        this.buttonWidth = width;
        this.buttonHeight = height;
        this.imageLocation = imageLocation;
    }



}
