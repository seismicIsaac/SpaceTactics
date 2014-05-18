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

    private final String initialBuildingsFileName = "data/initialBuildings.txt";
    private final String initialTechnologyListFileName = "data/technologyList.txt";
    private final TechnologyInternalName initiallyResearching = TechnologyInternalName.FACTORY_COST_10;
    private final DataLoader dataLoader = new DataLoader();

    public GameSimulation gameSimulation;

    public void annualUpdatePlayerStats(PlayerStats playerStats)
    {
        gameSimulation.planetaryResourceController.calculateProductionOnPlanets(playerStats);
    }

    public void updateMasterBuildQueue()
    {

    }

    public void initializePlayerStats(PlayerSlot playerSlot, HashMap<PlayerSlot, PlayerStats> players){
        PlayerStats playerStats = new PlayerStats();
        playerStats.playerSlot = playerSlot;
        playerStats.planetaryResourceStats = getInitialPlanetaryResources();
        playerStats.masterBuildQueue = getInitialBuildQueue();
        playerStats.allResearchableTechnologies = getInitialResearchableTech();
        gameSimulation.technologyController.pickSomethingToResearch(playerStats, playerStats.allResearchableTechnologies.get(initiallyResearching));

        for (Building building: playerStats.masterBuildQueue.values())
        {
            playerStats.planetaryResourceStats.get(building.associatedResource).buildingQueue.add(building);
            playerStats.planetaryResourceStats.get(building.associatedResource).currentlyBuilding = building;
        }

        players.put(playerSlot, playerStats);
    }

    public HashMap<BuildingName, Building> getInitialBuildQueue() {
        ArrayList<Building> initialBuildQueue = dataLoader.returnListFromDataFile(initialBuildingsFileName);
        HashMap<BuildingName, Building> initialBuildings = new HashMap<BuildingName, Building>();

        for (Building building : initialBuildQueue)
        {
            initialBuildings.put(building.buildingInternalName, building);
        }

        return initialBuildings;
    }

    public HashMap<PlanetaryResourceType, PlanetaryResource> getInitialPlanetaryResources() {
        HashMap<PlanetaryResourceType, PlanetaryResource> initialResources = new HashMap<PlanetaryResourceType, PlanetaryResource>();
        PlanetaryResource industry = new PlanetaryResource(PlanetaryResourceType.INDUSTRY);
        PlanetaryResource ecology = new PlanetaryResource(PlanetaryResourceType.ECOLOGY);
        PlanetaryResource science = new PlanetaryResource(PlanetaryResourceType.SCIENCE);
        initialResources.put(industry.resourceType, industry);
        initialResources.put(ecology.resourceType, ecology);
        initialResources.put(science.resourceType, science);

        return initialResources;
    }

    public HashMap<TechnologyInternalName, Technology> getInitialResearchableTech() {
        ArrayList<Technology> technologies = dataLoader.returnListFromDataFile(initialTechnologyListFileName);

        HashMap<TechnologyInternalName, Technology> allResearchableTech = new HashMap<TechnologyInternalName, Technology>();

        for ( Technology technology : technologies) {
            allResearchableTech.put(technology.internalName, technology);
        }

        return allResearchableTech;
    }

    public PlayerStatsController(GameSimulation gameSimulation)
    {
        this.gameSimulation = gameSimulation;
    }
}
