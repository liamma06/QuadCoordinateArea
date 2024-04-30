import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class CoordArea {
    //Properties
    JFrame theframe = new JFrame("Quadralateral Coordinate Area Program");
    JPanel thepanel = new JPanel();

    //Methods


    //Constructor
    public CoordArea(){
        thepanel.setPreferredSize(new Dimension(400,200));
        thepanel.setLayout(null);

        //putting the panel inside the frame
        theframe.setContentPane(thepanel);
        theframe.pack();
        theframe.setVisible(true);
        theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //Main Method
    public static void main(String[] args){
        new CoordArea();
    
    }
}
