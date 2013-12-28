package spacetactics.model;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/24/13
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Building {

    public int cost;
    public int progress;
    public int buildingPriority;  // 0 = completed, 1 = default/nothing to build
    public int currentStatus;
    public boolean partialBonus;
    public String statModified;
    public String completionRewardType;
    public int completionValue;
    public int partialCompletionPayedSoFar = 0;

}
