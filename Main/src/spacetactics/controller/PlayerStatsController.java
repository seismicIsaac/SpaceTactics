package spacetactics.controller;

import spacetactics.model.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/22/13
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerStatsController {

    private final String initialBuildingsFileName = "data/initialBuildings";

    public GameSimulation gameSimulation;

    public void annualUpdatePlayerStats(PlayerStats playerStats)
    {
        gameSimulation.planetaryResourceController.calculateProductionOnPlanets(playerStats);
    }

    public void updateMasterBuildQueue()
    {

    }

    public PlayerStatsController(GameSimulation gameSimulation)
    {
        this.gameSimulation = gameSimulation;
    }
}
