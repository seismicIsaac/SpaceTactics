package spacetactics.controller;

import com.badlogic.gdx.InputProcessor;
import spacetactics.view.Clickable;
import spacetactics.view.planetobserverscreen.PlanetView;
import spacetactics.view.planetobserverscreen.PlanetObserverScreen;

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
    private ArrayList<Clickable> clickables = new ArrayList<Clickable>();
    private int applicationWidth;
    private int applicationHeight;
    public PlanetObserverScreen currentScreen;

    public InputHandler(ArrayList<Clickable> arrayList, int width, int height)
    {
        this.clickables = arrayList;
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
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        screenY = (screenY - applicationHeight) * -1;
        System.out.println("Mouse Location x: " + screenX + " Mouse location y: " + screenY);

        for (Clickable clickable : clickables)
        {
            if (clickable.hitTest(screenX, screenY))
            {
                clickable.onClick();
            }
            else
            {
                clickable.removeFocus();
            }
        }

        return false;
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
