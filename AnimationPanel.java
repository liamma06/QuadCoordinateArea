import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;

public class AnimationPanel extends JPanel{
    //Properties
    BufferedImage imgPlane = null;
    int PointAx = 530/2 +400;
    int PointAy = 530/2;
    int PointBx = 530/2 + 400;
    int PointBy = 530/2;
    int PointCx = 530/2 + 400;
    int PointCy = 530/2;
    int PointDx = 530/2 + 400;
    int PointDy = 530/2;
    int GraphWidth = 540;
    int GraphHeight = 540;
    int GraphMinX = -12;
    int GraphMaxX = 12;
    int GraphMinY = -12;
    int GraphMaxY = 12;
    int GraphOriginX = 540/2;
    int GraphOriginY = 540/2;
    int GraphTickSpacing = 30;


    //Methods

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

        g.setColor(Color.WHITE);
        g.fillRect(50,365,300,150);

    }

    //constructor
    public AnimationPanel(){
        super();
        
    }
}
