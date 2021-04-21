package io;

import game.Block;
import game.Round;

public class Checker{

    public static boolean moveX(int direction){
        currentBlock b = getDetails();
        return check(b.structure, b.coordX + direction, b.coordY);
    }

    public static boolean rotate(){
        Block currentBlock = Round.getBlock(-1);
        int[][] rotateCopy = currentBlock.rotate();
        int coordX = currentBlock.getX();
        int coordY = currentBlock.getY();
        return check(rotateCopy, coordX, coordY);
    }

    public static boolean below(Block block){
        int coordX = block.getX();
        int coordY = block.getY();
        int[][] structure = block.getStructure();
        return check(structure, coordX, coordY + 1);
    }

    private static currentBlock getDetails(){
        Block currentBlock = Round.getBlock(-1);
        currentBlock b = new currentBlock(currentBlock.getStructure(),currentBlock.getX(), currentBlock.getY());
        return b;
    }

    private static boolean check(int [][] structure, int coordX, int coordY){
        int size = structure.length;                //array is always a square
        for(int x = 0; x< size; x++){
            for(int y = 0; y< size; y++){
                if(structure[x][y] == 1){
                    if ((coordY) + y > 17) {
                        return true;
                    }
                    if (coordX + x >= 10 || coordX + x < 0) {
                        return true;
                    }
                    if (coordY + y >= 0 && coordY + y < 18 && coordX + x < 10 && coordX + x >= 0) {   //within Borders
                        if (Round.grid[coordX+ x][coordY + y] != 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isFull (int row){
        for(int i = 0; i < Round.grid.length; i++){
            if(Round.grid[i][row] == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean top(){
        for(int x = 0; x < Round.grid.length; x++){
            if(Round.grid[x][0] > 0){
                return true;
            }
        }
        return false;
    }

}

final class currentBlock{
    public int coordX;
    public int coordY;
    public int[][] structure;

    public currentBlock(int [][] structure, int coordX, int coordY){
        this.coordX = coordX;
        this.coordY = coordY;
        this.structure = structure;
    }
}
