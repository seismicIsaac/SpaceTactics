package spacetactics.controller;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import spacetactics.view.Clickable;
import spacetactics.view.PlanetView;
import spacetactics.view.PlanetObserverScreen;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/17/13
 * Time: 12:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class InputHandler implements InputProcessor
{
    private ArrayList<PlanetView> planetViews = new ArrayList<PlanetView>();
    private int applicationWidth;
    private int applicationHeight;
    public PlanetObserverScreen currentScreen;


    public InputHandler(ArrayList<PlanetView> arrayList, int width, int height)
    {
        this.planetViews = arrayList;
        this.applicationHeight = height;
        this.applicationWidth = width;
    }

    @Override
    public boolean keyDown(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        removeFocus();
        screenY = (screenY - applicationHeight) * -1;
        System.out.println("Mouse Location x: " + screenX + " Mouse location y: " + screenY + " Pointer? " + pointer + " button: " + button);
        for (Clickable clickable : planetViews)
        {
            if (clickable.hitTest(screenX, screenY))
            {
                clickable.onClick();
            }
        }

        if (screenX >= 1075 && screenX <= 1260 && screenY >= 50 && screenY <= 110)
        {
            currentScreen.playerStatsController.annualUpdatePlayerStats(currentScreen.playerStats);
        }

        return false;
    }

    public void removeFocus()
    {
        for (PlanetView planetView: planetViews)
        {
            planetView.isSelected = false;
        }
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        // TODO Auto-generated method stub
        return false;
    }
}
