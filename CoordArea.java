import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.text.DecimalFormat;

public class CoordArea implements ActionListener, ChangeListener, MouseListener{
    //Properties
    /**Main Frame for the program and panels */
    public JFrame theframe = new JFrame("Quadralateral Coordinate Calculator Program");
    /**panel that contains the main program */
    public JPanel thepanel = new JPanel();
    /**menu bar above the panels*/
    public JMenuBar menuBar =  new JMenuBar();
    /**menu option for home screen, switching to main panel*/
    public JMenu homeMenu = new JMenu("Home");
    /**menu option for the help screen, switching to help panel*/
    public JMenu helpMenu = new JMenu("Help");
    /**creates help panel*/
    public JPanel helpPanel = new JPanel();
    /**menu option for the about screen, switching to about panel*/
    public JMenu aboutMenu = new JMenu("About");
    /**creates about panel */
    public JPanel aboutPanel = new JPanel();
    /**menu option for the quiz screen, switching to quiz panel*/
    public JMenu quizMenu = new JMenu("Quiz");
    /**creates quiz panel */
    public JPanel quizPanel = new JPanel();
    /**menu option for the scores screen, switching to scores panel*/
    public JMenu scoresMenu = new JMenu("Scores");
    /**creates scores panel */
    public JPanel scoresPanel = new JPanel();
    /**timer for 48 frames per second*/
    public Timer theTimer = new Timer(1000/48,this);
    /**textfield for inputing Ax value */
    public JTextField AxTxtField;
    /**textfield for inputing Ay value */
    public JTextField AyTxtField;
    /**label title for Point A*/
    public JLabel ALabel;
    /**label title for Ax*/
    public JLabel AxLabel;
    /**label title for Ay*/
    public JLabel AyLabel;
    /**slider for getting the value of Ax*/
    public JSlider AxSlider;
    /**slider for getting the value of Ay*/
    public JSlider AySlider;
    /**integer for keeping the value of Ax*/
    public int AxVal = 0;
    /**integer for keeping the value of Ay*/
    public int AyVal =0 ;

    /**textfield for inputing Bx value */
    public JTextField BxTxtField;
    /**textfield for inputing By value */
    public JTextField ByTxtField;
    /**label title for Point B*/
    public JLabel BLabel;
    /**label title for Bx*/
    public JLabel BxLabel;
    /**label title for By*/
    public JLabel ByLabel;
    /**slider for getting the value of Bx*/
    public JSlider BxSlider;
    /**slider for getting the value of By*/
    public JSlider BySlider;
    /**integer for keeping the value of Bx*/
    public int BxVal= 0;
    /**integer for keeping the value of By*/
    public int ByVal=0;

    /**textfield for inputing Cx value */
    public JTextField CxTxtField;
    /**textfield for inputing Cy value */
    public JTextField CyTxtField;
    /**label title for Point C*/
    public JLabel CLabel;
    /**label title for Cx*/
    public JLabel CxLabel;
    /**label title for Cy*/
    public JLabel CyLabel;
    /**slider for getting the value of Cx*/
    public JSlider CxSlider;
    /**slider for getting the value of Cy*/
    public JSlider CySlider;
    /**integer for keeping the value of Cx*/
    public int CxVal=0;
    /**integer for keeping the value of Cy*/
    public int CyVal=0;

    /**textfield for inputing Dx value */
    public JTextField DxTxtField;
    /**textfield for inputing Dy value */
    public JTextField DyTxtField;
    /**label title for Point D*/
    public JLabel DLabel;
    /**label title for Dx*/
    public JLabel DxLabel;
    /**label title for Dy*/
    public JLabel DyLabel;
    /**slider for getting the value of Dx*/
    public JSlider DxSlider;
    /**slider for getting the value of Dy*/
    public JSlider DySlider;
    /**integer for keeping the value of Dx*/
    public int DxVal=0;
    /**integer for keeping the value of Dy*/
    public int DyVal=0;

    /**Button to show the calculations of Area and Perimeter*/
    public JButton startCalc;
    /**Button the reset the points back to the origin*/
    public JButton Reset;
    /**adding the animation/graphics panel*/
    public AnimationPanel AniPanel = new AnimationPanel();
    /**double for keeping the value of the area*/
    public Double dblArea = 0.0;
    /**double for keeping the value of the perimeter*/
    public Double dblPeri = 0.0;
    /**Label title of area results*/
    public JLabel ResultsArea;
    /**Label title of perimeter results*/
    public JLabel ResultsPeri;

    /**Label title for quiz*/
    public JLabel quizTitleLabel;
    /**Label title to show questions*/
    public JLabel questionLabel1, questionLabel2, questionLabel3, questionLabel4;
    /**Radio buttons for multiple choice question1 */
    public JRadioButton optionA1, optionB1, optionC1, optionD1;
    /**Radio buttons for multiple choice question2 */
    public JRadioButton optionA2, optionB2, optionC2, optionD2;
    /**Radio buttons for multiple choice question3 */
    public JRadioButton optionA3, optionB3, optionC3, optionD3;
    /**Radio buttons for multiple choice question4 */
    public JRadioButton optionA4, optionB4, optionC4, optionD4;
    /**textfield for inputing the name*/
    public JTextField nameField;
    /**Label title for the score result*/
    public JLabel scoreLabel;
    /**Label title for the name*/
    public JLabel nameLabel;
    /**Button for submitting quiz*/
    public JButton submitButton;
    /**Button for resetting quiz*/
    public JButton tryagainButton;
    /**ButtonGroup for containg question1 radiobuttons*/
    public ButtonGroup group1;
    /**ButtonGroup for containg question2 radiobuttons*/
    public ButtonGroup group2;
    /**ButtonGroup for containg question3 radiobuttons*/
    public ButtonGroup group3;
    /**ButtonGroup for containg question4 radiobuttons*/
    public ButtonGroup group4;
    /**integer keeping the score*/
    public int intscore = 0;

    /**PrintWriter for writing names and corresponding scores to the scores.txt*/
    public PrintWriter txtscores;
    /**BufferedReader for reading names and corresponding scores from the scores.txt*/
    public BufferedReader txtscoresOut;

    /**Textarea where the scores read from scores.txt are shown*/
    public JTextArea scoresTextArea;
    /**scroll pane for the scoresTextArea*/
    public JScrollPane scoresScroll;
    /**String for getting the individual line in the scores.txt*/
    public String strLine;
    /**Label title for the score*/
    public JLabel scoreTitleLabel;

    /**Label containing the about image*/
    public JLabel imgAboutLabel;
    /**Label containing the help image*/
    public JLabel imgHelpLabel;
 
    //Methods
    public void actionPerformed(ActionEvent evt){
        /**getting data from the AxTxtField and adjusting the AxSlider*/
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
        /**getting data from the AyTxtField and adjusting the AySlider*/    
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
        /**getting data from the ByTxtField and adjusting the BySlider*/
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
        /**getting data from the BxTxtField and adjusting the BxSlider*/
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
        /**getting data from the CyTxtField and adjusting the CySlider*/
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
        /**getting data from the CxTxtField and adjusting the CxSlider*/
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
        /**getting data from the DyTxtField and adjusting the DySlider*/
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
        /**getting data from the DxTxtField and adjusting the DxSlider*/
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
        /**Adjusting the X and Y values of each point as the timer is running*/
        else if(evt.getSource() == theTimer){
            //Point A Animation to match the values of Ax and Ay
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
            //Point B Animation to match the values of Bx and By
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
            //Point C Animation to match the values of Cx and Cy
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
            //Point D Animation to match the values of Dx and Dy
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
        /**Reseting all points back to zero along with the textfields and sliders*/
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
        /**Button to do Calculations of Area and Perimeters*/
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
        /**If the radiobutton was pressed it would increase the score by one*/
        else if(evt.getSource() == optionA1){
            intscore += 1;
        /**If the radiobutton was pressed it would increase the score by one*/   
        }else if(evt.getSource() == optionB2){
            intscore += 1;
        /**If the radiobutton was pressed it would increase the score by one*/
        }else if(evt.getSource() == optionD3){
            intscore += 1;
        /**If the radiobutton was pressed it would increase the score by one*/
        }else if(evt.getSource() == optionA4){
            intscore += 1;
        }

        /**Submit button for inputting the scores*/
        else if(evt.getSource() == submitButton){
            //clearing all the radio button groups
            group1.clearSelection();
            group2.clearSelection();
            group3.clearSelection();
            group4.clearSelection();
            //displaying the score
            scoreLabel.setText("Score: "+intscore+"  /  4");
            //inputing the name and corresponding score into scores.txt
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
            //reseting the score back to zero
            intscore = 0;
        }
        /**Creating a tryagain Button that resets the quiz*/
        else if(evt.getSource() == tryagainButton){
            //clearing all radio button groups
            group1.clearSelection();
            group2.clearSelection();
            group3.clearSelection();
            group4.clearSelection();
            
            //clearing the name and reseting the score.
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

    /**Using the mouse clicked to swtich between defferent menu option smoothly*/
    public void mouseClicked(MouseEvent evt){
        /**home menu option was pressed it goes back to the homepanel and resets all points*/
        if(evt.getSource() == homeMenu){
            System.out.println("home menu");
            theframe.setContentPane(thepanel);
            //reseting A point
            AxTxtField.setText("0");
            AxSlider.setValue(0);
            AyTxtField.setText("0");
            AySlider.setValue(0);
            AniPanel.PointAx = 665;
            AniPanel.PointAy = 265;
            //reseting B point
            BxTxtField.setText("0");
            BxSlider.setValue(0);
            ByTxtField.setText("0");
            BySlider.setValue(0);
            AniPanel.PointBx = 665;
            AniPanel.PointBy = 265;
            //reseting C point
            CxTxtField.setText("0");
            CxSlider.setValue(0);
            CyTxtField.setText("0");
            CySlider.setValue(0);
            AniPanel.PointCx = 665;
            AniPanel.PointCy = 265;
            //reseting D point
            DxTxtField.setText("0");
            DxSlider.setValue(0);
            DyTxtField.setText("0");
            DySlider.setValue(0);
            AniPanel.PointDx = 665;
            AniPanel.PointDy = 265;

            ResultsArea.setText("Area: ");
            ResultsPeri.setText("Perimeter: ");
            
            //repainting and revalidating the frame and panel
            AniPanel.repaint();
            theframe.revalidate();
            theframe.repaint();
        }
        /**going to the aboutPanel if the about menu option was pressed*/
        else if(evt.getSource() == aboutMenu){
            System.out.println("about menu");
            theframe.setContentPane(aboutPanel);
            theframe.revalidate();
            theframe.repaint();
        }
        /**going to the helpPanel if the help menu option was pressed*/
        else if(evt.getSource() == helpMenu){
            System.out.println("help menu");
            theframe.setContentPane(helpPanel);
            theframe.revalidate();
            theframe.repaint();
        }
        /**going to the scoresPanel if the scores menu option was pressed and showing the scores from scores.txt*/
        else if(evt.getSource() == scoresMenu){
            System.out.println("scores menu");
            theframe.setContentPane(scoresPanel);
            scoresTextArea.setText("");

            //reading the lines from scores.txt
            try{
                txtscoresOut = new BufferedReader(new FileReader("scores.txt"));
                strLine = txtscoresOut.readLine();
                while(strLine != null){
                    scoresTextArea.append(strLine+"\n");
                    strLine=txtscoresOut.readLine();
                }
                txtscoresOut.close();
               }catch(FileNotFoundException e){ 
                    System.out.println("File Not Found: todo.txt");
               }catch(IOException e){
                    System.out.println("Unable to read from the file or close the file");
               }

            //revalidating and repainting the frame
            theframe.revalidate();
            theframe.repaint();
        }
        /**going to the quizPanel if the quiz menu option was pressed*/
        else if(evt.getSource() == quizMenu){
            System.out.println("quiz menu");
            theframe.setContentPane(quizPanel);
            //revalidating and repainting the frame
            theframe.revalidate();
            theframe.repaint();
        }
    }

    /**Recieving data from each slider for each x and y. Adjusting the corresponding textfields to match the sliders*/
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

        //placing Point A label
        ALabel = new JLabel("Point A: (       ,       )");
        ALabel.setSize(200,50);
        ALabel.setLocation(30,0);
        thepanel.add(ALabel);
        //placing Ax textfield 
        AxTxtField = new JTextField("0");
        AxTxtField.setSize(22,17);
        AxTxtField.setLocation(85,17);
        AxTxtField.addActionListener(this);
        thepanel.add(AxTxtField); 
        //placing Ay textfield
        AyTxtField = new JTextField("0");
        AyTxtField.setSize(22,17);
        AyTxtField.setLocation(113,17);
        AyTxtField.addActionListener(this);
        thepanel.add(AyTxtField);
        //placing AxLabel
        AxLabel = new JLabel("Ax:");
        AxLabel.setSize(30,10);
        AxLabel.setLocation(30,40);
        thepanel.add(AxLabel);
        //placing AyLabel
        AyLabel = new JLabel("Ay:");
        AyLabel.setSize(30,20);
        AyLabel.setLocation(30,65);
        thepanel.add(AyLabel);
        //placing Axslider 
        AxSlider = new JSlider(-10,10,0);
        AxSlider.setSize(200,30);
        AxSlider.setLocation(55,35);
        AxSlider.setPaintTicks(true);
        AxSlider.setPaintTrack(true);
        AxSlider.setMajorTickSpacing(1);
        AxSlider.addChangeListener(this);
        thepanel.add(AxSlider);
        //placing Ayslider
        AySlider = new JSlider(-10,10,0);
        AySlider.setSize(200,30);
        AySlider.setLocation(55,65);
        AySlider.setPaintTicks(true);
        AySlider.setPaintTrack(true);
        AySlider.setMajorTickSpacing(1);
        AySlider.addChangeListener(this);
        thepanel.add(AySlider);

        //placing Point B Label
        BLabel = new JLabel("Point B: (       ,       )");
        BLabel.setSize(200,50);
        BLabel.setLocation(30,85);
        thepanel.add(BLabel);
        //placing Bx textfield 
        BxTxtField = new JTextField("0");
        BxTxtField.setSize(22,17);
        BxTxtField.setLocation(85,102);
        BxTxtField.addActionListener(this);
        thepanel.add(BxTxtField); 
        //placing By textfield 
        ByTxtField = new JTextField("0");
        ByTxtField.setSize(22,17);
        ByTxtField.setLocation(113,102);
        ByTxtField.addActionListener(this);
        thepanel.add(ByTxtField);
        //placing BxLabel
        BxLabel = new JLabel("Bx:");
        BxLabel.setSize(30,15);
        BxLabel.setLocation(30,120);
        thepanel.add(BxLabel);
        //placing ByLabel
        ByLabel = new JLabel("By:");
        ByLabel.setSize(30,20);
        ByLabel.setLocation(30,150);
        thepanel.add(ByLabel);
         //placing Bxslider
        BxSlider = new JSlider(-10,10,0);
        BxSlider.setSize(200,30);
        BxSlider.setLocation(55,120);
        BxSlider.setPaintTicks(true);
        BxSlider.setPaintTrack(true);
        BxSlider.setMajorTickSpacing(1);
        BxSlider.addChangeListener(this);
        thepanel.add(BxSlider);
         //placing Byslider
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
        //placing Cx textfield 
        CxTxtField = new JTextField("0");
        CxTxtField.setSize(22,17);
        CxTxtField.setLocation(85,187);
        CxTxtField.addActionListener(this);
        thepanel.add(CxTxtField); 
        //placing Cy textfield 
        CyTxtField = new JTextField("0");
        CyTxtField.setSize(22,17);
        CyTxtField.setLocation(113,187);
        CyTxtField.addActionListener(this);
        thepanel.add(CyTxtField);
        //placing CxLabel
        CxLabel = new JLabel("Cx:");
        CxLabel.setSize(30,10);
        CxLabel.setLocation(30,207);
        thepanel.add(CxLabel);
        //placing CyLabel
        CyLabel = new JLabel("Cy:");
        CyLabel.setSize(30,20);
        CyLabel.setLocation(30,232);
        thepanel.add(CyLabel);
         //placing Cxslider
        CxSlider = new JSlider(-10,10,0);
        CxSlider.setSize(200,30);
        CxSlider.setLocation(55,206);
        CxSlider.setPaintTicks(true);
        CxSlider.setPaintTrack(true);
        CxSlider.setMajorTickSpacing(1);
        CxSlider.addChangeListener(this);
        thepanel.add(CxSlider);
        //placing Cyslider
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
        //placing Dx textfield 
        DxTxtField = new JTextField("0");
        DxTxtField.setSize(22,17);
        DxTxtField.setLocation(85,272);
        DxTxtField.addActionListener(this);
        thepanel.add(DxTxtField); 
        //placing Dy textfield 
        DyTxtField = new JTextField("0");
        DyTxtField.setSize(22,17);
        DyTxtField.setLocation(113,272);
        DyTxtField.addActionListener(this);
        thepanel.add(DyTxtField);
        //placing DxLabel
        DxLabel = new JLabel("Dx:");
        DxLabel.setSize(30,15);
        DxLabel.setLocation(30,290);
        thepanel.add(DxLabel);
        //placing DyLabel
        DyLabel = new JLabel("Dy:");
        DyLabel.setSize(30,20);
        DyLabel.setLocation(30,317);
        thepanel.add(DyLabel);
        //placing Dxslider
        DxSlider = new JSlider(-10,10,0);
        DxSlider.setSize(200,30);
        DxSlider.setLocation(55,290);
        DxSlider.setPaintTicks(true);
        DxSlider.setPaintTrack(true);
        DxSlider.setMajorTickSpacing(1);
        DxSlider.addChangeListener(this);
        thepanel.add(DxSlider);
        //placing Dyslider
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
        //adding home to menu
        menuBar.add(homeMenu);
        homeMenu.addMouseListener(this);
        //adding About to menu
        menuBar.add(aboutMenu);
        aboutMenu.addMouseListener(this); 
        //adding Help to menu
        menuBar.add(helpMenu);
        helpMenu.addMouseListener(this);
        //adding Quiz to menu
        menuBar.add(quizMenu);
        quizMenu.addMouseListener(this);
        //adding scores to menu
        menuBar.add(scoresMenu);
        scoresMenu.addMouseListener(this);
        //adding menubar to the frame
        theframe.setJMenuBar(menuBar);


        //Quiz Panel
        quizPanel.setLayout(null);

        //placing quiz title on the quiz panel
        quizTitleLabel = new JLabel("Quiz: ");
        quizTitleLabel.setSize(100,15);
        quizTitleLabel.setLocation(450,15);
        quizPanel.add(quizTitleLabel);

        //placing question 1 label
        questionLabel1 = new JLabel("1. What concept is used for calculating the area of the quadralateral on a coordinate system?");
        questionLabel1.setSize(600,15);
        questionLabel1.setLocation(20,40);
        quizPanel.add(questionLabel1);
        //radiobutton for optionA in question 1
        optionA1 = new JRadioButton("A: Shoelace formula");
        optionA1.setSize(250,15);
        optionA1.setLocation(20,60);
        optionA1.addActionListener(this);
        quizPanel.add(optionA1);
        //radiobutton for optionB in question 1
        optionB1 = new JRadioButton("B: Pythagorean Theorem");
        optionB1.setSize(250,15);
        optionB1.setLocation(20,80);
        quizPanel.add(optionB1);
        //radiobutton for optionC in question 1
        optionC1 = new JRadioButton("C: Parallelogram Rule");
        optionC1.setSize(250,15);
        optionC1.setLocation(20,100);
        quizPanel.add(optionC1);
        //radiobutton for optionD in question 1
        optionD1 = new JRadioButton("D: Heron's formula");
        optionD1.setSize(250,15);
        optionD1.setLocation(20,120);
        quizPanel.add(optionD1);
        //Button group for all option in question1
        group1 = new ButtonGroup();
        group1.add(optionA1);
        group1.add(optionB1);
        group1.add(optionC1);
        group1.add(optionD1);

        //placing question 2 label
        questionLabel2 = new JLabel("2. What concept is used for calculating the perimeter of the quadralateral?");
        questionLabel2.setSize(500,15);
        questionLabel2.setLocation(20,160);
        quizPanel.add(questionLabel2);
        //radiobutton for optionA in question 2
        optionA2 = new JRadioButton("A: Circumference formula");
        optionA2.setSize(250,15);
        optionA2.setLocation(20,180);
        quizPanel.add(optionA2);
        //radiobutton for optionB in question 2
        optionB2 = new JRadioButton("B: Pythagorean Theorem");
        optionB2.setSize(250,15);
        optionB2.setLocation(20,200);
        optionB2.addActionListener(this);
        quizPanel.add(optionB2);
        //radiobutton for optionC in question 2        
        optionC2 = new JRadioButton("C: Parallelogram Rule");
        optionC2.setSize(250,15);
        optionC2.setLocation(20,220);
        quizPanel.add(optionC2);
        //radiobutton for optionD in question 2       
        optionD2 = new JRadioButton("D: Exponential growth formula");
        optionD2.setSize(250,15);
        optionD2.setLocation(20,240);
        quizPanel.add(optionD2);
        //Button group for all option in question2
        group2 = new ButtonGroup();
        group2.add(optionA2);
        group2.add(optionB2);
        group2.add(optionC2);
        group2.add(optionD2);

        //placing question 3 label
        questionLabel3 = new JLabel("3. To find the perimeter of a quadrailateral in the Cartesian plane, what is the correct sequence of steps?");
        questionLabel3.setSize(700,15);
        questionLabel3.setLocation(20,280);
        quizPanel.add(questionLabel3);
        //radiobutton for optionA in question 3
        optionA3 = new JRadioButton("A: calculate the sum of the lengths of all four sides");
        optionA3.setSize(500,15);
        optionA3.setLocation(20,300);
        quizPanel.add(optionA3);
        //radiobutton for optionB in question 3
        optionB3 = new JRadioButton("B: Subtract each x and y coordinate and add the difference");
        optionB3.setSize(500,15);
        optionB3.setLocation(20,320);
        quizPanel.add(optionB3);
        //radiobutton for optionC in question 3
        optionC3 = new JRadioButton("C: multiply he lengths of oppostie sides and add them together");
        optionC3.setSize(500,15);
        optionC3.setLocation(20,340);
        quizPanel.add(optionC3);
        //radiobutton for optionD in question 3
        optionD3 = new JRadioButton("D: Find the distrance between each pair of points, then add them");
        optionD3.setSize(500,15);
        optionD3.setLocation(20,360);
        optionD3.addActionListener(this);
        quizPanel.add(optionD3);
        //Button group for all option in question3
        group3 = new ButtonGroup();
        group3.add(optionA3);
        group3.add(optionB3);
        group3.add(optionC3);
        group3.add(optionD3);

        //placing question 4 label
        questionLabel4 = new JLabel("4. When does the Pythagorean Theorem work?: ");
        questionLabel4.setSize(500,15);
        questionLabel4.setLocation(20,400);
        quizPanel.add(questionLabel4);
        //radiobutton for optionA in question 4
        optionA4 = new JRadioButton("A: All Right Angle triangle");
        optionA4.setSize(400,15);
        optionA4.setLocation(20,420);
        optionA4.addActionListener(this);
        quizPanel.add(optionA4);
        //radiobutton for optionB in question 4
        optionB4 = new JRadioButton("B: All Equilateral triangles");
        optionB4.setSize(400,15);
        optionB4.setLocation(20,440);
        quizPanel.add(optionB4);
        //radiobutton for optionC in question 4
        optionC4 = new JRadioButton("C: All Isoceles triangles");
        optionC4.setSize(400,15);
        optionC4.setLocation(20,460);
        quizPanel.add(optionC4);
        //radiobutton for optionD in question 4
        optionD4 = new JRadioButton("D: All Acute triangles");
        optionD4.setSize(400,15);
        optionD4.setLocation(20,480);
        quizPanel.add(optionD4);
        //Button group for all option in question4
        group4 = new ButtonGroup();
        group4.add(optionA4);
        group4.add(optionB4);
        group4.add(optionC4);
        group4.add(optionD4);

        //submit button for the quiz
        submitButton = new JButton("Submit");
        submitButton.setSize(100,30);
        submitButton.setLocation(800,470);
        submitButton.addActionListener(this);
        quizPanel.add(submitButton);
        //score label for showing the results
        scoreLabel = new JLabel("Score: 0  /  4");
        scoreLabel.setSize(100,20);
        scoreLabel.setLocation(813,450);
        quizPanel.add(scoreLabel);
        //name label 
        nameLabel = new JLabel("Name: ");
        nameLabel.setSize(50,15);
        nameLabel.setLocation(770,15);
        quizPanel.add(nameLabel);
        //name textfield to receive input
        nameField = new JTextField("");
        nameField.setSize(120,20);
        nameField.setLocation(820,13);
        quizPanel.add(nameField);
        //button for trying again 
        tryagainButton = new JButton("Try again");
        tryagainButton.setSize(100,30);
        tryagainButton.setLocation(800,500);
        tryagainButton.addActionListener(this);
        quizPanel.add(tryagainButton);

        //scores panel
        scoresPanel.setLayout(null);
        //scores title label 
        scoreTitleLabel = new JLabel("Scores");
        scoreTitleLabel.setSize(100,15);
        scoreTitleLabel.setLocation(450,25);
        scoresPanel.add(scoreTitleLabel);
        //scores text area for containing 
        scoresTextArea = new JTextArea("");
        scoresTextArea.setBounds(230, 60, 500, 450); 
        scoresTextArea.setEditable(false);
        scoresPanel.add(scoresTextArea);
        //scorll pane for the scores text area
        scoresScroll = new JScrollPane(scoresTextArea);
        scoresScroll.setBounds(230, 60, 500, 450); 
        scoresScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scoresPanel.add(scoresScroll);
        theframe.setVisible(true);

        //Starttimer
        theTimer.start();

        //About image only showing for the about Panel
        imgAboutLabel = new JLabel();
        imgAboutLabel.setIcon(new ImageIcon(AniPanel.imgAbout));
        imgAboutLabel.setVisible(true);
        aboutPanel.add(imgAboutLabel);

        //Help Image only showing for the help Panel
        imgHelpLabel = new JLabel();
        imgHelpLabel.setIcon(new ImageIcon(AniPanel.imgHelp));
        imgHelpLabel.setVisible(true);
        helpPanel.add(imgHelpLabel);

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
