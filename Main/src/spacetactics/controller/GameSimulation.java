package spacetactics.controller;

import spacetactics.SpaceTactics;
import spacetactics.model.*;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/28/13
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameSimulation {

    private PlanetaryResourceController planetaryResourceController = new PlanetaryResourceController();
    private PlayerStatsController playerStatsController = new PlayerStatsController();

    public void initializeNewGame(GameData gameData, SpaceTactics spaceTactics)
    {

        gameData.localUniverse = new LocalUniverse(spaceTactics.APPLICATION_WIDTH, spaceTactics.APPLICATION_HEIGHT, spaceTactics);
        gameData.players.put(PlayerSlot.PLAYER1, new PlayerStats(PlayerSlot.PLAYER1));

    }

    public void nextTurn()
    {

    }

    public void settleColony(Planet planet, PlayerStats playerStats)
    {
        planetaryResourceController.initalizeNewColonyResources(planet, playerStats);
        planet.settledBy = playerStats.playerSlot;
    }
}
