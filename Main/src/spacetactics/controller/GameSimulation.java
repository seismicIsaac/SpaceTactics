package spacetactics.controller;

import spacetactics.SpaceTactics;
import spacetactics.model.*;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/28/13
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameSimulation {

    public PlayerStatsController playerStatsController;
    public PlanetaryResourceController planetaryResourceController;
    public BuildingController buildingController;
    public TechnologyController technologyController;
    public DataLoader dataLoader;

    public void nextTurn(Collection<PlayerStats> allPlayerStats)
    {
        for (PlayerStats playerStats : allPlayerStats)
        {
            planetaryResourceController.calculateProductionOnPlanets(playerStats);
        }
    }

    public void settleColony(Planet planet, PlayerStats playerStats)
    {
        planetaryResourceController.initalizeNewColonyResources(planet, playerStats);
        playerStats.settledPlanets.add(planet);
        planet.settledBy = playerStats.playerSlot;
    }

    public void initializeNewGame(GameData gameData, SpaceTactics spaceTactics)
    {
        gameData.localUniverse = new LocalUniverse(spaceTactics.APPLICATION_WIDTH, spaceTactics.APPLICATION_HEIGHT, spaceTactics);
        playerStatsController.initializePlayerStats(PlayerSlot.PLAYER1, gameData.players);
    }

    public GameSimulation()
    {
        playerStatsController = new PlayerStatsController(this);
        planetaryResourceController = new PlanetaryResourceController(this);
        buildingController = new BuildingController(this);
        technologyController = new TechnologyController(this);
    }
}
