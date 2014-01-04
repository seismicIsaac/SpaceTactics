package spacetactics.controller;

import spacetactics.model.Building;
import spacetactics.model.PlanetaryResource;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/26/13
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class BuildingController {

    public PlanetaryResourceController planetaryResourceController;

    public BuildingController(PlanetaryResourceController planetaryResourceController)
    {
        this.planetaryResourceController = planetaryResourceController;
    }

    public void applyCompletionBonus(PlanetaryResource planetaryResource)
    {
        if (planetaryResource.currentlyBuilding.completionRewardType == "GenericStatMod")
        {
            planetaryResourceController.genericStatMod(planetaryResource);
        }
    }

    public Building pickNextBuilding(PlanetaryResource planetaryResource)
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
            Building building = new Building("<Nothing>", planetaryResource.resourceName, 10000000, 1, false, "None", "None", 0);
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
