package Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Data {

    public static void setHighScore(int highScore){
        String appdataPath = System.getenv("APPDATA");      //get the path where appdata is stored
        String str = Integer.toString(highScore);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(appdataPath + "\\tetris\\highScore.txt")); //write the text document "highScore.txt"
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getHighScore(){
        String appdataPath = System.getenv("APPDATA");      //get the path where appdata is stored
        try {
            Scanner scanner = new Scanner(new File(appdataPath + "\\tetris\\highScore.txt"));
            if(scanner.hasNext()){
                String text = scanner.useDelimiter("\\A").next();       //the entire text
                return Integer.parseInt(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void createDirectory(){
        String appdataPath = System.getenv("APPDATA");      //get the path where appdata is stored
        String fileName = appdataPath+"\\tetris";
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            File myObj = new File(appdataPath + "\\tetris\\highScore.txt");             //create "highScore.txt"
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                setHighScore(0);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
