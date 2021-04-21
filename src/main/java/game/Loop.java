package game;

import Data.Data;
import io.Checker;
import io.Music;
import io.Sound;

public class Loop implements Runnable {

    @Override
    public void run() {
        while (true){
            if (Round.state.equals("running")){              //loop

                Round.shiftGrid();
                if(!Checker.below(Round.getBlock(-1))){
                    Round.getBlock(-1).setY(Round.getBlock(-1).getY()+1);
                }else{
                    new Thread(new Sound("/resources/musicAndSounds/pop.mp3")).start();   //play "pop" sound
                    Round.newBlock();                               //spawn new Block
                    Round.insertIntoGrid(Round.getBlock(-2));   //insert the other block into grid
                    Round.speedUp(1/20);                        //speed up the game
                    if(Checker.top()){
                        if(Round.score > Data.getHighScore()){
                            Data.setHighScore(Round.score);
                        }
                        Round.state="end";
                        Music.stop();
                        sleep(1000);
                    }
                }

                int z=0;
                for (int i = 0; i < Round.grid[0].length; i++){
                    if(Checker.isFull(i)){
                        z++;
                        Round.delRow(i);
                    }
                }
                Round.score=Round.score + z;            //update score
                ///delay
                if(z>0) {
                    sleep(750);     //delay when row is deleted
                }
                else if(Round.boost){
                    sleep((int) (Round.delay - (Round.delay/ 1.1)));
                }else{
                    sleep((int)Round.delay);
                }


            }else{
                sleep(1000);
            }
        }
    }

    public static void sleep(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
