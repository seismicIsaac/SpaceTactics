package spacetactics.view.planetobserverscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import spacetactics.SpaceTactics;
import spacetactics.controller.PlanetaryResourceController;
import spacetactics.controller.PlayerStatsController;
import spacetactics.model.*;
import spacetactics.view.Button;
import spacetactics.view.Clickable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/17/13
 * Time: 12:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetObserverScreen implements Screen {

    public SpaceTactics spaceTactics;

    public ArrayList<PlanetView> planetViews = new ArrayList<PlanetView>();
    public ArrayList<Clickable> clickables = new ArrayList<Clickable>();
    public HashMap<String, Texture> textureAtlas = new HashMap<String, Texture>();
    public PlayerStatsController playerStatsController = new PlayerStatsController();
    public PlanetaryResourceController planetaryResourceController = new PlanetaryResourceController();
    public NextTurnButton nextTurnButton = new NextTurnButton(1085, 25, 185, 61, "nextTurnButton.png", this);
    public SettleColonyButton settleColonyButton = new SettleColonyButton(1085, 300, 185, 61, "settleColonyButton.png", this);
    public PlanetView selectedPlanetView;
    public String hudImageLocation = "hud1.png";

    public void getPlanetViewTextures()
    {
        for (PlanetView planetView : planetViews)
        {
            if (!textureAtlas.containsKey(planetView.imageLocation));
            {
                Texture texture = new Texture(Gdx.files.internal(planetView.imageLocation));
                textureAtlas.put(planetView.imageLocation, texture);
            }
        }
        Texture texture = new Texture(Gdx.files.internal(hudImageLocation));
        textureAtlas.put(hudImageLocation, texture);

        Texture texture1 = new Texture(Gdx.files.internal(nextTurnButton.imageLocation));
        textureAtlas.put(nextTurnButton.imageLocation, texture1);

        Texture texture2 = new Texture(Gdx.files.internal(settleColonyButton.imageLocation));
        textureAtlas.put(settleColonyButton.imageLocation, texture2);
    }

    public void displaySelectedPlanetStats()
    {
        String planetStats = new String("Max Population: " + selectedPlanetView.planet.maxPopulation + "  X:" + selectedPlanetView.planet.xPosition + "  Y:" + selectedPlanetView.planet.yPosition);

        if(selectedPlanetView.planet.settledBy == PlayerSlot.PLAYER1)
        {
            String planetStats2 = new String("Factories: " + selectedPlanetView.planet.planetaryResources.get(PlanetaryResourceType.INDUSTRY).baseUnitCount);
            String currentlyBuilding = new String("Currently Building: " + selectedPlanetView.planet.planetaryResources.get(PlanetaryResourceType.INDUSTRY).currentlyBuilding.buildingName);
            String buildingProgress = new String("Progress: " + selectedPlanetView.planet.planetaryResources.get(PlanetaryResourceType.INDUSTRY).currentlyBuilding.progress);

            spaceTactics.font.draw(spaceTactics.batch, planetStats2, 1000, 575);
            spaceTactics.font.draw(spaceTactics.batch, currentlyBuilding, 1000, 550);
            spaceTactics.font.draw(spaceTactics.batch, buildingProgress, 1000, 525);
        }
        spaceTactics.font.draw(spaceTactics.batch, planetStats, 1000, 600);
    }

    public void drawHud()
    {
        spaceTactics.batch.draw(this.textureAtlas.get(hudImageLocation),  0,  0);
        spaceTactics.batch.draw(this.textureAtlas.get(nextTurnButton.imageLocation), nextTurnButton.xPosition, nextTurnButton.yPosition);

        if(selectedPlanetView != null && selectedPlanetView.planet.settledBy != PlayerSlot.PLAYER1)
        {
            spaceTactics.batch.draw(this.textureAtlas.get(settleColonyButton.imageLocation), settleColonyButton.xPosition, settleColonyButton.yPosition);
        }
    }

    public PlanetObserverScreen(LocalUniverse localUniverse, SpaceTactics spaceTactics)
    {
        this.spaceTactics = spaceTactics;

        for (Planet planet : localUniverse.getPlanets())
        {
            PlanetView planetView = new PlanetView(planet, this);
            planetViews.add(planetView);
            clickables.add(planetView);
        }

        getPlanetViewTextures();
        clickables.add(nextTurnButton);
        clickables.add(settleColonyButton);
        playerStatsController.planetaryResourceController = planetaryResourceController;
    }

    @Override
    public void render(float delta) {
        //To change body of implemented methods use File | Settings | File Templates.
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        spaceTactics.batch.begin();

        for (PlanetView planetView : planetViews)
        {
            spaceTactics.batch.draw(this.textureAtlas.get(planetView.imageLocation), planetView.planet.xPosition, planetView.planet.yPosition);
        }

        drawHud();

        if (selectedPlanetView != null)
        {
            displaySelectedPlanetStats();
        }

        spaceTactics.batch.end();
    }

    public void onClick()
    {
        selectedPlanetView = null;
    }

    @Override
    public void resize(int width, int height) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void show() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void hide() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void pause() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void resume() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void dispose() {
        //To change body of implemented methods use File | Settings | File Templates.
    }


}

