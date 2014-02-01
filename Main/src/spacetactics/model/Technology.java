package spacetactics.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/28/13
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Technology {

    public TechnologyInternalName internalName;
    public TechnologyResearchType researchType;
    public String externalName;
    public ArrayList<ComplexPrerequisite> prerequisites;
    public ArrayList<TechnologyInternalName> requisiteFor;
    public int cost;

    public Technology()
    {

    }
}
