package spacetactics.controller;

import com.badlogic.gdx.utils.Json;
import spacetactics.model.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/22/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetaryResourceController {

    public BuildingController buildingController;
    private Json json = new Json();

    public void initalizeNewColonyResources(Planet planet, PlayerStats playerStats)
    {
        HashMap<PlanetaryResourceType, PlanetaryResource> initialPlanetaryResources = new HashMap<PlanetaryResourceType, PlanetaryResource>();

        PlanetaryResource industry = new PlanetaryResource(planet, playerStats, PlanetaryResourceType.INDUSTRY);
        initialPlanetaryResources.put(PlanetaryResourceType.INDUSTRY, industry);
        PlanetaryResource science = new PlanetaryResource(planet, playerStats, PlanetaryResourceType.SCIENCE);
        initialPlanetaryResources.put(PlanetaryResourceType.SCIENCE, science);
        PlanetaryResource ecology = new PlanetaryResource(planet, playerStats, PlanetaryResourceType.ECOLOGY);
        initialPlanetaryResources.put(PlanetaryResourceType.ECOLOGY, ecology);

        planet.planetaryResources = initialPlanetaryResources;
    }

    public void calculateProductionOnPlanets(PlayerStats playerStats)
    {
        for (Planet planet : playerStats.settledPlanets)
        {
            for (PlanetaryResourceType planetaryResourceType : PlanetaryResourceType.values())
            {
                float budget = getResourceProduction(planet.planetaryResources.get(planetaryResourceType));

                if (planet.planetaryResources.get(planetaryResourceType).currentlyBuilding.buildingName != "<Nothing>");
                {
                    processBuildingRequest(budget, planet.planetaryResources.get(planetaryResourceType));
                }
            }
        }
    }

    public void processBuildingRequest(float budget, PlanetaryResource planetaryResource)
    {
        if (budget + planetaryResource.currentlyBuilding.progress >= planetaryResource.currentlyBuilding.cost)
        {
            buildingController.setBuildingComplete(planetaryResource);
            buildingController.applyCompletionBonus(planetaryResource);
            budget = budget + planetaryResource.currentlyBuilding.progress - planetaryResource.currentlyBuilding.cost;
            planetaryResource.currentlyBuilding = buildingController.pickNextBuilding(planetaryResource);
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
        if (planetaryResource.currentlyBuilding.statModified == Building.StatModified.BASE_UNIT_COUNT)
        {
            planetaryResource.baseUnitCount += calculateStatModification(planetaryResource);
        }

        if (planetaryResource.currentlyBuilding.statModified == Building.StatModified.BASE_UNIT_MAX)
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
    }

    public void updateBuildQueue(PlanetaryResource planetaryResource, ArrayList<Technology> playerTechnologies)
    {

    }

    public PlanetaryResourceController()
    {
        BuildingController buildingController = new BuildingController(this);
        this.buildingController = buildingController;
    }
}
