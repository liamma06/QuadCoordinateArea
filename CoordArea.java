import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class CoordArea {
    //Properties
    JFrame theframe = new JFrame("Quadralateral Coordinate Area Program");
    JPanel thepanel = new JPanel();
    JTextField Ax;
    JTextField Ay;
    JLabel A;

    //Constructor
    public CoordArea(){
        thepanel.setPreferredSize(new Dimension(700,400));
        thepanel.setLayout(null);

        Ax = new JTextField("0");
        Ax.setSize(10,10);
        Ax.setLocation(0,0);
        thepanel.add(Ax);

        //putting the panel inside the frame
        theframe.setContentPane(thepanel);
        theframe.pack();
        theframe.setResizable(false);
        theframe.setVisible(true);
        theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //Main Method
    public static void main(String[] args){
        new CoordArea();
    
    }
}
