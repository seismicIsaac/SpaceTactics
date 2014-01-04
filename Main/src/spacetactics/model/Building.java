package spacetactics.model;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/24/13
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Building {

    public String buildingName;
    public String associatedResource;
    public int cost;
    public int progress;
    public int buildingPriority;  // 0 = completed, 1 = default/nothing to build
    public boolean partialBonus;
    public String statModified;
    public String completionRewardType;
    public int completionValue;
    public int partialCompletionPayedSoFar;


    public Building()
    {

    }

    public Building(String buildingName, String associatedResource, int cost, int buildingPriority, boolean partialBonus, String statModified, String completionRewardType, int completionValue)
    {
        this.buildingName = buildingName;
        this.associatedResource = associatedResource;
        this.cost = cost;
        this.buildingPriority = buildingPriority;
        this.partialBonus = partialBonus;
        this.statModified = statModified;
        this.completionRewardType = completionRewardType;
        this.completionValue = completionValue;
        this.progress = 0;
        this.partialCompletionPayedSoFar = 0;
    }
}
