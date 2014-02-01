package spacetactics;

import com.badlogic.gdx.Game;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import spacetactics.controller.DataLoader;
import spacetactics.controller.GameSimulation;
import spacetactics.model.GameData;
import spacetactics.controller.InputHandler;
import spacetactics.view.planetobserverscreen.PlanetObserverScreen;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/17/13
 * Time: 12:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpaceTactics extends Game {

    public GameData gameData;
    public GameSimulation gameSimulation = new GameSimulation();
    public DataLoader dataLoader = new DataLoader();

    public SpriteBatch batch;
    private InputHandler inputHandler;
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
        // Set Screen to Main menu -->
        // From Main Menu we decide what else to do
        gameData = new GameData(gameSimulation);
        gameSimulation.initializeNewGame(gameData, this);

        batch = new SpriteBatch();
        font = new BitmapFont();
        planetObserverScreen = new PlanetObserverScreen(gameData.localUniverse, this);
        inputHandler = new InputHandler(planetObserverScreen.clickables, APPLICATION_WIDTH, APPLICATION_HEIGHT);
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
