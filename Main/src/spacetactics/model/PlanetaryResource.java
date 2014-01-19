package spacetactics.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/21/13
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetaryResource {

    public PlanetaryResourceType resourceType;  //preset
    public float planetarySpending;             //preset
    public float innatePlanetBonus;             //defined by planet
    public int flatProduction;                  //defined by player stats
    public int baseUnitCost;                    //defined by player stats
    public int baseUnitCount;                   //defined by player stats
    public float baseUnitProductionMultiplier;  //defined by player stats
    public int baseUnitMax;                     //defined by planet & player stats
    public int baseUnitSize;                    //defined by player stats
    public ArrayList<Building> buildingQueue = new ArrayList<Building>();//defined by player stats
    public Building currentlyBuilding;          //defined by player stats

    public PlanetaryResource(Planet planet, PlayerStats playerStats, PlanetaryResourceType planetaryResourceType)     //used for settling a colony/seeding a planet resources with players tech level
    {
        this.resourceType = planetaryResourceType;
        this.flatProduction = playerStats.planetaryResourceStats.get(planetaryResourceType).flatProduction;
        this.baseUnitCost = playerStats.planetaryResourceStats.get(planetaryResourceType).baseUnitCost;
        this.baseUnitCount = playerStats.planetaryResourceStats.get(planetaryResourceType).baseUnitCount;
        this.baseUnitProductionMultiplier = playerStats.planetaryResourceStats.get(planetaryResourceType).baseUnitProductionMultiplier;
        this.baseUnitMax = planet.maxPopulation / playerStats.planetaryResourceStats.get(planetaryResourceType).baseUnitSize;
        this.buildingQueue = playerStats.planetaryResourceStats.get(planetaryResourceType).buildingQueue;
    }

    public PlanetaryResource()
    {

    }

}
