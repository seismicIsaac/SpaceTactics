package spacetactics.model;


import java.util.HashMap;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/17/13
 * Time: 12:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Planet {

    private static Random randomNumGenerator = new Random();

    public int xPosition;
    public int yPosition;
    public String imageLocation; //should this go into planetView? yes.
    public int interactHeight; //should this go into planetView? yes.
    public int interactWidth; //should this go into planetView? yes.
    public String starName;

    public HashMap<PlanetaryResourceType, Float> ProductionBonusByResourceType = new HashMap<PlanetaryResourceType, Float>();

    public PlayerSlot settledBy;
    public int maxPopulation;

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

        ProductionBonusByResourceType.put(PlanetaryResourceType.INDUSTRY, getRandomProductionBonus());
        ProductionBonusByResourceType.put(PlanetaryResourceType.ECOLOGY, getRandomProductionBonus());
        ProductionBonusByResourceType.put(PlanetaryResourceType.SCIENCE, getRandomProductionBonus());
    }

    public float getRandomProductionBonus()
    {
        double productionBonus = new Double(Math.abs(1 - randomNumGenerator.nextGaussian()));
        float blah = (float) productionBonus;
        return blah;
    }
}
