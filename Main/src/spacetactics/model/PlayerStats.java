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

    public String playerName;
    public PlayerSlot playerSlot;
    public HashMap<PlanetaryResourceType, PlanetaryResource> planetaryResourceStats = new HashMap<PlanetaryResourceType, PlanetaryResource>();
    public HashMap<TechnologyInternalName, Technology> allResearchableTechnologies = new HashMap<TechnologyInternalName, Technology>();
    public HashMap<BuildingName, Building> masterBuildQueue = new HashMap<BuildingName, Building>();
    public ArrayList<Planet> settledPlanets = new ArrayList<Planet>();
    public Technology currentlyResearching;

}
