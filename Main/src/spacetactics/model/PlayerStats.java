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

    private int terraformingBonus;
    private int productionBonus;
    private int researchBonus;

    public int factoryCost;
    public int prodPerFactory;

    public int colonistCost;
    public int prodPerColonist;

    public ArrayList<Planet> settledPlanets;

    public void annualStatUpdate()
    {
        for (Planet planet : settledPlanets)
        {
            planet.update(this);
        }
    }

}
