package spacetactics.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
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

    public <T> ArrayList<T> returnListFromDataFile(String fileName)
    {
        ArrayList<T> listFromDataFile = new ArrayList<T>();
        Object[] genericList;
        FileHandle file = Gdx.files.internal(fileName);
        String favoriteString = file.readString();
        genericList = this.json.fromJson(Object[].class, favoriteString);

        for(Object object : genericList)
        {
            T TObject = (T) object;
            listFromDataFile.add(TObject);
        }

        return listFromDataFile;
    }
}
