package spacetactics.controller.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import spacetactics.model.Building;
import spacetactics.model.PlanetaryResource;
import spacetactics.model.PlanetaryResourceType;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 1/13/14
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class JsonParserTest {

    public Building building;
    public PlanetaryResource planetaryResource = new PlanetaryResource();
    public Json json = new Json();

    public static void main(String[] args)
    {
        JsonParserTest jsonParserTest = new JsonParserTest();
        jsonParserTest.building = new Building("Tech Lab", PlanetaryResourceType.INDUSTRY, 1000, 100, false, "baseUnitCost", "GenericStatMod", 5);

        String temp = (jsonParserTest.json.toJson(jsonParserTest.building));

        System.out.println(temp);
    }


}
