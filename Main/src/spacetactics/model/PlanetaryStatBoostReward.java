package spacetactics.model;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 2/10/14
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetaryStatBoostReward extends TechnologyReward {

    public PlanetaryStatName statModified;
    public PlanetaryResourceType resourceTypeOfStat;
    public boolean addToStat;
    public int amountToModifyFloat;
    public int ammountToModifyInt;


    @Override
    public void reward(PlayerStats playerStats)
    {
        switch (statModified)
        {
            case BASE_UNIT_PRODUCTION_MULTIPLIER:
                playerStats.planetaryResourceStats.get(resourceTypeOfStat).baseUnitProductionMultiplier += this.amountToModifyFloat;
                break;
            case BASE_UNIT_COUNT:
                playerStats.planetaryResourceStats.get(resourceTypeOfStat).baseUnitCount += this.ammountToModifyInt;
                break;
            case BASE_UNIT_MAX:
                playerStats.planetaryResourceStats.get(resourceTypeOfStat).baseUnitMax += this.ammountToModifyInt;
                break;
        }
    }
}
