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

    public PlanetaryResourceController planetaryResourceController;
    public DataLoader dataLoader = new DataLoader();

    public void annualUpdatePlayerStats(PlayerStats playerStats)
    {
        planetaryResourceController.calculateProductionOnPlanets(playerStats);
    }

    public void updateMasterBuildQueue()
    {

    }

    public PlayerStatsController ()
    {
        this.planetaryResourceController = new PlanetaryResourceController();
    }
}
