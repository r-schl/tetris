package game;

import io.Music;

import java.util.ArrayList;

public class Round {
    public static String state ="paused";
    public static ArrayList<Block> blocks = new ArrayList<Block>();
    public static int[][] grid = new int[10][18];
    public static double delay = 950;
    public static boolean boost = false;
    public static int score = 0;

    public static void reset(){
        state ="running";
        blocks.clear();
        for(int column = 0; column <grid.length ; column++){
            for(int row = 0; row < grid[0].length; row++){
                grid[column][row]=0;
            }
        }
        delay = 950;
        boost = false;
        score = 0;
        newBlock();
        new Thread(new Music()).start();
    }

    public static void newBlock() {
        Block block = new Block();
        blocks.add(block);
    }

    public static void start() {
        state = "running";
        new Thread(new Music()).start();
    }

    public static void speedUp(int factor){
        delay = delay - (delay * factor);
    }

    public static void boost(boolean onOff){
        boost=onOff;
    }

    public static void pause() {
        Music.stop();
        state = "paused";
    }


    public static void insertIntoGrid(Block block){
        int size = block.structure.length;        //width and height are the same
        for(int x = 0; x< size; x++){
            for(int y = 0; y< size; y++){
                if (block.getStructure()[x][y]==1){
                    if (block.getY()+y>=0 && block.getY()+y<18 && block.getX()+x<10 && block.getX()+x>=0){
                        grid[block.getX()+x][block.getY()+y] = block.getId();
                    }
                }
            }
        }
    }

    public static void shiftGrid(){
        for (int y = 0; y < grid[0].length; y++){
            if(isminus(y)){
                for(int i = y; i>= 0; i--){
                    for(int x= 0; x<grid.length; x++){
                        if (i > 0){
                            grid[x][i] = grid[x][i-1];
                        }else{
                            grid[x][i] = 0;
                        }
                    }
                }
            }
        }
    }

    public static boolean isminus(int row){
        for(int x= 0; x<grid.length; x++){
            if(grid[x][row]== -1){
                return true;
            }
        }
        return false;
    }

    public static void delRow(int row){
        for(int x= 0; x<grid.length; x++){
            grid[x][row]= -1;
        }
    }

    public static void displayGrid(){
        for(int y = 0; y< grid[0].length; y++){
            for(int x = 0; x< grid.length; x++){
                 System.out.print(grid[x][y]);
            }
            System.out.println();
        }
    }

    public static Block getBlockById (int id){
        for(int b = 0; b<blocks.size()-1; b++){
            if(blocks.get(b).getId()==id){
                return blocks.get(b);
            }
        }
        return null;
    }

    public static Block getBlock(int index){
        if (index < 0){             //-1 is latest Block
            return blocks.get(blocks.size()+index);
        }else{
            return blocks.get(index);
        }
    }




}
