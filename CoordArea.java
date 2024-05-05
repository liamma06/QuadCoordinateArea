import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.math.*;
import java.text.DecimalFormat;

public class CoordArea implements ActionListener, ChangeListener{
    //Properties
    JFrame theframe = new JFrame("Quadralateral Coordinate Calculator Program");
    JPanel thepanel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu helpMenu = new JMenu("Help");
    JMenu aboutMenu = new JMenu("About");
    JMenu quizMenu = new JMenu("Quiz");
    JMenuItem quizItem = new JMenuItem("Quiz");
    JMenuItem scoresItem = new JMenuItem("Scores");
    Timer theTimer = new Timer(1000/48,this);
    JTextField AxTxtField;
    JTextField AyTxtField;
    JLabel ALabel;
    JLabel AxLabel;
    JLabel AyLabel;
    JSlider AxSlider;
    JSlider AySlider;
    int AxVal = 0;
    int AyVal =0 ;
    JTextField BxTxtField;
    JTextField ByTxtField;
    JLabel BLabel;
    JLabel BxLabel;
    JLabel ByLabel;
    JSlider BxSlider;
    JSlider BySlider;
    int BxVal= 0;
    int ByVal=0;
    JTextField CxTxtField;
    JTextField CyTxtField;
    JLabel CLabel;
    JLabel CxLabel;
    JLabel CyLabel;
    JSlider CxSlider;
    JSlider CySlider;
    int CxVal=0;
    int CyVal=0;
    JTextField DxTxtField;
    JTextField DyTxtField;
    JLabel DLabel;
    JLabel DxLabel;
    JLabel DyLabel;
    JSlider DxSlider;
    JSlider DySlider;
    int DxVal=0;
    int DyVal=0;
    JButton startCalc;
    JButton Reset;
    AnimationPanel AniPanel = new AnimationPanel();
    Double dblArea = 0.0;
    Double dblPeri = 0.0;
    JLabel ResultsArea;
    JLabel ResultsPeri;

    //Methods
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == AxTxtField){
            try{
                AxVal = Integer.parseInt(AxTxtField.getText());
                AxSlider.setValue(AxVal);
            }catch(NumberFormatException e){
                AxTxtField.setText("0");
                AxSlider.setValue(0);
            }
        }else if(evt.getSource() == AyTxtField){
            try{
                AyVal = Integer.parseInt(AyTxtField.getText());
                AySlider.setValue(AyVal);
            }catch(NumberFormatException e){
                AyTxtField.setText("0");
                AySlider.setValue(0);
            }
        }else if(evt.getSource() == ByTxtField){
            try{
                int ByVal = Integer.parseInt(ByTxtField.getText());
                BySlider.setValue(ByVal);
            }catch(NumberFormatException e){
                ByTxtField.setText("0");
                BySlider.setValue(0);
            }
        }else if(evt.getSource() == BxTxtField){
            try{
                int BxVal = Integer.parseInt(BxTxtField.getText());
                BxSlider.setValue(BxVal);
            }catch(NumberFormatException e){
                BxTxtField.setText("0");
                BxSlider.setValue(0);
            }
        }else if(evt.getSource() == CyTxtField){
            try{
                int CyVal = Integer.parseInt(CyTxtField.getText());
                CySlider.setValue(CyVal);
            }catch(NumberFormatException e){
                CyTxtField.setText("0");
                CySlider.setValue(0);
            }
        }else if(evt.getSource() == CxTxtField){
            try{
                int CxVal = Integer.parseInt(CxTxtField.getText());
                CxSlider.setValue(CxVal);
            }catch(NumberFormatException e){
                CxTxtField.setText("0");
                CxSlider.setValue(0);
            }
        }else if(evt.getSource() == DyTxtField){
            try{
                int DyVal = Integer.parseInt(DyTxtField.getText());
                DySlider.setValue(DyVal);
            }catch(NumberFormatException e){
                DyTxtField.setText("0");
                DySlider.setValue(0);
            }
        }else if(evt.getSource() == DxTxtField){
            try{
                int DxVal = Integer.parseInt(DxTxtField.getText());
                DxSlider.setValue(DxVal);
            }catch(NumberFormatException e){
                DxTxtField.setText("0");
                DxSlider.setValue(0);
            }
        }
        //Timer
        else if(evt.getSource() == theTimer){
            //Point A Animation
            if((AxVal*22)+665 > AniPanel.PointAx){
                AniPanel.PointAx = AniPanel.PointAx + 1;
            }else if((AxVal*22)+665 < AniPanel.PointAx){
                AniPanel.PointAx = AniPanel.PointAx -1;
            }else if(265 - (AyVal*22)  < AniPanel.PointAy){
                AniPanel.PointAy = AniPanel.PointAy - 1;
            }else if(265 - (AyVal*22)  > AniPanel.PointAy){
                AniPanel.PointAy = AniPanel.PointAy + 1;
            }
            //Point B Animation
            if((BxVal*22)+665 > AniPanel.PointBx){
                AniPanel.PointBx = AniPanel.PointBx + 1;
            }else if((BxVal*22)+665 < AniPanel.PointBx){
                AniPanel.PointBx = AniPanel.PointBx -1;
            }else if(265 - (ByVal*22)  < AniPanel.PointBy){
                AniPanel.PointBy = AniPanel.PointBy - 1;
            }else if(265 - (ByVal*22)  > AniPanel.PointBy){
                AniPanel.PointBy = AniPanel.PointBy + 1;
            }
            //Point C Animation
            if((CxVal*22)+665 > AniPanel.PointCx){
                AniPanel.PointCx = AniPanel.PointCx + 1;
            }else if((CxVal*22)+665 < AniPanel.PointCx){
                AniPanel.PointCx = AniPanel.PointCx -1;
            }else if(265 - (CyVal*22)  < AniPanel.PointCy){
                AniPanel.PointCy = AniPanel.PointCy - 1;
            }else if(265 - (CyVal*22)  > AniPanel.PointCy){
                AniPanel.PointCy = AniPanel.PointCy + 1;
            }
            //Point D Animation
            if((DxVal*22)+665 > AniPanel.PointDx){
                AniPanel.PointDx = AniPanel.PointDx + 1;
            }else if((DxVal*22)+665 < AniPanel.PointDx){
                AniPanel.PointDx = AniPanel.PointDx -1;
            }else if(265 - (DyVal*22)  < AniPanel.PointDy){
                AniPanel.PointDy = AniPanel.PointDy - 1;
            }else if(265 - (DyVal*22)  > AniPanel.PointDy){
                AniPanel.PointDy = AniPanel.PointDy + 1;
            }
            AniPanel.repaint();
            theframe.repaint();
        }
        //Reset Button
        else if(evt.getSource() == Reset){
            theTimer.stop();
            AxTxtField.setText("0");
            AxSlider.setValue(0);
            AyTxtField.setText("0");
            AySlider.setValue(0);
            AniPanel.PointAx = 665;
            AniPanel.PointAy = 265;

            BxTxtField.setText("0");
            BxSlider.setValue(0);
            ByTxtField.setText("0");
            BySlider.setValue(0);
            AniPanel.PointBx = 665;
            AniPanel.PointBy = 265;

            CxTxtField.setText("0");
            CxSlider.setValue(0);
            CyTxtField.setText("0");
            CySlider.setValue(0);
            AniPanel.PointCx = 665;
            AniPanel.PointCy = 265;

            DxTxtField.setText("0");
            DxSlider.setValue(0);
            DyTxtField.setText("0");
            DySlider.setValue(0);
            AniPanel.PointDx = 665;
            AniPanel.PointDy = 265;

            ResultsArea.setText("clal");

            AniPanel.repaint();
            theframe.repaint();
            theTimer.start();
        }
        //Start Calculation button
        else if(evt.getSource() == startCalc){
            theTimer.stop();

            //Area Calculation
            dblArea = 0.5*((AxVal*ByVal + BxVal*CyVal + CxVal*DyVal + DxVal*AyVal) - (AyVal*BxVal + ByVal*CxVal + CyVal*DxVal + DyVal*AxVal));
            ResultsArea.setText("Area: "+ new DecimalFormat("##.##").format(Math.abs(dblArea))+" units squared");

            //Perimeter Calculation
            double AB = Math.sqrt(Math.pow(BxVal - AxVal,2) + Math.pow(ByVal - AyVal,2));
            double BC = Math.sqrt(Math.pow(CxVal - BxVal,2) + Math.pow(CyVal - ByVal,2));
            double CD = Math.sqrt(Math.pow(DxVal - CxVal,2) + Math.pow(DyVal - CyVal,2));
            double DA = Math.sqrt(Math.pow(AxVal - DxVal,2) + Math.pow(AyVal - DyVal,2));

            dblPeri = AB + BC + CD + DA;
            ResultsPeri.setText("Perimeter: "+new DecimalFormat("##.##").format(dblPeri)+" units");

        }

    }
    public void stateChanged(ChangeEvent evt){
        if(evt.getSource() == AxSlider){
            AxTxtField.setText(AxSlider.getValue()+"");
            AxVal = AxSlider.getValue();
        }else if(evt.getSource() == AySlider){
            AyTxtField.setText(AySlider.getValue()+"");
            AyVal = AySlider.getValue();
        }else if(evt.getSource() == BySlider){
            ByTxtField.setText(BySlider.getValue()+"");
            ByVal = BySlider.getValue();
        }else if(evt.getSource() == BxSlider){
            BxTxtField.setText(BxSlider.getValue()+"");
            BxVal = BxSlider.getValue();
        }else if(evt.getSource() == CySlider){
            CyTxtField.setText(CySlider.getValue()+"");
            CyVal = CySlider.getValue();
        }else if(evt.getSource() == CxSlider){
            CxTxtField.setText(CxSlider.getValue()+"");
            CxVal = CxSlider.getValue();
        }else if(evt.getSource() == DySlider){
            DyTxtField.setText(DySlider.getValue()+"");
            DyVal = DySlider.getValue();
        }else if(evt.getSource() == DxSlider){
            DxTxtField.setText(DxSlider.getValue()+"");
            DxVal = DxSlider.getValue();
        }

    }

    //Constructor
    public CoordArea(){
        thepanel.setPreferredSize(new Dimension(960,540));
        thepanel.setLayout(new BorderLayout());

        //Point A 
        ALabel = new JLabel("Point A: (     ,     )");
        ALabel.setSize(200,50);
        ALabel.setLocation(30,0);
        thepanel.add(ALabel);

        AxTxtField = new JTextField("0");
        AxTxtField.setSize(17,17);
        AxTxtField.setLocation(85,17);
        AxTxtField.addActionListener(this);
        thepanel.add(AxTxtField); 

        AyTxtField = new JTextField("0");
        AyTxtField.setSize(17,17);
        AyTxtField.setLocation(105,17);
        AyTxtField.addActionListener(this);
        thepanel.add(AyTxtField);

        AxLabel = new JLabel("Ax:");
        AxLabel.setSize(30,10);
        AxLabel.setLocation(30,40);
        thepanel.add(AxLabel);

        AyLabel = new JLabel("Ay:");
        AyLabel.setSize(30,20);
        AyLabel.setLocation(30,65);
        thepanel.add(AyLabel);

        AxSlider = new JSlider(-10,10,0);
        AxSlider.setSize(200,30);
        AxSlider.setLocation(55,35);
        AxSlider.setPaintTicks(true);
        AxSlider.setPaintTrack(true);
        AxSlider.setMajorTickSpacing(1);
        AxSlider.addChangeListener(this);
        thepanel.add(AxSlider);

        AySlider = new JSlider(-10,10,0);
        AySlider.setSize(200,30);
        AySlider.setLocation(55,65);
        AySlider.setPaintTicks(true);
        AySlider.setPaintTrack(true);
        AySlider.setMajorTickSpacing(1);
        AySlider.addChangeListener(this);
        thepanel.add(AySlider);

        //Point B
        BLabel = new JLabel("Point B: (     ,     )");
        BLabel.setSize(200,50);
        BLabel.setLocation(30,85);
        thepanel.add(BLabel);

        BxTxtField = new JTextField("0");
        BxTxtField.setSize(17,17);
        BxTxtField.setLocation(85,102);
        BxTxtField.addActionListener(this);
        thepanel.add(BxTxtField); 

        ByTxtField = new JTextField("0");
        ByTxtField.setSize(17,17);
        ByTxtField.setLocation(105,102);
        ByTxtField.addActionListener(this);
        thepanel.add(ByTxtField);

        BxLabel = new JLabel("Bx:");
        BxLabel.setSize(30,15);
        BxLabel.setLocation(30,120);
        thepanel.add(BxLabel);

        ByLabel = new JLabel("By:");
        ByLabel.setSize(30,20);
        ByLabel.setLocation(30,150);
        thepanel.add(ByLabel);

        BxSlider = new JSlider(-10,10,0);
        BxSlider.setSize(200,30);
        BxSlider.setLocation(55,120);
        BxSlider.setPaintTicks(true);
        BxSlider.setPaintTrack(true);
        BxSlider.setMajorTickSpacing(1);
        BxSlider.addChangeListener(this);
        thepanel.add(BxSlider);

        BySlider = new JSlider(-10,10,0);
        BySlider.setSize(200,30);
        BySlider.setLocation(55,150);
        BySlider.setPaintTicks(true);
        BySlider.setPaintTrack(true);
        BySlider.setMajorTickSpacing(1);
        BySlider.addChangeListener(this);
        thepanel.add(BySlider);

        //Point C 
        CLabel = new JLabel("Point C: (     ,     )");
        CLabel.setSize(200,50);
        CLabel.setLocation(30,170);
        thepanel.add(CLabel);

        CxTxtField = new JTextField("0");
        CxTxtField.setSize(17,17);
        CxTxtField.setLocation(85,187);
        CxTxtField.addActionListener(this);
        thepanel.add(CxTxtField); 

        CyTxtField = new JTextField("0");
        CyTxtField.setSize(17,17);
        CyTxtField.setLocation(105,187);
        CyTxtField.addActionListener(this);
        thepanel.add(CyTxtField);

        CxLabel = new JLabel("Cx:");
        CxLabel.setSize(30,10);
        CxLabel.setLocation(30,207);
        thepanel.add(CxLabel);

        CyLabel = new JLabel("Cy:");
        CyLabel.setSize(30,20);
        CyLabel.setLocation(30,232);
        thepanel.add(CyLabel);

        CxSlider = new JSlider(-10,10,0);
        CxSlider.setSize(200,30);
        CxSlider.setLocation(55,206);
        CxSlider.setPaintTicks(true);
        CxSlider.setPaintTrack(true);
        CxSlider.setMajorTickSpacing(1);
        CxSlider.addChangeListener(this);
        thepanel.add(CxSlider);

        CySlider = new JSlider(-10,10,0);
        CySlider.setSize(200,30);
        CySlider.setLocation(55,236);
        CySlider.setPaintTicks(true);
        CySlider.setPaintTrack(true);
        CySlider.setMajorTickSpacing(1);
        CySlider.addChangeListener(this);
        thepanel.add(CySlider);

        //Point D
        DLabel = new JLabel("Point D: (     ,     )");
        DLabel.setSize(200,50);
        DLabel.setLocation(30,255);
        thepanel.add(DLabel);

        DxTxtField = new JTextField("0");
        DxTxtField.setSize(17,17);
        DxTxtField.setLocation(85,272);
        DxTxtField.addActionListener(this);
        thepanel.add(DxTxtField); 

        DyTxtField = new JTextField("0");
        DyTxtField.setSize(17,17);
        DyTxtField.setLocation(105,272);
        DyTxtField.addActionListener(this);
        thepanel.add(DyTxtField);

        DxLabel = new JLabel("Dx:");
        DxLabel.setSize(30,15);
        DxLabel.setLocation(30,290);
        thepanel.add(DxLabel);

        DyLabel = new JLabel("Dy:");
        DyLabel.setSize(30,20);
        DyLabel.setLocation(30,317);
        thepanel.add(DyLabel);

        DxSlider = new JSlider(-10,10,0);
        DxSlider.setSize(200,30);
        DxSlider.setLocation(55,290);
        DxSlider.setPaintTicks(true);
        DxSlider.setPaintTrack(true);
        DxSlider.setMajorTickSpacing(1);
        DxSlider.addChangeListener(this);
        thepanel.add(DxSlider);

        DySlider = new JSlider(-10,10,0);
        DySlider.setSize(200,30);
        DySlider.setLocation(55,319);
        DySlider.setPaintTicks(true);
        DySlider.setPaintTrack(true);
        DySlider.setMajorTickSpacing(1);
        DySlider.addChangeListener(this);
        thepanel.add(DySlider);

        //start calculation button
        startCalc = new JButton("Calculate");
        startCalc.setSize(100,25);
        startCalc.setLocation(275,75);
        startCalc.addActionListener(this);
        thepanel.add(startCalc);

        //Reset Button
        Reset = new JButton("Reset");
        Reset.setSize(100,25);
        Reset.setLocation(275,25);
        Reset.addActionListener(this);
        thepanel.add(Reset);

        //Results Area
        ResultsArea = new JLabel("Area: ");
        ResultsArea.setSize(200, 100);
        ResultsArea.setLocation(100,360);
        thepanel.add(ResultsArea);

        //Results Perimeter
        ResultsPeri = new JLabel("Perimeter: ");
        ResultsPeri.setSize(200,100);
        ResultsPeri.setLocation(100,410);
        thepanel.add(ResultsPeri);


        //Menu bar
        //About
        menuBar.add(aboutMenu);
        aboutMenu.addActionListener(this);
        //Help
        menuBar.add(helpMenu);
        helpMenu.addActionListener(this);
        //Quiz
        quizMenu.add(quizItem);
        quizItem.addActionListener(this);
        quizMenu.add(scoresItem);
        scoresItem.addActionListener(this);
        menuBar.add(quizMenu);
        
        theframe.setJMenuBar(menuBar);

        //Starttimer
        theTimer.start();

        //adding the animation panel
        thepanel.add(AniPanel);

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
