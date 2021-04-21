package game;

import Data.BlockData;
import org.json.simple.JSONObject;

import java.awt.*;


public class Block {
    int x, y;                           //coordinates (multiply by 32 to get the absolute value)
    int[][] structure;                  //structure ->  [0] fields in x the black takes up space   [1] fields in y the block takes up space
    Color color;                        //color
    int id;

    public Block() {
        JSONObject jsonobject = BlockData.read("/resources/blockData/blockData.json");     //get JSON Object from file "blockData.json"
        int random = BlockData.getRandom(jsonobject);   //get a random Block
        id = random+1;  //set the id of the Block
        structure = BlockData.getStructure(jsonobject, random);  // get the structure of the block
        color = BlockData.getColor(jsonobject,random);   // get the color of the block

        x= 4;               // set start coordinates
        y = -3;
    }

    public int[][] rotate() {
        int h = structure.length;
        int w = structure[0].length;
        int[][] ret = new int[h][w];
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                ret[i][j] = structure[w - j - 1][i];                //create a array "ret" rotated to the right
            }
        }
        return ret;
    }


    public void left(){
        x--;
    }

    public void right(){
        x++;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId(){
        return id;
    }


    public int[][] getStructure() {
        return this.structure;
    }

    public void setStructure(int[][] structure) {
        this.structure = structure;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
