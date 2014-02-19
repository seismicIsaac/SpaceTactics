package spacetactics.view.planetobserverscreen;

import spacetactics.SpaceTactics;
import spacetactics.controller.GameSimulation;
import spacetactics.model.PlayerStats;
import spacetactics.view.Button;
import spacetactics.view.Clickable;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 1/12/14
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class NextTurnButton extends Button implements Clickable {

    private Collection<PlayerStats> allPlayerStats;
    private GameSimulation gameSimulation;

    @Override
    public void onClick()
    {
        gameSimulation.nextTurn(allPlayerStats);
    }

    @Override
    public boolean hitTest(int x, int y) {
        return super.hitTest(x, y);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void inView() {
        super.inView();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public NextTurnButton(int x, int y, int width, int height, String imageLocation, SpaceTactics spaceTactics)
    {
        super(x, y, width, height, imageLocation);
        this.allPlayerStats = spaceTactics.gameData.players.values();
        this.gameSimulation = spaceTactics.gameSimulation;
    }
}
