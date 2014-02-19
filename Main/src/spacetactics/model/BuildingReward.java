package spacetactics.model;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 2/10/14
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuildingReward extends TechnologyReward {

    public BuildingName buildingName;

    @Override
    public void reward(PlayerStats playerStats)
    {
        playerStats.masterBuildQueue.get(this.buildingName).availability = Availability.BUILDABLE;

        updatePlanetBuildQueues(playerStats);
    }

    public void updatePlanetBuildQueues(PlayerStats playerStats)
    {
        for (Planet planet : playerStats.settledPlanets)
        {
            planet.planetaryResources.get(playerStats.masterBuildQueue.get(buildingName).associatedResource).buildingQueue.add(playerStats.masterBuildQueue.get(buildingName));
        }
    }
}
