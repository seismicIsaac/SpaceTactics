package spacetactics.controller;

import spacetactics.SpaceTactics;
import spacetactics.model.Building;
import spacetactics.model.GameData;
import spacetactics.model.LocalUniverse;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/28/13
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameSimulation {

    public void initializeNewGame(GameData gameData, SpaceTactics spaceTactics)
    {
        spaceTactics.dataLoader.loadData(gameData.allBuildings, "data/testBuilding.txt");
        gameData.localUniverse = new LocalUniverse(spaceTactics.APPLICATION_WIDTH, spaceTactics.APPLICATION_HEIGHT);
    }

    public void nextTurn()
    {

    }
}
