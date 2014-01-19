package spacetactics.model;

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

    public int prodPerFactory = 1;

    public String playerName;
    public String playerSlot;
    public HashMap<PlanetaryResourceType, PlanetaryResource> planetaryResourceStats = new HashMap<PlanetaryResourceType, PlanetaryResource>();
    public ArrayList<Planet> settledPlanets;
    public ArrayList<Technology> researchedTechnologies;

    public PlayerStats()
    {

    }

}
