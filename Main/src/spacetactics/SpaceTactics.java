package spacetactics;

import com.badlogic.gdx.Game;
import java.util.HashMap;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import spacetactics.view.PlanetView;
import spacetactics.controller.InputHandler;
import spacetactics.model.LocalUniverse;
import spacetactics.view.PlanetObserverScreen;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/17/13
 * Time: 12:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpaceTactics extends Game {

    public SpriteBatch batch;
    private InputHandler inputHandler;
    private LocalUniverse localUniverse;
    private PlanetObserverScreen planetObserverScreen;
    public final int APPLICATION_WIDTH;
    public final int APPLICATION_HEIGHT;
    public BitmapFont font;
    private HashMap<String, Texture> textureAtlas = new HashMap<String, Texture>();

    public SpaceTactics(int width, int height)
    {
        this.APPLICATION_WIDTH = width;
        this.APPLICATION_HEIGHT = height;
    }

    @Override
    public void create() {

        batch = new SpriteBatch();
        font = new BitmapFont();
        localUniverse = new LocalUniverse(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        planetObserverScreen = new PlanetObserverScreen(localUniverse, this);
        inputHandler = new InputHandler(planetObserverScreen.planetViews, APPLICATION_WIDTH, APPLICATION_HEIGHT);
        Gdx.input.setInputProcessor(inputHandler);
        setScreen(planetObserverScreen);
        inputHandler.currentScreen = planetObserverScreen;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }


}
