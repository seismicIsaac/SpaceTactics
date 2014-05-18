package spacetactics.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import spacetactics.SpaceTactics;
import spacetactics.model.PlayerSlot;
import spacetactics.model.PlayerStats;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 3/4/14
 * Time: 9:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResearchScreen implements Screen {

    public SpaceTactics spaceTactics;
    public PlayerStats player1Stats;
    public HashMap<String, Texture> textureAtlas = new HashMap<String, Texture>();

    public void reviewResearchedTechnology()
    {

    }

    public void displayTechnologyChoices()
    {

    }

    public ResearchScreen(SpaceTactics spaceTactics)
    {
        this.spaceTactics = spaceTactics;
        this.player1Stats = spaceTactics.gameData.players.get(PlayerSlot.PLAYER1);

    }

    @Override
    public void dispose() {
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
    public void render(float delta) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void resize(int width, int height) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void resume() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void show() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
