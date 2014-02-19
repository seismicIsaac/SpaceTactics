package spacetactics.controller;

import spacetactics.model.Building;
import spacetactics.model.PlanetaryResource;
import spacetactics.model.PlanetaryStatName;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/26/13
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class BuildingController {

    public GameSimulation gameSimulation;

    public BuildingController(GameSimulation gameSimulation)
    {
        this.gameSimulation = gameSimulation;
    }

    public void applyCompletionBonus(PlanetaryResource planetaryResource)
    {
        if (planetaryResource.currentlyBuilding.completionRewardType == Building.CompletionRewardType.GENERIC_STAT_MOD)
        {
            gameSimulation.planetaryResourceController.genericStatMod(planetaryResource);
        }
    }

    public void pickBuilding(PlanetaryResource planetaryResource, Building building)
    {
        planetaryResource.currentlyBuilding = building;
    }

    public Building pickNextQueuedBuilding(PlanetaryResource planetaryResource)
    {
        for (Building building : planetaryResource.buildingQueue)
        {
            if (building.buildingPriority > planetaryResource.currentlyBuilding.buildingPriority)
            {
                planetaryResource.currentlyBuilding = building;
            }
        }

        if (planetaryResource.currentlyBuilding.buildingPriority == 0)
        {
            Building building = new Building("<Nothing>", planetaryResource.resourceType, 10000000, 1, false, PlanetaryStatName.NONE, Building.CompletionRewardType.GENERIC_STAT_MOD, 0);
            planetaryResource.buildingQueue.add(building);
            planetaryResource.currentlyBuilding = building;
        }

        return planetaryResource.currentlyBuilding;
    }

    public void setBuildingComplete(PlanetaryResource planetaryResource)
    {
        planetaryResource.currentlyBuilding.buildingPriority = 0;
        planetaryResource.currentlyBuilding.progress = planetaryResource.currentlyBuilding.cost;
    }


}
