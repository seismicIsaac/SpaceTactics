package spacetactics.model;

import spacetactics.controller.DataLoader;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/21/13
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerStats {

    private final String initialBuildingsFileName = "data/initialBuildings.txt";
    private DataLoader dataLoader = new DataLoader();

    public String playerName;
    public PlayerSlot playerSlot;
    public HashMap<PlanetaryResourceType, PlanetaryResource> planetaryResourceStats = new HashMap<PlanetaryResourceType, PlanetaryResource>();
    public HashMap<TechnologyInternalName, Technology> allResearchableTechnologies = new HashMap<TechnologyInternalName, Technology>();
    public HashMap<BuildingName, Building> masterBuildQueue = new HashMap<BuildingName, Building>();
    public ArrayList<Planet> settledPlanets = new ArrayList<Planet>();
    public Technology currentlyResearching;

    public PlayerStats(PlayerSlot playerSlot)
    {
        this.playerSlot = playerSlot;
        this.planetaryResourceStats = getInitialPlanetaryResources();
        this.masterBuildQueue = getInitialBuildQueue();

        for (Building building: masterBuildQueue.values())
        {
            planetaryResourceStats.get(building.associatedResource).buildingQueue.add(building);
            planetaryResourceStats.get(building.associatedResource).currentlyBuilding = building;
        }
    }

    public HashMap<PlanetaryResourceType, PlanetaryResource> getInitialPlanetaryResources()
    {
        HashMap<PlanetaryResourceType, PlanetaryResource> initialResources = new HashMap<PlanetaryResourceType, PlanetaryResource>();
        PlanetaryResource industry = new PlanetaryResource(PlanetaryResourceType.INDUSTRY);
        PlanetaryResource ecology = new PlanetaryResource(PlanetaryResourceType.ECOLOGY);
        PlanetaryResource science = new PlanetaryResource(PlanetaryResourceType.SCIENCE);
        initialResources.put(industry.resourceType, industry);
        initialResources.put(ecology.resourceType, ecology);
        initialResources.put(science.resourceType, science);

        return initialResources;
    }

    public HashMap<BuildingName, Building> getInitialBuildQueue()
    {
        ArrayList<Building> initialBuildQueue = dataLoader.returnListFromDataFile(initialBuildingsFileName);
        HashMap<BuildingName, Building> initialBuildings = new HashMap<BuildingName, Building>();

        for (Building building : initialBuildQueue)
        {
            initialBuildings.put(building.buildingInternalName, building);
        }

        return initialBuildings;
    }


}
