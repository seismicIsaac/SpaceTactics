package spacetactics.model;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 2/7/14
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TechnologyReward {

    public enum RewardType{
        BUILDING_UNLOCK, SHIP_COMPONENT_UNLOCK, PLANETARY_STAT_BOOST
    }

    public RewardType type;

    public void reward(PlayerStats playerStats)
    {

    }
}
