package spacetactics.view;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/17/13
 * Time: 12:52 AM
 * To change this template use File | Settings | File Templates.
 */

import spacetactics.model.Planet;

public class PlanetView implements Clickable
{
    private String imageLocation;

    public Planet getPlanet() {
        return planet;
    }

    private Planet planet;
    private final int interactHeight = 35;
    private final int interactWidth = 35;
    private int xPosition;
    private int yPosition;
    public boolean isSelected = false;

    public PlanetView(Planet planet)
    {
        this.planet = planet;
        this.imageLocation = planet.starName;
        this.xPosition = planet.xPosition;
        this.yPosition = planet.yPosition;
    }

    @Override
    public void inView() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick() {
        // TODO Auto-generated method stub
        System.out.println(planet.getStarName());
        isSelected = true;

    }

    @Override
    public boolean hitTest(int x, int y) {
        // TODO Auto-generated method stub
        return (x >= this.xPosition && x <= this.xPosition + this.interactWidth ) && (y >= this.yPosition && y <= this.yPosition + this.interactHeight);
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
