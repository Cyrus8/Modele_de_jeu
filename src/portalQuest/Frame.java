package portalQuest;
import java.awt.Color;
 

import javax.swing.JFrame;
 
 
public class Frame extends JFrame{
        public static Color Colors[] = new Color[4];
        public static int Size[] = new int[2];
       
        public static boolean End = false;
        public static int Grade = 0;
       
        public static boolean Timer = false;
        public static int Time = 0;
        public static int TimeF = 0;
 
        public static int Life = 80;
       
        public static int Exit[] = new int[2];
       
        public static int Plateforms[][] = new int[1000][3];
        public static boolean PlateformsIs[] = new boolean[1000];
        public static int Plateform = 0;
       
        public static int Pieces[][] = new int[1000][2];
        public static boolean PiecesIs[] = new boolean[1000];
        public static int Piece = 0;
        public static int Left = 0;
       
        public static double PlayerPos[] = new double[2];
        public static double PlayerSpeed[] = new double[2];
        public static int MapPos[] = new int[2];
        public static int Borders[] = new int[4];
        public static keyListener kl = new keyListener();
        public static Panel panel = new Panel();
       
        public Frame(){
                this.setTitle("Projet II - Plateform Runner");
                this.setVisible(true);
                this.setSize(1288, 747);
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setContentPane(panel);
               
                this.addKeyListener(kl);
 
                panel.initFont();
               
                PlayerPos[0] = -20;
                PlayerPos[1] = -50;
                Exit[0] = 40;
                Exit[1] = -350;
                Borders[0] = 500;
                Borders[1] = -400;
                Borders[2] = 0;
                Borders[3] = -400;
                Colors[0] = new Color(200, 220, 240);
                Colors[1] = new Color(20, 20, 20);
                Colors[2] = new Color(10, 10, 10);
                Colors[3] = new Color(255, 150, 0);
               
                addPlateform(-340, -70, 200);
                addPlateform(-100, -300, 200);
                addPlateform(230, -170, 200);
                addPiece(400, -210);
                addPiece(300, -40);
                addPiece(-300, -110);
                addPiece(-70, -340);
               
                Trame();
        }
       
        public static void Trame(){
                while(true){
                        int Buffer = TimerThread.MILLI;
 
                        MapPos[0] = (int)((PlayerPos[0]-Size[0]/2+MapPos[0]*29)/30);
                        MapPos[1] = (int)((PlayerPos[1]-Size[1]/2+MapPos[1]*29)/30);
                       
                        if(!Frame.End){
                                boolean G = true;
                               
                                if(kl.Right && PlayerSpeed[0] < 5){
                                        if(!Timer){
                                                Timer = true;
                                                TimeF = TimerThread.MILLI;}
                                        PlayerSpeed[0]+=.2;
                                }
                                else if(kl.Left && PlayerSpeed[0] > -5){
                                        if(!Timer){
                                                Timer = true;
                                                TimeF = TimerThread.MILLI;}
                                        PlayerSpeed[0]-=.2;
                                }
                                else PlayerSpeed[0]/=1.1;
                               
                                if(PlayerPos[0]+PlayerSpeed[0] >= Borders[0]-40){
                                        PlayerSpeed[0] = 0;
                                        PlayerPos[0] = Borders[0]-40;}
                                if(PlayerPos[0]+PlayerSpeed[0] <= Borders[1]){
                                        PlayerSpeed[0] = 0;
                                        PlayerPos[0] = Borders[1];}
                               
                                if(PlayerPos[1]+PlayerSpeed[1] >= Borders[2]-50){
                                        G = false;
                                        PlayerSpeed[1] = 0;
                                        PlayerPos[1] = Borders[2]-50;
                                        if(kl.Up){
                                                if(!Timer){
                                                        Timer = true;
                                                        TimeF = TimerThread.MILLI;}
                                                PlayerSpeed[1] = -17;
                                        }
                                }
       
                                if(PlayerPos[1]+PlayerSpeed[1] <= Borders[3]){
                                        PlayerSpeed[1] = 0;
                                        PlayerPos[1] = Borders[3];}
                               
                                if(PlayerSpeed[1] > 0){
                                        for(int i = 0; i < Plateform; i++){
                                                if(PlateformsIs[i]){
                                                        if(PlayerPos[0]+25 > Plateforms[i][0] && PlayerPos[0]+25 < Plateforms[i][0]+Plateforms[i][2]){
                                                                if(PlayerPos[1]+50 > Plateforms[i][1] && PlayerPos[1]+50 < Plateforms[i][1]+15){
                                                                        G = false;
                                                                        PlayerSpeed[1] = 0;
                                                                        PlayerPos[1] = Plateforms[i][1]-50;
                                                                        if(kl.Up){
                                                                                if(!Timer){
                                                                                        Timer = true;
                                                                                        TimeF = TimerThread.MILLI;}
                                                                                PlayerSpeed[1] = -17;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                                if(G) PlayerSpeed[1]+=.6;
                               
                                PlayerPos[0]+=PlayerSpeed[0];
                                PlayerPos[1]+=PlayerSpeed[1];
 
                                for(int i = 0; i < Piece; i++){
                                        if(PiecesIs[i]){
                                                if(PlayerPos[0]+40 > Pieces[i][0] && PlayerPos[0] < Pieces[i][0]+20){
                                                        if(PlayerPos[1]+50 > Pieces[i][1] && PlayerPos[1] < Pieces[i][1]+20){
                                                                PiecesIs[i] = false;
                                                                Left--;
                                                        }
                                                }
                                        }
                                }
                               
                                if(Left == 0){
                                        if(PlayerPos[0]+40 > Exit[0] && PlayerPos[0] < Exit[0]+40){
                                                if(PlayerPos[1]+50 > Exit[1] && PlayerPos[1] < Exit[1]+50){
                                                        End = true;
                                                        Time = TimerThread.MILLI;
                                                }
                                        }
                                }
                        }
                       
                        if(End && Grade < 150){
                                PlayerPos[0] = (PlayerPos[0]*29+Exit[0])/30;
                                PlayerPos[1] = (PlayerPos[1]*29+Exit[1])/30;
                                Grade++;
                                if(Grade == 100){
                                        PlayerPos[0] = Exit[0];
                                        PlayerPos[1] = Exit[1];
                                }
                        }
                       
                        panel.repaint();
                        if(TimerThread.MILLI-Buffer < 10){
                                try {Thread.sleep(10-(TimerThread.MILLI-Buffer));}
                                catch (InterruptedException e) {e.printStackTrace();}
                        }
                }
        }
       
        public static void addPlateform(int x, int y, int sx){
                int ind = 0;
                while(PlateformsIs[ind]) ind++;
                PlateformsIs[ind] = true;
                Plateforms[ind][0] = x;
                Plateforms[ind][1] = y;
                Plateforms[ind][2] = sx;
                if(ind >= Plateform) Plateform = ind+1;
        }
        public static void addPiece(int x, int y){
                int ind = 0;
                while(PiecesIs[ind]) ind++;
                Left++;
                PiecesIs[ind] = true;
                Pieces[ind][0] = x;
                Pieces[ind][1] = y;
                if(ind >= Piece) Piece = ind+1;
        }
}
 
 
 

 
 
 

