package Data;

import game.Block;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class BlockData {

    public static int getRandom(JSONObject jsonobject){
        int random = (int) (Math.random() * (((JSONArray) jsonobject.get("blocks")).size()));
        return random;
    }

    public static int[][] getStructure(JSONObject jsonobject, int random){
        JSONArray structure = (JSONArray) ((JSONObject) ((JSONArray) jsonobject.get("blocks")).get(random)).get("structure");
        int size = (int) structure.size();
        int [][] arr = new int [size][size];                       //set the bounds of the array "structure" (array is always a square)
        for (int x = 0; x <size; x++){                               //fill array "structure"
            for (int y = 0; y<size; y++){
                arr[x][y] = Integer.parseInt(String.valueOf(((JSONArray) structure.get(y)).get(x)));
            }
        }
        return arr;
    }

    public static Color getColor(JSONObject jsonobject, int random){
        String colorString = String.valueOf(((JSONObject) ((JSONArray) jsonobject.get("blocks")).get(random)).get("color"));
        Scanner scanner = new Scanner(colorString);
        scanner.useDelimiter("\\D+");
        Color color = new Color(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        return color;
    }

    public static JSONObject read(String path){
        InputStream is = BlockData.class.getResourceAsStream(path);
        Scanner scanner = new Scanner(is);
        String jsonText = scanner.useDelimiter("\\A").next();       //the entire text
        return (JSONObject) JSONValue.parse(jsonText);
    }
}
