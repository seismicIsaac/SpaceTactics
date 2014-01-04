package spacetactics.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import spacetactics.model.Building;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: iaustin
 * Date: 12/30/13
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataLoader {

    public Json json = new Json();

    public void loadData(ArrayList<?> arrayList, String fileName)
    {
        FileHandle file = Gdx.files.internal(fileName);
        String favoriteString = file.readString();
        arrayList = this.json.fromJson(ArrayList.class, favoriteString);
        System.out.println(arrayList.get(0).getClass());
    }
}
