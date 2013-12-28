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

    public void applyCompletionBonus(PlanetaryResource planetaryResource)
    {
        if (planetaryResource.currentlyBuilding.completionRewardType == "GenericStatMod")
        {
            planetaryResourceController.genericStatMod(planetaryResource);
        }
    }

    public void setPartiallyComplete(PlanetaryResource planetaryResource)
    {

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

        return planetaryResource.currentlyBuilding;
    }

    public void setBuildingComplete(PlanetaryResource planetaryResource)
    {
         planetaryResource.currentlyBuilding.buildingPriority = 0;
        // anything else i need to do here? like, add historical information? call to getBuilding CompletionBonus
    }


}
