package spacetactics.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/24/13
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Building {

    public PlanetaryResourceType associatedResource;        //from data file
    public String buildingName;                             //from data file
    public BuildingName buildingInternalName;
    public Availability availability;
    public int buildingPriority;  // 0 = completed, 1 = default/nothing to build - //from data file
    public CompletionRewardType completionRewardType;                     //from dat
    public int completionValue;                             //from dat
    public int cost;                                        //from data file
    public boolean partialBonus;                            //from data file
    public int partialCompletionPayedSoFar;                  //preset to 0 on init
    public int progress;                                    //preset to 0 on initialization
    public PlanetaryStatName statModified;                             //from dat
    public ArrayList<ComplexPrerequisite> prerequisiteTechs;         //from dat



    public enum CompletionRewardType{
        GENERIC_STAT_MOD
    }


    public Building()
    {

    }

    public Building(String buildingName, PlanetaryResourceType associatedResource, int cost, int buildingPriority, boolean partialBonus, PlanetaryStatName statModified, CompletionRewardType completionRewardType, int completionValue)
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
