package spacetactics.view.planetobserverscreen;

import spacetactics.view.Button;
import spacetactics.view.Clickable;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 1/12/14
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class NextTurnButton extends Button implements Clickable {

    private PlanetObserverScreen planetObserverScreen;

    @Override
    public void onClick() {
        System.out.println("Next turn...");

    }

    @Override
    public boolean hitTest(int x, int y) {
        return super.hitTest(x, y);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void inView() {
        super.inView();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public NextTurnButton(int x, int y, int width, int height, String imageLocation, PlanetObserverScreen planetObserverScreen)
    {
        super(x, y, width, height, imageLocation);
        this.planetObserverScreen = planetObserverScreen;
    }
}
