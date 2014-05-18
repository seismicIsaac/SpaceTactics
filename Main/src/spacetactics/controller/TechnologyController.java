package spacetactics.controller;

import spacetactics.model.*;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 2/10/14
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TechnologyController {

    public GameSimulation gameSimulation;

    public void processResearchPoints(PlayerStats playerStats, int researchPoints)
    {
        if (researchPoints + playerStats.currentlyResearching.progress >= playerStats.currentlyResearching.cost)
        {
            handleResearchComplete(playerStats);
        }
        else
        {
            playerStats.currentlyResearching.progress += researchPoints;
        }
    }

    public void handleResearchComplete(PlayerStats playerStats)
    {
        playerStats.currentlyResearching.availability = Availability.RESEARCHED;
        updateTechnologyAvailability(playerStats, playerStats.currentlyResearching);
        grantResearchReward(playerStats, playerStats.currentlyResearching);
    }

    public void updateTechnologyAvailability(PlayerStats playerStats, Technology technology)
    {
        for (TechnologyInternalName techName : technology.requisiteFor)
        {
            updatePrerequisites(playerStats.allResearchableTechnologies.get(techName), playerStats.currentlyResearching.internalName);
        }
    }

    public void updatePrerequisites(Technology technology, TechnologyInternalName prerequisiteCompleted)
    {
        for (ComplexPrerequisite complexPrerequisite : technology.prerequisites)
        {
            if(!complexPrerequisite.requiredToUnlock.get(prerequisiteCompleted))
            {
                complexPrerequisite.requiredToUnlock.put(prerequisiteCompleted, true);

                if (!complexPrerequisite.requiredToUnlock.containsValue(false))
                {
                    technology.availability = Availability.RESEARCHABLE;
                }
            }
        }
    }

    public void grantResearchReward(PlayerStats playerStats, Technology technology)
    {
        technology.researchReward.reward(playerStats);
    }

    public TechnologyController(GameSimulation gameSimulation)
    {
        this.gameSimulation = gameSimulation;
    }

    public void pickSomethingToResearch(PlayerStats playerStats, Technology technology)
    {
        playerStats.currentlyResearching = technology;
    }
}
