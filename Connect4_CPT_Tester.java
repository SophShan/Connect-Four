//Sophia Shantharupan
//November 9, 2020
//Runs two-player or one-player game of connect four.
import java.awt.Color;//imports class to change colour of GUI elements
import javax.swing.JOptionPane; //imports class to display different panes in GUI
import java.util.concurrent.ThreadLocalRandom; //imports random number class.
import javax.swing.ImageIcon; //imports class to add images into java (for Jframe icon)

class Connect4 //Create new class
{//Start Class
    boolean Win; //declare var
    Connect4_CPT_Tester c1;//declare var
Connect4 (boolean Win, Connect4 c2, int Array [][], Connect4_CPT_Tester c1) //Create new constructor
{//Start constructor
    this.Win=Win; //Set var to Win var in main
    this.c1=c1;//Set var to c1 var in main
}//End constructor

boolean Checkwin (int [][]Array) //Create method 
{//Start method
    for (int x=0; x<6; x++) //create for loop (x for rows)
     {//start for loop
	for (int y=0; y<4; y++) //create for loop (y for columns)
	 {//start for loop
            if (((Array [x][y]==1) && (Array [x][y+1]==1) && (Array [x][y+2]==1) && (Array [x][y+3]==1)) || ((Array [x][y]==2) && (Array [x][y+1]==2) && (Array [x][y+2]==2) && (Array [x][y+3]==2))) //true branch
                Win=true; //if true var=true
	 }// end for loop
     }//end for loop
    for (int y=0; y<7; y++)//create for loop
     {//start for loop
	for (int x=0; x<3; x++)//create for loop
	 {//start for loop
            if ((Array [x][y]==1) && (Array [x+1][y]==1) && (Array [x+2][y]==1) && (Array [x+3][y]==1) || (Array [x][y]==2) && (Array [x+1][y]==2) && (Array [x+2][y]==2) && (Array [x+3][y]==2))//true branch
                Win=true; //if true var=true
         }
     }// end for loop
    for (int i=0; i<2; i++)//create for loop
     {//start for loop
       for (int count=0; count<3; count++)//create for loop
        {//start for loop
            if ((Array [count] [count+i]==1) && (Array [1+count] [1+count+i]==1) && (Array [2+count] [2+count+i]==1) && (Array [3+count] [3+count+i]==1) || (Array [count] [count+i]==2) && (Array [1+count] [1+count+i]==2) && (Array [2+count] [2+count+i]==2) && (Array [3+count] [3+count+i]==2))//true branch
                Win=true; //if true var=true
        }// end for loop
    
        for (int count=0; count<3; count++)//create for loop
         {//start for loop
            if (((Array [5-count] [count+i]==1) && (Array [4-count] [count+i+1]==1) && (Array [3-count] [count+i+2]==1) && (Array [2-count] [count+i+3]==1)) || ((Array [5-count] [count+i]==2) && (Array [4-count] [count+i+1]==2) && (Array [3-count] [count+i+2]==2) && (Array [2-count] [count+i+3]==2)))//true branch
                Win=true; //if true var=true
         }// end for loop

     }// end for loop

    for (int count=0; count<2; count++)//create for loop, left side with 2 combinations
     {//start for loop
        if ((Array[4-count] [0+count]==1) && (Array[3-count] [1+count]==1) && (Array[2-count] [2+count]==1) && (Array[1-count] [3+count]==1) || (Array[4-count] [0+count]==2) && (Array[3-count] [1+count]==2) && (Array[2-count] [2+count]==2) && (Array[1-count] [3+count]==2))//true branch
            Win=true; //if true var=true
     }// end for loop
    
    for (int count=0; count<2; count++)//create for loop, right side with 2 combinations
     {//start for loop
	if ((Array[5-count] [2+count]==1) && (Array[4-count] [3+count]==1) && (Array[3-count] [4+count]==1) && (Array[2-count] [5+count]==1) || (Array[5-count] [2+count]==2) && (Array[4-count] [3+count]==2) && (Array[3-count] [4+count]==2) && (Array[2-count] [5+count]==2))//true branch
            Win=true; //if true var=true
     }// end for loop

    for (int count=0; count<2; count++)//create for loop, opposite side (right most side)
     {//start for loop
        if ((Array [5-count][4-count]==1) && (Array [4-count][3-count]==1) && (Array [3-count][2-count]==1) && (Array [2-count][1-count] ==1) || (Array [5-count][4-count]==2) && (Array [4-count][3-count]==2) && (Array [3-count][2-count]==2) && (Array [2-count][1-count] ==2))//true branch
            Win=true; //if true var=true
     }// end for loop
    
    for (int count=0; count<2; count++)//create for loop, opposite side (top right side to higher left
     {//start for loop
	if ((Array [4-count] [6-count]==1) && (Array [3-count] [5-count]==1) && (Array [2-count] [4-count]==1) && (Array [1-count] [3-count] ==1) || (Array [4-count] [6-count]==2) && (Array [3-count] [5-count]==2) && (Array [2-count] [4-count]==2) && (Array [1-count] [3-count] ==2))//true branch
            Win=true; //if true var=true
     }// end for loop

    if ((Array [3][0]==1) && (Array [2][1]==1) && (Array [1][2]==1) && (Array [0][3]==1) || (Array [3][0]==2) && (Array [2][1]==2) && (Array [1][2]==2) && (Array [0][3]==2))//true branch
        Win=true; //if true var=true
    else if ((Array [3][6]==1) && (Array [2][4]==1) && (Array [1][4]==1) && (Array [0][3]==1) || (Array [3][6]==2) && (Array [2][4]==2) && (Array [1][4]==2))//true branch
        Win=true; //if true var=true
   
    else if ((Array [5][3]==1) && (Array [4][2]==1) && (Array [3][1]==1) && (Array [2][0]==1) || (Array [5][3]==2) && (Array [4][2]==2) && (Array [3][1]==2) && (Array [2][0]==2))//true branch
        Win=true; //if true var=true
    
    else if ((Array [5][3]==1) && (Array [4][4]==1) && (Array [3][5]==1) && (Array [2][6]==1) || (Array [5][3]==2) && (Array [4][4]==2) && (Array [3][5]==2) && (Array [2][6]==2))//true branch
        Win=true; //if true, var= true
    return Win;
    }//End method

int[][] ResetArray (int [][]Array, boolean Win) //create method
{//Start method
    for (int x=0; x<6; x++)//declare/initiate x in for loop (x for rows)
      {//start loop
       for (int y=0; y<7; y++)//declare/initiate y in for loop (y for columns)
          Array [x][y]=0;//reassign array value 
      }//End loop
   return Array;//return var
}//end method
}//End Class

public class Connect4_CPT_Tester extends javax.swing.JFrame 
{//Start class
    Connect4 c2;//declare var
    int Array [][]; //declare var
    int Turn=0; //declare var
    int Player=1; //declare var
    boolean Reset=false;//declare var
    String PName1=new String (" ");//declare var/object
    String PName2= new String (" ");//declare var/object
    boolean Win;//declare var
    int num_of_players=0;//declare/initiate var
    int column;//declare var
    int count=0;//intitiate/declarevar
    String label_text=new String (" ");//declare String var/object
    ImageIcon icon;//creates var to store icon image
    
    
public Connect4_CPT_Tester(Connect4 c2, int Array [][], boolean Win, Connect4_CPT_Tester c1) //constructor
{//Start constructor
    initComponents();//method of all of the GUI elements
    this.c2= new Connect4 (Win, c2, Array, c1); //assigns var
    this.Array=Array; //assigns var
    icon=new ImageIcon ("Connect4symbol.jpg"); //store image in icon var
    setIconImage(icon.getImage()); //sets icon image to icon var- learned from https://youtu.be/9k033x6rNRo
}//End constructor 

//changes colour of each players name so players know whose turn it is, keeps track of turns
void Changelabel ()//create method
{//Start method
        if (Player==1)//True branch
         {//start true branch
            Player=2;//reassign var
            label3.setForeground(Color.yellow); //set label colour
            label2.setForeground(Color.white); //set label colour
          }//end true branch
        else//false branch
          {//start true branch
            Player=1;//reassign var
            label2.setForeground(Color.red); //set label colour
            label3.setForeground (Color.white); //set label colour
          }//end true branch
        Turn+=1;//reassign var
    }//End method  

//Displays who won or if the board is full
void Displaywin ()//Create method
{//Start method
    if (c2.Win==true && Player==1)//True branch
        JOptionPane.showMessageDialog(null, "Congratualtions "+PName1+"! You won! Please press reset to play again."); //outputs new window
    else if(c2.Win==true && Player==2 && num_of_players==1)//create branch
        JOptionPane.showMessageDialog(null, "Sorry " +PName1+ ". You lost. Please press reset to play again."); //outputs new window
    else if(c2.Win==true && Player==2)//create branch
        JOptionPane.showMessageDialog(null, "Congratualtions "+PName2+"! You won! Please press reset to play again."); //outputs new window
    else if (Turn==41)//create branch
        JOptionPane.showMessageDialog(null, "All slots are full. Neither player has won. Please press reset if you wish to play again."); //outputs new window
    if (Win==true)//true branch, will set reset to default so player is forced to press reset when trying to continue playing (meets condition of else if statment in each button method).
        Reset=false;//reassign var
}//End method

//all column methods were made so that they could be used for each button event and for the One_player method.
void column1 ()//create method
{//start method
    if (Array[0][0]!=0)//true branch, ensures players do not try to place a game piece in a full column
        JOptionPane.showMessageDialog(null, "Please choose a column that is not full."); //will output a window
    else if (Array [5][0]==0) //create branch, else if statements ensure the pieces dropped start at the bottom most slot.
     {//Start branch
        label11.setText("O"); //set label text
            if (Player==1)//True branch, will assign a different number to the array and display a different colour piece depending on the player
             {//Start true branch
                label11.setForeground(Color.red); //set label colour
                Array [5][0]=1; //Reassign array value
             }//End true branch
            else//flase branch
             {//start false branch
                label11.setForeground(Color.yellow); //set label colour
                Array [5][0]=2; //Reassign array value
             }//End false branch
     }//end branch
    else if (Array [4][0]==0) //create branch
     {//Start branch
        label12.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label12.setForeground(Color.red);//set label colour
                Array [4][0]=1; //Reassign array value
             }//End true branch
            else//False branch
             {//Start false branch
                label12.setForeground(Color.yellow);//set label colour
                Array [4][0]=2; //Reassign array value
             }//End false branch
     }//end branch
    else if (Array [3][0]==0)//create branch
     {//Start branch
        label10.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label10.setForeground(Color.red);//set label colour
                Array [3][0]=1; //Reassign array value
             }//end true branch
            else//false branch
             {//start false branch
                label10.setForeground(Color.yellow);//set label colour
                Array [3][0]=2; //Reassign array value
             }//End false branch
     }//end branch
    else if (Array [2][0]==0)//create branch
     {//Start branch
        label9.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label9.setForeground(Color.red);//set label colour
                Array [2][0]=1; //Reassign array value
             }//end true branch
            else//false branch
             {//start false branch
                label9.setForeground(Color.yellow);//set label colour
                Array [2][0]=2; //Reassign array value
             }//End false branch
     }//end branch
    else if (Array [1][0]==0)//create branch
     {//Start branch
        label8.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label8.setForeground(Color.red);//set label colour
                Array [1][0]=1; //Reassign array value
             }//end true branch
            else//false branch
             {//start false branch
                label8.setForeground(Color.yellow);//set label colour
                Array [1][0]=2; //Reassign array value
             }//End false branch
     }//end branch
    else if (Array [0][0]==0)//create branch
     {//Start branch
        label7.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label7.setForeground(Color.red);//set label colour
                Array [0][0]=1; //Reassign array value
             }//end true branch
            else//false brnach
             {//start false branch
                label7.setForeground(Color.yellow);//set label colour
                Array [0][0]=2; //Reassign array value
             }//End false branch
     }//end branch
    c2.Checkwin(Array);//calls method, checks for win after each turn
    Displaywin();//calls method, checks to see if a win needs to be announced/end of game each turn
    Changelabel (); //calls method, will change colour of player labels and keep track of turns each turn
}//End method
    
void column2()//create method
{//Start method
    if (Array[0][1]!=0)//true branch
            JOptionPane.showMessageDialog(null, "Please choose a column that is not full."); //will output a window
    else if (Array [5][1]==0)//create branch
     {//Start true branch
        label13.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label13.setForeground(Color.red);//set label colour
                Array [5][1]=1; //Reassign array value
             }//End true branch
            else//false branch
             {//Start false branch
                label13.setForeground(Color.yellow);//set label colour
                Array [5][1]=2; //Reassign array value
             }//End false branch
     }//end true branch
    else if (Array [4][1]==0)//create branch
     {//Start branch
        label14.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label14.setForeground(Color.red);//set label colour
                Array [4][1]=1; //Reassign array value
             }//End true branch
            else//false branch
             {//Start false branch
                label14.setForeground(Color.yellow);//set label colour
                Array [4][1]=2; //Reassign array value
             }//End false branch
     }//end branch
    else if (Array [3][1]==0)//create branch
     {//Start branch
        label15.setText("O");//set label text
            if (Player==1)//True branch
             {//Start true branch
                label15.setForeground(Color.red);//set label colour
                Array [3][1]=1; //Reassign array value
             }//End true branch
            else//false branch
             {//Start false branch
                label15.setForeground(Color.yellow);//set label colour
                Array [3][1]=2; //Reassign array value
             }//End false branch
     }//end branch
    else if (Array [2][1]==0)//create branch
     {//Start branch
        label16.setText("O");//set label text
            if (Player==1)//True branch
             {//Start true branch
                label16.setForeground(Color.red);//set label colour
                Array [2][1]=1; //Reassign array value
             }//End true branch
            else//false branch
             {//Start false branch
                label16.setForeground(Color.yellow);//set label colour
                Array [2][1]=2; //Reassign array value
             }//End false branch
     }//end branch
     else if (Array [1][1]==0)//create branch
     {//Start branch
        label17.setText("O");//set label text
            if (Player==1)//True branch
             {//Start true branch
                label17.setForeground(Color.red); //set label colour
                Array [1][1]=1; //Reassign array value
             }//End true branch
            else//false branch
             {//Start false branch
                label17.setForeground(Color.yellow); //set label colour
                Array [1][1]=2; //Reassign array value
             }//End false branch
    }//end branch
    else if (Array [0][1]==0)//create branch
     {//Start branch
        label18.setText("O");//set label text
            if (Player==1)//True branch
             {//Start true branch
                label18.setForeground(Color.red); //set label colour
                Array [0][1]=1; //Reassign array value
             }//End true branch
            else//false branch
             {//Start false branch
                label18.setForeground(Color.yellow); //set label colour
                Array [0][1]=2; //Reassign array value
             }//End false branch
         }//end branch
    c2.Checkwin(Array);//calls method
    Displaywin();//calls method
    Changelabel (); //calls method
}//End method

void column3()//create method
{//Start method
    if (Array[0][2]!=0)//true branch
            JOptionPane.showMessageDialog(null, "Please choose a column that is not full."); //will output a window
    else if (Array [5][2]==0)//create branch
     {//Start true branch
        label19.setText("O"); //set label text
        if (Player==1)//True branch
         {//Start true branch
            label19.setForeground(Color.red);//set label colour
            Array [5][2]=1; //Reassign array value
         }//End true branch
        else//false branch
         {//Start false branch
            label19.setForeground(Color.yellow);//set label colour
            Array [5][2]=2; //Reassign array value
         }//End false branch
     }//End true branch
    else if (Array [4][2]==0)//create branch
     {//Start branch
        label20.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label20.setForeground(Color.red);//set label colour
                Array [4][2]=1; //Reassign array value
             }//End true branch
            else//false branch
             {//Start false branch
                label20.setForeground(Color.yellow);//set label colour
                Array [4][2]=2; //Reassign array value
             }//End false branch
     }//end branch
    else if (Array [3][2]==0)//create branch
     {//Start branch
        label21.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label21.setForeground(Color.red);//set label colour
                Array [3][2]=1; //Reassign array value
             }//End true branch
            else//false branch
             {//Start false branch
                label21.setForeground(Color.yellow);//set label colour
                Array [3][2]=2; //Reassign array value
             }//End false branch
     }//end branch
    else if (Array [2][2]==0)//create branch
     {//Start branch
        label22.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label22.setForeground(Color.red);//set label colour
                Array [2][2]=1; //Reassign array value
             }//End true branch
            else//false branch
             {//Start false branch
                label22.setForeground(Color.yellow);//set label colour
                Array [2][2]=2; //Reassign array value
             }//End false branch
     }//end branch
    else if (Array [1][2]==0)//create branch
     {//Start branch
        label23.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label23.setForeground(Color.red);//set label colour
                Array [1][2]=1; //Reassign array value
             }//End true branch
            else//false branch
             {//Start false branch
                label23.setForeground(Color.yellow);//set label colour
                Array [1][2]=2; //Reassign array value
             }//End false branch
     }//end branch
    else if (Array [0][2]==0)//create branch
     {//Start branch
        label24.setText("O"); //set label text
            if (Player==1)//True branch
             {//Start true branch
                label24.setForeground(Color.red);//set label colour
                Array [0][2]=1; //Reassign array value
             }//End true branch
            else//false branch
             {//Start false branch
                label24.setForeground(Color.yellow);//set label colour
                Array [0][2]=2; //Reassign array value
             }//End false branch
    }//end branch
    c2.Checkwin(Array);//calls method
    Displaywin();//calls method
    Changelabel (); //calls method
}//End method

void column4()//create method
{//Start method
    if (Array[0][3]!=0)//true branch
            JOptionPane.showMessageDialog(null, "Please choose a column that is not full."); //will output a window
    else if (Array [5][3]==0) //create branch
    {//Start true branch
        label25.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label25.setForeground(Color.red); //set label colour
                Array [5][3]=1; //Reassign array value
            }//End true branch
            else//flase branch
             {//start false branch
                label25.setForeground(Color.yellow); //set label colour
                Array [5][3]=2; //Reassign array value
             }//End false branch
    }//end branch
    else if (Array [4][3]==0) //create branch
    {//Start branch
        label26.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label26.setForeground(Color.red);//set label colour
                Array [4][3]=1; //Reassign array value
            }//End true branch
            else//False branch
            {//Start false branch
                label26.setForeground(Color.yellow);//set label colour
                Array [4][3]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [3][3]==0)//create branch
    {//Start branch
        label27.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label27.setForeground(Color.red);//set label colour
                Array [3][3]=1; //Reassign array value
            }//end true branch
            else//false branch
            {//start false branch
                label27.setForeground(Color.yellow);//set label colour
                Array [3][3]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [2][3]==0)//create branch
    {//Start branch
        label49.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label49.setForeground(Color.red);//set label colour
                Array [2][3]=1; //Reassign array value
            }//end true branch
            else//false branch
            {//start false branch
                label49.setForeground(Color.yellow);//set label colour
                Array [2][3]=2; //Reassign array value
            }//End false branch
    }//end branch
     else if (Array [1][3]==0)//create branch
    {//Start branch
        label29.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label29.setForeground(Color.red);//set label colour
                Array [1][3]=1; //Reassign array value
            }//end true branch
            else//false branch
            {//start false branch
                label29.setForeground(Color.yellow);//set label colour
                Array [1][3]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [0][3]==0)//create branch
    {//Start branch
        label30.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label30.setForeground(Color.red);//set label colour
                Array [0][3]=1; //Reassign array value
            }//end true branch
            else//false brnach
            {//start false branch
                label30.setForeground(Color.yellow);//set label colour
                Array [0][3]=2; //Reassign array value
            }//End false branch
    }//end false branch
    c2.Checkwin(Array);//calls method
    Displaywin();//calls method
    Changelabel (); //calls method
}//End method

void column5()//create method
{//Start method
    if (Array[0][4]!=0)//true branch
            JOptionPane.showMessageDialog(null, "Please choose a column that is not full."); //will output a window
    else if (Array [5][4]==0) //create branch
    {//Start true branch
        label31.setText("O"); //set label text
        if (Player==1)//True branch
        {//Start true branch
            label31.setForeground(Color.red); //set label colour
            Array [5][4]=1; //Reassign array value
        }//End true branch
        else//flase branch
         {//start false branch
            label31.setForeground(Color.yellow); //set label colour
            Array [5][4]=2; //Reassign array value
         }//End false branch
    }//end branch
    else if (Array [4][4]==0) //create branch
    {//Start branch
        label32.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label32.setForeground(Color.red);//set label colour
                Array [4][4]=1; //Reassign array value
            }//End true branch
            else//False branch
            {//Start false branch
                  label32.setForeground(Color.yellow);//set label colour
                  Array [4][4]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [3][4]==0)//create branch
    {//Start branch
        label33.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label33.setForeground(Color.red);//set label colour
                Array [3][4]=1; //Reassign array value
            }//end true branch
            else//false branch
            {//start false branch
                label33.setForeground(Color.yellow);//set label colour
                Array [3][4]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [2][4]==0)//create branch
    {//Start branch
        label34.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label34.setForeground(Color.red);//set label colour
                Array [2][4]=1; //Reassign array value
            }//end true branch
            else//false branch
            {//start false branch
                label34.setForeground(Color.yellow);//set label colour
                Array [2][4]=2; //Reassign array value
            }//End false branch
    }//end branch
     else if (Array [1][4]==0)//create branch
    {//Start branch
        label35.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label35.setForeground(Color.red);//set label colour
                Array [1][4]=1; //Reassign array value
            }//end true branch
            else//false branch
            {//start false branch
                label35.setForeground(Color.yellow);//set label colour
                Array [1][4]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [0][4]==0)//create branch
    {//Start branch
        label36.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label36.setForeground(Color.red);//set label colour
                Array [0][4]=1; //Reassign array value
            }//end true branch
            else//false brnach
            {//start false branch
                label36.setForeground(Color.yellow);//set label colour
                Array [0][4]=2; //Reassign array value
            }//End false branch
    }//end branch
    c2.Checkwin(Array);//calls method
    Displaywin();//calls method
    Changelabel (); //calls method
}//End method

void column6()//create method
{//Start method
    if (Array[0][5]!=0)//true branch
            JOptionPane.showMessageDialog(null, "Please choose a column that is not full."); //will output a window
    else if (Array [5][5]==0) //True branch
    {//Start true branch
        label37.setText("O"); //set label text
        if (Player==1)//True branch
        {//Start true branch
            label37.setForeground(Color.red); //set label colour
            Array [5][5]=1; //Reassign array value
        }//End true branch
        else//false branch
         {//start false branch
            label37.setForeground(Color.yellow); //set label colour
            Array [5][5]=2; //Reassign array value
         }//End false branch
    }//end branch
    else if (Array [4][5]==0) //create branch
    {//Start branch
        label38.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label38.setForeground(Color.red);//set label colour
                Array [4][5]=1; //Reassign array value
            }//End true branch
            else//False branch
            {//Start false branch
                  label38.setForeground(Color.yellow);//set label colour
                  Array [4][5]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [3][5]==0)//create branch
    {//Start branch
        label39.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label39.setForeground(Color.red);//set label colour
                Array [3][5]=1; //Reassign array value
            }//end true branch
            else//false branch
            {//start false branch
                  label39.setForeground(Color.yellow);//set label colour
                  Array [3][5]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [2][5]==0)//create branch
    {//Start branch
        label40.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label40.setForeground(Color.red);//set label colour
                Array [2][5]=1; //Reassign array value
            }//end true branch
            else//false branch
            {//start false branch
                  label40.setForeground(Color.yellow);//set label colour
                  Array [2][5]=2; //Reassign array value
            }//End false branch
    }//end branch
     else if (Array [1][5]==0)//create branch
    {//Start branch
        label41.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label41.setForeground(Color.red);//set label colour
                Array [1][5]=1; //Reassign array value
            }//end true branch
            else//false branch
            {//start false branch
                  label41.setForeground(Color.yellow);//set label colour
                  Array [1][5]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [0][5]==0)//create branch
    {//Start branch
        label42.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label42.setForeground(Color.red);//set label colour
                Array [0][5]=1; //Reassign array value
            }//end true branch
            else//false brnach
            {//start false branch
                  label42.setForeground(Color.yellow);//set label colour
                  Array [0][5]=2; //Reassign array value
            }//End false branch
    }//end branch
    c2.Checkwin(Array);//calls method
    Displaywin();//calls method
    Changelabel (); //calls method
}//End method
    
void column7()//create method
{//Start method
    if (Array[0][6]!=0)//true branch
            JOptionPane.showMessageDialog(null, "Please choose a column that is not full."); //will output a window
    else if (Array [5][6]==0)//create branch
    {//Start true branch
        label4.setText("O"); //set label text
        if (Player==1)//True branch
        {//Start true branch
            label4.setForeground(Color.red);//set label colour
            Array [5][6]=1; //Reassign array value
        }//End true branch
        else//false branch
         {//Start false branch
            label4.setForeground(Color.yellow);//set label colour
            Array [5][6]=2; //Reassign array value
         }//End false branch
    }//End true branch
    else if (Array [4][6]==0)//create branch
    {//Start branch
        label5.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label5.setForeground(Color.red);//set label colour
                Array [4][6]=1; //Reassign array value
            }//End true branch
            else//false branch
            {//Start false branch
                label5.setForeground(Color.yellow);//set label colour
                Array [4][6]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [3][6]==0)//create branch
    {//Start branch
        label43.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label43.setForeground(Color.red);//set label colour
                Array [3][6]=1; //Reassign array value
            }//End true branch
            else//false branch
            {//Start false branch
                label43.setForeground(Color.yellow);//set label colour
                Array [3][6]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [2][6]==0)//create branch
    {//Start branch
        label44.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label44.setForeground(Color.red);//set label colour
                Array [2][6]=1; //Reassign array value
            }//End true branch
            else//false branch
            {//Start false branch
                label44.setForeground(Color.yellow);//set label colour
                Array [2][6]=2; //Reassign array value
            }//End false branch
    }//end branch
     else if (Array [1][6]==0)//create branch
    {//Start branch
        label45.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label45.setForeground(Color.red);//set label colour
                Array [1][6]=1; //Reassign array value
            }//End true branch
            else//false branch
            {//Start false branch
                label45.setForeground(Color.yellow);//set label colour
                Array [1][6]=2; //Reassign array value
            }//End false branch
    }//end branch
    else if (Array [0][6]==0)//create branch
    {//Start branch
        label46.setText("O"); //set label text
            if (Player==1)//True branch
            {//Start true branch
                label46.setForeground(Color.red);//set label colour
                Array [0][6]=1; //Reassign array value
            }//End true branch
            else//false branch
            {//Start false branch
                label46.setForeground(Color.yellow);//set label colour
                Array [0][6]=2; //Reassign array value
            }//End false branch
    }//end branch
    c2.Checkwin(Array);//calls method
    Displaywin();//calls method
    Changelabel (); //calls method
}//End method

void One_player ()//create method
{//start method
        if (num_of_players==1 && c2.Win==false)//true branch, will run as long as player 1 has not won and 1 player is selected.
         {//start true branch
            do //create do while loop
             {//start do while loop
                 column=ThreadLocalRandom.current().nextInt(0, 6); //assigns var a random int from 0 to 5 (picks which column a piece will be dropped.)
             }while(Array[0][column]!=0); //condition of loop, makes sure a column that is full is not picked.
                if (column==0)//true branch
                    column1();//calls method
                else if (column==1)//true branch
                    column2();//calls method
                else if (column==2)//true branch
                    column3();//calls method
                else if (column==3)//true branch
                    column4();//calls method
                else if (column==4)//true branch
                    column5();//calls method
                else if (column==5)//true branch
                    column6();//calls method
                else if (column==6)//true branch
                    column7();//calls method
    }//end true branch
}//end method
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();
        button6 = new java.awt.Button();
        button7 = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        label7 = new java.awt.Label();
        button9 = new java.awt.Button();
        button8 = new java.awt.Button();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label18 = new java.awt.Label();
        jPanel5 = new javax.swing.JPanel();
        label16 = new java.awt.Label();
        jPanel6 = new javax.swing.JPanel();
        label6 = new java.awt.Label();
        label8 = new java.awt.Label();
        jPanel7 = new javax.swing.JPanel();
        label22 = new java.awt.Label();
        jPanel8 = new javax.swing.JPanel();
        label30 = new java.awt.Label();
        jPanel9 = new javax.swing.JPanel();
        label41 = new java.awt.Label();
        jPanel10 = new javax.swing.JPanel();
        label45 = new java.awt.Label();
        jPanel11 = new javax.swing.JPanel();
        label24 = new java.awt.Label();
        jPanel12 = new javax.swing.JPanel();
        label46 = new java.awt.Label();
        jPanel13 = new javax.swing.JPanel();
        label44 = new java.awt.Label();
        jPanel14 = new javax.swing.JPanel();
        label49 = new java.awt.Label();
        jPanel15 = new javax.swing.JPanel();
        label23 = new java.awt.Label();
        jPanel16 = new javax.swing.JPanel();
        label17 = new java.awt.Label();
        jPanel17 = new javax.swing.JPanel();
        label35 = new java.awt.Label();
        jPanel18 = new javax.swing.JPanel();
        label36 = new java.awt.Label();
        jPanel19 = new javax.swing.JPanel();
        label29 = new java.awt.Label();
        jPanel20 = new javax.swing.JPanel();
        label9 = new java.awt.Label();
        jPanel21 = new javax.swing.JPanel();
        label15 = new java.awt.Label();
        jPanel22 = new javax.swing.JPanel();
        label34 = new java.awt.Label();
        jPanel23 = new javax.swing.JPanel();
        label42 = new java.awt.Label();
        jPanel24 = new javax.swing.JPanel();
        label10 = new java.awt.Label();
        jPanel25 = new javax.swing.JPanel();
        label27 = new java.awt.Label();
        jPanel26 = new javax.swing.JPanel();
        label40 = new java.awt.Label();
        jPanel27 = new javax.swing.JPanel();
        label21 = new java.awt.Label();
        jPanel28 = new javax.swing.JPanel();
        label12 = new java.awt.Label();
        jPanel29 = new javax.swing.JPanel();
        label11 = new java.awt.Label();
        jPanel30 = new javax.swing.JPanel();
        label43 = new java.awt.Label();
        jPanel31 = new javax.swing.JPanel();
        label33 = new java.awt.Label();
        jPanel32 = new javax.swing.JPanel();
        label39 = new java.awt.Label();
        jPanel4 = new javax.swing.JPanel();
        label14 = new java.awt.Label();
        jPanel33 = new javax.swing.JPanel();
        label25 = new java.awt.Label();
        jPanel34 = new javax.swing.JPanel();
        label26 = new java.awt.Label();
        jPanel35 = new javax.swing.JPanel();
        label19 = new java.awt.Label();
        jPanel36 = new javax.swing.JPanel();
        label20 = new java.awt.Label();
        jPanel37 = new javax.swing.JPanel();
        label13 = new java.awt.Label();
        jPanel38 = new javax.swing.JPanel();
        label32 = new java.awt.Label();
        jPanel39 = new javax.swing.JPanel();
        label38 = new java.awt.Label();
        jPanel40 = new javax.swing.JPanel();
        label5 = new java.awt.Label();
        jPanel41 = new javax.swing.JPanel();
        label31 = new java.awt.Label();
        jPanel42 = new javax.swing.JPanel();
        label37 = new java.awt.Label();
        jPanel43 = new javax.swing.JPanel();
        label4 = new java.awt.Label();
        button10 = new java.awt.Button();
        button11 = new java.awt.Button();
        label47 = new java.awt.Label();
        label48 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        button3.setBackground(new java.awt.Color(255, 255, 0));
        button3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button3.setLabel("Drop Here");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(255, 255, 0));
        button4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button4.setLabel("Drop Here");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setBackground(new java.awt.Color(255, 255, 0));
        button5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button5.setLabel("Drop Here");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.setBackground(new java.awt.Color(255, 255, 0));
        button6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button6.setLabel("Drop Here");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button7.setBackground(new java.awt.Color(255, 255, 0));
        button7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button7.setLabel("Drop Here");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("CONNECT FOUR");

        button1.setBackground(new java.awt.Color(255, 255, 0));
        button1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button1.setLabel("Drop Here");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(255, 255, 0));
        button2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button2.setLabel("Drop Here");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(75, 75));

        label7.setAlignment(java.awt.Label.CENTER);
        label7.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label7.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        button9.setActionCommand("RESET");
        button9.setBackground(new java.awt.Color(255, 255, 0));
        button9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        button9.setLabel("RESET");
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        button8.setBackground(new java.awt.Color(255, 255, 0));
        button8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        button8.setLabel("Instructions");
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 36)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Player 1");

        label3.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 36)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Player 2");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(75, 75));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label1.setMaximumSize(new java.awt.Dimension(4000, 4000));
        label1.setPreferredSize(new java.awt.Dimension(60, 40));

        label18.setAlignment(java.awt.Label.CENTER);
        label18.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label18.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(label18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(75, 75));

        label16.setAlignment(java.awt.Label.CENTER);
        label16.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label16.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(75, 75));

        label6.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label6.setPreferredSize(new java.awt.Dimension(44, 54));

        label8.setAlignment(java.awt.Label.CENTER);
        label8.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label8.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(75, 75));

        label22.setAlignment(java.awt.Label.CENTER);
        label22.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label22.setName(""); // NOI18N
        label22.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(75, 75));

        label30.setAlignment(java.awt.Label.CENTER);
        label30.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label30.setName(""); // NOI18N
        label30.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(75, 75));

        label41.setAlignment(java.awt.Label.CENTER);
        label41.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label41.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(75, 75));

        label45.setAlignment(java.awt.Label.CENTER);
        label45.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label45.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(75, 75));

        label24.setAlignment(java.awt.Label.CENTER);
        label24.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label24.setName(""); // NOI18N
        label24.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(label24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(label24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(75, 75));

        label46.setAlignment(java.awt.Label.CENTER);
        label46.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label46.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(75, 75));

        label44.setAlignment(java.awt.Label.CENTER);
        label44.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label44.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(75, 75));

        label49.setAlignment(java.awt.Label.CENTER);
        label49.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label49.setName(""); // NOI18N
        label49.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(75, 75));

        label23.setAlignment(java.awt.Label.CENTER);
        label23.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label23.setName(""); // NOI18N
        label23.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(75, 75));

        label17.setAlignment(java.awt.Label.CENTER);
        label17.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label17.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(75, 75));

        label35.setAlignment(java.awt.Label.CENTER);
        label35.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label35.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(label35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addComponent(label35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(75, 75));

        label36.setAlignment(java.awt.Label.CENTER);
        label36.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label36.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(label36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addComponent(label36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(75, 75));

        label29.setAlignment(java.awt.Label.CENTER);
        label29.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label29.setName(""); // NOI18N
        label29.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(75, 75));

        label9.setAlignment(java.awt.Label.CENTER);
        label9.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label9.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(75, 75));

        label15.setAlignment(java.awt.Label.CENTER);
        label15.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label15.setName(""); // NOI18N
        label15.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(75, 75));

        label34.setAlignment(java.awt.Label.CENTER);
        label34.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label34.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(label34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addComponent(label34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(75, 75));

        label42.setAlignment(java.awt.Label.CENTER);
        label42.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label42.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(75, 75));

        label10.setAlignment(java.awt.Label.CENTER);
        label10.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label10.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setPreferredSize(new java.awt.Dimension(75, 75));

        label27.setAlignment(java.awt.Label.CENTER);
        label27.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label27.setName(""); // NOI18N
        label27.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setPreferredSize(new java.awt.Dimension(75, 75));

        label40.setAlignment(java.awt.Label.CENTER);
        label40.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label40.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setPreferredSize(new java.awt.Dimension(75, 75));

        label21.setAlignment(java.awt.Label.CENTER);
        label21.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label21.setName(""); // NOI18N
        label21.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setPreferredSize(new java.awt.Dimension(75, 75));

        label12.setAlignment(java.awt.Label.CENTER);
        label12.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label12.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setPreferredSize(new java.awt.Dimension(75, 75));

        label11.setAlignment(java.awt.Label.CENTER);
        label11.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label11.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setPreferredSize(new java.awt.Dimension(75, 75));

        label43.setAlignment(java.awt.Label.CENTER);
        label43.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label43.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setPreferredSize(new java.awt.Dimension(75, 75));

        label33.setAlignment(java.awt.Label.CENTER);
        label33.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label33.setName(""); // NOI18N
        label33.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(label33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addComponent(label33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setPreferredSize(new java.awt.Dimension(75, 75));

        label39.setAlignment(java.awt.Label.CENTER);
        label39.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label39.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(75, 75));

        label14.setAlignment(java.awt.Label.CENTER);
        label14.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label14.setMinimumSize(new java.awt.Dimension(50, 70));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setPreferredSize(new java.awt.Dimension(75, 75));

        label25.setAlignment(java.awt.Label.CENTER);
        label25.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label25.setName(""); // NOI18N
        label25.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(label25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addComponent(label25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setPreferredSize(new java.awt.Dimension(75, 75));

        label26.setAlignment(java.awt.Label.CENTER);
        label26.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label26.setName(""); // NOI18N
        label26.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(label26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addComponent(label26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setPreferredSize(new java.awt.Dimension(75, 75));

        label19.setAlignment(java.awt.Label.CENTER);
        label19.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label19.setName(""); // NOI18N
        label19.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setPreferredSize(new java.awt.Dimension(75, 75));

        label20.setAlignment(java.awt.Label.CENTER);
        label20.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label20.setName(""); // NOI18N
        label20.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(label20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addComponent(label20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setPreferredSize(new java.awt.Dimension(75, 75));

        label13.setAlignment(java.awt.Label.CENTER);
        label13.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label13.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel38.setPreferredSize(new java.awt.Dimension(75, 75));

        label32.setAlignment(java.awt.Label.CENTER);
        label32.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label32.setName(""); // NOI18N
        label32.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(label32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(label32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel39.setPreferredSize(new java.awt.Dimension(75, 75));

        label38.setAlignment(java.awt.Label.CENTER);
        label38.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label38.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(label38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(label38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel40.setPreferredSize(new java.awt.Dimension(75, 75));

        label5.setAlignment(java.awt.Label.CENTER);
        label5.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label5.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel41.setPreferredSize(new java.awt.Dimension(75, 75));

        label31.setAlignment(java.awt.Label.CENTER);
        label31.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label31.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel42.setPreferredSize(new java.awt.Dimension(75, 75));

        label37.setAlignment(java.awt.Label.CENTER);
        label37.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label37.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addComponent(label37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addComponent(label37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setMinimumSize(new java.awt.Dimension(80, 80));
        jPanel43.setPreferredSize(new java.awt.Dimension(75, 75));

        label4.setAlignment(java.awt.Label.CENTER);
        label4.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        label4.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        button10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        button10.setLabel("One Player");
        button10.setName(""); // NOI18N
        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10ActionPerformed(evt);
            }
        });

        button11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        button11.setLabel("Two Player");
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        label47.setAlignment(java.awt.Label.CENTER);
        label47.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        label47.setForeground(new java.awt.Color(255, 255, 255));
        label47.setText("Choose number");

        label48.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        label48.setForeground(new java.awt.Color(255, 255, 255));
        label48.setText("of players:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(label47, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE))))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(button10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                            .addComponent(label48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(112, 112, 112))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(label47, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(label48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68)
                        .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        button1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        //First column Array-[0]
        if (num_of_players==0)//true branch, if and if else statments ensures game is always reset/num of players is always selected
            JOptionPane.showMessageDialog(null, "Please select the number of players.");//outputs a window
        else if ((c2.Win==true) || (Turn==42)) //create branch
            JOptionPane.showMessageDialog (null, "Please press the RESET button. "); //outputs new window
        else//false branch
         {//start false branch
            column1();//call method
            One_player();//call method
         }//end false branch
    }//GEN-LAST:event_button1ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // Fourth column Array-[3]
        if (num_of_players==0)//true branch
            JOptionPane.showMessageDialog(null, "Please select the number of players.");//outputs a window
        else if (c2.Win==true||Turn==42) //Create branch
            JOptionPane.showMessageDialog (null, "Please press the RESET button. "); //outputs new window
        else//false branch
         {//Start false branch
            column4();//calls method
            One_player();//calls method
         }//End false branch
    }//GEN-LAST:event_button4ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // Third column Array-[2]
        if (num_of_players==0)//true branch
            JOptionPane.showMessageDialog(null, "Please select the number of players.");//outputs a window
        else if ((c2.Win==true) || (Turn==42)) //create branch
            JOptionPane.showMessageDialog (null, "Please press the RESET button. "); //outputs new window
        else//false branch
         {//Start false branch
            column3();//calls method
            One_player();//calls method
         }//End false branch
    }//GEN-LAST:event_button3ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // Second column Array-[1]
        if (num_of_players==0)//true branch
            JOptionPane.showMessageDialog(null, "Please select the number of players.");//outputs a window
        else if (c2.Win==true || Turn==42) //create branch
            JOptionPane.showMessageDialog (null, "Please press the RESET button. "); //outputs new window
        else//false branch
         {//Start false branch
            column2();//call method
            One_player();//call method
         }//End false branch
    }//GEN-LAST:event_button2ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // Fifth column Array-[4]
        if (num_of_players==0)//true branch
            JOptionPane.showMessageDialog(null, "Please select the number of players.");//outputs a window
        else if (c2.Win==true ||Turn==42) //create branch
            JOptionPane.showMessageDialog (null, "Please press the RESART button. "); //outputs new window
        else//false branch
         {//Start false branch
            column5();//calls method
            One_player();//calls method
         }//End false branch
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // Sixth column Array-[5]
        if (num_of_players==0)//true branch
            JOptionPane.showMessageDialog(null, "Please select the number of players.");//outputs a window
        else if (c2.Win==true || Turn==42) //create branch
            JOptionPane.showMessageDialog (null, "Please press the RESART button. "); //outputs new window
        else//false branch
         {//Start false branch
            column6();//calls method
            One_player();//calls method
         }//End false branch
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // Seventh column Array-[6]
        if (num_of_players==0)//true branch
            JOptionPane.showMessageDialog(null, "Please select the number of players.");//outputs a window
        else if (c2.Win==true || Turn==42) //true branch
            JOptionPane.showMessageDialog (null, "Please press the RESART button. "); //outputs new window
        else//false branch
         {//Start false branch
            column7();//calls method
            One_player();//calls method
         }//End false branch
    }//GEN-LAST:event_button7ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
    // Reset button
    if (num_of_players==0)//true branch
                JOptionPane.showMessageDialog(null, "Please select the number of players.");//outputs a window
    else//false branch
    {//Start false branch
        Reset=true; //reassigns var
        button10.setVisible(true);//make button visible, makes buttons and labels for choosing num of players visible
        button11.setVisible(true);//make button visible
        label47.setVisible(true);//make label visible
        label48.setVisible(true);//make label visible
        //The following code resets all vars and labels so a new game can start:
        Turn=0;//reassigns var
        Player=1;//reassigns var
        num_of_players=0;//reassigns var
        c2.Win=false;//reassigns var
        c2.ResetArray(Array, Win);//calls method
        label2.setForeground(Color.red); //set label colour
        label3.setForeground(Color.white);//set label colour
        label7.setText(" "); //makes label blank
        label8.setText(" "); //makes label blank
        label9.setText(" "); //makes label blank
        label10.setText(" "); //makes label blank
        label11.setText(" "); //makes label blank 
        label12.setText(" "); //makes label blank
        label13.setText(" "); //makes label blank
        label14.setText(" "); //makes label blank
        label15.setText(" "); //makes label blank
        label16.setText(" "); //makes label blank 
        label17.setText(" "); //makes label blank
        label18.setText(" "); //makes label blank
        label19.setText(" "); //makes label blank
        label20.setText(" "); //makes label blank
        label21.setText(" "); //makes label blank 
        label22.setText(" "); //makes label blank
        label23.setText(" "); //makes label blank
        label24.setText(" "); //makes label blank
        label25.setText(" "); //makes label blank
        label26.setText(" "); //makes label blank 
        label27.setText(" "); //makes label blank
        label49.setText(" "); //makes label blank
        label29.setText(" "); //makes label blank
        label30.setText(" "); //makes label blank
        label31.setText(" "); //makes label blank
        label32.setText(" "); //makes label blank
        label33.setText(" "); //makes label blank
        label34.setText(" "); //makes label blank
        label35.setText(" "); //makes label blank
        label36.setText(" "); //makes label blank
        label37.setText(" "); //makes label blank
        label38.setText(" "); //makes label blank
        label39.setText(" "); //makes label blank
        label40.setText(" "); //makes label blank
        label41.setText(" "); //makes label blank
        label42.setText(" "); //makes label blank
        label4.setText(" "); //makes label blank
        label5.setText(" "); //makes label blank
        label43.setText(" "); //makes label blank
        label44.setText(" "); //makes label blank
        label45.setText(" "); //makes label blank
        label46.setText(" "); //makes label blank
    }//end false branch
    }//GEN-LAST:event_button9ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        // Instructions button
        JOptionPane.showMessageDialog(null, "Instructions:\nThe objective of the game is to get four of your "
                + "respective \ncoloured cicle tile (red if player 1 or yellow if player two) in a row, \neither "
                + "horizontally, diagonally, or vertically. Try to stop your opponent \nfrom getting four of "
                + "their respective colour in a row as well. \n\nFirst, choose a player setting; either one "
                + "player or two player.\n\nNext, click on one of the buttons labeled, \"Drop Here\", to "
                + "drop\nyour respective coloured tile into the column of slots under the\nbutton. The coloured "
                + "tile will be dropped to the bottom-most open \nslot. You will not be able to place a coloured"
                + " piece in a full column. \nEach player's turn will be indicated by the labels on the side, which "
                + "\nwill turn each player's respective colour to indicate their turn. When \na player has won a game, or all the slots "
                + "are full, press the \nreset button to play again."); //opens new window
    }//GEN-LAST:event_button8ActionPerformed

    private void button10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button10ActionPerformed
        // When one player is selected
        num_of_players=1;//reassign
            if (Reset==false)//create branch, this will only make the players enter their name once.
             {//start branch
                do //create do while loop
                 {//Start loop
                    PName1=JOptionPane.showInputDialog("Enter Player 1 name that is less than 10 characters: "); //outputs window that takes input and stores it in var
                    label2.setText(PName1); //Set label text
                 }while(PName1.equals ("") || PName1.length()>10);//end loop (conditions will prevent player from just pressing enter)
            }//end branch
        label3.setText ("Computer"); //sets labels text
        button10.setVisible(false);//make button invisible, makes buttons/labels to choose a player disapear so player cannot cheat and change it in middle of game.
        button11.setVisible(false);//make button invisible
        label47.setVisible(false);//make button invisible
        label48.setVisible(false);//make button invisible
        label2.setForeground(Color.red); //sets label colour
    }//GEN-LAST:event_button10ActionPerformed

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        // When two player is selected
        label_text=label3.getText();
            if (Reset==false || label_text.equalsIgnoreCase("Computer"))//create branch (this will only make the players enter their names at the start of the game and when oenplayer was player the game before.
             {//start branch
                do //create do while loop
                 {//Start loop
                    PName1=JOptionPane.showInputDialog("Enter Player 1 name that is less than 10 characters: "); //outputs window that takes input and stores it in var
                    label2.setText(PName1); //Set label text
                    PName2=JOptionPane.showInputDialog("Enter Player 2 name that is less than 10 characters: "); //outputs window that takes input and stores it in var
                    label3.setText(PName2);//set label text
                 }while(PName1.equals ("") || PName2.equals ("") || PName1.length()>10 || PName2.length()>10); //end loop (conditions will prevent PNames from being blank)
            }//end branch
        num_of_players=2;//reassign var
        button10.setVisible(false); //make button invisible
        button11.setVisible(false);//make button invisible
        label47.setVisible(false);//make button invisible
        label48.setVisible(false);//make button invisible
        label2.setForeground(Color.red); //sets label colour
    }//GEN-LAST:event_button11ActionPerformed

    /**
     * @param args the command line arguments (computer generated)
     */
    public static void main(String args[]) 
     {//Start main program
        boolean Win=false;//declare and initiate var
        int Array [][]=new int [6][7];//declare and initiate array
        Connect4 c2=null;//create reference to object
        Connect4_CPT_Tester c1=null;//reference to object
        c1= new Connect4_CPT_Tester (c2, Array, Win, c1); //initiate reference to object
        c2= new Connect4 (Win, c2, Array, c1);//initiate reference to object
        
            c1.setVisible(true);//Makes GUI visible
            c1.setTitle("Connect Four"); //set the title in the top of the GUI display
            
            
        //Start computer auto generated code
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Connect4_CPT_Tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connect4_CPT_Tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connect4_CPT_Tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connect4_CPT_Tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new Connect4_CPT_Tester(c2).setVisible(true);
            }
        });
        //End computer generated code
    }//End main program

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button10;
    private java.awt.Button button11;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private java.awt.Button button6;
    private java.awt.Button button7;
    private java.awt.Button button8;
    private java.awt.Button button9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label15;
    private java.awt.Label label16;
    private java.awt.Label label17;
    private java.awt.Label label18;
    private java.awt.Label label19;
    private java.awt.Label label2;
    private java.awt.Label label20;
    private java.awt.Label label21;
    private java.awt.Label label22;
    private java.awt.Label label23;
    private java.awt.Label label24;
    private java.awt.Label label25;
    private java.awt.Label label26;
    private java.awt.Label label27;
    private java.awt.Label label29;
    private java.awt.Label label3;
    private java.awt.Label label30;
    private java.awt.Label label31;
    private java.awt.Label label32;
    private java.awt.Label label33;
    private java.awt.Label label34;
    private java.awt.Label label35;
    private java.awt.Label label36;
    private java.awt.Label label37;
    private java.awt.Label label38;
    private java.awt.Label label39;
    private java.awt.Label label4;
    private java.awt.Label label40;
    private java.awt.Label label41;
    private java.awt.Label label42;
    private java.awt.Label label43;
    private java.awt.Label label44;
    private java.awt.Label label45;
    private java.awt.Label label46;
    private java.awt.Label label47;
    private java.awt.Label label48;
    private java.awt.Label label49;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    // End of variables declaration//GEN-END:variables
}//End class