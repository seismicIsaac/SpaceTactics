package spacetactics.model;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/17/13
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
import spacetactics.SpaceTactics;

import java.util.ArrayList;
import java.util.Random;

public class LocalUniverse {

    private ArrayList <Planet> planets = new ArrayList<Planet>();
    public ArrayList <PlayerStats> players = new ArrayList<PlayerStats>();
    private final int MINIMUM_DISTANCE = 20;
    private final int MAX_POP = 150;
    private final int MIN_POP = 35;
    private final int UNIVERSE_SIZE = 5;

    public LocalUniverse(int width, int height, SpaceTactics spaceTactics)
    {
        //TODO: add some awesome algorithm for spawning 'dem planets
        Random random = new Random();

        while (planets.size() < UNIVERSE_SIZE)
        {
            int x = random.nextInt(width) + 1;
            int y = random.nextInt(height) + 1;
            int maxPop = random.nextInt(MAX_POP) + MIN_POP;

            if (insideMinimumDistance(x, y))
            {
                int starType = random.nextInt(5) + 1; //normally this would determine the image location <_<
                String planetName = new String(setStarName(starType));
                String imgLocation = planetName;
                int planetInteractSquareDimension = 39;

                Planet randomPlanet = new Planet(x, y, imgLocation, planetInteractSquareDimension, planetInteractSquareDimension, planetName, maxPop);
                planets.add(randomPlanet);
            }
        }
    }

    public ArrayList <Planet> getPlanets() {
        return planets;
    }

    public String setStarName(int starType)
    {
        String planetName = new String();

        switch (starType)
        {
            case 1:
                planetName = "StarFinishBlue01.png";
                break;
            case 2:
                planetName = "StarFinishGold01.png";
                break;
            case 3:
                planetName = "StarFinishGreen01.png";
                break;
            case 4:
                planetName = "StarFinishWhite01.png";
                break;
            case 5:
                planetName = "StarFinishRed01.png";
                break;
        }
        return planetName;
    }

    public boolean insideMinimumDistance(int x, int y)
    {
        for (Planet planet: planets)
        {
            if (Math.sqrt(((planet.xPosition - x) * (planet.xPosition - x) + ((planet.yPosition - y) *(planet.yPosition - y)))) < MINIMUM_DISTANCE)
            {
                return false;
            }
        }
        return true;
    }
}
