package spacetactics.view.planetobserverscreen;

import spacetactics.model.PlayerSlot;
import spacetactics.view.Button;
import spacetactics.view.Clickable;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 1/12/14
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class SettleColonyButton extends Button implements Clickable {

    private PlanetObserverScreen planetObserverScreen;

    @Override
    public void onClick() {
        System.out.println("Settle Colony");
        if (planetObserverScreen.selectedPlanetView.planet.settledBy == null)
        {
            planetObserverScreen.spaceTactics.gameSimulation.settleColony(planetObserverScreen.selectedPlanetView.planet, planetObserverScreen.spaceTactics.gameData.players.get(PlayerSlot.PLAYER1));
        }
        else
        {
            System.out.println("Already Settled by Player 1");
        }

    }

    @Override
    public boolean hitTest(int x, int y) {
        return super.hitTest(x, y);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void inView() {
        super.inView();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public SettleColonyButton(int x, int y, int width, int height, String imageLocation, PlanetObserverScreen planetObserverScreen)
    {
        super(x, y, width, height, imageLocation);
        this.planetObserverScreen = planetObserverScreen;
    }
}
