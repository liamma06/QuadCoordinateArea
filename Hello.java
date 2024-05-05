import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;

public class Hello{
    public static void main(String[] args){
        BufferedImage imgPlane = null;
        try{
            imgPlane = ImageIO.read(new File("graph.png"));
        }catch(IOException e){
            System.out.println("Unable to load image");
        }

    }
}