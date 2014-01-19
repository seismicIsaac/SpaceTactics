package spacetactics.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/17/13
 * Time: 12:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Planet {

    public int xPosition;
    public int yPosition;
    public String imageLocation; //should this go into planetView? yes.
    public int interactHeight; //should this go into planetView? yes.
    public int interactWidth; //should this go into planetView? yes.
    public String starName;

    private float growthBonus;
    private float researchBonus;
    private float productionBonus;
    // could add a bunch more specific bonuses but this is simple enough for now.

    public String settledBy;
    public int currentPopulation;
    public final int maxPopulation;

    public int factoryCount;
    public int factoriesMax;
    public HashMap<PlanetaryResourceType, PlanetaryResource> planetaryResources = new HashMap<PlanetaryResourceType, PlanetaryResource>();

    public Planet(int x, int y, String imageLocation, int height, int width, String planetType, int maxPop)
    {
        this.xPosition = x;
        this.yPosition = y;
        this.imageLocation = imageLocation;
        this.interactHeight = height;
        this.interactWidth = width;
        this.starName = planetType;
        this.maxPopulation = maxPop;
    }

    public void update(PlayerStats playerStats)
    {
       // making up some calculations for updating stats
       // Factory/prod first
       float planetProduction = getProductionFromFactories(playerStats);


    }

    public void divideSpending()
    {

    }

    public float getProductionFromFactories(PlayerStats playerStats)
    {
        return factoryCount * playerStats.prodPerFactory * productionBonus; //* planetarySpendingRatio("production");
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }
}
