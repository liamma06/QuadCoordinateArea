import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;

public class AnimationPanel extends JPanel{
    //Properties
    /**integer for holding the position of Ax */
    public int PointAx = 530/2 +400;
    /**integer for holding the position of Ay */
    public int PointAy = 530/2;
    /**integer for holding the position of Bx */
    public int PointBx = 530/2 + 400;
    /**integer for holding the position of By */
    public int PointBy = 530/2;
    /**integer for holding the position of Cx */
    public int PointCx = 530/2 + 400;
    /**integer for holding the position of Cy */
    public int PointCy = 530/2;
    /**integer for holding the position of Dx */
    public int PointDx = 530/2 + 400;
    /**integer for holding the position of Dy */
    public int PointDy = 530/2;
    /**integer holding the width of the graph */
    public int GraphWidth = 540;
    /**integer holding the height of the graph */
    public int GraphHeight = 540;
    /**integer holding the lowest x value */
    public int GraphMinX = -12;
    /**integer holding the highest x value */
    public int GraphMaxX = 12;
    /**integer holding the lowest y value */
    public int GraphMinY = -12;
    /**integer holding the highest y value */
    public int GraphMaxY = 12;
    /**integer holding the origin x value */
    public int GraphOriginX = 540/2;
    /**integer holding the origin y value */
    public int GraphOriginY = 540/2;
    /**integer holding pixels between each tick of the grpah */
    public int GraphTickSpacing = 30;
    /**variable holding the about image */
    public BufferedImage imgAbout;

    /**variable holding the help image */
    public BufferedImage imgHelp;

    /**allowing Jar file to contian the images  */
    public BufferedImage loadImage(String strFilename){  
        // Try to read the file from the jar file
        InputStream imageclass = null;
        imageclass = this.getClass().getResourceAsStream(strFilename+".jpg");
        if(imageclass == null){
          //System.out.println("Unable to load image file: \""+strFilename+"\"");
         //return null;
        }else{
          try{
            return ImageIO.read(imageclass);
          }catch(IOException e){
            //System.out.println(e.toString());
            //System.out.println("Unable to load image file: \""+strFileName+"\"");
            //return null;
          }
        }
        // Then try to read the local file
        try{
          BufferedImage theImage = ImageIO.read(new File(strFilename+".jpg"));
          return theImage;
        }catch(IOException e){
          System.out.println("Unable to load local image file: \""+strFilename+"\"");
          return null;
        }
      }

    //Methods
    /**Drawing the cartesian plane and updating each point */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //draw grid lines
        g.setColor(Color.LIGHT_GRAY);
        for (int i = GraphMinX; i <= GraphMaxX; i++){
            int xPos = GraphOriginX +400+ i *(GraphWidth/(GraphMaxX-GraphMinX));
            g.drawLine(xPos, 0, xPos, GraphHeight);
        }
        for(int j = GraphMinY; j <= GraphMaxY; j++){
            int yPos = GraphOriginY - j *(GraphHeight/(GraphMaxY-GraphMinY));
            g.drawLine(0,yPos,GraphWidth+400,yPos);
        }

        //draw Axes
        g.setColor(Color.BLACK);
        g.drawLine(0,GraphOriginY, GraphWidth+400,GraphOriginY); //x-axis
        g.drawLine(GraphOriginX+400, 0, GraphOriginX+400, GraphHeight);//Y-axis

        //Draw Ticks
        for(int i = GraphMinX + 1; i < GraphMaxX; i++){
            int xPos = GraphOriginX+400 + i*(GraphWidth/(GraphMaxX - GraphMinX));
            g.drawLine(xPos, GraphOriginY -5,xPos, GraphOriginY + 5);
        }
        for (int j = GraphMinY + 1; j < GraphMaxY; j++){
            int yPos = GraphOriginY - j*(GraphHeight/(GraphMaxY-GraphMinY));
            g.drawLine(GraphOriginX+400 - 5, yPos, GraphOriginX+400+5, yPos);
        }

        //Background for inputs
        g.setColor(new Color(238,238,238));
        g.fillRect(0,0,400,540);

        //Drawing point A
        g.setColor(Color.BLUE);
        g.fillOval(PointAx,PointAy,10,10);
        g.fillOval(140,22,10,10);
        
        //Drawing point B
        g.setColor(Color.GREEN);
        g.fillOval(PointBx,PointBy,10,10);
        g.fillOval(140,107,10,10);

        //Drawing point C
        g.setColor(Color.YELLOW);
        g.fillOval(PointCx,PointCy,10,10);
        g.fillOval(140,192,10,10);

        //Drawing point D
        g.setColor(Color.RED);
        g.fillOval(PointDx,PointDy,10,10);
        g.fillOval(140,277,10,10);

        //Drawing Lines between A-B, B-C, C-D, D-A
        g.setColor(Color.BLACK);
        g.drawLine(PointAx + 5, PointAy + 5, PointBx + 5, PointBy + 5);
        g.drawLine(PointBx + 5, PointBy + 5, PointCx + 5, PointCy + 5);
        g.drawLine(PointCx + 5, PointCy + 5, PointDx + 5, PointDy + 5);
        g.drawLine(PointDx + 5, PointDy + 5, PointAx + 5, PointAy + 5);

        //background of the inputs
        g.setColor(Color.WHITE);
        g.fillRect(50,365,300,150);

    }

    //constructor
    public AnimationPanel(){
        super();
        //inputing the about.jpg and help.png
        imgAbout = loadImage("about"); 
        imgHelp = loadImage("help");

    }
}
