package spacetactics.view.planetobserverscreen;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/17/13
 * Time: 12:52 AM
 * To change this template use File | Settings | File Templates.
 */

import spacetactics.model.Planet;
import spacetactics.view.Button;
import spacetactics.view.Clickable;

public class PlanetView extends Button implements Clickable
{
    public PlanetObserverScreen planetObserverScreen;
    public Planet planet;
    public boolean isSelected = false;

    public void planetStatDisplay()
    {
//        planetObserverScreen.spaceTactics.batch.

    }

    @Override
    public void onClick() {
        isSelected = true;
        planetObserverScreen.selectedPlanetView = this;
    }

    @Override
    public void inView() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean hitTest(int x, int y) {
        return super.hitTest(x, y);
    }

    @Override
    public void removeFocus() {
        isSelected = false;
    }

    public PlanetView(Planet planet, PlanetObserverScreen planetObserverScreen)
    {
       super(planet.xPosition, planet.yPosition, planet.interactWidth, planet.interactWidth, planet.imageLocation);
       this.planet = planet;
       this.planetObserverScreen = planetObserverScreen;
    }
}
