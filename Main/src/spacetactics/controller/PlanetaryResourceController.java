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

    public GameSimulation gameSimulation;

    private Json json = new Json();

    public void calculateProductionOnPlanets(PlayerStats playerStats)
    {
        for (Planet planet : playerStats.settledPlanets)
        {
            int researchPointsBudget = 0;

            for (PlanetaryResourceType planetaryResourceType : PlanetaryResourceType.values())
            {
                float budget = getResourceProduction(planet.planetaryResources.get(planetaryResourceType));

                if (planetaryResourceType == PlanetaryResourceType.SCIENCE)
                {
                    researchPointsBudget += budget;
                }

                if (planet.planetaryResources.get(planetaryResourceType).currentlyBuilding.buildingName != "<Nothing>");
                {
                    processBuildingRequest(budget, planet.planetaryResources.get(planetaryResourceType));
                }
            }

            gameSimulation.technologyController.processResearchPoints(playerStats, researchPointsBudget);
        }
    }

    public void processBuildingRequest(float budget, PlanetaryResource planetaryResource)
    {
        if (budget + planetaryResource.currentlyBuilding.progress >= planetaryResource.currentlyBuilding.cost)
        {
            gameSimulation.buildingController.setBuildingComplete(planetaryResource);
            gameSimulation.buildingController.applyCompletionBonus(planetaryResource);
            budget = budget + planetaryResource.currentlyBuilding.progress - planetaryResource.currentlyBuilding.cost;
            planetaryResource.currentlyBuilding = gameSimulation.buildingController.pickNextQueuedBuilding(planetaryResource);
            processBuildingRequest(budget, planetaryResource);

        }
        else if (budget + planetaryResource.currentlyBuilding.progress < planetaryResource.currentlyBuilding.cost)
        {
            planetaryResource.currentlyBuilding.progress += budget;

            if (planetaryResource.currentlyBuilding.partialBonus)
            {
               gameSimulation.buildingController.applyCompletionBonus(planetaryResource);
            }
        }
    }

    public void processResearchPoints(PlayerStats playerStats, int researchPoints)
    {

    }

    public float getResourceProduction(PlanetaryResource planetaryResource)
    {
        System.out.println("Production: " + planetaryResource.baseUnitCount * planetaryResource.baseUnitProductionMultiplier * planetaryResource.innatePlanetBonus * planetaryResource.planetarySpending);

        return (planetaryResource.baseUnitCount * planetaryResource.baseUnitProductionMultiplier * planetaryResource.innatePlanetBonus * planetaryResource.planetarySpending);
    }

    public void genericStatMod(PlanetaryResource planetaryResource)
    {
        if (planetaryResource.currentlyBuilding.statModified == PlanetaryStatName.BASE_UNIT_PRODUCTION_MULTIPLIER)
        {
            planetaryResource.baseUnitCount += calculateStatModification(planetaryResource);
        }

        if (planetaryResource.currentlyBuilding.statModified == PlanetaryStatName.BASE_UNIT_MAX)
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

    public void initalizeNewColonyResources(Planet planet, PlayerStats playerStats)
    {
        HashMap<PlanetaryResourceType, PlanetaryResource> initialPlanetaryResources = new HashMap<PlanetaryResourceType, PlanetaryResource>();
        System.out.println("Setting new resources");
        PlanetaryResource industry = new PlanetaryResource(planet, playerStats, PlanetaryResourceType.INDUSTRY);
        initialPlanetaryResources.put(PlanetaryResourceType.INDUSTRY, industry);
        gameSimulation.buildingController.pickBuilding(industry, industry.buildingQueue.get(0));
        PlanetaryResource science = new PlanetaryResource(planet, playerStats, PlanetaryResourceType.SCIENCE);
        initialPlanetaryResources.put(PlanetaryResourceType.SCIENCE, science);
        gameSimulation.buildingController.pickBuilding(science, science.buildingQueue.get(0));
        PlanetaryResource ecology = new PlanetaryResource(planet, playerStats, PlanetaryResourceType.ECOLOGY);
        initialPlanetaryResources.put(PlanetaryResourceType.ECOLOGY, ecology);
        gameSimulation.buildingController.pickBuilding(ecology, ecology.buildingQueue.get(0));

        planet.planetaryResources = initialPlanetaryResources;
    }

    public PlanetaryResourceController(GameSimulation gameSimulation)
    {
        this.gameSimulation = gameSimulation;
    }
}
