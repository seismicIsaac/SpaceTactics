package spacetactics.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import spacetactics.SpaceTactics;
import spacetactics.controller.PlanetaryResourceController;
import spacetactics.controller.PlayerStatsController;
import spacetactics.model.Planet;
import spacetactics.model.LocalUniverse;
import spacetactics.model.PlayerStats;

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

    private SpaceTactics spaceTactics;

    public ArrayList<PlanetView> planetViews = new ArrayList<PlanetView>();
    public HashMap<String, Texture> textureAtlas = new HashMap<String, Texture>();
    public Clickable[] screenButtons;
    public PlayerStatsController playerStatsController = new PlayerStatsController();
    public PlayerStats playerStats = new PlayerStats();
    public PlanetaryResourceController planetaryResourceController = new PlanetaryResourceController();

    public void getPlanetViewTextures()
    {
        for (PlanetView planetView : planetViews)
        {
            if (!textureAtlas.containsKey(planetView.getImageLocation()));
            {
                Texture texture = new Texture(Gdx.files.internal(planetView.getImageLocation()));
                textureAtlas.put(planetView.getImageLocation(), texture);
            }
        }
        Texture texture = new Texture(Gdx.files.internal("hud1.png"));
        textureAtlas.put("hud1.png", texture);

        Texture texture1 = new Texture(Gdx.files.internal("next turn button.png"));
        textureAtlas.put("next turn button.png", texture1);
    }

    public PlanetObserverScreen(LocalUniverse localUniverse, SpaceTactics spaceTactics)
    {
        this.spaceTactics = spaceTactics;

        for (Planet planet : localUniverse.getPlanets())
        {
            planetViews.add(new PlanetView(planet));
        }
        getPlanetViewTextures();
        playerStats.settledPlanets = localUniverse.getPlanets();
        playerStatsController.planetaryResourceController = planetaryResourceController;

    }

    @Override
    public void render(float delta) {
        //To change body of implemented methods use File | Settings | File Templates.
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        spaceTactics.batch.begin();

        String planetStats = new String();
        String planetStats2 = new String();

        for (PlanetView planetView : planetViews)
        {
            spaceTactics.batch.draw(this.textureAtlas.get(planetView.getImageLocation()), planetView.getPlanet().xPosition, planetView.getPlanet().yPosition);
            if (planetView.isSelected)
            {
                planetStats = "Max Population: " + planetView.getPlanet().maxPopulation + "  X:" + planetView.getPlanet().xPosition + "  Y:" + planetView.getPlanet().yPosition;
                planetStats2 = "Factories: " + planetView.getPlanet().planetaryResources.get(0).resourceCount;
            }
        }

        spaceTactics.batch.draw(this.textureAtlas.get("hud1.png"),  0,  0);
        spaceTactics.batch.draw(this.textureAtlas.get("next turn button.png"), 1075, 50);
        spaceTactics.font.draw(spaceTactics.batch, planetStats, 1000, 500);
        spaceTactics.font.draw(spaceTactics.batch, planetStats2, 1000, 475);

        spaceTactics.batch.end();


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
