package spacetactics.view.planetobserverscreen;

import spacetactics.SpaceTactics;
import spacetactics.controller.GameSimulation;
import spacetactics.model.PlayerSlot;
import spacetactics.model.PlayerStats;
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

    public PlanetView selectedPlanetView = null;

    private GameSimulation gameSimulation;
    private PlayerStats player1Stats;

    @Override
    public void onClick()
    {
        if (selectedPlanetView.planet.settledBy == null)
        {
            gameSimulation.settleColony(selectedPlanetView.planet, player1Stats);
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

    public SettleColonyButton(int x, int y, int width, int height, String imageLocation, SpaceTactics spaceTactics)
    {
        super(x, y, width, height, imageLocation);
        this.gameSimulation = spaceTactics.gameSimulation;
        this.player1Stats = spaceTactics.gameData.players.get(PlayerSlot.PLAYER1);
    }
}
