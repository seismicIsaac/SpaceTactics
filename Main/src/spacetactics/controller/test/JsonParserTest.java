package spacetactics.controller.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import spacetactics.model.*;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 1/13/14
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class JsonParserTest {

    public Building building;
    public Technology technology1 = new Technology();
    public Technology technology2 = new Technology();
    public ArrayList<Technology> techs = new ArrayList<Technology>();
    public PlanetaryResource planetaryResource = new PlanetaryResource();
    public Json json = new Json();

    public static void main(String[] args)
    {
        JsonParserTest jsonParserTest = new JsonParserTest();
        jsonParserTest.building = new Building("Tech Lab", PlanetaryResourceType.INDUSTRY, 1000, 100, false, Building.StatModified.FLAT_PRODUCTION, "GenericStatMod", 5);
        jsonParserTest.technology1.internalName = TechnologyInternalName.FACTORY_COST_10;
        jsonParserTest.technology1.externalName = "Factories - 10";
        jsonParserTest.technology1.prerequisites = null;
        jsonParserTest.technology1.researchType = TechnologyResearchType.CONSTRUCTION;
        jsonParserTest.technology1.cost = 1000;

        ArrayList<TechnologyInternalName> prereqs = new ArrayList<TechnologyInternalName>();
        ComplexPrerequisite tech2prereq = new ComplexPrerequisite();
        tech2prereq.requiredToUnlock = prereqs;
        ArrayList<ComplexPrerequisite> realRequ = new ArrayList<ComplexPrerequisite>();
        realRequ.add((tech2prereq));
        prereqs.add(TechnologyInternalName.IMPROVED_ECO_RESTORATION_1);
        prereqs.add(TechnologyInternalName.TERRAFORMING_10);

        jsonParserTest.technology2.internalName = TechnologyInternalName.IMPROVED_ECO_RESTORATION_3;
        jsonParserTest.technology2.externalName = "Improved Eco Restoration";
        jsonParserTest.technology2.prerequisites = realRequ;
        jsonParserTest.technology2.researchType = TechnologyResearchType.ECOLOGY;
        jsonParserTest.technology2.cost = 2500;

        jsonParserTest.techs.add(jsonParserTest.technology1);
        jsonParserTest.techs.add(jsonParserTest.technology2);

        String temp = (jsonParserTest.json.toJson(jsonParserTest.techs));
        System.out.println(jsonParserTest.json.prettyPrint(temp));

    }


}
