import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.text.DecimalFormat;

public class CoordArea implements ActionListener, ChangeListener, MouseListener{
    //Properties
    JFrame theframe = new JFrame("Quadralateral Coordinate Calculator Program");
    JPanel thepanel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu homeMenu = new JMenu("Home");
    JMenu helpMenu = new JMenu("Help");
    JPanel helpPanel = new JPanel();
    JMenu aboutMenu = new JMenu("About");
    JPanel aboutPanel = new JPanel();
    JMenu quizMenu = new JMenu("Quiz");
    JPanel quizPanel = new JPanel();
    JMenu scoresMenu = new JMenu("Scores");
    JPanel scoresPanel = new JPanel();
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

    JLabel quizTitleLabel;
    JLabel questionLabel1, questionLabel2, questionLabel3, questionLabel4;
    JRadioButton optionA1, optionB1, optionC1, optionD1;
    JRadioButton optionA2, optionB2, optionC2, optionD2;
    JRadioButton optionA3, optionB3, optionC3, optionD3;
    JRadioButton optionA4, optionB4, optionC4, optionD4;
    JTextField nameField;
    JLabel scoreLabel;
    JLabel nameLabel;
    JButton submitButton;
    JButton tryagainButton;
    ButtonGroup group1;
    ButtonGroup group2;
    ButtonGroup group3;
    ButtonGroup group4;
    int intscore = 0;

    PrintWriter txtscores;
    BufferedReader txtscoresOut;

    JTextArea scoresTextArea;
    JScrollPane scoresScroll;
    String strLine;
    JLabel scoreTitleLabel;
    
    
 
    //Methods
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == AxTxtField){
            try{
                AxVal = Integer.parseInt(AxTxtField.getText());
                if(AxVal > 10){
                    AxVal = 10;
                    AxTxtField.setText("10");
                    AxSlider.setValue(10);
                }else if(AxVal < -10){
                    AxVal = -10;
                    AxTxtField.setText("-10");
                    AxSlider.setValue(10);
                }else{
                    AxSlider.setValue(AxVal);
                }
                
            }catch(NumberFormatException e){
                AxTxtField.setText("0");
                AxSlider.setValue(0);
            }
        }else if(evt.getSource() == AyTxtField){
            try{
                AyVal = Integer.parseInt(AyTxtField.getText());
                if(AyVal > 10){
                    AyVal = 10;
                    AyTxtField.setText("10");
                    AySlider.setValue(10);
                }else if(AyVal < -10){
                    AyVal = -10;
                    AyTxtField.setText("-10");
                    AySlider.setValue(10);
                }else{
                    AySlider.setValue(AyVal);
                }
            }catch(NumberFormatException e){
                AyTxtField.setText("0");
                AySlider.setValue(0);
            }
        }else if(evt.getSource() == ByTxtField){
            try{
                int ByVal = Integer.parseInt(ByTxtField.getText());
                if(ByVal > 10){
                    ByVal = 10;
                    ByTxtField.setText("10");
                    BySlider.setValue(10);
                }else if(ByVal < -10){
                    ByVal = -10;
                    ByTxtField.setText("-10");
                    BySlider.setValue(10);
                }else{
                    BySlider.setValue(ByVal);
                }
            }catch(NumberFormatException e){
                ByTxtField.setText("0");
                BySlider.setValue(0);
            }
        }else if(evt.getSource() == BxTxtField){
            try{
                int BxVal = Integer.parseInt(BxTxtField.getText());
                if(BxVal > 10){
                    BxVal = 10;
                    BxTxtField.setText("10");
                    BxSlider.setValue(10);
                }else if(BxVal < -10){
                    BxVal = -10;
                    BxTxtField.setText("-10");
                    BxSlider.setValue(10);
                }else{
                    BxSlider.setValue(BxVal);
                }
            }catch(NumberFormatException e){
                BxTxtField.setText("0");
                BxSlider.setValue(0);
            }
        }else if(evt.getSource() == CyTxtField){
            try{
                int CyVal = Integer.parseInt(CyTxtField.getText());
                if(CyVal > 10){
                    CyVal = 10;
                    CyTxtField.setText("10");
                    CySlider.setValue(10);
                }else if(CyVal < -10){
                    CyVal = -10;
                    CyTxtField.setText("-10");
                    CySlider.setValue(10);
                }else{
                    CySlider.setValue(CyVal);
                }
            }catch(NumberFormatException e){
                CyTxtField.setText("0");
                CySlider.setValue(0);
            }
        }else if(evt.getSource() == CxTxtField){
            try{
                int CxVal = Integer.parseInt(CxTxtField.getText());
                if(CxVal > 10){
                    CxVal = 10;
                    CxTxtField.setText("10");
                    CxSlider.setValue(10);
                }else if(CxVal < -10){
                    CxVal = -10;
                    CxTxtField.setText("-10");
                    CxSlider.setValue(10);
                }else{
                    CxSlider.setValue(CxVal);
                }
            }catch(NumberFormatException e){
                CxTxtField.setText("0");
                CxSlider.setValue(0);
            }
        }else if(evt.getSource() == DyTxtField){
            try{
                int DyVal = Integer.parseInt(DyTxtField.getText());
                if(DyVal > 10){
                    DyVal = 10;
                    DyTxtField.setText("10");
                    DySlider.setValue(10);
                }else if(DyVal < -10){
                    DyVal = -10;
                    DyTxtField.setText("-10");
                    DySlider.setValue(10);
                }else{
                    DySlider.setValue(DyVal);
                }
            }catch(NumberFormatException e){
                DyTxtField.setText("0");
                DySlider.setValue(0);
            }
        }else if(evt.getSource() == DxTxtField){
            try{
                int DxVal = Integer.parseInt(DxTxtField.getText());
                if(DxVal > 10){
                    DxVal = 10;
                    DxTxtField.setText("10");
                    DxSlider.setValue(10);
                }else if(DxVal < -10){
                    DxVal = -10;
                    DxTxtField.setText("-10");
                    DxSlider.setValue(10);
                }else{
                    DxSlider.setValue(DxVal);
                }
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
            }
            if(265 - (AyVal*22)  < AniPanel.PointAy){
                AniPanel.PointAy = AniPanel.PointAy - 1;
            }else if(265 - (AyVal*22)  > AniPanel.PointAy){
                AniPanel.PointAy = AniPanel.PointAy + 1;
            }
            //Point B Animation
            if((BxVal*22)+665 > AniPanel.PointBx){
                AniPanel.PointBx = AniPanel.PointBx + 1;
            }else if((BxVal*22)+665 < AniPanel.PointBx){
                AniPanel.PointBx = AniPanel.PointBx -1;
            }
            if(265 - (ByVal*22)  < AniPanel.PointBy){
                AniPanel.PointBy = AniPanel.PointBy - 1;
            }else if(265 - (ByVal*22)  > AniPanel.PointBy){
                AniPanel.PointBy = AniPanel.PointBy + 1;
            }
            //Point C Animation
            if((CxVal*22)+665 > AniPanel.PointCx){
                AniPanel.PointCx = AniPanel.PointCx + 1;
            }else if((CxVal*22)+665 < AniPanel.PointCx){
                AniPanel.PointCx = AniPanel.PointCx -1;
            }
            if(265 - (CyVal*22)  < AniPanel.PointCy){
                AniPanel.PointCy = AniPanel.PointCy - 1;
            }else if(265 - (CyVal*22)  > AniPanel.PointCy){
                AniPanel.PointCy = AniPanel.PointCy + 1;
            }
            //Point D Animation
            if((DxVal*22)+665 > AniPanel.PointDx){
                AniPanel.PointDx = AniPanel.PointDx + 1;
            }else if((DxVal*22)+665 < AniPanel.PointDx){
                AniPanel.PointDx = AniPanel.PointDx -1;
            }
            if(265 - (DyVal*22)  < AniPanel.PointDy){
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

            ResultsArea.setText("Area: ");
            ResultsPeri.setText("Perimeter: ");

            AniPanel.repaint();
            theframe.repaint();
            theTimer.start();
        }
        //Start Calculation button
        else if(evt.getSource() == startCalc){

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
        //quiz scores
        else if(evt.getSource() == optionA1){
            intscore += 1;
        }else if(evt.getSource() == optionB2){
            intscore += 1;
        }else if(evt.getSource() == optionD3){
            intscore += 1;
        }else if(evt.getSource() == optionA4){
            intscore += 1;
        }

        //submit button for quiz
        else if(evt.getSource() == submitButton){
            scoreLabel.setText("Score: "+intscore+"  /  4");

            try{
                txtscores= new PrintWriter(new FileWriter("scores.txt",true));
                txtscores.println(nameField.getText()+" "+intscore+"/4");
                System.out.println("scores.txt updated");
                txtscores.close();
            }catch(FileNotFoundException e){ 
                System.out.println("File Not Found: scores.txt");
            }catch(IOException e){
                System.out.println("Unable to read from the file or close the file");
            }
            intscore = 0;
        }
        //tryagain button for quiz
        else if(evt.getSource() == tryagainButton){
            group1.clearSelection();
            group2.clearSelection();
            group3.clearSelection();
            group4.clearSelection();
            
            scoreLabel.setText("Score: 0  /  4");
            nameField.setText("");
            

        }
        
    }

    public void mouseReleased(MouseEvent evt){

    }

    public void mousePressed(MouseEvent evt){

    }

    public void mouseExited(MouseEvent evt){

    }

    public void mouseEntered(MouseEvent evt){

    }

    public void mouseClicked(MouseEvent evt){
        //home Menu 
        if(evt.getSource() == homeMenu){
            System.out.println("home menu");
            theframe.setContentPane(thepanel);
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

            ResultsArea.setText("Area: ");
            ResultsPeri.setText("Perimeter: ");

            AniPanel.repaint();
            theframe.revalidate();
            theframe.repaint();
        }
        //about menu
        else if(evt.getSource() == aboutMenu){
            System.out.println("about menu");
            theframe.setContentPane(aboutPanel);
            theframe.revalidate();
            theframe.repaint();
        }
        //help Menu
        else if(evt.getSource() == helpMenu){
            System.out.println("help menu");
            theframe.setContentPane(helpPanel);
            theframe.revalidate();
            theframe.repaint();
        }
        //scores Menu 
        else if(evt.getSource() == scoresMenu){
            System.out.println("scores menu");
            theframe.setContentPane(scoresPanel);

            try{
                txtscoresOut = new BufferedReader(new FileReader("scores.txt"));
                strLine = txtscoresOut.readLine();
                while(strLine != null){
                    System.out.println(strLine);
                    scoresTextArea.append(strLine+"\n");
                    strLine=txtscoresOut.readLine();
                }
                txtscoresOut.close();
               }catch(FileNotFoundException e){ 
                    System.out.println("File Not Found: todo.txt");
               }catch(IOException e){
                    System.out.println("Unable to read from the file or close the file");
               }

            theframe.revalidate();
            theframe.repaint();
        }
        //quiz menu 
        else if(evt.getSource() == quizMenu){
            System.out.println("quiz menu");
            theframe.setContentPane(quizPanel);
            theframe.revalidate();
            theframe.repaint();
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
        ALabel = new JLabel("Point A: (       ,       )");
        ALabel.setSize(200,50);
        ALabel.setLocation(30,0);
        thepanel.add(ALabel);

        AxTxtField = new JTextField("0");
        AxTxtField.setSize(22,17);
        AxTxtField.setLocation(85,17);
        AxTxtField.addActionListener(this);
        thepanel.add(AxTxtField); 

        AyTxtField = new JTextField("0");
        AyTxtField.setSize(22,17);
        AyTxtField.setLocation(113,17);
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
        BLabel = new JLabel("Point B: (       ,       )");
        BLabel.setSize(200,50);
        BLabel.setLocation(30,85);
        thepanel.add(BLabel);

        BxTxtField = new JTextField("0");
        BxTxtField.setSize(22,17);
        BxTxtField.setLocation(85,102);
        BxTxtField.addActionListener(this);
        thepanel.add(BxTxtField); 

        ByTxtField = new JTextField("0");
        ByTxtField.setSize(22,17);
        ByTxtField.setLocation(113,102);
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
        CLabel = new JLabel("Point C: (       ,       )");
        CLabel.setSize(200,50);
        CLabel.setLocation(30,170);
        thepanel.add(CLabel);

        CxTxtField = new JTextField("0");
        CxTxtField.setSize(22,17);
        CxTxtField.setLocation(85,187);
        CxTxtField.addActionListener(this);
        thepanel.add(CxTxtField); 

        CyTxtField = new JTextField("0");
        CyTxtField.setSize(22,17);
        CyTxtField.setLocation(113,187);
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
        DLabel = new JLabel("Point D: (       ,       )");
        DLabel.setSize(200,50);
        DLabel.setLocation(30,255);
        thepanel.add(DLabel);

        DxTxtField = new JTextField("0");
        DxTxtField.setSize(22,17);
        DxTxtField.setLocation(85,272);
        DxTxtField.addActionListener(this);
        thepanel.add(DxTxtField); 

        DyTxtField = new JTextField("0");
        DyTxtField.setSize(22,17);
        DyTxtField.setLocation(113,272);
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
        //home
        menuBar.add(homeMenu);
        homeMenu.addMouseListener(this);
        //About
        menuBar.add(aboutMenu);
        //aboutMenu.add(aboutItem);
        aboutMenu.addMouseListener(this);
        
        //Help
        menuBar.add(helpMenu);
        helpMenu.addMouseListener(this);
        //Quiz
        menuBar.add(quizMenu);
        quizMenu.addMouseListener(this);

        //scores
        menuBar.add(scoresMenu);
        scoresMenu.addMouseListener(this);
        
        theframe.setJMenuBar(menuBar);


        //Quiz Panel
        quizPanel.setLayout(null);

        quizTitleLabel = new JLabel("Quiz: ");
        quizTitleLabel.setSize(100,15);
        quizTitleLabel.setLocation(450,15);
        quizPanel.add(quizTitleLabel);

        //question 1
        questionLabel1 = new JLabel("1. What concept is used for calculating the area of the quadralateral on a coordinate system?");
        questionLabel1.setSize(600,15);
        questionLabel1.setLocation(20,40);
        quizPanel.add(questionLabel1);

        optionA1 = new JRadioButton("A: Shoelace formula");
        optionA1.setSize(250,15);
        optionA1.setLocation(20,60);
        optionA1.addActionListener(this);
        quizPanel.add(optionA1);
    
        
        optionB1 = new JRadioButton("B: Pythagorean Theorem");
        optionB1.setSize(250,15);
        optionB1.setLocation(20,80);
        quizPanel.add(optionB1);

        optionC1 = new JRadioButton("C: Parallelogram Rule");
        optionC1.setSize(250,15);
        optionC1.setLocation(20,100);
        quizPanel.add(optionC1);
        
        optionD1 = new JRadioButton("D: Heron's formula");
        optionD1.setSize(250,15);
        optionD1.setLocation(20,120);
        quizPanel.add(optionD1);

        group1 = new ButtonGroup();
        group1.add(optionA1);
        group1.add(optionB1);
        group1.add(optionC1);
        group1.add(optionD1);

        //question2
        questionLabel2 = new JLabel("2. What concept is used for calculating the perimeter of the quadralateral?");
        questionLabel2.setSize(500,15);
        questionLabel2.setLocation(20,160);
        quizPanel.add(questionLabel2);

        optionA2 = new JRadioButton("A: Circumference formula");
        optionA2.setSize(250,15);
        optionA2.setLocation(20,180);
        quizPanel.add(optionA2);
        
        optionB2 = new JRadioButton("B: Pythagorean Theorem");
        optionB2.setSize(250,15);
        optionB2.setLocation(20,200);
        optionB2.addActionListener(this);
        quizPanel.add(optionB2);

        optionC2 = new JRadioButton("C: Parallelogram Rule");
        optionC2.setSize(250,15);
        optionC2.setLocation(20,220);
        quizPanel.add(optionC2);
        
        optionD2 = new JRadioButton("D: Exponential growth formula");
        optionD2.setSize(250,15);
        optionD2.setLocation(20,240);
        quizPanel.add(optionD2);

        group2 = new ButtonGroup();
        group2.add(optionA2);
        group2.add(optionB2);
        group2.add(optionC2);
        group2.add(optionD2);

        //question3
        questionLabel3 = new JLabel("3. To find the perimeter of a quadrailateral in the Cartesian plane, what is the correct sequence of steps?:");
        questionLabel3.setSize(500,15);
        questionLabel3.setLocation(20,280);
        quizPanel.add(questionLabel3);

        optionA3 = new JRadioButton("A: calculate the sum of the lengths of all four sides");
        optionA3.setSize(400,15);
        optionA3.setLocation(20,300);
        quizPanel.add(optionA3);
        
        optionB3 = new JRadioButton("B: Subtract each x and y coordinate and add the difference");
        optionB3.setSize(400,15);
        optionB3.setLocation(20,320);
        quizPanel.add(optionB3);

        optionC3 = new JRadioButton("C: multiply he lengths of oppostie sides and add them together");
        optionC3.setSize(400,15);
        optionC3.setLocation(20,340);
        quizPanel.add(optionC3);
        
        optionD3 = new JRadioButton("D: Find the distrance between each pair of points, then add them");
        optionD3.setSize(400,15);
        optionD3.setLocation(20,360);
        optionD3.addActionListener(this);
        quizPanel.add(optionD3);

        group3 = new ButtonGroup();
        group3.add(optionA3);
        group3.add(optionB3);
        group3.add(optionC3);
        group3.add(optionD3);

        //question4
        questionLabel4 = new JLabel("4. When does the Pythagorean Theorem work?: ");
        questionLabel4.setSize(500,15);
        questionLabel4.setLocation(20,400);
        quizPanel.add(questionLabel4);

        optionA4 = new JRadioButton("A: All Right Angle triangle");
        optionA4.setSize(400,15);
        optionA4.setLocation(20,420);
        optionA4.addActionListener(this);
        quizPanel.add(optionA4);
        
        optionB4 = new JRadioButton("B: All Equilateral triangles");
        optionB4.setSize(400,15);
        optionB4.setLocation(20,440);
        quizPanel.add(optionB4);

        optionC4 = new JRadioButton("C: All Isoceles triangles");
        optionC4.setSize(400,15);
        optionC4.setLocation(20,460);
        quizPanel.add(optionC4);
        
        optionD4 = new JRadioButton("D: All Acute triangles");
        optionD4.setSize(400,15);
        optionD4.setLocation(20,480);
        quizPanel.add(optionD4);

        group4 = new ButtonGroup();
        group4.add(optionA4);
        group4.add(optionB4);
        group4.add(optionC4);
        group4.add(optionD4);

        //submit button and name input
        submitButton = new JButton("Submit");
        submitButton.setSize(100,30);
        submitButton.setLocation(800,470);
        submitButton.addActionListener(this);
        quizPanel.add(submitButton);


        scoreLabel = new JLabel("Score: 0  /  4");
        scoreLabel.setSize(100,20);
        scoreLabel.setLocation(800,450);
        quizPanel.add(scoreLabel);

        nameLabel = new JLabel("Name: ");
        nameLabel.setSize(50,15);
        nameLabel.setLocation(770,15);
        quizPanel.add(nameLabel);

        nameField = new JTextField("");
        nameField.setSize(120,20);
        nameField.setLocation(820,13);
        quizPanel.add(nameField);

        tryagainButton = new JButton("Try again");
        tryagainButton.setSize(100,30);
        tryagainButton.setLocation(800,500);
        tryagainButton.addActionListener(this);
        quizPanel.add(tryagainButton);

        //scores panel
        scoresPanel.setLayout(null);

        scoreTitleLabel = new JLabel("Scores");
        scoreTitleLabel.setSize(100,15);
        scoreTitleLabel.setLocation(450,25);
        scoresPanel.add(scoreTitleLabel);


        scoresTextArea = new JTextArea("");
        scoresTextArea.setBounds(230, 60, 500, 450); // Set bounds for JTextArea
        scoresTextArea.setEditable(false);
        scoresPanel.add(scoresTextArea);

        scoresScroll = new JScrollPane(scoresTextArea);
        scoresScroll.setBounds(230, 60, 500, 450); // Set bounds for JScrollPane, same as JTextArea
        scoresScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scoresPanel.add(scoresScroll);
        
        
        theframe.setVisible(true);

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
