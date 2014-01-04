package spacetactics.controller;

import spacetactics.model.Planet;
import spacetactics.model.PlanetaryResource;
import spacetactics.model.PlayerStats;
import spacetactics.model.Technology;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/22/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetaryResourceController {

    public BuildingController buildingController;

    public PlanetaryResourceController()
    {
        BuildingController buildingController = new BuildingController(this);
        this.buildingController = buildingController;
    }

    public void calculateProductionOnPlanets(PlayerStats playerStats)
    {
        for (Planet planet : playerStats.settledPlanets)
        {
            for (PlanetaryResource planetaryResource : planet.planetaryResources)
            {
                float budget = getResourceProduction(planetaryResource);

                if (planetaryResource.currentlyBuilding.buildingName != "<Nothing>")
                {
                    processBuildingRequest(budget, planetaryResource);
                }
            }
        }
    }

    public void processBuildingRequest(float budget, PlanetaryResource planetaryResource)
    {
        if (budget + planetaryResource.currentlyBuilding.progress >= planetaryResource.currentlyBuilding.cost)
        {
            //get bonus for building completion

            buildingController.setBuildingComplete(planetaryResource);
            buildingController.applyCompletionBonus(planetaryResource);

            //calculate remainder
            budget = budget + planetaryResource.currentlyBuilding.progress - planetaryResource.currentlyBuilding.cost;

            //pick next building in building queue
            planetaryResource.currentlyBuilding = buildingController.pickNextBuilding(planetaryResource);

            //do i have enough to complete that building too?
            processBuildingRequest(budget, planetaryResource);

        }
        else if (budget + planetaryResource.currentlyBuilding.progress < planetaryResource.currentlyBuilding.cost)
        {
            planetaryResource.currentlyBuilding.progress += budget;

            if (planetaryResource.currentlyBuilding.partialBonus)
            {
               buildingController.applyCompletionBonus(planetaryResource);
            }
        }
    }

    public float getResourceProduction(PlanetaryResource planetaryResource)
    {
        System.out.println("Production: " + planetaryResource.baseUnitCount * planetaryResource.baseUnitProductionMultiplier * planetaryResource.innatePlanetBonus * planetaryResource.planetarySpending);
        return (planetaryResource.baseUnitCount * planetaryResource.baseUnitProductionMultiplier * planetaryResource.innatePlanetBonus * planetaryResource.planetarySpending);
    }

    public void genericStatMod(PlanetaryResource planetaryResource)
    {
        if (planetaryResource.currentlyBuilding.statModified == "baseUnitCount")
        {
            planetaryResource.baseUnitCount += calculateStatModification(planetaryResource);
            System.out.println("attempted to modify baseUnitCount");
        }

        if (planetaryResource.currentlyBuilding.statModified == "baseUnitMax")
        {
            planetaryResource.baseUnitMax += calculateStatModification(planetaryResource);
        }
    }

    public int calculateStatModification(PlanetaryResource planetaryResource)
    {
        float percentComplete = (float)(planetaryResource.currentlyBuilding.progress) / (float)(planetaryResource.currentlyBuilding.cost);
        int statModification = (int)((planetaryResource.currentlyBuilding.completionValue * percentComplete)) - planetaryResource.currentlyBuilding.partialCompletionPayedSoFar;

        if (planetaryResource.currentlyBuilding.partialBonus)
        {
            planetaryResource.currentlyBuilding.partialCompletionPayedSoFar += statModification;
        }

        return statModification;
    }                               // this works for partial bonus too. should probably test it with weird edge cases and i'm not sure how java is going to handle the maths.

    public void updateBuildQueue(PlanetaryResource planetaryResource, ArrayList<Technology> playerTechnologies)
    {

    }
}
