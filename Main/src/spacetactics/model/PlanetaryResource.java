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

    public float planetarySpending;
    public float innatePlanetBonus;
    public int flatProduction;
    public int resourceSaved;
    public int baseUnitCost;
    public int baseUnitCount;
    public float baseUnitProductionMultiplier;
    public int baseUnitMax;
    public int baseUnitCurrent;
    public int currentDebt;
    public ArrayList<Building> buildingQueue = new ArrayList<Building>();
    public Building currentlyBuilding;


}
