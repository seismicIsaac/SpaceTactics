package spacetactics;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/17/13
 * Time: 12:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class DesktopStarter {
    public static void main(String[] args)
    {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Space Tactics";
        cfg.useGL20 = true;
        cfg.width = 1280;
        cfg.height = 720;
        new LwjglApplication(new SpaceTactics(cfg.width, cfg.height), cfg);
    }
}
