package spacetactics.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 1/25/14
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComplexPrerequisite {

    public HashMap<TechnologyInternalName, Boolean> requiredToUnlock;
    public boolean prerequisiteMet;
}
