package spacetactics.controller;

import spacetactics.model.PlayerStats;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/22/13
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerStatsController {

    public PlanetaryResourceController planetaryResourceController;

    public void annualUpdatePlayerStats(PlayerStats playerStats)
    {
        planetaryResourceController.calculateProductionOnPlanets(playerStats);
    }

    public PlayerStatsController ()
    {
        this.planetaryResourceController = new PlanetaryResourceController();
    }
}
