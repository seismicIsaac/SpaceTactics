package spacetactics.model;

import spacetactics.controller.DataLoader;
import spacetactics.controller.GameSimulation;
import spacetactics.controller.PlayerStatsController;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/28/13
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameData {

    public GameSimulation gameSimulation;
    public LocalUniverse localUniverse;
    public ArrayList<Building> allBuildings;
    public ArrayList<Technology> allTechnologies;
    public HashMap<PlayerSlot, PlayerStats> players = new HashMap<PlayerSlot, PlayerStats>();

    public GameData(GameSimulation gameSimulation)
    {
        this.gameSimulation = gameSimulation;
    }




}
