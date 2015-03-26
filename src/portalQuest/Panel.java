package portalQuest;
//Panel.java
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
 


import javax.swing.JPanel;
 
 
public class Panel extends JPanel{
        public static Font f;
        public static void initFont(){
                try {f = Font.createFont(Font.TRUETYPE_FONT, new File("digifit.ttf"));}
                catch (FontFormatException e) {f = new Font("Arial", Font.PLAIN, 20);}
                catch (IOException e) {f = new Font("Arial", Font.PLAIN, 20);}
        }
        public void paintComponent(Graphics g){
                Frame.Size[0] = getSize().width;
                Frame.Size[1] = getSize().height;
                g.setColor(Frame.Colors[0]);
                g.fillRect(0, 0, getSize().width, getSize().height);
                g.setColor(Frame.Colors[1]);
                g.fillRect(Frame.Borders[0]-Frame.MapPos[0], 0, getSize().width-(Frame.Borders[0]-Frame.MapPos[0]), getSize().height);
                g.fillRect(0, 0, Frame.Borders[1]-Frame.MapPos[0], getSize().height);
                g.fillRect(0, Frame.Borders[2]-Frame.MapPos[1], getSize().width, getSize().height-(Frame.Borders[2]-Frame.MapPos[1]));
                g.fillRect(0, 0, getSize().width, Frame.Borders[3]-Frame.MapPos[1]);
               
                for(int i = 0; i < Frame.Plateform; i++){
                        if(Frame.PlateformsIs[i]){
                                g.setColor(Frame.Colors[2]);
                                g.fillRect(Frame.Plateforms[i][0]-Frame.MapPos[0], Frame.Plateforms[i][1]-Frame.MapPos[1], Frame.Plateforms[i][2], 13);
                        }
                }
 
                for(int i = 0; i < Frame.Piece; i++){
                        if(Frame.PiecesIs[i]){
                                g.setColor(Frame.Colors[3]);
                                g.fillOval(Frame.Pieces[i][0]-Frame.MapPos[0], Frame.Pieces[i][1]-Frame.MapPos[1], 20, 20);
                        }
                }
               
                if(Frame.Left <= 0){
                        g.setColor(new Color(0, 0, 0, 200));
                        g.fillRect(Frame.Exit[0]-Frame.MapPos[0], Frame.Exit[1]-Frame.MapPos[1], 40, 50);
                        g.setColor(new Color(255, 255, 255));
                        g.setFont(new Font("Digifit", Font.PLAIN, 15));
                        g.drawString("Exit", Frame.Exit[0]-Frame.MapPos[0]+4, Frame.Exit[1]-Frame.MapPos[1]+15);}
                       
                g.setColor(Color.RED);
                g.fillRect((int)(Frame.PlayerPos[0]-Frame.MapPos[0]), (int)(Frame.PlayerPos[1]-Frame.MapPos[1]), 40, 50);
               
                if(!Frame.End){
                        g.setColor(new Color(100, 150, 255));
                        g.fillRect(20, getSize().height-70, (int)(Frame.Life*4), 30);
                        g.setColor(new Color(255, 255, 255, 100));
                        g.fillRect(20, getSize().height-70, 400, 30);
                        g.setColor(new Color(0, 0, 0));
                        g.drawRect(20, getSize().height-70, 400, 30);
                       
                        g.setColor(Frame.Colors[3]);
                       
                        g.setFont(f.deriveFont(Font.PLAIN, 20));
                        if(Frame.Left > 1) g.drawString(Frame.Left+" pieces manquantes", 10, 30);
                        else if(Frame.Left == 1) g.drawString(Frame.Left+" piece manquante", 10, 30);
                       
                        if(Frame.Timer){
                                g.setColor(new Color(255, 255, 255));
                                int Minuts = (int)((double)(TimerThread.MILLI-Frame.TimeF)/60000);
                                int Seconds = (int)((double)(TimerThread.MILLI-Frame.TimeF-Minuts*60000)/1000);
                                g.setFont(f.deriveFont(Font.PLAIN, 40));
                                if(Seconds < 10) g.drawString(Minuts+":0"+Seconds, getSize().width-200, 60);
                                else g.drawString(Minuts+":"+Seconds, getSize().width-200, 60);
                                g.setColor(new Color(255, 255, 255, 100));
                                g.fillRect(getSize().width-220, 18, 150, 60);
                                g.setColor(new Color(0, 0, 0));
                                g.drawRect(getSize().width-220, 18, 150, 60);
                        }
                }
                if(Frame.End){
                        g.setColor(new Color(0, 0, 0, Frame.Grade));
                        g.fillRect(0, 0, getSize().width, getSize().height);
                        g.setColor(new Color(255, 255, 255, Frame.Grade+55));
                        g.setFont(f.deriveFont(Font.PLAIN, 100));
                        int Minuts = (int)((double)(Frame.Time-Frame.TimeF)/60000);
                        int Seconds = (int)((double)(Frame.Time-Frame.TimeF-Minuts*60000)/1000);
                        int Milli = Frame.Time-Frame.TimeF-Minuts*60000-Seconds*1000;
                        if(Seconds < 10){
                                if(Milli < 10) g.drawString(Minuts+":0"+Seconds+".00"+Milli+" s", 40, 100);
                                else if(Milli < 100) g.drawString(Minuts+":0"+Seconds+".0"+Milli+" s", 40, 100);
                                else g.drawString(Minuts+":"+Seconds+"."+Milli+" s", 40, 100);
                        }
                        else{
                                if(Milli < 10) g.drawString(Minuts+":"+Seconds+".00"+Milli+" s", 40, 100);
                                else if(Milli < 100) g.drawString(Minuts+":"+Seconds+".0"+Milli+" s", 40, 100);
                                else g.drawString(Minuts+":"+Seconds+"."+Milli+" s", 40, 100);
                        }
                        g.fillRect(0, 140, getSize().width, 20);
                }
        }
}
